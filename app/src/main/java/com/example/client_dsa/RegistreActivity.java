package com.example.client_dsa;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class RegistreActivity extends AppCompatActivity {
    /*Declaració de variables */
    String id;
    private EditText nom;
    private EditText cognom;
    private EditText nomUsuari;
    private EditText contra;
    private EditText contra2;
    private Button registre;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registre);

        /*Generem un numero random per l'ID*/
        Random rand = new Random();
        id = String.valueOf(rand.nextInt(1000));

        /*Assignació de les referències als elements de la interfície*/
        nom = findViewById(R.id.nom);
        cognom = findViewById(R.id.cognom);
        nomUsuari = findViewById(R.id.nomUsuarii);
        contra = findViewById(R.id.contra1);
        contra2 = findViewById(R.id.contra2);

        registre = findViewById(R.id.registre);


        registre.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                //S'obté les dades introduïdes per l'usuari
                String nombre = nom.getText().toString();
                String apellido = cognom.getText().toString();
                String username = nomUsuari.getText().toString();
                String password = contra.getText().toString();
                String password2 = contra2.getText().toString();

                //FER FUNCIÓ DE SI S'HA REALITZAT BÉ EL REGISTRE FA EL SEGÜENT:
                Intent intent = new Intent(RegistreActivity.this, LoginActivity.class);
                startActivity(intent);

            }
        });
    }
    public void anarLogin(View view)
    {
        Intent intent = new Intent(RegistreActivity.this, LoginActivity.class);
        startActivity(intent);
    }
}
