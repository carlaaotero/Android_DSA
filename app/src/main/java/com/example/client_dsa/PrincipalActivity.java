package com.example.client_dsa;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class PrincipalActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        Button usuari = findViewById(R.id.Usuari);
        Button botiga = findViewById(R.id.Botiga);
        Button jugar = findViewById(R.id.jugar);
        Button issue = findViewById(R.id.Issue);
        Button formulari = findViewById(R.id.formulari);


        botiga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PrincipalActivity.this, BotigaActivity.class);
                startActivity(intent);
            }
        });
        usuari.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PrincipalActivity.this, UsuariActivity.class);
                startActivity(intent);
            }
        });
        formulari.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PrincipalActivity.this, FormulariActivity.class);
                startActivity(intent);
            }
        });
    }

    public void anarUsuari(View view)
    {
        Intent intent = new Intent(PrincipalActivity.this, UsuariActivity.class);
        startActivity(intent);
    }
    public void anarBotiga(View view)
    {
        Intent intent = new Intent(PrincipalActivity.this, BotigaActivity.class);
        startActivity(intent);
    }
    public void anarIssue(View view)
    {
        Intent intent = new Intent(PrincipalActivity.this, IssueActivity.class);
        startActivity(intent);
    }
    public void anarLogin(View view)
    {
        Intent intent = new Intent(PrincipalActivity.this, LoginActivity.class);
        startActivity(intent);
    }
    public void anarFormulari(View view)
    {
        Intent intent = new Intent(PrincipalActivity.this, FormulariActivity.class);
        startActivity(intent);
    }


}
