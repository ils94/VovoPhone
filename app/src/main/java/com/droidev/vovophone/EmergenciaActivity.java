package com.droidev.vovophone;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class EmergenciaActivity extends AppCompatActivity {

    TextView ambulancia, bombeiros, policia;
    Intents intent;
    Permissoes permissoes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emergencia);

        setTitle("EMERGÊNCIA");

        ActionBar bar = getSupportActionBar();
        assert bar != null;
        bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#1689d2")));

        intent = new Intents();

        permissoes = new Permissoes();

        ambulancia = findViewById(R.id.ambulancia);
        bombeiros = findViewById(R.id.bombeiros);
        policia = findViewById(R.id.policia);

        ambulancia.setOnClickListener(view -> {

            if (permissoes.permissoesGerais(EmergenciaActivity.this)) {

                intent.telefone(EmergenciaActivity.this, "192");
            } else {

                Toast.makeText(EmergenciaActivity.this, "É preciso conceder as permissões necessárias primeiro.", Toast.LENGTH_LONG).show();
            }
        });

        bombeiros.setOnClickListener(view -> {

            if (permissoes.permissoesGerais(EmergenciaActivity.this)) {

                intent.telefone(EmergenciaActivity.this, "193");
            } else {

                Toast.makeText(EmergenciaActivity.this, "É preciso conceder as permissões necessárias primeiro.", Toast.LENGTH_LONG).show();
            }
        });

        policia.setOnClickListener(view -> {

            if (permissoes.permissoesGerais(EmergenciaActivity.this)) {

                intent.telefone(EmergenciaActivity.this, "190");
            } else {

                Toast.makeText(EmergenciaActivity.this, "É preciso conceder as permissões necessárias primeiro.", Toast.LENGTH_LONG).show();
            }
        });
    }
}