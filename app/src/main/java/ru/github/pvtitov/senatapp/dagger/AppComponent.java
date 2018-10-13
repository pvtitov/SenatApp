package ru.github.pvtitov.senatapp.dagger;

import javax.inject.Singleton;

import dagger.Component;
import ru.github.pvtitov.senatapp.login.LoginModelImpl;
import ru.github.pvtitov.senatapp.login.LoginPresenterImpl;
import ru.github.pvtitov.senatapp.main.MainModelImpl;
import ru.github.pvtitov.senatapp.main.MainPresenterImpl;

@Component (modules = {LoginModule.class, MainModule.class, NetworkModule.class})
@Singleton
public interface AppComponent {

    LoginPresenterImpl loginPresenter();
    LoginModelImpl loginModel();
    MainPresenterImpl mainPresenter();
    MainModelImpl mainModel();
}
