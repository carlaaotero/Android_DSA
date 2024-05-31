package com.example.client_dsa;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.client_dsa.Classes.LoginComp;
import com.example.client_dsa.Classes.Usuari;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RankingActivity extends AppCompatActivity {

    private ListView rankingListView;
    Usuari usuari;
    private ArrayList<Usuari> ranking_list;
    private UsuariAdap usuariAdap;
    String nomUsuari;
    String data;
    int puntuacio;
    API api;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);

        rankingListView = findViewById(R.id.ranking);
        api = APIimp.getAPI();

        ArrayList<Usuari> llistausuaris = new ArrayList<>();
        for (int i = 1; i <=llistausuaris.size(); i++) {
            nomUsuari = usuari.getNomusuari();
            data=usuari.getData();
            puntuacio = usuari.getPuntuacio();
            llistausuaris.add(new Usuari("nom", "cognom","nomUsuari","password","password2", "data", 3));
        }

        ranking_list = new ArrayList<>();
        for (Usuari usuari1 : llistausuaris) {
            ranking_list.add(new Usuari("nom", "cognom","nomusuari","password","password2", "data", 3));
        }

        // Ordenar la lista por puntos en orden descendente
        Collections.sort(ranking_list, new Comparator<Usuari>() {
            @Override
            public int compare(Usuari u1, Usuari u2) {
                return Integer.compare(u2.getPuntuacio(), u1.getPuntuacio());
            }
        });

        UsuariAdap usuariAdap= new UsuariAdap(this, ranking_list);
        rankingListView.setAdapter(usuariAdap);
    }
}
