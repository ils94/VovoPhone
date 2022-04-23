package com.droidev.vovophone;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class DiscadorActivity extends AppCompatActivity {

    TextView num1, num2, num3, num4, num5, num6, num7, num8, num9, num0, jogoDaVelha, asterisco, numero, ligar, apagar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discador);

        setTitle("DISCADOR");

        ActionBar bar = getSupportActionBar();
        assert bar != null;
        bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#1689d2")));

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

        ligar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });

        apagar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String num = numero.getText().toString();

                if (!(num.length() == 0)) {

                    num = num.substring(0, num.length() - 1);
                }

                numero.setText(num);
            }
        });

        num1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                numero.append("1");
            }
        });

    }
}