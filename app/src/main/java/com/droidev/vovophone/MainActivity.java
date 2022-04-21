package com.droidev.vovophone;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button camera, galeria, telefone, contatos, whatsapp, mensagens, brilho, alarme;
    Intents intents;
    Permissoes permissoes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        intents = new Intents();
        permissoes = new Permissoes();

        setTitle("TELA INICIAL");

        camera = findViewById(R.id.camera);
        galeria = findViewById(R.id.galeria);
        telefone = findViewById(R.id.telefone);
        contatos = findViewById(R.id.contatos);
        whatsapp = findViewById(R.id.whatsapp);
        mensagens = findViewById(R.id.mensagens);
        brilho = findViewById(R.id.brilho);
        alarme = findViewById(R.id.alarme);

        camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {

                    Intent intent = new Intent(MediaStore.INTENT_ACTION_STILL_IMAGE_CAMERA);
                    startActivity(intent);

                } catch (Exception e) {

                    Toast.makeText(MainActivity.this, "Erro ao abrir a câmera.", Toast.LENGTH_LONG).show();
                }
            }
        });

        galeria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {

                    Intent intent = new Intent();
                    intent.setType("image/*");
                    intent.setAction(Intent.ACTION_VIEW);
                    startActivity(intent);

                } catch (Exception e) {

                    Toast.makeText(MainActivity.this, "Erro ao abrir a galeria.", Toast.LENGTH_LONG).show();
                }
            }
        });

        telefone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (permissoes.permissoesContatos(MainActivity.this)) {

                    intents.intentActivity(MainActivity.this, TelefoneActivity.class);
                } else {

                    Toast.makeText(MainActivity.this, "É preciso conceder as permissões necessárias primeiro.", Toast.LENGTH_LONG).show();
                }
            }
        });

        mensagens.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {

                    Intent intent = new Intent(Intent.ACTION_MAIN);
                    intent.addCategory(Intent.CATEGORY_DEFAULT);
                    intent.setType("vnd.android-dir/mms-sms");
                    startActivity(intent);

                } catch (Exception e) {

                    Toast.makeText(MainActivity.this, "Erro ao abrir o navegador.", Toast.LENGTH_LONG).show();
                }
            }
        });

        whatsapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (permissoes.permissoesContatos(MainActivity.this)) {

                    intents.intentActivity(MainActivity.this, WhatsappActivity.class);
                } else {

                    Toast.makeText(MainActivity.this, "É preciso conceder as permissões necessárias primeiro.", Toast.LENGTH_LONG).show();
                }
            }
        });

        contatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {

                    Intent intent = new Intent(Intent.ACTION_VIEW, ContactsContract.Contacts.CONTENT_URI);
                    startActivity(intent);

                } catch (Exception e) {

                    Toast.makeText(MainActivity.this, "Erro ao abrir os contatos.", Toast.LENGTH_LONG).show();
                }
            }
        });

        brilho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                intents.intentActivity(MainActivity.this, BrilhoActivity.class);
            }
        });

        alarme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {

                    Intent intent = new Intent(AlarmClock.ACTION_SHOW_ALARMS);
                    startActivity(intent);

                } catch (Exception e) {

                    Toast.makeText(MainActivity.this, "Erro ao abrir o Relógio.", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_activity_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.configuracoes:

                break;

            case R.id.configuracoesDeContatos:

                intents.intentActivity(MainActivity.this, ConfigurarContatosActivity.class);

                break;

            case R.id.googleplaystore:

                break;
            case R.id.navegador:

                break;
        }
        return super.onOptionsItemSelected(item);
    }
}