package com.example.sysadmin.quafos;

import android.app.AlertDialog;
import android.content.Context;

public class InfoDialog {

    public static void showDialog(Context context, String message) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);

        alertDialogBuilder.setMessage(message);
        alertDialogBuilder.setPositiveButton("OK", null);
        alertDialogBuilder.show();
    }
}
