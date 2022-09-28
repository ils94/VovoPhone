package com.droidev.vovophone;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class TelefoneActivity extends AppCompatActivity {

    TextView contato1, contato2, contato3, contato4, contato5, contato6, emergencia, discador;
    Intents intent;
    Permissoes permissoes;
    Contatos contatos;
    TinyDB tinyDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_telefone);

        setTitle("TELEFONE");

        ActionBar bar = getSupportActionBar();
        assert bar != null;
        bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#1689d2")));

        tinyDB = new TinyDB(TelefoneActivity.this);

        intent = new Intents();

        permissoes = new Permissoes();

        contatos = new Contatos();

        contato1 = findViewById(R.id.telcontato1);
        contato2 = findViewById(R.id.telcontato2);
        contato3 = findViewById(R.id.telcontato3);
        contato4 = findViewById(R.id.telcontato4);
        contato5 = findViewById(R.id.telcontato5);
        contato6 = findViewById(R.id.telcontato6);

        discador = findViewById(R.id.discador);

        emergencia = findViewById(R.id.emergencia);

        contato1.setOnClickListener(view -> {

            if(permissoes.permissoesGerais(TelefoneActivity.this)){

                intent.telefone(TelefoneActivity.this, tinyDB.getString("numeroContato1"));
            } else {

                Toast.makeText(TelefoneActivity.this, "É preciso conceder as permissões necessárias primeiro.", Toast.LENGTH_LONG).show();
            }
        });

        contato2.setOnClickListener(view -> {

            if(permissoes.permissoesGerais(TelefoneActivity.this)){

                intent.telefone(TelefoneActivity.this, tinyDB.getString("numeroContato2"));
            } else {

                Toast.makeText(TelefoneActivity.this, "É preciso conceder as permissões necessárias primeiro.", Toast.LENGTH_LONG).show();
            }
        });

        contato3.setOnClickListener(view -> {

            if(permissoes.permissoesGerais(TelefoneActivity.this)){

                intent.telefone(TelefoneActivity.this, tinyDB.getString("numeroContato3"));
            } else {

                Toast.makeText(TelefoneActivity.this, "É preciso conceder as permissões necessárias primeiro.", Toast.LENGTH_LONG).show();
            }
        });

        contato4.setOnClickListener(view -> {

            if(permissoes.permissoesGerais(TelefoneActivity.this)){

                intent.telefone(TelefoneActivity.this, tinyDB.getString("numeroContato4"));
            } else {

                Toast.makeText(TelefoneActivity.this, "É preciso conceder as permissões necessárias primeiro.", Toast.LENGTH_LONG).show();
            }
        });

        contato5.setOnClickListener(view -> {

            if(permissoes.permissoesGerais(TelefoneActivity.this)){

                intent.telefone(TelefoneActivity.this, tinyDB.getString("numeroContato5"));
            } else {

                Toast.makeText(TelefoneActivity.this, "É preciso conceder as permissões necessárias primeiro.", Toast.LENGTH_LONG).show();
            }
        });

        contato6.setOnClickListener(view -> {

            if(permissoes.permissoesGerais(TelefoneActivity.this)){

                intent.telefone(TelefoneActivity.this, tinyDB.getString("numeroContato6"));
            } else {

                Toast.makeText(TelefoneActivity.this, "É preciso conceder as permissões necessárias primeiro.", Toast.LENGTH_LONG).show();
            }
        });

        discador.setOnClickListener(view -> intent.intentActivity(TelefoneActivity.this, DiscadorActivity.class));

        emergencia.setOnClickListener(view -> intent.intentActivity(TelefoneActivity.this, EmergenciaActivity.class));

        contatos.carregarContatos(TelefoneActivity.this, contato1, contato2, contato3, contato4, contato5, contato6);
    }
}