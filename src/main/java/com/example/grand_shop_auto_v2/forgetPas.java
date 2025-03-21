package com.example.grand_shop_auto_v2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class forgetPas {

    @FXML
    private Label allError;

    @FXML
    private PasswordField id;

    @FXML
    private Label idError;

    @FXML
    private TextField userName;

    @FXML
    private Label userNameError;

    @FXML
    public void back(ActionEvent event)  {
        Abdoll.goBack(event);
    }

    @FXML
    public void go(ActionEvent event) {
        String[] error=Abdoll.checkLogInF(userName.getText(),id.getText());
        if(error[0].equals("enter")){
            Abdoll.goBack(event);
        }else{
            allError.setText(error[0]);
            userNameError.setText(error[1]);
            idError.setText(error[2]);
            userName.clear();
            id.clear();
        }
    }
}
