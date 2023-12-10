package com.example.algoritmos;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class homeController implements Initializable {
    Llist<Movimiento> l=new Llist<>();


    @Override
    public void initialize(URL location, ResourceBundle resources) {



        categoriafilter.getItems().addAll("Alimentación",
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
@FXML Label saldo;
    double Saldo=0;

    @FXML
    VBox vBox1;
    @FXML
    ChoiceBox categoriafilter;
    @FXML
    DatePicker desde,hasta;

    @FXML
    void charge(ActionEvent e) {
        Saldo=0;

        vBox1.getChildren().clear();

        Serializar s = new Serializar();
        Llist<Movimiento> list = s.desSerializar();
        for (int i = 0; i < list.length(); i++) {
            list.moveToPos(i);
            AnchorPane ap=new AnchorPane();
            Label cat=new Label();
            Label id =new Label();
            Label mo=new Label();
            cat.setText("Categoria "+list.getValue().getCategoria());
            id.setText("Id. "+String.valueOf(list.currPos()));
            mo.setText(String.valueOf(list.getValue().getMonto()));
            ap.getChildren().addAll(cat,mo, id);
            cat.setLayoutX(14);
            cat.setLayoutY(14);
            id.setLayoutX(14);
            id.setLayoutY(35);
            mo.setLayoutX(303);
            mo.setLayoutY(14);
            vBox1.getChildren().add(ap);
            if (list.getValue().getTipo().equals("Gasto")){
                Saldo-=list.getValue().getMonto();
            }else {

                Saldo+=list.getValue().getMonto();
            }

        }

        saldo.setText("Saldo: "+Saldo);



    }
    @FXML
    void filter(ActionEvent e){
        vBox1.getChildren().clear();
        Serializar s = new Serializar();
        Llist<Movimiento> list = s.desSerializar();

        Llist<Movimiento> lf=new Llist<>();
        for (int i=0;i<list.length();i++){

            if(list.getValue().getCategoria().equals(categoriafilter.getValue())){
                lf.insert(list.getValue());

            }
        }
        for (int i = 0; i < lf.length(); i++) {
            lf.moveToPos(i);
            AnchorPane ap=new AnchorPane();
            Label cat=new Label();
            Label id =new Label();
            Label mo=new Label();
            cat.setText("Categoria "+lf.getValue().getCategoria());
            id.setText("Id. "+String.valueOf(lf.currPos()));
            mo.setText(String.valueOf(lf.getValue().getMonto()));
            ap.getChildren().addAll(cat,mo, id);
            cat.setLayoutX(14);
            cat.setLayoutY(14);
            id.setLayoutX(14);
            id.setLayoutY(35);
            mo.setLayoutX(303);
            mo.setLayoutY(14);
            vBox1.getChildren().add(ap);
            if (lf.getValue().getTipo().equals("Gasto")){
                Saldo-=lf.getValue().getMonto();
            }else {

                Saldo+=lf.getValue().getMonto();
            }

        }

        saldo.setText("Saldo: "+Saldo);

    }
    @FXML void anadir(ActionEvent e) throws IOException {

        FXMLLoader cargar=new FXMLLoader(getClass().getResource("addMovimiento.fxml"));
        Scene scene=new Scene(cargar.load());
        Stage stage=(Stage) vBox1.getScene().getWindow();
        stage.setScene(scene);
    }
    @FXML void  credits(ActionEvent e) throws IOException {
        FXMLLoader cargar=new FXMLLoader(getClass().getResource("credits.fxml"));
        Scene scene=new Scene(cargar.load());
        Stage stage=(Stage) vBox1.getScene().getWindow();
        stage.setScene(scene);

    }
    @FXML void  edit(ActionEvent e) throws IOException {
        FXMLLoader cargar = new FXMLLoader(getClass().getResource("edit.fxml"));
        Scene scene = new Scene(cargar.load());
        Stage stage = (Stage) vBox1.getScene().getWindow();
        stage.setScene(scene);

    }
    @FXML void report(ActionEvent e){
        Saldo=0;
        String contenidoReporte="";
        Serializar s = new Serializar();
        Llist<Movimiento> list = s.desSerializar();
        for (int i = 0; i < list.length(); i++) {
            if (list.getValue().getTipo().equals("Gasto")){
                Saldo-=list.getValue().getMonto();
            }else {

                Saldo+=list.getValue().getMonto();
            }
            contenidoReporte=contenidoReporte+"Fecha: "+list.getValue().getFecha()+"\n"
                    + "Tipo: "+list.getValue().getTipo()+"\n"
                    + "Categoria: "+list.getValue().getCategoria()+"\n"
                    + "Descripcion: "+list.getValue().getDescripcion()+"\n"
                    + "monto: $"+list.getValue().getMonto()+"\n";

        }

contenidoReporte+="Saldo Total: "+Saldo;

        String rutaArchivo = "reporte.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo))) {
            writer.write(contenidoReporte);
            System.out.println("Reporte generado exitosamente en: " + rutaArchivo);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
    @FXML void borrar(ActionEvent e) throws IOException {
        FXMLLoader cargar = new FXMLLoader(getClass().getResource("borrar.fxml"));
        Scene scene = new Scene(cargar.load());
        Stage stage = (Stage) vBox1.getScene().getWindow();
        stage.setScene(scene);


    }

    }
