package com.example.algoritmos;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class creditsController {
    @FXML
    Button b;
    @FXML void back(ActionEvent e) throws IOException {
        FXMLLoader cargar=new FXMLLoader(getClass().getResource("home.fxml"));
        Scene scene=new Scene(cargar.load());
        Stage stage=(Stage) b.getScene().getWindow();
        stage.setScene(scene);

    }
}
