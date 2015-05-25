package com.example.sysadmin.quafos;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class TransactionActivity extends Activity {

    TextView textViewQuestion = null;
    EditText editTextAnswer = null;
    Button buttonOK = null;
    QuizQuestion quizQuestion = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction);

        textViewQuestion = (TextView)findViewById(R.id.textViewQuestion);
        editTextAnswer = (EditText)findViewById(R.id.editTextAnswer);
        buttonOK = (Button) findViewById(R.id.buttonOK);

        showQuestin();
    }

    private void showQuestin () {
        // TODO: Zufallszahlengenerierung optimieren. Die Generierung ist etwas einseitig.
        quizQuestion = QuizQuestionManager.getRandomQuizQuestin();
        textViewQuestion.setText(quizQuestion.getTransaction());
    }

    public void checkTheAnswer(View view) {

        if(editTextAnswer.getText().toString().isEmpty())
            // Eingabefeld ist leer
            InfoDialog.showDialog(this, "Bitte geben Sie eine Antwort ein.");
        else if(editTextAnswer.getText().toString().equals(quizQuestion.getTransactionCode()))
            // Antwort ist richtig
            InfoDialog.showDialog(this, "Sehr gut! Ihre antwort ist richtig.");
        else
            // Antwort ist falsch
            InfoDialog.showDialog(this, "Ihre Antwort ist leider falsch.");

        // Zeige nächste Frage.
        showQuestin();
    }
}
