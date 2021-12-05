package com.poo2;

import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class PrimaryController {
    @FXML
    private TableView<Book> booksTableView;

    @FXML
    private Button createButton;

    @FXML
    private TableColumn<Book, String> nameTableColumn;

    @FXML
    private TableColumn<Book, String> authorTableColumn;

    @FXML
    private TableColumn<Book, String> descriptionTableColumn;

    @FXML
    private TableColumn<Book, String> genereTableColumn;

    @FXML
    private TableColumn<Book, Integer> editionTableColumn;

    @FXML
    private ComboBox<String> fieldsComboBox;

    @FXML
    private Button searchButton;

    @FXML
    private TextField valueTextField;

    private ObservableList<Book> books = FXCollections.observableArrayList();

    @FXML
    void initialize() {
        fieldsComboBox.getItems().addAll(
            "nombre",
            "autor",
            "descripcion",
            "genero",
            "edicion"
        );
        fieldsComboBox.getSelectionModel().selectFirst();

        nameTableColumn.setCellValueFactory(
            new PropertyValueFactory<>("name")
        );
        authorTableColumn.setCellValueFactory(
            new PropertyValueFactory<>("autor")
        );
        descriptionTableColumn.setCellValueFactory(
            new PropertyValueFactory<>("descripcion")
        );
        genereTableColumn.setCellValueFactory(
            new PropertyValueFactory<>("genero")
        );
        editionTableColumn.setCellValueFactory(
            new PropertyValueFactory<>("edition")
        );

        booksTableView.setItems(books);
        loadBooks();
    }

    @FXML
    void createButtonOnMouseClicked(MouseEvent event) throws IOException {
        App.setRoot("secondary");
    }

    @FXML
    void searchButtonOnMouseClicked(MouseEvent event) {
        String selected = fieldsComboBox
                            .getSelectionModel()
                            .getSelectedItem();
        String value = valueTextField.getText();

        if (value == null || value.isBlank()) {
            loadBooks();
            return;
        }

        // Only case where is should be an int
        if (selected.equals("edicion")) {
            Integer valueInteger = null;
            try {
                valueInteger = Integer.valueOf(value);
            } catch (final NumberFormatException e) {
                errorMessage("Las ediciones solo pueden ser numeros enteros");
                return;
            }
            loadBooks(selected, valueInteger);
        } else {
            loadBooks(selected, value);
        }
    }

    void errorMessage(String msg) {
        var a = new Alert(AlertType.ERROR);
        a.setTitle("Error");
        a.setHeaderText("Error al ingresar los datos");
        a.setContentText(msg);
        a.showAndWait();
    }

    void loadBooks(String field, String value) {
        var newBooks = DB.getInstance().getBooks(field, value);
        books.setAll(newBooks);
    }

    void loadBooks(String field, Integer value) {
        var newBooks = DB.getInstance().getBooks(field, value);
        books.setAll(newBooks);
    }

    void loadBooks() {
        var newBooks = DB.getInstance().getBooks();
        books.setAll(newBooks);
    }
}
