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
            Abdoll.goTo("test",event);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("hi");
        }
    }
    public static car getCar(){
        return car;
    }
}