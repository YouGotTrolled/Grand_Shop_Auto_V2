package com.example.grand_shop_auto_v2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;

import java.util.ArrayList;

public class customerInfo {

    @FXML
    private Label address;

    @FXML
    private Label balance;

    @FXML
    private TextField balanceAdd;

    @FXML
    private VBox infoP;

    @FXML
    private Label dob;

    @FXML
    private Label dobAge;

    @FXML
    private Label id;

    @FXML
    private VBox valet;

    @FXML
    private Label lastName;

    @FXML
    private Label name;

    @FXML
    private Circle notif;

    @FXML
    private Label phone;

    @FXML
    private void initialize() {
        customer now=((customer) Abdoll.getCurrentAcc());
        name.setText(now.getName());
        lastName.setText(now.getLastName());
        address.setText(now.getAddress());
        phone.setText("0"+ now.getPhoneNumber());
        id.setText(String.valueOf(now.getId()));
        //date & age
        int date=now.getDateOfBirth();
        dob.setText(date/10000+"/"+(date/100)%100+"/"+date%100);
        dobAge.setText(String.valueOf(((1404_00_00-date)/1_00_00)%100));
        //
        balance.setText(String.valueOf(now.getBalance()));
        if(now.getNotification()){
            notif.setVisible(true);
        }
    }

    @FXML
    void back(ActionEvent event) {
        Abdoll.goBack(event);
    }

    @FXML
    void balanceAddB(ActionEvent event) {
        long temp=((customer) Abdoll.getCurrentAcc()).getBalance()+Long.parseLong(balanceAdd.getText());
        ((customer) Abdoll.getCurrentAcc()).setBalance(temp);
        balance.setText(String.valueOf(temp));
    }

    @FXML
    void card(ActionEvent event) {
        Abdoll.goTo("card",event);
    }

    @FXML
    void changeInfo(ActionEvent event) {
        Abdoll.goTo("editAccount",event);
    }

    @FXML
    void chat(ActionEvent event) {
        Abdoll.goTo("userChat",event);
        ((customer) Abdoll.getCurrentAcc()).setNotification(false);
    }

    @FXML
    void exit(ActionEvent event) {
        Abdoll.setCurrentAcc(null);
        Abdoll.goTo("main",event);
        ArrayList<String> temp=new ArrayList<>();
        temp.add("main");
        Abdoll.setLastPageName(temp);
    }

    @FXML
    void favList(ActionEvent event) {
        Abdoll.goTo("favList",event);
    }

    @FXML
    void switchForm(ActionEvent event) {
        if(((Button) event.getSource()).getId().equals("kif")){
            valet.setVisible(true);
            infoP.setVisible(false);
        }else{
            valet.setVisible(false);
            infoP.setVisible(true);
        }
    }

}
