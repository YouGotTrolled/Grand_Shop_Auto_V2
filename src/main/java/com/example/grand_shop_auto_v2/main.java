package com.example.grand_shop_auto_v2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.shape.Circle;

public class main {

    @FXML
    private Button loginB;

    @FXML
    private Button infoB;

    @FXML
    private Circle notifC;

    @FXML
    private Button m2;

    @FXML
    private Button m22;

    @FXML
    private Button m222;

    @FXML
    private Button m3;

    @FXML
    private Button m4;

    @FXML
    private Button m5;

    @FXML
    private ScrollPane scroll;

    @FXML
    private ScrollPane scroll1;

    @FXML
    private ScrollPane scroll21;

    @FXML
    private ScrollPane scroll3;

    @FXML
    private TextField searchIn;

    @FXML
    private void initialize() {
        if(Abdoll.getCurrentAcc()!=null){
            loginB.setVisible(false);
            infoB.setVisible(true);
            if(Abdoll.getCurrentAcc() instanceof customer &&((customer) Abdoll.getCurrentAcc()).getNotification()){
                notifC.setVisible(true);
            }
        }
    }

    @FXML
    void back(ActionEvent event) {
        Abdoll.goBack(event);
    }

    @FXML
    void close(ActionEvent event) {
        Abdoll.closeTheApp();
    }

    @FXML
    void favList(ActionEvent event) {
        Abdoll.goTo("favList",event);
    }

    @FXML
    void goMian(ActionEvent event) {
        Abdoll.goTo("main",event);
    }

    @FXML
    void info(ActionEvent event) {
        if(Abdoll.getCurrentAcc() instanceof customer){
            Abdoll.goTo("customerInfo",event);
        }else {
            Abdoll.goTo("adminInfo",event);
        }
    }

    @FXML
    void login(ActionEvent event) {
        Abdoll.goTo("logIn",event);
    }

    @FXML
    void m1(ActionEvent event) {

    }

    @FXML
    void m2(ActionEvent event) {

    }

    @FXML
    void m3(ActionEvent event) {

    }

    @FXML
    void m4(ActionEvent event) {

    }

    @FXML
    void min(ActionEvent event) {
        GSA.primaryStage.setIconified(true);
    }

    @FXML
    void newList(ActionEvent event) {
        Abdoll.goTo("newList",event);
    }

    @FXML
    void notif(ActionEvent event) {
        if(Abdoll.getCurrentAcc()==null){
            Abdoll.goTo("logIn", event);
        }else {
            Abdoll.goTo("userChat", event);
            if(Abdoll.getCurrentAcc() instanceof customer)
                ((customer) Abdoll.getCurrentAcc()).setNotification(false);
        }
    }

    @FXML
    void search(ActionEvent event) {

    }

}
