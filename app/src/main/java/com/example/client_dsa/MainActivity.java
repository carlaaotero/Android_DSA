package com.example.client_dsa;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.client_dsa.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private String USUARI = "Usuari";
    private String SESSIO_INICIADA = "isLoggedIn";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences sharedPreferences = getSharedPreferences(USUARI, Context.MODE_PRIVATE);
        boolean isLogged = sharedPreferences.getBoolean(SESSIO_INICIADA, false);

        if (isLogged) {
            // Ir a la actividad principal si el usuario ya ha iniciado sesión
            Intent intent = new Intent(MainActivity.this, PrincipalActivity.class);
            startActivity(intent);
        } else {

            setContentView(R.layout.activity_main);

            Button start = findViewById(R.id.start);
            start.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                    startActivity(intent);
                }
            });

            /*Button btnOpenFaq = findViewById(R.id.faq);
            // Configurar el listener del botón para abrir FaqActivity
            btnOpenFaq.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, FaqActivity.class);
                    startActivity(intent);
                }
            });*/
        }
    }

    public void anarLogin(View view)
    {
        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(intent);
    }

}