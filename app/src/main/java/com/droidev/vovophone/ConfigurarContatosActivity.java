package com.droidev.vovophone;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class ConfigurarContatosActivity extends AppCompatActivity {

    private EditText nomeContato1, numeroContato1, nomeContato2, numeroContato2,
            nomeContato3, numeroContato3, nomeContato4, numeroContato4,
            nomeContato5, numeroContato5, nomeContato6, numeroContato6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configurar_contatos);

        setTitle("CONFIGURAR CONTATOS");

        ActionBar bar = getSupportActionBar();
        assert bar != null;
        bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#1689d2")));

        nomeContato1 = findViewById(R.id.nomeContato1);
        numeroContato1 = findViewById(R.id.numeroContato1);
        nomeContato2 = findViewById(R.id.nomeContato2);
        numeroContato2 = findViewById(R.id.numeroContato2);
        nomeContato3 = findViewById(R.id.nomeContato3);
        numeroContato3 = findViewById(R.id.numeroContato3);
        nomeContato4 = findViewById(R.id.nomeContato4);
        numeroContato4 = findViewById(R.id.numeroContato4);
        nomeContato5 = findViewById(R.id.nomeContato5);
        numeroContato5 = findViewById(R.id.numeroContato5);
        nomeContato6 = findViewById(R.id.nomeContato6);
        numeroContato6 = findViewById(R.id.numeroContato6);

        carregar();

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.configurar_contatos_activity_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.salvar) {
            salvar();

            Toast.makeText(ConfigurarContatosActivity.this, "Salvo", Toast.LENGTH_LONG).show();
        }
        return super.onOptionsItemSelected(item);
    }

    private void salvar() {

        TinyDB tinyDB = new TinyDB(ConfigurarContatosActivity.this);

        tinyDB.remove("nomeContato1");
        tinyDB.remove("numeroContato1");
        tinyDB.remove("nomeContato2");
        tinyDB.remove("numeroContato2");
        tinyDB.remove("nomeContato3");
        tinyDB.remove("numeroContato3");
        tinyDB.remove("nomeContato4");
        tinyDB.remove("numeroContato4");
        tinyDB.remove("nomeContato5");
        tinyDB.remove("numeroContato5");
        tinyDB.remove("nomeContato6");
        tinyDB.remove("numeroContato6");

        tinyDB.putString("nomeContato1", nomeContato1.getText().toString().replace(" ", ""));
        tinyDB.putString("numeroContato1", numeroContato1.getText().toString().replace(" ", ""));
        tinyDB.putString("nomeContato2", nomeContato2.getText().toString().replace(" ", ""));
        tinyDB.putString("numeroContato2", numeroContato2.getText().toString().replace(" ", ""));
        tinyDB.putString("nomeContato3", nomeContato3.getText().toString().replace(" ", ""));
        tinyDB.putString("numeroContato3", numeroContato3.getText().toString().replace(" ", ""));
        tinyDB.putString("nomeContato4", nomeContato4.getText().toString().replace(" ", ""));
        tinyDB.putString("numeroContato4", numeroContato4.getText().toString().replace(" ", ""));
        tinyDB.putString("nomeContato5", nomeContato5.getText().toString().replace(" ", ""));
        tinyDB.putString("numeroContato5", numeroContato5.getText().toString().replace(" ", ""));
        tinyDB.putString("nomeContato6", nomeContato6.getText().toString().replace(" ", ""));
        tinyDB.putString("numeroContato6", numeroContato6.getText().toString().replace(" ", ""));
    }

    private void carregar() {

        TinyDB tinyDB = new TinyDB(ConfigurarContatosActivity.this);

        nomeContato1.setText(tinyDB.getString("nomeContato1"));
        numeroContato1.setText(tinyDB.getString("numeroContato1"));
        nomeContato2.setText(tinyDB.getString("nomeContato2"));
        numeroContato2.setText(tinyDB.getString("numeroContato2"));
        nomeContato3.setText(tinyDB.getString("nomeContato3"));
        numeroContato3.setText(tinyDB.getString("numeroContato3"));
        nomeContato4.setText(tinyDB.getString("nomeContato4"));
        numeroContato4.setText(tinyDB.getString("numeroContato4"));
        nomeContato5.setText(tinyDB.getString("nomeContato5"));
        numeroContato5.setText(tinyDB.getString("numeroContato5"));
        nomeContato6.setText(tinyDB.getString("nomeContato6"));
        numeroContato6.setText(tinyDB.getString("numeroContato6"));
    }
}