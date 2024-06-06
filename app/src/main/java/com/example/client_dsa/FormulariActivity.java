package com.example.client_dsa;

import static com.example.client_dsa.R.*;

import com.example.client_dsa.Classes.*;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.Normalizer;
import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FormulariActivity extends AppCompatActivity {
    String id;
    private EditText data;
    private EditText title;
    private EditText message;
    private EditText sender;
    private Button enviar;

    API api;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulari);

        /*Generem un numero random per l'ID*/
        Random rand = new Random();
        id = String.valueOf(rand.nextInt(1000));

        /*Assignació de les referències als elements de la interfície*/
        data = findViewById(R.id.data);
        title = findViewById(R.id.title);
        message = findViewById(R.id.message);
        sender = findViewById(R.id.sender);

        enviar = findViewById(R.id.enviar);

        api = APIimp.getAPI();


        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //progressBar.setVisibility(View.VISIBLE);
                //S'obté les dades introduïdes per l'usuari
                String dia = data.getText().toString();
                String titol = title.getText().toString();
                String missatge = message.getText().toString();
                String usuari = sender.getText().toString();

                //validar que les constrasenyes coincideixen

                Formulari formulari = new Formulari (dia, titol, missatge, usuari);
                Call<Formulari> call = api.formulari(formulari);

                call.enqueue(new Callback<Formulari>() {
                    @Override
                    public void onResponse(Call<Formulari> call, Response<Formulari> response) {

                        if(!response.isSuccessful()){
                            Log.d("REGISTRE","USUARI NO REGISTRAT");
                            Toast.makeText(FormulariActivity.this,"Error a l'enviar", Toast.LENGTH_LONG).show();
                            return;
                        }
                        Log.d("FORMULARI", "201 OK");

                        Toast.makeText(FormulariActivity.this,"Formulari enviat", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(FormulariActivity.this, Formulari.class);
                        startActivity(intent);

                    }
                    @Override
                    public void onFailure(Call<Formulari> call, Throwable t) {
                        Log.d("FORMULARI", "ERROR:" + t.getMessage());
                        Toast.makeText(FormulariActivity.this,"ERROR:" + t.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }
}

