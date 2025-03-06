package com.example.grand_shop_auto_v2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class test2 {

    @FXML
    void car(ActionEvent event) {
        System.out.println(HelloController.getCar().getName());
        try {
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("hi");
        }
    }

}
