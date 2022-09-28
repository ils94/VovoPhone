package com.droidev.vovophone;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

public class DiscadorActivity extends AppCompatActivity {

    TextView num1, num2, num3, num4, num5, num6, num7, num8, num9, num0, jogoDaVelha, asterisco, numero, ligar, apagar;
    Intents intents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discador);

        setTitle("DISCADOR");

        ActionBar bar = getSupportActionBar();
        assert bar != null;
        bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#1689d2")));

        intents = new Intents();

        numero = findViewById(R.id.numero);

        ligar = findViewById(R.id.discadorLigar);
        apagar = findViewById(R.id.discadorApagar);

        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);
        num3 = findViewById(R.id.num3);
        num4 = findViewById(R.id.num4);
        num5 = findViewById(R.id.num5);
        num6 = findViewById(R.id.num6);
        num7 = findViewById(R.id.num7);
        num8 = findViewById(R.id.num8);
        num9 = findViewById(R.id.num9);
        num0 = findViewById(R.id.num0);
        jogoDaVelha = findViewById(R.id.jogodavelha);
        asterisco = findViewById(R.id.asterisco);

        numero.setMovementMethod(new ScrollingMovementMethod());

        ligar.setOnClickListener(view -> intents.telefone(DiscadorActivity.this, numero.getText().toString()));

        apagar.setOnClickListener(view -> {

            String num = numero.getText().toString();

            if (!(num.length() == 0)) {

                num = num.substring(0, num.length() - 1);
            }

            numero.setText(num);
        });

        apagar.setOnLongClickListener(view -> {

            numero.setText("");

            return true;
        });

        num1.setOnClickListener(view -> numero.append("1"));

        num2.setOnClickListener(view -> numero.append("2"));

        num3.setOnClickListener(view -> numero.append("3"));

        num4.setOnClickListener(view -> numero.append("4"));

        num5.setOnClickListener(view -> numero.append("5"));

        num6.setOnClickListener(view -> numero.append("6"));

        num7.setOnClickListener(view -> numero.append("7"));

        num8.setOnClickListener(view -> numero.append("8"));

        num9.setOnClickListener(view -> numero.append("9"));

        num0.setOnClickListener(view -> numero.append("0"));

        asterisco.setOnClickListener(view -> numero.append("*"));

        jogoDaVelha.setOnClickListener(view -> numero.append("#"));
    }
}