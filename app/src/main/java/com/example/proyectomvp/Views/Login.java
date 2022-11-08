package com.example.proyectomvp.Views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.example.proyectomvp.Interfaces.LoginPresenters;
import com.example.proyectomvp.Interfaces.LoginView;
import com.example.proyectomvp.Presenters.LoginPresentersImpl;
import com.example.proyectomvp.R;

import static com.example.proyectomvp.R.id.progressBar;

public class Login extends AppCompatActivity implements LoginView {

    private EditText User, Password;
    private ProgressBar progressBar;

    private LoginPresenters presenters;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        User = findViewById(R.id.User_name);
        Password = findViewById(R.id.Password);
        progressBar = findViewById(R.id.progressBar);

        presenters = new LoginPresentersImpl(this);

    }
    public void validacion(View view){
        presenters.validarUsuario(User.getText().toString(),Password.getText().toString());
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void setErrorUser() {
        User.setError("Campo obligatorio");
    }

    @Override
    public void setErrorPassword() {
        Password.setError("Campo obligatorio");
    }

    @Override
    public void navigateToHome() {
        startActivity(new Intent(Login.this,PrincipalMenu.class));
    }

   /* public void validacion(View view){
        presenters.validarUsuario(User.getText().toString(),Password.getText().toString());
    }*/
}