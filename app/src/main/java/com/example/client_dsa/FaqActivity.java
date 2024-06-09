package com.example.client_dsa;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

//public class FaqActivity extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_faq);
//
//        // Obtener el ListView
//        ListView faqListView = findViewById(R.id.faqListView);
//
//        // Datos de ejemplo para las FAQs
//        String[] faqs = {
//                "Pregunta 1: Respuesta a la pregunta 1",
//                "Pregunta 2: Respuesta a la pregunta 2",
//                "Pregunta 3: Respuesta a la pregunta 3",
//                "Pregunta 4: Respuesta a la pregunta 4",
//                "Pregunta 5: Respuesta a la pregunta 5"
//        };
//
//        // Configurar el adaptador para el ListView
//        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, faqs);
//        faqListView.setAdapter(adapter);
//    }
//
//
//
//}


import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.client_dsa.Classes.Faq;

import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FaqActivity extends AppCompatActivity {

    private ListView faqListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faq);

        faqListView = findViewById(R.id.faqListView);

        // Configurar Retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://localhost:8080/dsaApp/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        API apiService = retrofit.create(API.class);

        // Hacer la solicitud para obtener las FAQs
        Call<List<Faq>> call = apiService.getFaqs();
        call.enqueue(new Callback<List<Faq>>() {
            @Override
            public void onResponse(Call<List<Faq>> call, Response<List<Faq>> response) {
                if (response.isSuccessful()) {
                    List<Faq> faqs = response.body();
                    ArrayAdapter<String> adapter = new ArrayAdapter<>(FaqActivity.this, android.R.layout.simple_list_item_1);
                    for (Faq faq : faqs) {
                        adapter.add(faq.getF() + ": " + faq.getQ());
                    }
                    faqListView.setAdapter(adapter);
                } else {
                    int statusCode = response.code();
                    // Aquí puedes realizar acciones basadas en el código de estado, como mostrar un mensaje de error
                    Log.e("FaqActivity", "Error al obtener las FAQs. Código de estado: " + statusCode);
                }
            }

            @Override
            public void onFailure(Call<List<Faq>> call, Throwable t) {
                Log.e("FaqActivity", "Error al obtener las FAQs. Fallo en la solicitud: " + t.getMessage());
            }
        });
    }
}


