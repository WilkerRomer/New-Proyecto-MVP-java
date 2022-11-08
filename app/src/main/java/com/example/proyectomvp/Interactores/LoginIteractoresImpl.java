package com.example.proyectomvp.Interactores;

import android.os.Handler;

import com.example.proyectomvp.Interfaces.LoginInteractores;
import com.example.proyectomvp.Interfaces.OnLoginFinishListener;

public class LoginIteractoresImpl implements LoginInteractores {


    @Override
    public void validarUser(String User, String password, OnLoginFinishListener Listener) {

        new Handler().postDelayed(new Runnable(){

            @Override
            public void run() {

                if (!User.equals("") && !password.equals("")){

                    Listener.exitoOperacion();

                }else{
                    if (User.equals("")){
                        Listener.usernameError();
                    }
                    if (password.equals("")){
                        Listener.passwordError();
                    }
                }

            }
        },3000);

    }
}
