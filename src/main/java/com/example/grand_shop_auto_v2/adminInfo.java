package com.example.grand_shop_auto_v2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.util.ArrayList;

public class adminInfo {

    @FXML
    private Label dob;

    @FXML
    private Label id;

    @FXML
    private Label lastNmae;

    @FXML
    private Label name;

    @FXML
    private Label phone;

    @FXML
    private void initialize() {
        admin now=((admin) Abdoll.getCurrentAcc());
        name.setText(now.getName());
        lastNmae.setText(now.getLastName());
        phone.setText("0"+ now.getPhoneNumber());
        id.setText(String.valueOf(now.getId()));
        int date=now.getDateOfBirth();
        dob.setText(date/10000+"/"+(date/100)%100+"/"+date%100);
    }

    @FXML
    void accManeige(ActionEvent event) {
        Abdoll.goTo("editAcc",event);
    }

    @FXML
    void addBrand(ActionEvent event) {
        Abdoll.goTo("addBrand",event);
    }

    @FXML
    void addCar(ActionEvent event) {
        Abdoll.goTo("addCar",event);
    }

    @FXML
    void back(ActionEvent event) {
        Abdoll.goBack(event);
    }

    @FXML
    void chat(ActionEvent event) {
        Abdoll.goTo("userChat",event);
    }

    @FXML
    void close(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    void editBrand(ActionEvent event) {
        Abdoll.goTo("editBrand",event);
    }

    @FXML
    void editCar(ActionEvent event) {
        Abdoll.goTo("editCar",event);
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
    void log(ActionEvent event) {
        Abdoll.goTo("logView",event);
    }

    @FXML
    void min(ActionEvent event) {
        GSA.primaryStage.setIconified(true);
    }

}
