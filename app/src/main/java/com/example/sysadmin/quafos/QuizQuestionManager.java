package com.example.sysadmin.quafos;

import java.util.ArrayList;
import java.util.List;

public class QuizQuestionManager {

    public static List<QuizQuestion> quizQuestionList = new ArrayList<QuizQuestion>();

    public static QuizQuestion getRandomQuizQuestin() {
        int randomNumber = (int)(Math.random()*(quizQuestionList.size()-1)+0.5);
        return quizQuestionList.get(randomNumber);
    }
}
