package com.example.grand_shop_auto_v2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class logIn {

    @FXML
    private TextField username;
    @FXML
    private TextField pasword;
    @FXML
    private Label allError;
    @FXML
    private Label passwordError;
    @FXML
    private Label userNameError;

    @FXML
    private void forget(ActionEvent event) {
        //Abdoll.goTo("forgetPas",event);
    }

    @FXML
    public void signUp(ActionEvent event)  {
        Abdoll.goToWithNoFootPrint("SignUp",event);
    }

    @FXML
    public void back(ActionEvent event)  {
        Abdoll.goBack(event);
    }

    @FXML
    public void login(ActionEvent event) {
        String[] error=Abdoll.checkLogIn(username.getText(),pasword.getText());
        if(error[0].equals("enter")){
            Abdoll.goBack(event);
        }else{
            allError.setText(error[0]);
            userNameError.setText(error[1]);
            passwordError.setText(error[2]);
            username.clear();
            pasword.clear();
        }
    }
    @FXML
    void eye1(ActionEvent event) {

    }
}
