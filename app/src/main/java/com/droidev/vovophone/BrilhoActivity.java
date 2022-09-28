package com.droidev.vovophone;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.provider.Settings;
import android.widget.TextView;
import android.widget.Toast;

public class BrilhoActivity extends AppCompatActivity {

    TextView percent25, percent50, percent75, percent100;
    Permissoes permissoes;
    String titulo = "BRILHO: ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brilho);

        ActionBar bar = getSupportActionBar();
        assert bar != null;
        bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#1689d2")));

        permissoes = new Permissoes();

        try {
            setTitle(titulo + (int) getCurrentBrightness() + "%");
        } catch (Settings.SettingNotFoundException e) {
            e.printStackTrace();
        }

        percent25 = findViewById(R.id.percent25);
        percent50 = findViewById(R.id.percent50);
        percent75 = findViewById(R.id.percent75);
        percent100 = findViewById(R.id.percent100);

        percent25.setOnClickListener(view -> {

            if (permissoes.permissionsConfigSistema(BrilhoActivity.this)) {

                adjust(25);

                setTitle(titulo + "25%");
            } else {

                Toast.makeText(BrilhoActivity.this, "É preciso conceder as permissões necessárias primeiro.", Toast.LENGTH_LONG).show();
            }
        });

        percent50.setOnClickListener(view -> {

            if (permissoes.permissionsConfigSistema(BrilhoActivity.this)) {

                adjust(50);

                setTitle(titulo + "50%");
            } else {

                Toast.makeText(BrilhoActivity.this, "É preciso conceder as permissões necessárias primeiro.", Toast.LENGTH_LONG).show();
            }
        });

        percent75.setOnClickListener(view -> {

            if (permissoes.permissionsConfigSistema(BrilhoActivity.this)) {

                adjust(75);

                setTitle(titulo + "75%");
            } else {

                Toast.makeText(BrilhoActivity.this, "É preciso conceder as permissões necessárias primeiro.", Toast.LENGTH_LONG).show();
            }
        });

        percent100.setOnClickListener(view -> {

            if (permissoes.permissionsConfigSistema(BrilhoActivity.this)) {

                adjust(100);

                setTitle(titulo + "100%");
            } else {

                Toast.makeText(BrilhoActivity.this, "É preciso conceder as permissões necessárias primeiro.", Toast.LENGTH_LONG).show();
            }
        });
    }

    private float normalize(float x, float inMin, float inMax, float outMin, float outMax) {
        float outRange = outMax - outMin;
        float inRange = inMax - inMin;
        return (x - inMin) * outRange / inRange + outMin;
    }

    private void adjust(int i) {


        float brightness = normalize(i, 0, 100, 0.0f, 255.0f);

        ContentResolver cResolver = getContentResolver();

        Settings.System.putInt(getContentResolver(),
                Settings.System.SCREEN_BRIGHTNESS_MODE, Settings.System.SCREEN_BRIGHTNESS_MODE_MANUAL);

        Settings.System.putInt(cResolver, Settings.System.SCREEN_BRIGHTNESS, (int) brightness);
    }

    private float getCurrentBrightness() throws Settings.SettingNotFoundException {

        ContentResolver cResolver = getContentResolver();

        float b = Settings.System.getInt(cResolver, Settings.System.SCREEN_BRIGHTNESS);

        return Math.round(b / 255 * 100);
    }
}