package com.example.grand_shop_auto_v2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class test {

    @FXML
    void car(ActionEvent event) {
        Abdoll.goTo("test2",event);
        Abdoll.say();
        System.out.println("test\n___");

    }

}
