package ru.github.pvtitov.senatapp.main;

import android.content.Intent;
import android.support.v4.app.Fragment;
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

public class MainActivity extends AppCompatActivity implements MainView {

    private android.support.v7.widget.Toolbar toolbar;
    private MainPresenterImpl presenter;
    private FragmentManager fragmentManager;
    private ListMeetingsFragment fragmentList;
    private DetailMeetingFragment fragmentDetails;
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
        fragmentList = (ListMeetingsFragment) fragmentManager.findFragmentByTag(ListMeetingsFragment.TAG);
        if (fragmentList == null){
            fragmentList = new ListMeetingsFragment();
            fragmentList.setRetainInstance(true);
            fragmentManager
                    .beginTransaction()
                    .add(R.id.main_fragment_container, fragmentList, ListMeetingsFragment.TAG)
                    .addToBackStack(null)
                    .commit();
        }
        fragmentDetails = (DetailMeetingFragment) fragmentManager.findFragmentByTag(DetailMeetingFragment.TAG);
        if (fragmentDetails == null){
            fragmentDetails = new DetailMeetingFragment();
            fragmentDetails.setRetainInstance(true);
            fragmentManager
                    .beginTransaction()
                    .add(R.id.detail_fragment_container, fragmentDetails, DetailMeetingFragment.TAG)
                    .addToBackStack(null)
                    .commit();
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
    public void showMeetingDetails(Meeting meeting) {

        fragmentDetails = new DetailMeetingFragment();
        fragmentDetails.setMeeting(meeting);
        fragmentDetails.setRetainInstance(true);
        fragmentManager
                .beginTransaction()
                .replace(R.id.detail_fragment_container, fragmentDetails, DetailMeetingFragment.TAG)
                .commit();
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
