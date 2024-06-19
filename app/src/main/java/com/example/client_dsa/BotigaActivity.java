package com.example.client_dsa;

import static java.lang.Boolean.TRUE;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.client_dsa.Classes.Item;
import com.example.client_dsa.Classes.RegisterComp;
import com.example.client_dsa.Classes.Usuari;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
public class BotigaActivity extends AppCompatActivity {
    private Button enrereButton;
    private TextView nom1;
    private TextView nom2;
    private TextView nom3;
    private TextView nom4;
    private TextView descripcio1;
    private TextView descripcio2;
    private TextView descripcio3;
    private TextView descripcio4;
    private TextView preu1;
    private TextView preu2;
    private TextView preu3;
    private TextView preu4;
    private Button btnComprat1;
    private Button btnComprat2;
    private Button btnComprat3;
    private Button btnComprat4;
    private API api;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_botiga);

        // Inicialitza les variables de classe
        nom1 = findViewById(R.id.nom1);
        descripcio1 = findViewById(R.id.descripcio1);
        preu1 = findViewById(R.id.preu1);
        btnComprat1 = findViewById(R.id.btnComprat1);

        nom2 = findViewById(R.id.nom2);
        descripcio2 = findViewById(R.id.descripcio2);
        preu2 = findViewById(R.id.preu2);
        btnComprat2 = findViewById(R.id.btnComprat2);

        nom3 = findViewById(R.id.nom3);
        descripcio3 = findViewById(R.id.descripcio3);
        preu3 = findViewById(R.id.preu3);
        btnComprat3 = findViewById(R.id.btnComprat3);

        nom4 = findViewById(R.id.nom4);
        descripcio4 = findViewById(R.id.descripcio4);
        preu4 = findViewById(R.id.preu4);
        btnComprat4 = findViewById(R.id.btnComprat4);

        api = APIimp.getAPI();

        SharedPreferences sharedPreferences = getSharedPreferences("Usuari", Context.MODE_PRIVATE);
        String username = sharedPreferences.getString("USERNAME", null);

        Call<List<Item>> call = api.getBotiga();

        call.enqueue(new Callback<List<Item>>() {
            @Override
            public void onResponse(Call<List<Item>> call, Response<List<Item>> response) {
                if (!response.isSuccessful()) {
                    Log.d("USUARI", "ERROR");
                    Toast.makeText(BotigaActivity.this, "Error al trobar les dades", Toast.LENGTH_LONG).show();
                    return;
                }
                List<Item> items = response.body();

                String n1 = items.get(0).getColor();
                String n2 = items.get(1).getColor();
                String n3 = items.get(2).getColor();
                String n4 = items.get(3).getColor();

                String d1 = items.get(0).getDescripcio();
                String d2 = items.get(1).getDescripcio();
                String d3 = items.get(2).getDescripcio();
                String d4 = items.get(3).getDescripcio();

                int p1 = items.get(0).getPreu();
                int p2 = items.get(1).getPreu();
                int p3 = items.get(2).getPreu();
                int p4 = items.get(3).getPreu();

                // Utilitza les variables de classe sense redeclarar-les
                nom1.setText(n1);
                nom2.setText(n2);
                nom3.setText(n3);
                nom4.setText(n4);

                descripcio1.setText(d1);
                descripcio2.setText(d2);
                descripcio3.setText(d3);
                descripcio4.setText(d4);

                preu1.setText("" + p1);
                preu2.setText("" + p2);
                preu3.setText("" + p3);
                preu4.setText("" + p4);
            }

            @Override
            public void onFailure(Call<List<Item>> call, Throwable t) {
                Log.i("SCAPE_ROOM", "on failure", t);
                Toast.makeText(BotigaActivity.this, "Error", Toast.LENGTH_LONG).show();
            }
        });


        btnComprat1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Call<Usuari> call = api.comprar(username,"Vermell");

                call.enqueue(new Callback<Usuari>() {
                    @Override
                    public void onResponse(Call<Usuari> call, Response<Usuari> response) {


                        if (!response.isSuccessful()) {
                            Log.d("COMPRAR", "ERROR");
                            Toast.makeText(BotigaActivity.this, "Diners insuficients", Toast.LENGTH_LONG).show();
                            return;
                        }
                        Usuari usuari = response.body();
                        Toast.makeText(BotigaActivity.this, "Has comprat la Skin Vermella", Toast.LENGTH_LONG).show();

                    }
                    @Override
                    public void onFailure(Call<Usuari> call, Throwable t) {
                        Log.i("COMPRAR", "on failure", t);
                        Toast.makeText(BotigaActivity.this, "Error", Toast.LENGTH_LONG).show();
                    }
                });

            }
        });

        btnComprat2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Call<Usuari> call = api.comprar(username,"Verd");

                call.enqueue(new Callback<Usuari>() {
                    @Override
                    public void onResponse(Call<Usuari> call, Response<Usuari> response) {
                        if (!response.isSuccessful()) {
                            Log.d("COMPRAR", "ERROR");
                            Toast.makeText(BotigaActivity.this, "Diners insuficients", Toast.LENGTH_LONG).show();
                            return;
                        }
                        Usuari usuari = response.body();
                        Toast.makeText(BotigaActivity.this, "Has comprat la Skin Verda", Toast.LENGTH_LONG).show();

                    }
                    @Override
                    public void onFailure(Call<Usuari> call, Throwable t) {
                        Log.i("COMPRAR", "on failure", t);
                        Toast.makeText(BotigaActivity.this, "Error", Toast.LENGTH_LONG).show();
                    }
                });

            }
        });

        btnComprat3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Call<Usuari> call = api.comprar(username,"Groc");

                call.enqueue(new Callback<Usuari>() {
                    @Override
                    public void onResponse(Call<Usuari> call, Response<Usuari> response) {
                        if (!response.isSuccessful()) {
                            Log.d("COMPRAR", "ERROR");
                            Toast.makeText(BotigaActivity.this, "Diners insuficients", Toast.LENGTH_LONG).show();
                            return;
                        }
                        Usuari usuari = response.body();
                        Toast.makeText(BotigaActivity.this, "Has comprat la Skin Groga", Toast.LENGTH_LONG).show();

                    }
                    @Override
                    public void onFailure(Call<Usuari> call, Throwable t) {
                        Log.i("COMPRAR", "on failure", t);
                        Toast.makeText(BotigaActivity.this, "Error", Toast.LENGTH_LONG).show();
                    }
                });

            }
        });

        btnComprat4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Call<Usuari> call = api.comprar(username,"Blau");

                call.enqueue(new Callback<Usuari>() {
                    @Override
                    public void onResponse(Call<Usuari> call, Response<Usuari> response) {
                        if (!response.isSuccessful()) {
                            Log.d("COMPRAR", "ERROR");
                            Toast.makeText(BotigaActivity.this, "Diners insuficients", Toast.LENGTH_LONG).show();
                            return;
                        }
                        Usuari usuari = response.body();
                        Toast.makeText(BotigaActivity.this, "Has comprat la Skin Blava", Toast.LENGTH_LONG).show();

                    }
                    @Override
                    public void onFailure(Call<Usuari> call, Throwable t) {
                        Log.i("COMPRAR", "on failure", t);
                        Toast.makeText(BotigaActivity.this, "Error", Toast.LENGTH_LONG).show();
                    }
                });

            }
        });
    }
    public void anarMain(View view)
    {
        Intent intent = new Intent(BotigaActivity.this, PrincipalActivity.class);
        startActivity(intent);
    }
}
