package com.example.client_dsa;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.client_dsa.Classes.Item;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BotigaActivity extends AppCompatActivity {
    private Button enrereButton;
    TextView nom1;
    TextView nom2;
    TextView nom3;
    TextView nom4;
    TextView descripcio1;
    TextView descripcio2;
    TextView descripcio3;
    TextView descripcio4;
    TextView preu1;
    TextView preu2;
    TextView preu3;
    TextView preu4;
    Button btnComprat1;
    Button btnComprat2;
    Button btnComprat3;
    Button btnComprat4;
    API api;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_botiga);


        // Referències als elements del layout
        TextView nom1 = findViewById(R.id.nom1);
        TextView descripcio1 = findViewById(R.id.descripcio1);
        TextView preu1 = findViewById(R.id.preu1);
        Button btnComprat1 = findViewById(R.id.btnComprat1);

        TextView nom2 = findViewById(R.id.nom2);
        TextView descripcio2 = findViewById(R.id.descripcio2);
        TextView preu2 = findViewById(R.id.preu2);
        Button btnComprat2 = findViewById(R.id.btnComprat2);

        TextView nom3 = findViewById(R.id.nom3);
        TextView descripcio3 = findViewById(R.id.descripcio3);
        TextView preu3 = findViewById(R.id.preu3);
        Button btnComprat3 = findViewById(R.id.btnComprat3);

        TextView nom4 = findViewById(R.id.nom4);
        TextView descripcio4 = findViewById(R.id.descripcio4);
        TextView preu4 = findViewById(R.id.preu4);
        Button btnComprat4 = findViewById(R.id.btnComprat4);

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

                BotigaActivity.this.nom1.setText(n1);
                BotigaActivity.this.nom2.setText(n2);
                BotigaActivity.this.nom3.setText(n3);
                BotigaActivity.this.nom4.setText(n4);

                BotigaActivity.this.descripcio1.setText(d1);
                BotigaActivity.this.descripcio2.setText(d2);
                BotigaActivity.this.descripcio3.setText(d3);
                BotigaActivity.this.descripcio4.setText(d4);

                BotigaActivity.this.preu1.setText(""+p1);
                BotigaActivity.this.preu2.setText(""+p2);
                BotigaActivity.this.preu3.setText(""+p3);
                BotigaActivity.this.preu4.setText(""+p4);

            }
            @Override
            public void onFailure(Call<List<Item>> call, Throwable t) {
                Log.i("SCAPE_ROOM", "on failure", t);
                Toast.makeText(BotigaActivity.this, "Error", Toast.LENGTH_LONG).show();
            }
        });



    }
}
