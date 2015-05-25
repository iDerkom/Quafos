package com.example.sysadmin.quafos;

import android.util.Log;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CsvFileManager {

    // TODO
    // In der folgenden Methode Kommentare einfügen und eine kurze Methodenbeschreibung
    // hinterlassen.
    public void readQuestionsFromCsvFile(String filePath) throws IOException {
        FileReader fileReader = new FileReader(filePath);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        // Die ersten zwei Zeilen in der CSV Datei sind nicht relevant und sollen nicht
        // berücksichgt werden.

        bufferedReader.readLine();
        bufferedReader.readLine();

        // Die restlichen Zeilen sind wichtig und werden rausgelesen und gespeichert.

        String currentLine;
        while ((currentLine = bufferedReader.readLine()) != null) {
            QuizQuestion quizQuestion = new QuizQuestion();

            // In der CSV Datei sieht ein QuizQuestion-Datensatz so aus: "0;iw31;Auftrag anlegen"
            // Dieser Datensatz wird zerlegt und in die entsprechenden Variablen gespeichert.
            // ==> parsen

            // ID speichern.
            int start = 0;
            int end = currentLine.indexOf(";", start);      // TODO: indexOf(...) = -1
            quizQuestion.setId(Integer.parseInt(currentLine.substring(start, end)));

            // Kategory speichern
            start = end + 1;
            end = currentLine.indexOf(";", start);
            quizQuestion.setCategory(currentLine.substring(start, end));

            // Transaktionscode speichern.
            start = end + 1;
            end = currentLine.indexOf(";", start);
            quizQuestion.setTransactionCode(currentLine.substring(start, end));

            // Transaktion speichern
            start = end + 1;
            end = currentLine.length();
            quizQuestion.setTransaction(currentLine.substring(start, end));

            // Alle QuizQuestions in einen "Container" speichern, der sie alle managet.
            QuizQuestionManager.quizQuestionList.add(quizQuestion);
        }

        bufferedReader.close();

        Log.i("MyAppQuafos", "ID: " +
                Integer.toString(QuizQuestionManager.quizQuestionList.get(0).getId()));
        Log.i("MyAppQuafos", "Kategory: " +
                QuizQuestionManager.quizQuestionList.get(0).getCategory());
        Log.i("MyAppQuafos", "Transaktionscode: " +
                QuizQuestionManager.quizQuestionList.get(0).getTransactionCode());
        Log.i("MyAppQuafos", "Transaktion: " +
                QuizQuestionManager.quizQuestionList.get(0).getTransaction());
    }
}









