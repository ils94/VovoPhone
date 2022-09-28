package com.droidev.vovophone;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;

public class Intents {

    public void intentActivity(Activity activity, Class classe) {

        Intent myIntent = new Intent(activity, classe);
        activity.startActivity(myIntent);

    }

    public void telefone(Activity activity, String telefone) {

        Intent callIntent = new Intent(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse("tel:" + telefone));
        activity.startActivity(callIntent);
    }

    public void whatsappCall(Activity activity, String contato){

        new Thread(new Runnable() {
            @SuppressLint("Range")
            @Override
            public void run() {

                long id = 0;

                ContentResolver resolver = activity.getContentResolver();

                Cursor cursor = resolver.query(
                        ContactsContract.Data.CONTENT_URI,
                        null, null, null,
                        ContactsContract.Contacts.DISPLAY_NAME);

                while (cursor.moveToNext()) {

                    if (cursor.getString(cursor.getColumnIndex(ContactsContract.Data.DISPLAY_NAME)).equals(contato) && cursor.getString(cursor.getColumnIndex(ContactsContract.Data.MIMETYPE)).equals("vnd.android.cursor.item/vnd.com.whatsapp.voip.call")){

                        id = cursor.getLong(cursor.getColumnIndex(ContactsContract.Data._ID));

                        break;
                    }
                }

                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);

                intent.setDataAndType(Uri.parse("content://com.android.contacts/data/" + id),
                        "vnd.android.cursor.item/vnd.com.whatsapp.voip.call");
                intent.setPackage("com.whatsapp");

                activity.startActivity(intent);
            }
        }).start();
    }
}
