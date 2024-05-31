package com.example.client_dsa;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.client_dsa.Classes.Usuari;

import java.util.ArrayList;

public class UsuariAdap extends BaseAdapter {
    private ArrayList<Usuari> ranking_list;
    Context context;

    public UsuariAdap(Context context, ArrayList<Usuari> ranking_list) {
        this.ranking_list = ranking_list;
        this.context = context;
    }
    @Override
    public int getCount() {
        return ranking_list.size();
    }
    @Override
    public Object getItem(int position) {
        return ranking_list.get(position);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.ranking, parent, false);
        }

        Usuari currentUser = (Usuari) getItem(position);

        TextView nomUsuariTextView = convertView.findViewById(R.id.nomUsuari);
        TextView dataTextView = convertView.findViewById(R.id.data);
        TextView puntuacioTextView = convertView.findViewById(R.id.puntuacio);

        nomUsuariTextView.setText(currentUser.getNomusuari());
        dataTextView.setText(currentUser.getData());
        puntuacioTextView.setText(String.valueOf(currentUser.getPuntuacio()));

        return convertView;
    }
}
