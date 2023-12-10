module com.example.algoritmos {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens com.example.algoritmos to javafx.fxml;
    exports com.example.algoritmos;
}