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

    abstract class BasicPresenter<V extends View, M extends Model> implements Presenter<V, M> {

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
}
