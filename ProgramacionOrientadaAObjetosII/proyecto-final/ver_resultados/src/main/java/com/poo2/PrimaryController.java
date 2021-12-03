package com.poo2;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.text.DecimalFormat;

import static com.poo2.Answer.Answers;

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
    private class AnswersData {
        public int noHappy = 0;
        public int noNeutral = 0;
        public int noSad = 0;
        public int noAnswers = 0;

        public float happyPercentage() {
            return ((float)noHappy / (float)noAnswers) * 100.f;
        }
        public float neutralPercentage() {
            return ((float)noNeutral / (float)noAnswers) * 100.f;
        }
        public float sadPercentage() {
            return ((float)noSad / (float)noAnswers) * 100.f;
        }
    }

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

    private ObservableList<AnswerPercentages> answerPercentages =
        FXCollections.observableArrayList();
    private ObservableList<PieChart.Data> pieChartData =
        FXCollections.observableArrayList();
    private ArrayList<Answer> answers = new ArrayList<>();
    private ArrayList<Question> questions = new ArrayList<>();
    private ArrayList<AnswersData> answersData = new ArrayList<>();

    @FXML
    void initialize() {
        selectedDateDatePicker.setValue(LocalDate.now());
        selectedDateDatePicker
            .valueProperty()
            .addListener((ov, oldValue, newValue) -> {
                generateDateStatistic(newValue);
        });

        contentTableView.getSelectionModel()
            .selectedItemProperty()
            .addListener((obs, oldSelection, newSelection) -> {
                cleanPieChartData();
                if (newSelection != null) {
                    generatePieChart(newSelection);
                }
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

        contentTableView.setItems(answerPercentages);
        contentTableView.setPlaceholder(new Label("Sin datos para este dia"));
        selectedDayStatisticPieChart.setData(pieChartData);
        questions = DB.getInstance().getQuestions();
        generateDateStatistic(LocalDate.now());
    }

    void generatePieChart(AnswerPercentages selection) {
        final int index = answerPercentages.indexOf(selection);
        final AnswersData data = answersData.get(index);

        pieChartData.add(
            new PieChart.Data("Bien", data.happyPercentage())
        );
        pieChartData.add(
            new PieChart.Data("Regular", data.neutralPercentage())
        );
        pieChartData.add(
            new PieChart.Data("Mal", data.sadPercentage())
        );

        happyNumberLabel.setText(Integer.toString(data.noHappy));
        neutralNumberLabel.setText(Integer.toString(data.noNeutral));
        sadNumberLabel.setText(Integer.toString(data.noSad));
    }

    void cleanPieChartData() {
        final String cero = "00";
        pieChartData.clear();
        happyNumberLabel.setText(cero);
        neutralNumberLabel.setText(cero);
        sadNumberLabel.setText(cero);
    }

    void clearAverages() {
        final String cero = "00.00%";
        happyPercentageLabel.setText(cero);
        neutralPercentageLabel.setText(cero);
        sadPercentageLabel.setText(cero);
    }

    void generateDateStatistic(LocalDate ldDate) {
        pieChartData.clear();
        answerPercentages.clear();
        answersData.clear();
        clearAverages();

        var df = new DecimalFormat("#.00");
        String date = ldDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        answers = DB.getInstance().getAnswers(date);

        if (answers.isEmpty()) {
            return;
        }

        for (final var q : questions) {
            generatePercentages(q, df);
        }
        calculateAverages(df);
    }

    void generatePercentages(Question q, DecimalFormat df) {
        AnswerPercentages percentages =
            new AnswerPercentages("", "", "", ""); // Values will be
                                                  // calculated latter
        AnswersData data = new AnswersData();

        for (final var a : answers) {
            if (q.getQuestionId() == a.getQuestionId()) {
                data.noAnswers++;
                var ans = a.getAnswer();
                if (ans == Answers.happy) {
                    data.noHappy++;
                } else if (ans == Answers.neutral) {
                    data.noNeutral++;
                } else if (ans == Answers.sad) {
                    data.noSad++;
                } else {
                    System.err.println("Invalid answer for " + a);
                    return;
                }
            }
        }

        percentages.setQuestion(q.getText());
        percentages.setHappyPercentage(
            df.format(data.happyPercentage()) + "%"
        );
        percentages.setNeutralPercentage(
            df.format(data.neutralPercentage()) + "%"
        );
        percentages.setSadPercentage(
            df.format(data.sadPercentage()) + "%"
        );
        answerPercentages.add(percentages);
        answersData.add(data);
    }

    void calculateAverages(DecimalFormat df) {
        final float total = 100.f * answersData.size();
        double happyTotal = 0.f;
        double neutralTotal = 0.f;
        double sadTotal = 0.f;

        for (final var ad : answersData) {
            happyTotal += ad.happyPercentage();
            neutralTotal += ad.neutralPercentage();
            sadTotal += ad.sadPercentage();
        }
        
        happyPercentageLabel.setText(
            df.format((happyTotal/total) * 100.f) + "%"
        );
        neutralPercentageLabel.setText(
            df.format((neutralTotal/total) * 100.f) + "%"
        );
        sadPercentageLabel.setText(
            df.format((sadTotal/total) * 100.f) + "%"
        );
    }
}
