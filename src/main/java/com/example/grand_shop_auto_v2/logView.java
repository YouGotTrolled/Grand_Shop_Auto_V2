package com.example.grand_shop_auto_v2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class logView {

    @FXML
    private ComboBox<String> combo;

    @FXML
    private TextArea messageAria;

    @FXML
    private void initialize() {
        combo.getItems().add("systemLog.txt");
        if((new File(".\\systemFiles\\userLog")).exists()){
            combo.getItems().addAll((new File(".\\systemFiles\\userLog")).list());
        }
    }

    @FXML
    void back(ActionEvent event) {
        Abdoll.goBack(event);
    }

    @FXML
    void close(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    void comboA(ActionEvent event) {
        reload(event);
    }

    @FXML
    void min(ActionEvent event) {
        GSA.primaryStage.setIconified(true);
    }

    @FXML
    void reload(ActionEvent event) {
        String path="";
        if(combo.getValue().equals("systemLog.txt")){
            path=".\\systemFiles\\systemLog.txt";
        }else{
            path=".\\systemFiles\\userLog\\"+combo.getValue();
        }
        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            String temp = reader.readLine();
            while (temp != null) {
                messageAria.appendText(temp+"\n");
                temp = reader.readLine();
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
