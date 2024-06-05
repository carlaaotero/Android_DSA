package com.example.client_dsa;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import androidx.appcompat.app.AppCompatActivity;

import com.example.client_dsa.Classes.Issue;
import com.example.client_dsa.Classes.RegisterComp;

import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class IssueActivity extends AppCompatActivity {
    private EditText date;
    private EditText informer;
    private EditText message;
    private Button enviar;
    private Button enrere1;
    API api;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_issue);

        /*Assignació de les referències als elements de la interfície*/
        date = findViewById(R.id.date);
        informer = findViewById(R.id.informer);
        message = findViewById(R.id.message);
        enviar = findViewById(R.id.enviar);
        enrere1 = findViewById(R.id.enrere1);

        api = APIimp.getAPI();

        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               //S'obté les dades introduïdes per l'usuari
                String informer1 = informer.getText().toString();
                String date1 = date.getText().toString();
                String message1 = message.getText().toString();

                Issue issue = new Issue(date1, informer1, message1);
                Call<Issue> call = api.addIssue(issue);

                call.enqueue(new Callback<Issue>() {
                    @Override
                    public void onResponse(Call<Issue> call, Response<Issue> response) {

                        if(!response.isSuccessful()){
                            Log.d("ISSUE","MESSAGE NO REGISTRAT");
                            Toast.makeText(IssueActivity.this,"Error al fer el message", Toast.LENGTH_LONG).show();
                            return;
                        }
                        Log.d("ISSUE", "201 OK");
                        Toast.makeText(IssueActivity.this,"MESSAGE REGISTRAT", Toast.LENGTH_LONG).show();

                    }
                    @Override
                    public void onFailure(Call<Issue> call, Throwable t) {
                        Log.d("ISSUE", "ERROR:" + t.getMessage());
                        Toast.makeText(IssueActivity.this,"ERROR:" + t.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }
    public void anarPrincipal(View view)
    {
        Intent intent = new Intent(IssueActivity.this, PrincipalActivity.class);
        startActivity(intent);
    }


}
