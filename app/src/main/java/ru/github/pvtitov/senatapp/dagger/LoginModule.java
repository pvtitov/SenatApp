package ru.github.pvtitov.senatapp.dagger;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ru.github.pvtitov.senatapp.login.LoginModelImpl;
import ru.github.pvtitov.senatapp.login.LoginPresenterImpl;

@Module
public class LoginModule {

    @Provides
    @Singleton
    public LoginPresenterImpl provideLoginPresenter() {
        return new LoginPresenterImpl();
    }


    @Provides
    @Singleton
    public LoginModelImpl provideLoginModel() {
        return new LoginModelImpl();
    }
}