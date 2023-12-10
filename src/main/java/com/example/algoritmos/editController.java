package com.example.algoritmos;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class editController implements Initializable {
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tipo.getItems().addAll("Gasto","Ingreso");
        categoria.getItems().addAll("Alimentación",
                "Vivienda",
                "Transporte",
                "Salud",
                "Entretenimiento",
                "Educación",
                "Ropa y Accesorios",
                "Cuidado Personal",
                "Deudas",
                "Misceláneos",
                "Ingresos Laborales",
                "Ingresos Adicionales",
                "Ingresos Pasivos",
                "Reembolsos",
                "Regalías y Comisiones",
                "Premios y Lotería",
                "Herencias y Donaciones",
                "Ingresos de Rentas",
                "Ventas de Bienes",
                "Otras Fuentes de Ingresos");
    }

    Serializar s=new Serializar();

    @FXML
    ChoiceBox categoria,tipo;
    @FXML TextField amount,id;
    @FXML
    TextArea descripcion;
    Llist<Movimiento> l=s.desSerializar();
    @FXML
    void Cargar(ActionEvent e){
        if(l.length()>Integer.parseInt(id.getText())){

            l.moveToPos(Integer.parseInt(id.getText()));
            categoria.setAccessibleText(l.getValue().getCategoria());
            tipo.setAccessibleText(l.getValue().getTipo());
            amount.setText(String.valueOf(l.getValue().getMonto()));
            descripcion.setText(l.getValue().getDescripcion());
        }

    }



    @FXML void Registrar(ActionEvent e) throws IOException {
        l.moveToPos(Integer.parseInt(id.getText()));
        l.remove();
        Movimiento m=new Movimiento(tipo.getValue().toString(),categoria.getValue().toString(),Double.parseDouble(amount.getText()),descripcion.getText());
        l.moveToPos(Integer.parseInt(id.getText()));
       if(l.length()>Integer.parseInt(id.getText())) {
           l.insert(m);
        }else{
           l.append(m);
        }
        s.serializar(l,"list");
        FXMLLoader cargar=new FXMLLoader(getClass().getResource("home.fxml"));
        Scene scene=new Scene(cargar.load());
        Stage stage=(Stage) tipo.getScene().getWindow();
        stage.setScene(scene);



    }
}
