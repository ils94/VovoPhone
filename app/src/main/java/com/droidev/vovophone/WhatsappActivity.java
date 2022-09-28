package com.droidev.vovophone;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class WhatsappActivity extends AppCompatActivity {

    TextView contato1, contato2, contato3, contato4, contato5, contato6, whatsapp;
    Intents intent;
    Contatos contatos;
    Permissoes permissoes;
    TinyDB tinyDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_whatsapp);

        setTitle("WHATSAPP");

        ActionBar bar = getSupportActionBar();
        assert bar != null;
        bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#1689d2")));

        tinyDB = new TinyDB(WhatsappActivity.this);

        intent = new Intents();

        contatos = new Contatos();

        permissoes = new Permissoes();

        contato1 = findViewById(R.id.wpcontato1);
        contato2 = findViewById(R.id.wpcontato2);
        contato3 = findViewById(R.id.wpcontato3);
        contato4 = findViewById(R.id.wpcontato4);
        contato5 = findViewById(R.id.wpcontato5);
        contato6 = findViewById(R.id.wpcontato6);

        whatsapp = findViewById(R.id.abrirWhatsapp);

        contato1.setOnClickListener(view -> {

            if (permissoes.permissoesGerais(WhatsappActivity.this)) {

                intent.whatsappCall(WhatsappActivity.this, tinyDB.getString("nomeContato1"));
            } else {

                Toast.makeText(WhatsappActivity.this, "É preciso conceder as permissões necessárias primeiro.", Toast.LENGTH_LONG).show();
            }
        });

        contato2.setOnClickListener(view -> {

            if (permissoes.permissoesGerais(WhatsappActivity.this)) {

                intent.whatsappCall(WhatsappActivity.this, tinyDB.getString("nomeContato2"));
            } else {

                Toast.makeText(WhatsappActivity.this, "É preciso conceder as permissões necessárias primeiro.", Toast.LENGTH_LONG).show();
            }
        });

        contato3.setOnClickListener(view -> {

            if (permissoes.permissoesGerais(WhatsappActivity.this)) {

                intent.whatsappCall(WhatsappActivity.this, tinyDB.getString("nomeContato3"));
            } else {

                Toast.makeText(WhatsappActivity.this, "É preciso conceder as permissões necessárias primeiro.", Toast.LENGTH_LONG).show();
            }
        });

        contato4.setOnClickListener(view -> {

            if (permissoes.permissoesGerais(WhatsappActivity.this)) {

                intent.whatsappCall(WhatsappActivity.this, tinyDB.getString("nomeContato4"));
            } else {

                Toast.makeText(WhatsappActivity.this, "É preciso conceder as permissões necessárias primeiro.", Toast.LENGTH_LONG).show();
            }
        });

        contato5.setOnClickListener(view -> {

            if (permissoes.permissoesGerais(WhatsappActivity.this)) {

                intent.whatsappCall(WhatsappActivity.this, tinyDB.getString("nomeContato5"));
            } else {

                Toast.makeText(WhatsappActivity.this, "É preciso conceder as permissões necessárias primeiro.", Toast.LENGTH_LONG).show();
            }
        });

        contato6.setOnClickListener(view -> {

            if (permissoes.permissoesGerais(WhatsappActivity.this)) {

                intent.whatsappCall(WhatsappActivity.this, tinyDB.getString("nomeContato6"));
            } else {

                Toast.makeText(WhatsappActivity.this, "É preciso conceder as permissões necessárias primeiro.", Toast.LENGTH_LONG).show();
            }
        });

        whatsapp.setOnClickListener(view -> {

            Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.whatsapp");
            if (launchIntent != null) {
                startActivity(launchIntent);
            } else {

                Toast.makeText(WhatsappActivity.this, "Não foi possível abrir o Whatsapp.", Toast.LENGTH_SHORT).show();
            }
        });

        contatos.carregarContatos(WhatsappActivity.this, contato1, contato2, contato3, contato4, contato5, contato6);
    }
}