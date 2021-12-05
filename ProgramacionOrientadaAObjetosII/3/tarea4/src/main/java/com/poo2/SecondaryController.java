package com.poo2;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class SecondaryController {

    @FXML
    private TextField authorTextField;

    @FXML
    private TextField descriptionTextField;

    @FXML
    private TextField editionTextField;

    @FXML
    private TextField genereTextField;

    @FXML
    private TextField nameTextField;

    @FXML
    private Button returnButton;

    @FXML
    private Button saveButton;

    @FXML
    void returnButtonOnMouseClicked(MouseEvent event) throws IOException {
        App.setRoot("primary");
    }

    @FXML
    void saveButtonOnMouseClicked(MouseEvent event) {

    }

}
