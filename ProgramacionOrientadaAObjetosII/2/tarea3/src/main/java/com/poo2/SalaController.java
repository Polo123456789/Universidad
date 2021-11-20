package com.poo2;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class SalaController {
    @FXML
    private Button enviarMensajeButton;

    @FXML
    private TextArea mensajeTextArea;

    @FXML
    private ListView<Mensaje> mensajesListView;

    @FXML
    private TextField usuarioTextField;

    private static ObservableList<Mensaje> mensajes =
        FXCollections.observableArrayList();
    private Boolean envioPrimerMensaje = false;
    private String usuario = "";

    @FXML
    public void initialize() {
        mensajesListView.setItems(mensajes);
        mensajesListView.setPlaceholder(new Label("Sin mensajes"));
    }

    public void enviarMensajeButtonClick() {
        if (!envioPrimerMensaje) {
            registarUsuario();
        }
        mensajes.add(new Mensaje(usuario, mensajeTextArea.getText()));
        mensajeTextArea.setText("");
    }

    private void registarUsuario() {
        usuario = usuarioTextField.getText();
        usuarioTextField.setDisable(true);
        PrimaryController.usuarios.add(usuario);
        envioPrimerMensaje = true;
    }
}
