package com.poo2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

public class PrimaryController {
    protected static ObservableList<String> usuarios =
        FXCollections.observableArrayList();
    private List<Stage> stages = new ArrayList<>();

    @FXML
    private Button ingresarButton;

    @FXML
    private Label usuariosLabel;

    @FXML
    private ListView<String> usuariosListView;

    @FXML
    private void initialize() {
        usuariosListView.setItems(usuarios);
        usuariosListView.setPlaceholder(new Label("Sin usuarios"));
    }

    @FXML
    void ingresarButtonClick() {
        try {
            Stage s = new Stage();
            s.setTitle("Sala de chat");
            s.setScene(new Scene(App.loadFXML("sala")));
            s.show();
            stages.add(s);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
