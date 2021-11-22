package com.poo2;

import javafx.beans.property.SimpleStringProperty;

public class AnswerPercentages {
    private SimpleStringProperty question;
    private SimpleStringProperty happyPercentage;
    private SimpleStringProperty neutralPercentage;
    private SimpleStringProperty sadPercentage;

    public AnswerPercentages(String question,
                             String happyPercentage,
                             String neutralPercentage,
                             String sadPercentage) {

        this.question = new SimpleStringProperty(question);
        this.happyPercentage = new SimpleStringProperty(happyPercentage);
        this.neutralPercentage = new SimpleStringProperty(neutralPercentage);
        this.sadPercentage = new SimpleStringProperty(sadPercentage);
    }

    public String getQuestion() {
        return question.get();
    }

    public void setQuestion(String question) {
        this.question.set(question);
    }

    public String getHappyPercentage() {
        return happyPercentage.get();
    }

    public void setHappyPercentage(String happyPercentage) {
        this.happyPercentage.set(happyPercentage);
    }

    public String getNeutralPercentage() {
        return neutralPercentage.get();
    }

    public void setNeutralPercentage(String neutralPercentage) {
        this.neutralPercentage.set(neutralPercentage);
    }

    public String getSadPercentage() {
        return sadPercentage.get();
    }

    public void setSadPercentage(String sadPercentage) {
        this.sadPercentage.set(sadPercentage);
    }

    @Override
    public String toString() {
        return "AnswerPercentages [happyPercentage=" + happyPercentage.get()
               + ", neutralPercentage=" + neutralPercentage.get()
               + ", question=" + question.get()
               + ", sadPercentage=" + sadPercentage.get() + "]";
    }

}
