package com.example.grand_shop_auto_v2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class HelloController {
    static car car;
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick(ActionEvent event) {
        try {
            welcomeText.setText("Welcome to JavaFX Application!");
            car = new car();
            Parent info = FXMLLoader.load(getClass().getResource("test.fxml"));
            Scene scene = new Scene(info, 1280, 720);
            Stage info1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
            info1.setScene(scene);
            info1.show();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("hi");
        }
    }
    public static car getCar(){
        return car;
    }
}