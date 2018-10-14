package ru.github.pvtitov.senatapp.mvp;

public abstract class BasicPresenter<V extends MvpContract.View, M extends MvpContract.Model> implements MvpContract.Presenter<V, M> {

    private V view;

    @Override
    public void attachView(V view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        this.view = null;
    }

    @Override
    public V getView() {
        return this.view;
    }
}