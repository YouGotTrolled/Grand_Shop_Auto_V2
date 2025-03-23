package com.example.grand_shop_auto_v2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;

public class List {

    @FXML
    private Button addToCardB1;

    @FXML
    private Button addToCardB11;

    @FXML
    private Button addToCardB12;

    @FXML
    private Button addToCardB13;

    @FXML
    private Button addToFavListB1;

    @FXML
    private Button addToFavListB11;

    @FXML
    private Button addToFavListB12;

    @FXML
    private Button addToFavListB13;

    @FXML
    private Label cardQ1;

    @FXML
    private Label cardQ11;

    @FXML
    private Label cardQ12;

    @FXML
    private Label cardQ13;

    @FXML
    private Button edit1;

    @FXML
    private Button edit11;

    @FXML
    private Button edit12;

    @FXML
    private Button edit13;

    @FXML
    private AnchorPane editCard1;

    @FXML
    private AnchorPane editCard11;

    @FXML
    private AnchorPane editCard12;

    @FXML
    private AnchorPane editCard13;

    @FXML
    private Button editCardMB1;

    @FXML
    private Button editCardMB11;

    @FXML
    private Button editCardMB12;

    @FXML
    private Button editCardMB13;

    @FXML
    private Button editCardPB1;

    @FXML
    private Button editCardPB11;

    @FXML
    private Button editCardPB12;

    @FXML
    private Button editCardPB13;

    @FXML
    private Label error1;

    @FXML
    private Label error11;

    @FXML
    private Label error12;

    @FXML
    private Label error13;

    @FXML
    private ImageView image1;

    @FXML
    private ImageView image11;

    @FXML
    private ImageView image12;

    @FXML
    private ImageView image13;

    @FXML
    private Button infoB;

    @FXML
    private AnchorPane item1;

    @FXML
    private AnchorPane item11;

    @FXML
    private AnchorPane item12;

    @FXML
    private AnchorPane item13;

    @FXML
    private Button loginB;

    @FXML
    private Button nextPageB;

    @FXML
    private Circle notifC;

    @FXML
    private Button prePageB;

    @FXML
    private Button removeFromFavListB1;

    @FXML
    private Button removeFromFavListB11;

    @FXML
    private Button removeFromFavListB12;

    @FXML
    private Button removeFromFavListB13;

    @FXML
    private TextField searchIn;

    @FXML
    private TextArea textArea1;

    @FXML
    private TextArea textArea11;

    @FXML
    private TextArea textArea12;

    @FXML
    private TextArea textArea13;

    @FXML
    void initialize() {
        if(Abdoll.getCurrentAcc()!=null){
            loginB.setVisible(false);
            infoB.setVisible(true);
            if(Abdoll.getCurrentAcc() instanceof customer &&((customer) Abdoll.getCurrentAcc()).getNotification()){
                notifC.setVisible(true);
            }
        }
    }

    @FXML
    void addToCard(ActionEvent event) {

    }

    @FXML
    void addToFavList(ActionEvent event) {

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
    void editB(ActionEvent event) {

    }

    @FXML
    void editCardM(ActionEvent event) {

    }

    @FXML
    void editCardP(ActionEvent event) {

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

    }

    @FXML
    void min(ActionEvent event) {
        GSA.primaryStage.setIconified(true);
    }

    @FXML
    void newList(ActionEvent event) {
        Abdoll.goTo("List",event);
    }

    @FXML
    void nextPage(ActionEvent event) {

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
    void prePage(ActionEvent event) {

    }

    @FXML
    void removeFromFavList(ActionEvent event) {

    }

    @FXML
    void search(ActionEvent event) {

    }

}
