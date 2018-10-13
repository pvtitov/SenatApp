package ru.github.pvtitov.senatapp.dagger;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ru.github.pvtitov.senatapp.http_service.HttpClientRetrofitImpl;

@Module
public class NetworkModule {

    @Provides
    @Singleton
    public HttpClientRetrofitImpl provideHttpClient() {
        return new HttpClientRetrofitImpl();
    }
}
