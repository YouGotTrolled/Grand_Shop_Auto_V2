package com.example.grand_shop_auto_v2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class addCar {

    @FXML
    private TextField brand;

    @FXML
    private Label brandError;

    @FXML
    private TextArea detail;

    @FXML
    private Label detailError;

    @FXML
    private Label error;

    @FXML
    private TextField name;

    @FXML
    private Label nameError;

    @FXML
    private ImageView photo;

    @FXML
    private TextField price;

    @FXML
    private Label priceError;

    @FXML
    private Label quantityError;

    @FXML
    private TextField quatity;

    @FXML
    private TextField year;

    @FXML
    private Label yearError;

    File picture;

    @FXML
    void back(ActionEvent event) {
        Abdoll.goBack(event);
    }

    @FXML
    void chosePhoto(ActionEvent event) {
        FileChooser fileChooser=new FileChooser();
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Image Files", "*.png"));
        picture=fileChooser.showOpenDialog(new Stage());
        if(picture!=null){
            Image pic=new Image(picture.toURI().toString());
            photo.setImage(pic);
        }else{
            error.setText("فایل به درستی انتخاب نشد");
        }
    }

    @FXML
    void submit(ActionEvent event) {
        if(picture!=null) {
            String[] errors=Abdoll.createNewCar(name.getText(), brand.getText(), detail.getText(), year.getText(), price.getText(), "true", quatity.getText());
            if(errors[0]==null){
                try {
                    Path destinationPath = Path.of(".\\systemFiles\\carPictures\\", name.getText() + ".png");
                    Files.copy(picture.toPath(), destinationPath, StandardCopyOption.REPLACE_EXISTING);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                name.clear();
                brand.clear();
                detail.clear();
                year.clear();
                price.clear();
                quatity.clear();
                picture=null;
                photo.setImage(null);
                error.setText("تامام");
            }else{
                error.setText(errors[0]);
                nameError.setText(errors[1]);
                if (errors[1]!=null)
                    name.clear();
                brandError.setText(errors[2]);
                if (errors[2]!=null)
                    brand.clear();
                detailError.setText(errors[3]);
                if (errors[3]!=null)
                    detail.clear();
                yearError.setText(errors[4]);
                if (errors[4]!=null)
                    year.clear();
                priceError.setText(errors[5]);
                if (errors[5]!=null)
                    price.clear();
                error.setText(errors[6]);
                quantityError.setText(errors[7]);
                if (errors[7]!=null)
                    quatity.clear();
            }
        }else{
            error.setText("عکس نزاشتی");
        }
    }
}
