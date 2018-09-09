package ru.github.pvtitov.senatapp.main;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

import ru.github.pvtitov.senatapp.R;
import ru.github.pvtitov.senatapp.login.LoginActivity;

public class MainActivity extends AppCompatActivity implements MainView {

    private android.support.v7.widget.Toolbar toolbar;
    private MainPresenterImpl presenter;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = MainPresenterImpl.getInstance();
        presenter.attachView(this);
        presenter.setModel(new MainModelImpl());
        presenter.authStatusCheck();

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        button = findViewById(R.id.button);
        button.setOnClickListener(v -> presenter.downloadMeeting());
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
    public void showProgressBar() {

    }

    @Override
    public void hideProgressBar() {

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
