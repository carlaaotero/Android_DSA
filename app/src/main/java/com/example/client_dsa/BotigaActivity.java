package com.example.client_dsa;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class BotigaActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_botiga);

        //Obtenir la llista d'articles de la botiga
        //List<Botiga> articles = Botiga.getCamiseta();


        // Referències als elements del layout
        ImageView imageView1 = findViewById(R.id.imageView1);
        TextView nom1 = findViewById(R.id.nom1);
        TextView descripcio1 = findViewById(R.id.descripcio1);
        TextView preu1 = findViewById(R.id.preu1);

        ImageView imageView2 = findViewById(R.id.imageView2);
        TextView nom2 = findViewById(R.id.nom2);
        TextView descripcio2 = findViewById(R.id.descripcio2);
        TextView preu2 = findViewById(R.id.preu2);

        ImageView imageView3 = findViewById(R.id.imageView3);
        TextView nom3 = findViewById(R.id.nom3);
        TextView descripcio3 = findViewById(R.id.descripcio3);
        TextView preu3 = findViewById(R.id.preu3);

        ImageView imageView4 = findViewById(R.id.imageView4);
        TextView nom4 = findViewById(R.id.nom4);
        TextView descripcio4 = findViewById(R.id.descripcio4);
        TextView preu4 = findViewById(R.id.preu4);

        /*IMATGE*/
        // Obtenir la URL de la imatge
       /* String urlImatge1 = getImatgeCamiseta(articles, 1);
        String urlImatge2 = getImatgeCamiseta(articles, 2);
        String urlImatge3 = getImatgeCamiseta(articles, 3);
        String urlImatge4 = getImatgeCamiseta(articles, 4);

        // Carregar la imatge amb Picasso
        Picasso.get().load(urlImatge1).into(imageView1);
        Picasso.get().load(urlImatge2).into(imageView2);
        Picasso.get().load(urlImatge3).into(imageView3);
        Picasso.get().load(urlImatge4).into(imageView4);


        /*DESCRIPCIÓ*/
        // Establir la descripció de l'article
       /* String desc1 = getDescripcioCamiseta(articles, 1);
        String desc2 = getDescripcioCamiseta(articles, 2);
        String desc3 = getDescripcioCamiseta(articles, 3);
        String desc4 = getDescripcioCamiseta(articles, 4);

        descripcio1.setText(desc1);
        descripcio2.setText(desc2);
        descripcio3.setText(desc3);
        descripcio4.setText(desc4);

        /*PREU*/
        /*int p1 = getPreuCamiseta(articles, 1);
        int p2 = getPreuCamiseta(articles, 2);
        int p3 = getPreuCamiseta(articles, 3);
        int p4 = getPreuCamiseta(articles, 4);

        preu1.setText(p1);
        preu2.setText(p2);
        preu3.setText(p3);
        preu4.setText(p4);

        /*NOM*/
        /*String n1 = getColorCamiseta(articles, 1);
        String n2 = getColorCamiseta(articles, 2);
        String n3 = getColorCamiseta(articles, 3);
        String n4 = getColorCamiseta(articles, 4);

        nom1.setText(n1);
        nom2.setText(n2);
        nom3.setText(n3);
        nom4.setText(n4);*/
    }
}
