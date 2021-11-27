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

    // Ill guess that the questions should be stored in the db, so they will be
    // synchronized in between the apps, so this is just temporal for testing
    //
    // TODO: Remove
    final private static String[] questions = {
        "Nos recomendarias a tu amigos?",
        "Como valorarias la atencion de nuestro personal?",
        "Que opinas del tiempo de espera para ser atendido?",
        "Como valorarias nuestra relacion calidad-precio?",
        "En general, como valoras la lipmieza de la tienda?",
    };

    @FXML
    void initialize() {
        // TODO: loadQuestions();
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
        Answer a = new Answer(questionId, ans);
        answers.add(a);
        if (allQuestionsWhereAnswered()) {
            // TODO: saveAsnwers();

            // This is just to check that the answers where saved correctly
            // TODO: Remove
            for (var i : answers) {
                System.out.println(i);
            }

            switchToSecondary();
            return;
        } 
        nextQuestion();
    }

    private void nextQuestion() {
        questionId++;

        // TODO: Update to use questions from db
        questionLabel.setText(questions[questionId]);
    }

    private Boolean allQuestionsWhereAnswered() {
        // TODO: Update to use questions from db
        return questionId == questions.length - 1;
    }

    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }

}
