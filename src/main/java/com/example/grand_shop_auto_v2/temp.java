package com.example.grand_shop_auto_v2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class temp {

    @FXML
    void login(ActionEvent event) {
        Abdoll.goTo("logIn",event);
    }

    @FXML
    void admin(ActionEvent event) {
        System.out.println(Abdoll.getCurrentAcc());
        System.out.println(Abdoll.getLastPageName());
        System.out.println(Abdoll.getAllAccounts());
        Abdoll.saveAllAccounts();
    }

    @FXML
    void creatCar(ActionEvent event) {
        Abdoll.goTo("addCar",event);
    }

    @FXML
    void createBrand(ActionEvent event) {
        Abdoll.goTo("addBrand",event);
    }

}
