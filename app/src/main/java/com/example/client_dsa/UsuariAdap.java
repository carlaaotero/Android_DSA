package com.example.client_dsa;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.client_dsa.Classes.Partida;
import com.example.client_dsa.Classes.Usuari;

import java.util.List;

public class UsuariAdap extends RecyclerView.Adapter<UsuariAdap.UsuarioViewHolder> {
    private List<Usuari> usuaris;
    Partida partida;
    public UsuariAdap(RankingActivity rankingActivity, List<Usuari> usuaris) {
        this.usuaris = usuaris;
    }

    @NonNull
    @Override
    public UsuarioViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.ranking, parent, false);
        return new UsuarioViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UsuarioViewHolder holder, int position) {
        Usuari usuari = usuaris.get(position);

        //holder.nombreTextView.setText(usuari.getNom());
        //holder.puntuacionTextView.setText(String.valueOf(usuari.getPuntuacio()));
        //holder.fechaTextView.setText((CharSequence) partida.getData());

        holder.nombreTextView.setText("usuari.getNom()");
        holder.puntuacionTextView.setText(String.valueOf(3));
    }

    @Override
    public int getItemCount() {
        return usuaris.size();
    }
    public static class UsuarioViewHolder extends RecyclerView.ViewHolder {
        TextView nombreTextView;
        TextView puntuacionTextView;
        TextView fechaTextView;

        public UsuarioViewHolder(@NonNull View itemView) {
            super(itemView);
            nombreTextView = itemView.findViewById(R.id.nomUsuari);
            puntuacionTextView = itemView.findViewById(R.id.puntuacio);
            fechaTextView = itemView.findViewById(R.id.data);
        }
    }
}