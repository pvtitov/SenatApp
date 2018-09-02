package ru.github.pvtitov.senatapp;

import org.junit.Test;
import org.mockito.Mockito;

import ru.github.pvtitov.senatapp.login.LoginModel;
import ru.github.pvtitov.senatapp.login.LoginModelImpl;
import ru.github.pvtitov.senatapp.login.LoginPresenter;

import static org.mockito.Mockito.verify;

public class LoginTest {

    @Test
    public void authorize_ValidLoginValidPassword_Success(){
        LoginModel model = Mockito.mock(LoginModelImpl.class);
        LoginPresenter presenter = LoginPresenter.getInstance();
        presenter.setModel(model);

        presenter.authorize("senat-demo", "senat-demo");

        verify(model).authorize("senat-demo", "senat-demo");
    }
}
