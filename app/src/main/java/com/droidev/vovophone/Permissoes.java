package com.droidev.vovophone;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.provider.Settings;

public class Permissoes {

    public boolean permissoesGerais(Activity activity) {

        boolean check = false;

        PackageManager manager = activity.getPackageManager();

        int contatos = manager.checkPermission("android.permission.READ_CONTACTS", activity.getPackageName());
        int telefone = manager.checkPermission("android.permission.CALL_PHONE", activity.getPackageName());
        int memoria = manager.checkPermission("android.permission.WRITE_EXTERNAL_STORAGE", activity.getPackageName());

        if (!(contatos == PackageManager.PERMISSION_GRANTED) || !(telefone == PackageManager.PERMISSION_GRANTED) || !(memoria == PackageManager.PERMISSION_GRANTED)) {

            Intent intent = new Intent();
            intent.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
            Uri uri = Uri.fromParts("package", activity.getPackageName(), null);
            intent.setData(uri);
            activity.startActivity(intent);
        } else {

            check = true;
        }

        return check;
    }

    public boolean permissionsConfigSistema(Activity activity) {

        boolean check = false;

        if (!Settings.System.canWrite(activity)) {

            Intent intent = new Intent(Settings.ACTION_MANAGE_WRITE_SETTINGS);
            intent.setData(Uri.parse("package:" + activity.getPackageName()));
            activity.startActivity(intent);
        } else {

            check = true;
        }

        return check;
    }
}
