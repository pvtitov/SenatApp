package ru.github.pvtitov.senatapp;

public interface MvpContract {

    interface Model {

    }

    interface View {
        void showProgressBar();
        void hideProgressBar();
        void showMessage(String message);
    }

    interface Presenter<V extends View, M extends Model> {
        void attachView(V view);
        void detachView();
        V getView();
        void setModel(M model);
        M getModel();
    }
}
