package com.example.client_dsa;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.client_dsa.Classes.LoginComp;
import com.example.client_dsa.Classes.RegisterComp;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    private EditText nomUsuari;
    private EditText contra;
    private Button loginButton;
    private Button registreButton;
    public ProgressBar progressBar;
    private String USUARI = "Usuari";
    private String SESSIO_INICIADA = "isLoggedIn";
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
        progressBar = findViewById(R.id.progressBar);

        api = APIimp.getAPI();

        SharedPreferences sharedPreferences = getSharedPreferences(USUARI, Context.MODE_PRIVATE);
        boolean isLogged = sharedPreferences.getBoolean(SESSIO_INICIADA, false);

        if (isLogged) {
            // Ir a la actividad principal si el usuario ya está registrado
            Intent intent = new Intent(LoginActivity.this, PrincipalActivity.class);
            startActivity(intent);
        } else {
            loginButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    progressBar.setVisibility(View.VISIBLE);
                    //S'obté les dades introduïdes per l'usuari
                    String username = nomUsuari.getText().toString();
                    String password = contra.getText().toString();

                    LoginComp loginComp = new LoginComp(username, password);
                    Call<LoginComp> call = api.login(loginComp);

                    call.enqueue(new Callback<LoginComp>() {
                        @Override
                        public void onResponse(Call<LoginComp> call, Response<LoginComp> response) {
                            if (!response.isSuccessful()) {
                                Log.d("LOGIN", "USUARI NO LOGEJAT");
                                Toast.makeText(LoginActivity.this, "Error al logejar", Toast.LENGTH_LONG).show();
                                return;
                            }
                            progressBar.setVisibility(View.INVISIBLE);
                            Log.d("LOGIN", "200 OK");
                            Toast.makeText(LoginActivity.this, "User logejat", Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(LoginActivity.this, PrincipalActivity.class);

                            String nomusuariPerfil = nomUsuari.getText().toString();

                            SharedPreferences sharedPreferences = getSharedPreferences(USUARI, Context.MODE_PRIVATE);
                            SharedPreferences.Editor editor = sharedPreferences.edit();
                            editor.putBoolean(SESSIO_INICIADA, true);
                            editor.putString("USERNAME",nomusuariPerfil);
                            editor.apply();
                            startActivity(intent);
                            finish();
                        }

                        @Override
                        public void onFailure(Call<LoginComp> call, Throwable t) {
                            Log.d("LOGIN", "ERROR");
                        }
                    });
                }
            });
        }

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
    public void anarMain(View view)
    {
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
    }

}
