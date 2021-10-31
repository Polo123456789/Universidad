package com.poo2;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class PrimaryController {

    @FXML
    Label texto;

    @FXML
    public void saludar() {
        texto.setText("Hola Pablo Sanchez");
    }
}
