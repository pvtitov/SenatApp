package ru.github.pvtitov.senatapp.mvp;

public abstract class BasicPresenter<V extends MvpContract.View, M extends MvpContract.Model> implements MvpContract.Presenter<V, M> {

    private V view;
    private M model;

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

    @Override
    public void setModel(M model) {
        this.model = model;
    }

    @Override
    public M getModel() {
        return model;
    }
}