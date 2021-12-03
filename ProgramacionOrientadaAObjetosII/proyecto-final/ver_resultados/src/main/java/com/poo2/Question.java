package com.poo2;

public class Question {
    private final Integer questionId;
    private final String text;

    public Question(Integer questionId, String text) {
        this.questionId = questionId;
        this.text = text;
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return "Question [questionId=" + questionId + ", text=" + text + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Question other = (Question) obj;
        if (questionId == null) {
            if (other.questionId != null)
                return false;
        } else if (!questionId.equals(other.questionId))
            return false;
        if (text == null) {
            if (other.text != null)
                return false;
        } else if (!text.equals(other.text))
            return false;
        return true;
    }
}
