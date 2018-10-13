package ru.github.pvtitov.senatapp.dagger;

import javax.inject.Singleton;

import dagger.Component;
import retrofit2.Retrofit;
import ru.github.pvtitov.senatapp.http_service.LoginService;
import ru.github.pvtitov.senatapp.http_service.MainService;
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
    LoginService loginService();
    MainService mainService();
    Retrofit mainRetrofit();
}
