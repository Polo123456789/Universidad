package com.poo2;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class PrimaryController {

    @FXML
    private TableColumn<?, ?> authorTableColumn;

    @FXML
    private TableView<?> booksTableView;

    @FXML
    private Button createButton;

    @FXML
    private TableColumn<?, ?> descriptionTableColumn;

    @FXML
    private TableColumn<?, ?> editionTableColumn;

    @FXML
    private ComboBox<?> fieldsComboBox;

    @FXML
    private TableColumn<?, ?> genereTableColumn;

    @FXML
    private TableColumn<?, ?> nameTableColumn;

    @FXML
    private Button searchButton;

    @FXML
    private TextField valueTextField;

    @FXML
    void createButtonOnMouseClicked(MouseEvent event) throws IOException {
        App.setRoot("secondary");
    }

    @FXML
    void searchButtonOnMouseClicked(MouseEvent event) {

    }

}
