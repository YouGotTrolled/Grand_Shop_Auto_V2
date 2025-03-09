package com.example.grand_shop_auto_v2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.stream.Collectors;

public class userChat {

    @FXML
    private ComboBox<accunt> combo;

    @FXML
    private TextField message;

    @FXML
    private Button re;

    @FXML
    private TextArea messageAria;

    @FXML
    private void initialize() {
        if(Abdoll.getCurrentAcc() instanceof customer){
            combo.setVisible(false);
            re.setVisible(false);
            if(new File(".\\systemFiles\\userChat\\"+Abdoll.getCurrentAcc().getUserName()+".txt").exists()) {
                try {
                    BufferedReader reader = new BufferedReader(new FileReader(".\\systemFiles\\userChat\\" + Abdoll.getCurrentAcc().getUserName() + ".txt"));
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
        }else {
            combo.getItems().addAll(Abdoll.getAllAccounts());
        }
    }

    @FXML
    void back(ActionEvent event) {
        Abdoll.goBack(event);
    }

    @FXML
    void chose(ActionEvent event) {
        reload(event);
    }

    @FXML
    void close(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    void deleteChat(ActionEvent event) {
        if(Abdoll.getCurrentAcc() instanceof customer){
            ((customer) Abdoll.getCurrentAcc()).getChatFile().delete();
        }else{
            ((customer) combo.getValue()).getChatFile().delete();
        }
        Abdoll.goBack(event);
    }

    @FXML
    void min(ActionEvent event) {
        GSA.primaryStage.setIconified(true);
    }

    @FXML
    void reload(ActionEvent event) {
        messageAria.setText("");
        if(new File(".\\systemFiles\\userChat\\"+combo.getValue().getUserName()+".txt").exists()) {
            try {
                BufferedReader reader = new BufferedReader(new FileReader(".\\systemFiles\\userChat\\" + combo.getValue().getUserName() + ".txt"));
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

    @FXML
    void send(ActionEvent event) {
        if(Abdoll.getCurrentAcc() instanceof customer){
            messageAria.appendText(Abdoll.customerSendChatMessage(message.getText())+"\n");
            message.clear();
        }else if(combo.getValue() instanceof customer){
            messageAria.appendText(Abdoll.adminSendChatMessage(message.getText(),combo.getValue())+"\n");
            message.clear();
            ((customer) combo.getValue()).setNotification(true);
        }else{
            messageAria.appendText("error");
        }
    }

}
