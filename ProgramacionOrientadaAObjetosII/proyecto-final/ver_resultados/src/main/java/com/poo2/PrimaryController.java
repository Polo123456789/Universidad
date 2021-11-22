package com.poo2;

import java.time.LocalDate;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class PrimaryController {

    @FXML
    private TableView<AnswerPercentages> contentTableView;

    @FXML
    private Label happyNumberLabel;

    @FXML
    private Label happyPercentageLabel;

    @FXML
    private TableColumn<AnswerPercentages, String> happyTableColumn;

    @FXML
    private Label neutralNumberLabel;

    @FXML
    private Label neutralPercentageLabel;

    @FXML
    private TableColumn<AnswerPercentages, String> neutralTableColumn;

    @FXML
    private TableColumn<AnswerPercentages, String> questionTableColumn;

    @FXML
    private Label sadNumberLabel;

    @FXML
    private Label sadPercentageLabel;

    @FXML
    private TableColumn<AnswerPercentages, String> sadTableColumn;

    @FXML
    private DatePicker selectedDateDatePicker;

    @FXML
    private PieChart selectedDayStatisticPieChart;

    @FXML
    void initialize() {
        selectedDateDatePicker.setValue(LocalDate.now());
        selectedDateDatePicker.valueProperty().addListener((ov,
                                                            oldValue,
                                                            newValue) -> {

            System.out.println("Fecha seleccionada: " + newValue);
            // TODO: generateDateStatistic(newValue);
        });

        questionTableColumn.setCellValueFactory(
                new PropertyValueFactory<>("question")
        );
        happyTableColumn.setCellValueFactory(
                new PropertyValueFactory<>("happyPercentage")
        );
        neutralTableColumn.setCellValueFactory(
                new PropertyValueFactory<>("neutralPercentage")
        );
        sadTableColumn.setCellValueFactory(
                new PropertyValueFactory<>("sadPercentage")
        );

        //
        // Example data, waiting for part 3 of the proyect
        //

        // TODO: Remove
        ObservableList<AnswerPercentages> exampleData =
            FXCollections.observableArrayList();

        exampleData.add(
            new AnswerPercentages(
                "Estos son unicamente de ejemplo",
                "33.33%",
                "33.33%",
                "33.33%"
            )
        );
        exampleData.add(
            new AnswerPercentages(
                "Esperando al entregable 3 para poner datos reales",
                "33.33%",
                "33.33%",
                "33.33%"
            )
        );

        contentTableView.setItems(exampleData);
        ObservableList<PieChart.Data> pieChartExampleData
            = FXCollections.observableArrayList(
                new PieChart.Data("Bien", 33),
                new PieChart.Data("Regular", 33),
                new PieChart.Data("Mal", 33)
            );

        selectedDayStatisticPieChart.setData(pieChartExampleData);

    }

    @FXML
    void contentTableViewOnMouseClicked() {
        // TODO: Generate pie chart based on the selected question
    }
}
