package ru.github.pvtitov.senatapp.dagger;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ru.github.pvtitov.senatapp.http_service.HttpClientRetrofitImpl;
import ru.github.pvtitov.senatapp.main.MainModelImpl;
import ru.github.pvtitov.senatapp.main.MainPresenterImpl;
import ru.github.pvtitov.senatapp.mvp.MainMvpContract;

@Module
public class MainModule {

    @Provides
    @Singleton
    public MainPresenterImpl provideMainPresenter() {
        return new MainPresenterImpl();
    }


    @Provides
    @Singleton
    public MainModelImpl provideMainModel(HttpClientRetrofitImpl client) {
        return new MainModelImpl(client);
    }
}