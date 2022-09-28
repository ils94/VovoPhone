package com.droidev.vovophone;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView camera, galeria, telefone, contatos, whatsapp, mensagens, brilho, alarme;
    Intents intents;
    Permissoes permissoes;
    Atualizar atualizar;
    String url = "https://github.com/ils94/VovoPhone/releases/download/release/VovoPhone.apk";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("TELA INICIAL");

        ActionBar bar = getSupportActionBar();
        assert bar != null;
        bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#1689d2")));

        intents = new Intents();
        permissoes = new Permissoes();
        atualizar = new Atualizar();

        camera = findViewById(R.id.camera);
        galeria = findViewById(R.id.galeria);
        telefone = findViewById(R.id.telefone);
        contatos = findViewById(R.id.contatos);
        whatsapp = findViewById(R.id.whatsapp);
        mensagens = findViewById(R.id.mensagens);
        brilho = findViewById(R.id.brilho);
        alarme = findViewById(R.id.alarme);

        camera.setOnClickListener(view -> {

            try {

                Intent intent = new Intent(MediaStore.INTENT_ACTION_STILL_IMAGE_CAMERA);
                startActivity(intent);

            } catch (Exception e) {

                Toast.makeText(MainActivity.this, "Erro ao abrir a câmera.", Toast.LENGTH_LONG).show();
            }
        });

        galeria.setOnClickListener(view -> {

            try {

                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.setType("image/*");
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);

            } catch (Exception e) {

                Toast.makeText(MainActivity.this, e.toString(), Toast.LENGTH_LONG).show();
            }
        });

        telefone.setOnClickListener(view -> {

            Random r = new Random();
            int desafio = r.nextInt(99999 - 10001) + 10001;

            EditText unlockTel = new EditText(MainActivity.this);
            unlockTel.setHint("Digite o código aqui.");
            unlockTel.setInputType(InputType.TYPE_CLASS_NUMBER);
            unlockTel.setMaxLines(1);

            LinearLayout lay = new LinearLayout(MainActivity.this);
            lay.setOrientation(LinearLayout.VERTICAL);
            lay.addView(unlockTel);

            AlertDialog dialog = new AlertDialog.Builder(MainActivity.this)
                    .setTitle("Código: " + desafio)
                    .setPositiveButton("Ok", null)
                    .setView(lay)
                    .show();

            Button positiveButton = dialog.getButton(AlertDialog.BUTTON_POSITIVE);

            positiveButton.setOnClickListener(view1 -> {

                if (unlockTel.getText().toString().equals(String.valueOf(desafio))) {

                    intents.intentActivity(MainActivity.this, TelefoneActivity.class);

                    dialog.dismiss();
                } else {

                    Toast.makeText(MainActivity.this, "Código incorreto.", Toast.LENGTH_SHORT).show();
                }

            });
        });

        mensagens.setOnClickListener(view -> {

            try {

                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_DEFAULT);
                intent.setType("vnd.android-dir/mms-sms");
                startActivity(intent);

            } catch (Exception e) {

                Toast.makeText(MainActivity.this, "Erro ao abrir o navegador.", Toast.LENGTH_LONG).show();
            }
        });

        whatsapp.setOnClickListener(view -> intents.intentActivity(MainActivity.this, WhatsappActivity.class));

        contatos.setOnClickListener(view -> {

            try {

                Intent intent = new Intent(Intent.ACTION_VIEW, ContactsContract.Contacts.CONTENT_URI);
                startActivity(intent);

            } catch (Exception e) {

                Toast.makeText(MainActivity.this, "Erro ao abrir os contatos.", Toast.LENGTH_LONG).show();
            }
        });

        brilho.setOnClickListener(view -> intents.intentActivity(MainActivity.this, BrilhoActivity.class));

        alarme.setOnClickListener(view -> {

            try {

                Intent intent = new Intent(AlarmClock.ACTION_SHOW_ALARMS);
                startActivity(intent);

            } catch (Exception e) {

                Toast.makeText(MainActivity.this, "Erro ao abrir o Relógio.", Toast.LENGTH_LONG).show();
            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_activity_menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @SuppressLint("NonConstantResourceId")
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.configuracoes:

                startActivity(new Intent(android.provider.Settings.ACTION_SETTINGS));

                break;

            case R.id.configurarContatos:

                intents.intentActivity(MainActivity.this, ConfigurarContatosActivity.class);

                break;

            case R.id.googleplaystore:

                Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.android.vending");
                if (launchIntent != null) {
                    startActivity(launchIntent);
                } else {

                    Toast.makeText(MainActivity.this, "Não foi possível abrir a Google Play Store.", Toast.LENGTH_SHORT).show();
                }

                break;

            case R.id.navegador:

                Intent browser = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com.br"));
                startActivity(browser);

                break;

            case R.id.atualizar:

                if (permissoes.permissoesGerais(MainActivity.this)) {

                    atualizar.downloader(MainActivity.this, url);
                } else {

                    Toast.makeText(MainActivity.this, "É preciso conceder as permissões necessárias primeiro.", Toast.LENGTH_LONG).show();
                }

                break;
        }
        return super.onOptionsItemSelected(item);
    }
}