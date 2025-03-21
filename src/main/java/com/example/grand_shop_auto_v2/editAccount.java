package com.example.grand_shop_auto_v2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.stream.Collectors;

public class editAccount {

    @FXML
    private ComboBox<accunt> accountChoose;

    @FXML
    private TextField address;

    @FXML
    private Label addressError;

    @FXML
    private Label allError;

    @FXML
    private TextField dateOfBirst;

    @FXML
    private Label dateOfBirstError;

    @FXML
    private TextField id;

    @FXML
    private Label idError;

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
    private TextField phoneNumber;

    @FXML
    private Label phoneNumberError;

    @FXML
    private void initialize() {
        accountChoose.getItems().addAll(Abdoll.getAllAccounts().stream().filter(o->o instanceof customer).collect(Collectors.toList()));
    }

    @FXML
    void back(ActionEvent event) {
        Abdoll.goBack(event);
    }

    @FXML
    void choose(ActionEvent event) {
        customer ali=((customer) accountChoose.getValue());
        name.setText(ali.getName());
        lastName.setText(ali.getLastName());
        address.setText(ali.getAddress());
        password.setText(ali.getPassword());
        phoneNumber.setText(String.valueOf(ali.getPhoneNumber()));
        id.setText(String.valueOf(ali.getId()));
        int date=ali.getDateOfBirth();
        dateOfBirst.setText(date/10000+"/"+(date/100)%100+"/"+date%100);
    }

    @FXML
    void submit(ActionEvent event) {
        /*
        0_allError
        1_nameError
        2_brandError
        3_detailError
        4_yearError
        5_priceError
        6_availabilityError
        7_quantityError
        */
        String[] errors=Abdoll.editCustomer(((customer) accountChoose.getValue()),password.getText(),name.getText(),lastName.getText(),address.getText(),dateOfBirst.getText(),id.getText(),phoneNumber.getText());
        if(errors[0]==null){
            name.clear();
            lastName.clear();
            password.clear();
            address.clear();
            dateOfBirst.clear();
            id.clear();
            phoneNumber.clear();
            allError.setText("تامام");
        }else{
            allError.setText(errors[0]);
            brandNameError.setText(errors[1]);
            if (errors[1]!=null)
                brandName.clear();
            brandOwnerNameError.setText(errors[2]);
            if (errors[2]!=null)
                brandOwnerName.clear();
            brandCountryError.setText(errors[3]);
            if (errors[3]!=null)
                brandCountry.clear();
            brandDetailError.setText(errors[4]);
            if (errors[4]!=null)
                brandDetail.clear();
            brandYearError.setText(errors[5]);
            if (errors[5]!=null)
                brandYear.clear();
            initialize();
        }
    }

}
