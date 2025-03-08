package com.example.grand_shop_auto_v2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class addBrand {

    @FXML
    private Label allError;

    @FXML
    private TextField brandCountry;

    @FXML
    private Label brandCountryError;

    @FXML
    private TextField brandName;

    @FXML
    private Label brandNameError;

    @FXML
    private TextField brandOwnerName;

    @FXML
    private Label brandOwnerNameError;

    @FXML
    private TextArea detail;

    @FXML
    private Label detailError;

    @FXML
    private ImageView photo;

    @FXML
    private TextField year;

    @FXML
    private Label yearError;

    File picture;

    @FXML
    void chosePhoto(ActionEvent event) {
        FileChooser fileChooser=new FileChooser();
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Image Files", "*.png"));
        picture=fileChooser.showOpenDialog(new Stage());
        if(picture!=null){
            Image pic=new Image(picture.toURI().toString());
            photo.setImage(pic);
        }else{
            allError.setText("فایل به درستی انتخاب نشد");
        }
    }

    @FXML
    void submit(ActionEvent event) {
        if(picture!=null) {
            String[] errors=Abdoll.createNewBrand(brandName.getText(),brandOwnerName.getText(),brandCountry.getText(),detail.getText(),year.getText());
            if(errors[0]==null){
                try {
                    Path destinationPath = Path.of(".\\systemFiles\\brandIcons\\", brandName.getText() + ".png");
                    Files.copy(picture.toPath(), destinationPath, StandardCopyOption.REPLACE_EXISTING);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                brandName.clear();
                brandOwnerName.clear();
                detail.clear();
                year.clear();
                brandCountry.clear();
                picture=null;
                photo.setImage(null);
                allError.setText("تامام");
            }else{
                /*
        0_allError
        1_brandNameError
        2_brandOwnerNameError
        3_brandCountryError
        4_brandDetailError
        5_yearError
        */
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
                detailError.setText(errors[4]);
                if (errors[4]!=null)
                    detail.clear();
                yearError.setText(errors[5]);
                if (errors[5]!=null)
                    year.clear();
            }
        }else{
            allError.setText("عکس نزاشتی");
        }
    }

    @FXML
    void back(ActionEvent event) {
        Abdoll.goBack(event);
    }

}
