package com.poo2;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Answer {
    public static enum Answers {
        undefined(-1),
        happy(0),
        neutral(1),
        sad(2);

        public final int val;
        private Answers(int val) {
            this.val = val;
        }

        public static Answers valueOf(Integer v) {
            switch (v) {
                case 0:
                    return happy;
                case 1:
                    return neutral;
                case 2:
                    return sad;
            }
            return undefined;
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

    public String getDate() {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        return df.format(date);
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
