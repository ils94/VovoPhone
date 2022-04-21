package com.droidev.vovophone;

import android.app.Activity;
import android.widget.Button;

public class Contatos {

    public void carregarContatos(Activity activity, Button contato1, Button contato2, Button contato3, Button contato4, Button contato5, Button contato6) {

        TinyDB tinyDB = new TinyDB(activity);

        if (!tinyDB.getString("nomeContato1").equals("")) {

            contato1.setText(tinyDB.getString("nomeContato1"));
        }

        if (!tinyDB.getString("nomeContato2").equals("")) {

            contato2.setText(tinyDB.getString("nomeContato2"));
        }

        if (!tinyDB.getString("nomeContato3").equals("")) {

            contato3.setText(tinyDB.getString("nomeContato3"));
        }

        if (!tinyDB.getString("nomeContato4").equals("")) {

            contato4.setText(tinyDB.getString("nomeContato4"));
        }

        if (!tinyDB.getString("nomeContato5").equals("")) {

            contato5.setText(tinyDB.getString("nomeContato5"));
        }

        if (!tinyDB.getString("nomeContato6").equals("")) {

            contato6.setText(tinyDB.getString("nomeContato6"));
        }
    }
}
