package com.example.grand_shop_auto_v2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class signUp {

    @FXML
    private TextField address;

    @FXML
    private Label addressError;

    @FXML
    private TextField dob;

    @FXML
    private Label dobError;

    @FXML
    private TextField id;

    @FXML
    private Label idError;

    @FXML
    private Label allError;

    @FXML
    private TextField lastName;

    @FXML
    private Label lastNameError;

    @FXML
    private TextField name;

    @FXML
    private Label nameError;

    @FXML
    private TextField password;

    @FXML
    private Label passwordError;

    @FXML
    private Label phoneError;

    @FXML
    private TextField rePassword;

    @FXML
    private Label rePasswordError;

    @FXML
    private TextField userName;

    @FXML
    private Label userNameError;

    @FXML
    private TextField phone;

    @FXML
    void back(ActionEvent event) {
        System.out.println(Abdoll.getLastPageName());
        Abdoll.goBack(event);
    }

    @FXML
    void submit(ActionEvent event) {
        String[] error=Abdoll.customerSignUp(userName.getText(),password.getText(),rePassword.getText(),name.getText(),lastName.getText(),address.getText(),dob.getText(),id.getText(),phone.getText());
        if(error[0]==null){
            Abdoll.goTo("temp",event);
        }else {
            allError.setText(error[0]);
            nameError.setText(error[1]);
            if (error[1]!=null)
                name.clear();
            lastNameError.setText(error[2]);
            if (error[2]!=null)
                lastName.clear();
            userNameError.setText(error[3]);
            if (error[3]!=null)
                userName.clear();
            passwordError.setText(error[4]);
            if (error[4]!=null)
                password.clear();
            rePasswordError.setText(error[5]);
            if (error[5]!=null)
                rePassword.clear();
            addressError.setText(error[6]);
            if (error[6]!=null)
                address.clear();
            idError.setText(error[7]);
            if (error[7]!=null)
                id.clear();
            phoneError.setText(error[8]);
            if (error[8]!=null)
                phone.clear();
            dobError.setText(error[9]);
            if (error[9]!=null)
                dob.clear();
        }
    }

}
