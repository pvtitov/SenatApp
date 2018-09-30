package ru.github.pvtitov.senatapp.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import ru.github.pvtitov.senatapp.R;

import static ru.github.pvtitov.senatapp.mvp.LoginMvpContract.*;

public class LoginActivity extends AppCompatActivity implements LoginView {

    private LoginPresenterImpl presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        presenter = LoginPresenterImpl.getInstance();
        presenter.attachView(this);

        EditText loginEditText = findViewById(R.id.login_edittext);
        EditText passwordEditText = findViewById(R.id.password_edittext);

        Button loginButton = findViewById(R.id.login_button);
        loginButton.setOnClickListener(view -> {
            String login = loginEditText.getText().toString();
            String password = passwordEditText.getText().toString();
            presenter.authorize(login, password);
        });

        Button logoutButton = findViewById(R.id.logout_button);
        logoutButton.setOnClickListener(view -> {
            presenter.logout();
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }

    @Override
    public void shutDown() {
        finish();
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
}
