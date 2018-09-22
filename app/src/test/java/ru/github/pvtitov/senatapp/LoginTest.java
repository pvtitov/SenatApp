package ru.github.pvtitov.senatapp;

import org.junit.Test;
import org.mockito.Mockito;

import ru.github.pvtitov.senatapp.login.LoginModelImpl;
import ru.github.pvtitov.senatapp.login.LoginMvpContract;
import ru.github.pvtitov.senatapp.login.LoginPresenterImpl;

import static org.mockito.Mockito.verify;

public class LoginTest {

    @Test
    public void authorize_ValidLoginValidPassword_Success(){
        LoginMvpContract.LoginModel model = Mockito.mock(LoginModelImpl.class);
        LoginPresenterImpl presenter = LoginPresenterImpl.getInstance();
        presenter.setModel(model);

        presenter.authorize("senat-demo", "senat-demo");

        verify(model).authorize("senat-demo", "senat-demo");
    }
}
