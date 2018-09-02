package ru.github.pvtitov.senatapp.login;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import ru.github.pvtitov.senatapp.R;

public class LoginActivity extends AppCompatActivity implements LoginView {

    public static final String IS_AUTHORIZED = "IS_AUTHORIZED";

    private LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        presenter = LoginPresenter.getInstance();
        presenter.attachView(this);
        presenter.setModel(new LoginModelImpl());

        EditText loginEditText = findViewById(R.id.login_edittext);
        EditText passwordEditText = findViewById(R.id.password_edittext);
        ImageButton loginButton = findViewById(R.id.login_button);

        loginButton.setOnClickListener(view -> {
            String login = loginEditText.getText().toString();
            String password = passwordEditText.getText().toString();
            presenter.authorize(login, password);
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }

    @Override
    public void saveAuthorizedState(boolean isAuthorized) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        sharedPreferences.edit().putBoolean(IS_AUTHORIZED, isAuthorized).apply();
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
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}
