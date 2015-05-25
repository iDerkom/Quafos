package com.example.sysadmin.quafos;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;


public class MainActivity extends Activity {

    private CsvFileManager csvFileManager = new CsvFileManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // App Ordner ("Quafos) erstellen, wenn noch kein existiert.

        File appFolder = new File(Environment.getExternalStorageDirectory(), "Quafos");
        if(!appFolder.exists())
            appFolder.mkdir();

        // Die Quiz Fragen aus einer CSV Datei lesen.

        try {
            String csvFilePath = appFolder.getPath() + "/Quafos.csv";
            csvFileManager.readQuestionsFromCsvFile(csvFilePath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            showAlertDialog("Die Datei Quafos.csv existiert nicht. Bitter erstellen Sie eine CSV" +
                    "Datei mit den Quiz Fragen.");
            // TODO: App schließen
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showAlertDialog(String message) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);

        alertDialogBuilder.setMessage(message);
        alertDialogBuilder.setPositiveButton("OK", null);
        alertDialogBuilder.show();
    }

    public void showTransactionActivity(View view) {
        startActivity(new Intent(this, TransactionActivity.class));
    }
}

/*
Shortcuts - Eclipse
In die Methode oder Clase springen (Declaration):           Strg + Button1 Click | F3
Eine Zeite unter dem Kursor einfügen:                       Strg + Enter
Zeile löschen:                                              Strg + D
Zeile nach oben bewegen:                                    Alt + Up
Zeile nach unten bewegen:                                   Alt + Down
Eine Funktion generieren:                                   Alt + Einfg

Shortcuts - Android Studio
In die Methode oder Clase springen:         Strg + B
Eine Zeite unter dem Kursor einfügen:       Strg + Enter
Zeile löschen:                              Strg + Y
Zeile duplizieren:                          Strg + D
Zeile nach oben bewegen:                    Shift + Alt + Up
Zeile nach unten bewegen:                   Shift + Alt + Down

 */
