package com.example.client_dsa;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    private EditText nomUsuari;
    private EditText contra;
    private Button loginButton;
    private Button registreButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Assignació de les referències als elements de la interfície/
        nomUsuari = findViewById(R.id.nomUsuari);
        contra = findViewById(R.id.contra);
        loginButton = findViewById(R.id.loginButton);
        registreButton = findViewById(R.id.registreButton);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //FER FUNCIÓ DE SI S'HA REALITZAT BÉ EL LOGIN FA EL SEGÜENT:
                Intent intent = new Intent(LoginActivity.this, PrincipalActivity.class);
                startActivity(intent);
            }
        });
        registreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegistreActivity.class);
                startActivity(intent);
            }
        });

        //S'obté les dades introduïdes per l'usuari
        String username = nomUsuari.getText().toString();
        String password = contra.getText().toString();



        /*LoginComp loginComp = new LoginComp(username, password);
        Callback<LoginComp> tCallback = new Callback<LoginComp>() {
            @Override
            public void onResponse(Call<LoginComp> call, Response<LoginComp> response) {
                Log.d("PROVA", "TINC RESPOSTA");
            }

            @Override
            public void onFailure(Call<LoginComp> call, Throwable t) {
                Log.d("PROVA", "TINC UN ERROR");
            }
        };
        client.login(loginComp).enqueue(tCallback);*/
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
