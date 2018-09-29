package ru.github.pvtitov.senatapp.mvp;

public interface LoginMvpContract {

    interface LoginModel extends MvpContract.Model{
        void authorize(String login, String password);
        void logout();
        void setAuthListener(AuthListener authListener);

        interface AuthListener {
            void onLogin();
            void onLogout();
            void onError(String message);
        }
    }

    interface LoginPresenter {
        void authorize(String login, String password);
        void logout();
    }

    interface LoginView extends MvpContract.View {
        void shutDown();
    }
}
