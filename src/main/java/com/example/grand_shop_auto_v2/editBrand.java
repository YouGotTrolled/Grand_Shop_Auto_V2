package com.example.grand_shop_auto_v2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
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

public class editBrand {

    @FXML
    private TextField brandCountry;

    @FXML
    private Label brandCountryError;

    @FXML
    private TextArea brandDetail;

    @FXML
    private Label brandDetailError;

    @FXML
    private TextField brandName;

    @FXML
    private Label brandNameError;

    @FXML
    private Label allError;

    @FXML
    private TextField brandOwnerName;

    @FXML
    private Label brandOwnerNameError;

    @FXML
    private TextField brandYear;

    @FXML
    private Label brandYearError;

    @FXML
    private ComboBox<carBrand> chooseBrand;

    @FXML
    private ImageView photo;

    File picture;

    @FXML
    private void initialize() {
        chooseBrand.getItems().addAll(Abdoll.getAllBrand());
    }

    @FXML
    void back(ActionEvent event) {
        Abdoll.goBack(event);
    }

    @FXML
    void choose(ActionEvent event) {
        carBrand brand=chooseBrand.getValue();
        brandName.setText(brand.getBrandName());
        brandOwnerName.setText(brand.getBrandOwnerName());
        brandCountry.setText(brand.getBrandCountry());
        brandYear.setText(String.valueOf(brand.getYear()));
        picture=brand.getBrandIcon();
        photo.setImage(new Image(picture.toURI().toString()));
        brandDetail.setText(brand.getBrandDetail());
    }

    @FXML
    void choosePhoto(ActionEvent event) {
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
    void close(ActionEvent event) {
        Abdoll.closeTheApp();
    }

    @FXML
    void min(ActionEvent event) {
        GSA.primaryStage.setIconified(true);
    }

    @FXML
    void submit(ActionEvent event) {
        if(picture!=null) {
            String[] errors=Abdoll.editBrand(chooseBrand.getValue(),brandName.getText(),brandOwnerName.getText(),brandCountry.getText(),brandDetail.getText(),brandYear.getText());
            if(errors[0]==null){
                try {
                    Path destinationPath = Path.of(".\\systemFiles\\brandIcons\\", brandName.getText() + ".png");
                    Files.copy(picture.toPath(), destinationPath, StandardCopyOption.REPLACE_EXISTING);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                brandName.clear();
                brandOwnerName.clear();
                brandDetail.clear();
                brandYear.clear();
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
                brandDetailError.setText(errors[4]);
                if (errors[4]!=null)
                    brandDetail.clear();
                brandYearError.setText(errors[5]);
                if (errors[5]!=null)
                    brandYear.clear();
                initialize();
            }
        }else{
            allError.setText("عکس نزاشتی");
        }
    }
    @FXML
    void remove(ActionEvent event){
        if (chooseBrand.getValue() == null) {
            allError.setText("هیچی انتخاب نکردی");
        } else {
            Abdoll.getAllBrand().remove(chooseBrand.getValue());
            initialize();
        }
    }

}
