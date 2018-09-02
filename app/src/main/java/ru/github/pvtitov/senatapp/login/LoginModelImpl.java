package ru.github.pvtitov.senatapp.login;

public class LoginModelImpl implements LoginModel {

    private AuthListener authListener;

    @Override
    public void authorize(String login, String password) {
        if (login.equals("senat-demo") && password.equals("senat-demo")) authListener.onSuccess();
    }

    @Override
    public void setAuthListener(AuthListener authListener) {
        this.authListener = authListener;
    }
}
