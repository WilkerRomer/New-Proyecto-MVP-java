package com.example.proyectomvp.Presenters;

import com.example.proyectomvp.Interactores.LoginIteractoresImpl;
import com.example.proyectomvp.Interfaces.LoginInteractores;
import com.example.proyectomvp.Interfaces.LoginPresenters;
import com.example.proyectomvp.Interfaces.LoginView;
import com.example.proyectomvp.Interfaces.OnLoginFinishListener;

public class LoginPresentersImpl implements LoginPresenters, OnLoginFinishListener {

    private LoginView view;
    private LoginInteractores interactores;

    public LoginPresentersImpl(LoginView view) {
        this.view = view;
        interactores = new LoginIteractoresImpl();

    }

    @Override
    public void validarUsuario(String User, String Password) {
        if (view != null) {
            view.showProgress();
        }
        interactores.validarUser(User,Password,this);
    }

    @Override
    public void usernameError() {

        if (view != null) {
            view.hideProgress();
            view.setErrorUser();
        }
    }

    @Override
    public void passwordError() {
        if (view != null) {
            view.hideProgress();
            view.setErrorPassword();
        }
    }

    @Override
    public void exitoOperacion() {
        if (view != null) {
            view.hideProgress();
            view.navigateToHome();
        }
    }
}

