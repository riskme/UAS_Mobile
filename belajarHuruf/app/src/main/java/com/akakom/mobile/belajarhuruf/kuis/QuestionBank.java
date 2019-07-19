package com.akakom.mobile.belajarhuruf.kuis;

public class QuestionBank {

    private String textQuestions [] = {
            "1. Apa huruf alfabet ke-14?",
            "2. Apa huruf alfabet ke-4?",
            "3. Hewan apa yang berawalan huruf alfabet ke-2?",
            "4. Buah apa yang berawalan huruf alfabet ke-10?",
            "5. Ada berapa total huruf alfabet?"
    };

    // array of multiple choices for each question
    private String multipleChoice [][] = {
            {"K", "L", "M", "N"},
            {"A", "B", "C", "D"},
            {"Angsa", "Jerapah", "Gajah", "Bebek"},
            {"Mangga", "Jeruk", "Anggur", "Belewah"},
            {"25", "26", "27", "28"}
    };

    private String mCorrectAnswers[] = {"N", "D", "Bebek", "Jeruk", "26"};

    public int getLength(){
        return textQuestions.length;
    }

    public String getQuestion(int a) {
        String question = textQuestions[a];
        return question;
    }

    public String getChoice(int index, int num) {
        String choice0 = multipleChoice[index][num-1];
        return choice0;
    }

    public String getCorrectAnswer(int a) {
        String answer = mCorrectAnswers[a];
        return answer;
    }
}