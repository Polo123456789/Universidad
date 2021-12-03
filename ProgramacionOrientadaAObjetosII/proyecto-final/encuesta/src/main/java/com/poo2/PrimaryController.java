package com.poo2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;

import static com.poo2.Answer.Answers;

public class PrimaryController {
    @FXML
    private Circle happyFaceCircle;
    @FXML
    private Circle neutralFaceCirle;
    @FXML
    private Circle sadFaceCircle;
    @FXML
    private Label questionLabel;

    private Integer questionId = -1;
    private List<Answer> answers = new ArrayList<>();
    private ArrayList<Question> questions = null; // Value given in
                                                  // loadQuestions

    @FXML
    void initialize() {
        loadQuestions();
        nextQuestion();
    }

    @FXML
    void happyFaceCirleClick(MouseEvent event) throws IOException {
        registerAnswer(Answers.happy);
    }

    @FXML
    void neutralFaceCirleClick(MouseEvent event) throws IOException {
        registerAnswer(Answers.neutral);
    }

    @FXML
    void sadFaceCircleClick(MouseEvent event) throws IOException {
        registerAnswer(Answers.sad);
    }

    private void registerAnswer(Answers ans) throws IOException {
        Answer a = new Answer(questionId + 1, ans);
        answers.add(a);
        if (allQuestionsWhereAnswered()) {
            saveAsnwers();
            switchToSecondary();
            return;
        } 
        nextQuestion();
    }

    private void nextQuestion() {
        questionId++;
        questionLabel.setText(questions.get(questionId).getText());
    }

    private Boolean allQuestionsWhereAnswered() {
        return questionId == questions.size()- 1;
    }

    private void loadQuestions() {
        questions = DB.getInstance().getQuestions();
    }
    
    private void saveAsnwers() {
        DB db = DB.getInstance();
        for (var ans : answers) {
            db.saveAnswer(ans);
        }
    }

    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }

}
