package com.example.algoritmos;
import com.example.algoritmos.Serializar;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;



public class Main extends Application{

    public static void main(String[] args)  {
        Llist l=new Llist<>();
        Serializar s=new Serializar();
        Movimiento m1=new Movimiento("Ingreso","Alimentación",200,"comida rapida");
        Movimiento m2=new Movimiento("Gasto","Alimentación",300,"consulta rapida");
        Movimiento m3=new Movimiento("Ingreso","Alimentación",250,"comida rapida");
        Movimiento m4=new Movimiento("Gasto","Alimentación",350,"consulta rapida");
        l.insert(m1);
        l.insert(m2);
        l.insert(m3);
        l.insert(m4);
        s.serializar(l,"list");
        launch();
    }

  @Override
    public void start(Stage stage) throws Exception {
        stage=new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("home.fxml"));
        Scene root = new Scene(fxmlLoader.load());
        Image icono=new Image(getClass().getResource("descarga.png").openStream());
        stage.getIcons().add(icono);
        stage.setScene(root);
        stage.show();
    }
}
