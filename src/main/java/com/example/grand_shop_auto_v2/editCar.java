package com.example.grand_shop_auto_v2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
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

public class editCar {

    @FXML
    private CheckBox avill;

    @FXML
    private TextField brand;

    @FXML
    private Label brandError;

    @FXML
    private ComboBox<carPack> chooseCar;

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
    private void initialize() {
        chooseCar.getItems().addAll(Abdoll.getAllCars());
    }

    @FXML
    void avillA(ActionEvent event) {

    }

    @FXML
    void back(ActionEvent event) {
        Abdoll.goBack(event);
    }

    @FXML
    void choose(ActionEvent event) {
        carPack carPack=chooseCar.getValue();
        car car=carPack.getCar();
        name.setText(car.getName());
        brand.setText(car.getBrand());
        year.setText(String.valueOf(car.getYear()));
        quatity.setText(String.valueOf(carPack.getQuantity()));
        price.setText(String.valueOf(car.getPrice()));
        picture=car.getPicture();
        photo.setImage(new Image(picture.toURI().toString()));
        detail.setText(car.getDetail());
        avill.setSelected(car.isAvailability());
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
    void exit(ActionEvent event) {
        Abdoll.closeTheApp();
    }

    @FXML
    void min(ActionEvent event) {
        GSA.primaryStage.setIconified(true);
    }

    @FXML
    void remove(ActionEvent event) {
        if (chooseCar.getValue()==null){
            error.setText("هیچی انتخاب نکردی");
        }else {
            int index =-1;
            carPack car=chooseCar.getValue();
            for (int i =0;index==-1&&i<Abdoll.getAllBrand().size();i++) {
                if (Abdoll.getAllBrand().get(i).getBrandName().equals(car.getCar().getBrand()))
                    index=i;
            }
            Abdoll.getAllBrand().get(index).removeFromBrandList(car);
            Abdoll.getAllCars().remove(car);
            chooseCar.setItems(null);
            chooseCar.getItems().addAll(Abdoll.getAllCars());
        }
    }

    @FXML
    void submit(ActionEvent event) {
        if(picture!=null) {
            String[] errors=Abdoll.editCar(chooseCar.getValue(),name.getText(), brand.getText(), detail.getText(), year.getText(), price.getText(), avill.isSelected(), quatity.getText());
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
                chooseCar.setItems(null);
                chooseCar.getItems().addAll(Abdoll.getAllCars());
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
