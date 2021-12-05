package com.poo2;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
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
    void saveButtonOnMouseClicked(MouseEvent event) throws IOException {
        String name = nameTextField.getText();
        String author = authorTextField.getText();
        String description = descriptionTextField.getText();
        String genere = genereTextField.getText();
        String editionString = editionTextField.getText();

        if (name == null || name.isBlank()) {
            errorMessage("El campo `Nombre` no puede estar en blanco");
            return;
        }
        if (author == null || author.isBlank()) {
            errorMessage("El campo `Autor` no puede estar en blanco");
            return;
        }
        if (description == null || description.isBlank()) {
            errorMessage("El campo `Descripcion` no puede estar en blanco");
            return;
        }
        if (genere == null || genere.isBlank()) {
            errorMessage("El campo `Genero` no puede estar en blanco");
            return;
        }
        if (editionString == null || editionString.isBlank()) {
            errorMessage("El campo `Edicion` no puede estar en blanco");
            return;
        }

        Integer edition = null;
        try {
            edition = Integer.valueOf(editionString);
        } catch (final NumberFormatException e) {
            errorMessage("El campo `Edicion` tiene que ser un numero entero");
            return;
        }
        assert edition != null;

        // The id is temporarily 0, when inserting it will be automatically
        // updated
        var b = new Book(0, name, author, description, genere, edition);
        DB.getInstance().saveBook(b);
        App.setRoot("primary");
    }

    void errorMessage(String msg) {
        var a = new Alert(AlertType.ERROR);
        a.setTitle("Error");
        a.setHeaderText("Error al ingresar los datos");
        a.setContentText(msg);
        a.showAndWait();
    }

}
