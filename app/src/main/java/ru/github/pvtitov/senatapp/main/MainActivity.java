package ru.github.pvtitov.senatapp.main;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import ru.github.pvtitov.senatapp.R;
import ru.github.pvtitov.senatapp.login.LoginActivity;
import ru.github.pvtitov.senatapp.pojos.Meeting;

import static android.content.res.Configuration.ORIENTATION_LANDSCAPE;
import static android.content.res.Configuration.ORIENTATION_PORTRAIT;

public class MainActivity extends AppCompatActivity implements MainView {

    private android.support.v7.widget.Toolbar toolbar;
    private MainPresenterImpl presenter;
    private FragmentManager fragmentManager;
    private ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = MainPresenterImpl.getInstance();
        presenter.attachView(this);
        presenter.setModel(new MainModelImpl());
        presenter.authStatusCheck();

        fragmentManager = getSupportFragmentManager();
        ListMeetingsFragment listFragment = (ListMeetingsFragment) fragmentManager.findFragmentByTag(ListMeetingsFragment.TAG);
        if (listFragment == null){
            listFragment = new ListMeetingsFragment();
            listFragment.setRetainInstance(true);
        }
        fragmentManager
                .beginTransaction()
                .replace(R.id.first_fragment_container, listFragment, ListMeetingsFragment.TAG)
                .commit();

        DetailMeetingFragment detailFragment = (DetailMeetingFragment) fragmentManager.findFragmentByTag(DetailMeetingFragment.TAG);
        if (detailFragment != null){
            fragmentManager
                    .beginTransaction()
                    .replace(R.id.second_fragment_container, detailFragment, DetailMeetingFragment.TAG)
                    .commit();

            if (this.getResources().getConfiguration().orientation == ORIENTATION_PORTRAIT){
                findViewById(R.id.first_fragment_container).setVisibility(View.GONE);
            }
        }

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        progressBar = findViewById(R.id.main_progress_bar);

        presenter.downloadMeeting();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }

    @Override
    public void openLoginScreen() {
        startActivity(new Intent(MainActivity.this, LoginActivity.class));
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        findViewById(R.id.first_fragment_container).setVisibility(View.VISIBLE);
    }

    @Override
    public void showMeetingDetails(Meeting meeting) {

        DetailMeetingFragment detailsFragment = new DetailMeetingFragment();
        detailsFragment.setRetainInstance(true);
        detailsFragment.setMeeting(meeting);
        fragmentManager
                .beginTransaction()
                .replace(R.id.second_fragment_container, detailsFragment, DetailMeetingFragment.TAG)
                .addToBackStack(null)
                .commit();
        if (this.getResources().getConfiguration().orientation == ORIENTATION_PORTRAIT){
            findViewById(R.id.first_fragment_container).setVisibility(View.GONE);
        }
    }

    @Override
    public void showProgressBar() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.login_menu_item:
                presenter.openLoginScreeen();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}
