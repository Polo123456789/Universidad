package com.poo2;

import java.util.Date;

public class Answer {
    public static enum Answers {
        happy(0),
        neutral(1),
        sad(2);

        public final int val;
        private Answers(int val) {
            this.val = val;
        }
    }

    private final Integer questionId;
    private final Answers answer;
    private final Date date;

    public Answer(Integer questionId, Answers answer) {
        this.questionId = questionId;
        this.answer = answer;
        this.date = new Date();
    }

    public Answers getAnswer() {
        return answer;
    }

    public Integer getQuestionId() {
        return questionId;

    }

    @Override
    public String toString() {
        return "Answer [answer=" + answer + ", date=" + date
               + ", questionId=" + questionId + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Answer other = (Answer) obj;
        if (answer != other.answer)
            return false;
        if (date == null) {
            if (other.date != null)
                return false;
        } else if (!date.equals(other.date))
            return false;
        if (questionId == null) {
            if (other.questionId != null)
                return false;
        } else if (!questionId.equals(other.questionId))
            return false;
        return true;
    }
}
