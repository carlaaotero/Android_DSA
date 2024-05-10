package com.example.client_dsa;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.client_dsa.Classes.LoginComp;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    private EditText nomUsuari;
    private EditText contra;
    private Button loginButton;
    private Button registreButton;
    API api;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Assignació de les referències als elements de la interfície/
        nomUsuari = findViewById(R.id.nomUsuari);
        contra = findViewById(R.id.contra);
        loginButton = findViewById(R.id.loginButton);
        registreButton = findViewById(R.id.registreButton);

        api = APIimp.getAPI();

        //S'obté les dades introduïdes per l'usuari
        String username = nomUsuari.getText().toString();
        String password = contra.getText().toString();

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Valor usuari:", String.valueOf(username));
                Log.d("Valor contra:", String.valueOf(password));

                LoginComp loginComp = new LoginComp(username, password);

                api.login(loginComp).enqueue(new Callback<LoginComp>() {
                    @Override
                    public void onResponse(Call<LoginComp> call, Response<LoginComp> response) {
                        Log.d("LOGIN", "200 OK");

                        Intent intent = new Intent(LoginActivity.this, PrincipalActivity.class);
                        startActivity(intent);
                    }

                    @Override
                    public void onFailure(Call<LoginComp> call, Throwable t) {
                        Log.d("LOGIN", "ERROR");
                    }
                });


            }

        });




        registreButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegistreActivity.class);
                startActivity(intent);
            }
        });
    }
    public void anarPrincipal(View view)
    {
        Intent intent = new Intent(LoginActivity.this, PrincipalActivity.class);
        startActivity(intent);
    }
    public void anarRegistre(View view)
    {
        Intent intent = new Intent(LoginActivity.this, RegistreActivity.class);
        startActivity(intent);
    }
}
