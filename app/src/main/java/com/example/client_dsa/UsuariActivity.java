package com.example.client_dsa;

import static java.lang.Boolean.TRUE;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.client_dsa.Classes.Usuari;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UsuariActivity extends AppCompatActivity {
    private Button enrereButton;
    TextView nomusuari;
    TextView nombre;
    TextView apellido;
    TextView id;
    TextView diners;
    TextView color;
    TextView key;
    API api;

    //public ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuari);

        nomusuari = findViewById(R.id.apellido);
        nombre = findViewById(R.id.nombre);
        apellido = findViewById(R.id.apellido);
        id = findViewById(R.id.id);
        diners = findViewById(R.id.diners);
        color = findViewById(R.id.color);
        key = findViewById(R.id.key);

        api = APIimp.getAPI();

        SharedPreferences sharedPreferences = getSharedPreferences("Usuari", Context.MODE_PRIVATE);
        String username = sharedPreferences.getString("USERNAME", null);

        if (username != null) {
            nomusuari.setText(username);
            obtenirDadesUsuari(username);

        } else {
            Toast.makeText(this, "Usuari no encontrado", Toast.LENGTH_LONG).show();
        }

    }
    private void obtenirDadesUsuari(String username){
        Call<Usuari> call = api.getUsuariAPI(username);
        call.enqueue(new Callback<Usuari>() {
            @Override
            public void onResponse(Call<Usuari> call, Response<Usuari> response) {
                if (!response.isSuccessful()) {
                    Log.d("USUARI", "ERROR");
                    Toast.makeText(UsuariActivity.this, "Error al trobar les dades", Toast.LENGTH_LONG).show();
                    return;
                }
                Usuari usuari = response.body();
                String nom = usuari.getNom();
                String cognom = usuari.getCognom();
                String skin = usuari.getSkin();
                boolean clau = usuari.getClau();
                String id = usuari.getId();
                int coins = usuari.getCoins();

                UsuariActivity.this.nombre.setText(nom);
                UsuariActivity.this.apellido.setText(cognom);
                UsuariActivity.this.color.setText(skin);
                UsuariActivity.this.id.setText(id);
                UsuariActivity.this.diners.setText(coins);

                if(clau == TRUE){
                    UsuariActivity.this.key.setText("Té una clau");
                } else{
                    UsuariActivity.this.key.setText("No té cap clau");
                }

            }

            @Override
            public void onFailure(Call<Usuari> call, Throwable t) {
                Toast.makeText(UsuariActivity.this, "Error", Toast.LENGTH_LONG).show();
            }
        });
    }
    public void anarMain(View view)
    {
        Intent intent = new Intent(UsuariActivity.this, MainActivity.class);
        startActivity(intent);
    }
}
