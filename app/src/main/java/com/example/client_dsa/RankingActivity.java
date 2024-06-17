package com.example.client_dsa;

import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.client_dsa.Classes.Partida;
import com.example.client_dsa.Classes.Usuari;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

public class RankingActivity extends AppCompatActivity {

    private ListView rankingListView;
    Usuari usuari;
    Partida partida;
    private ArrayList<Usuari> ranking_list;
    private UsuariAdap usuariAdap;
    String nomUsuari;
    Date data;
    int puntuacio;
    API api;
    private RecyclerView recyclerView;

    /*@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);

        rankingListView = findViewById(R.id.Ranking);
        api = APIimp.getAPI();

        recyclerView = findViewById(R.id.Ranking);

        ArrayList<Usuari> llistausuaris = new ArrayList<>();

        for (int i = 1; i <=llistausuaris.size(); i++) {
            nomUsuari = usuari.getNomusuari();
            data = partida.getData();
            puntuacio = usuari.getPuntuacio();
            llistausuaris.add(new Usuari("nomUsuari",1));
            llistausuaris.add(new Usuari("as",3));
            llistausuaris.add(new Usuari("asfasdf",20));
        }

        ranking_list = new ArrayList<>();
        for (Usuari usuari1 : llistausuaris) {
            ranking_list.add(new Usuari(nomUsuari, puntuacio));
        }

        // Ordenar la lista por puntos en orden descendente
        Collections.sort(ranking_list, new Comparator<Usuari>() {
            @Override
            public int compare(Usuari u1, Usuari u2) {
                return Integer.compare(u2.getPuntuacio(), u1.getPuntuacio());
            }
        });

        UsuariAdap usuariAdap= new UsuariAdap(this, ranking_list);
        rankingListView.setAdapter((ListAdapter) usuariAdap);
    }*/
}
