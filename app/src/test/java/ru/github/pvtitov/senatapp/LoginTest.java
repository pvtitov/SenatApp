package ru.github.pvtitov.senatapp;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mockito;

import javax.inject.Inject;

import dagger.Component;
import ru.github.pvtitov.senatapp.dagger.AppComponent;
import ru.github.pvtitov.senatapp.dagger.DaggerAppComponent;
import ru.github.pvtitov.senatapp.dagger.LoginModule;
import ru.github.pvtitov.senatapp.dagger.NetworkModule;
import ru.github.pvtitov.senatapp.login.LoginModelImpl;
import ru.github.pvtitov.senatapp.mvp.LoginMvpContract;
import ru.github.pvtitov.senatapp.login.LoginPresenterImpl;

import static org.mockito.Mockito.verify;

public class LoginTest {

    private AppComponent component;
    @Inject LoginModelImpl model;
    @Inject LoginPresenterImpl presenter;

    @Before
    public void initComponent() {
        component = DaggerAppComponent
                .builder()
                .loginModule(new LoginModule())
                .networkModule(new NetworkModule("https://senat.azurewebsites.net/"))
                .build();

        model = component.loginModel();
        presenter = component.loginPresenter();

    }

    @Ignore
    @Test
    public void authorize_ValidLoginValidPassword_Success(){

        presenter.authorize("senat-demo", "senat-demo");

        verify(model).authorize("senat-demo", "senat-demo");
    }
}
