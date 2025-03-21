package com.example.grand_shop_auto_v2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class newList {

    @FXML
    private AnchorPane Anch1;

    @FXML
    private AnchorPane Anch2;

    @FXML
    private AnchorPane Anch3;

    @FXML
    private AnchorPane Anch4;

    @FXML
    private AnchorPane Anch5;

    @FXML
    private AnchorPane Anch6;

    @FXML
    private AnchorPane Anch7;

    @FXML
    private AnchorPane Anch8;

    @FXML
    private AnchorPane Anch9;

    @FXML
    private StackPane box1;

    @FXML
    private StackPane box2;

    @FXML
    private StackPane box3;

    @FXML
    private StackPane box4;

    @FXML
    private StackPane box5;

    @FXML
    private StackPane box6;

    @FXML
    private StackPane box7;

    @FXML
    private StackPane box8;

    @FXML
    private StackPane box9;

    @FXML
    private Button card1;

    @FXML
    private Button card2;

    @FXML
    private Button card3;

    @FXML
    private Button card4;

    @FXML
    private Button card5;

    @FXML
    private Button card6;

    @FXML
    private Button card7;

    @FXML
    private Button card8;

    @FXML
    private Button card9;

    @FXML
    private ImageView image1;

    @FXML
    private ImageView image2;

    @FXML
    private ImageView image3;

    @FXML
    private ImageView image4;

    @FXML
    private ImageView image5;

    @FXML
    private ImageView image6;

    @FXML
    private ImageView image7;

    @FXML
    private ImageView image8;

    @FXML
    private ImageView image9;

    @FXML
    private Button infoB;

    @FXML
    private Button loginB;

    @FXML
    private Button minus1;

    @FXML
    private Button minus2;

    @FXML
    private Button minus3;

    @FXML
    private Button minus4;

    @FXML
    private Button minus5;

    @FXML
    private Button minus6;

    @FXML
    private Button minus7;

    @FXML
    private Button minus8;

    @FXML
    private Button minus9;

    @FXML
    private Label name1;

    @FXML
    private Label name2;

    @FXML
    private Label name3;

    @FXML
    private Label name4;

    @FXML
    private Label name5;

    @FXML
    private Label name6;

    @FXML
    private Label name7;

    @FXML
    private Label name8;

    @FXML
    private Label name9;

    @FXML
    private Circle notifC;

    @FXML
    private Button plus1;

    @FXML
    private Button plus2;

    @FXML
    private Button plus3;

    @FXML
    private Button plus4;

    @FXML
    private Button plus5;

    @FXML
    private Button plus6;

    @FXML
    private Button plus7;

    @FXML
    private Button plus8;

    @FXML
    private Button plus9;

    @FXML
    private Label price1;

    @FXML
    private Label price2;

    @FXML
    private Label price3;

    @FXML
    private Label price4;

    @FXML
    private Label price5;

    @FXML
    private Label price6;

    @FXML
    private Label price7;

    @FXML
    private Label price8;

    @FXML
    private Label price9;

    @FXML
    private Label q1;

    @FXML
    private Label year1;

    @FXML
    private Label year2;

    @FXML
    private Label year3;

    @FXML
    private Label year4;

    @FXML
    private Label year5;

    @FXML
    private Label year6;

    @FXML
    private Label year7;

    @FXML
    private Label year8;

    @FXML
    private Label year9;

    int page;
    ArrayList<car> carList;
    int thisPage;
    AnchorPane[] anchorPanes;
    StackPane[] stackPanes;
    Button[] cards;
    Button[] minuses;
    Button[] pluses;
    ImageView[] images;
    Label[] names;
    Label[] prices;
    Label[] years;

    @FXML
    void initialize(){
        if(Abdoll.getCurrentAcc()!=null){
            loginB.setVisible(false);
            infoB.setVisible(true);
        }
        //
        page=1;
        // AnchorPane array
        anchorPanes = new AnchorPane[]{Anch1, Anch2, Anch3, Anch4, Anch5, Anch6, Anch7, Anch8, Anch9};
        // StackPane array
        stackPanes= new StackPane[]{box1, box2, box3, box4, box5, box6, box7, box8, box9};
        for (StackPane stackPane : stackPanes) {
            stackPane.setVisible(false);
        }
        // Button arrays
        cards = new Button[]{card1, card2, card3, card4, card5, card6, card7, card8, card9};
        minuses = new Button[]{minus1, minus2, minus3, minus4, minus5, minus6, minus7, minus8, minus9};
        pluses = new Button[]{plus1, plus2, plus3, plus4, plus5, plus6, plus7, plus8, plus9};

        // ImageView array
        images = new ImageView[]{image1, image2, image3, image4, image5, image6, image7, image8, image9};

        // Label arrays
        names = new Label[]{name1, name2, name3, name4, name5, name6, name7, name8, name9};
        prices = new Label[]{price1, price2, price3, price4, price5, price6, price7, price8, price9};
        years = new Label[]{year1, year2, year3, year4, year5, year6, year7, year8, year9};
        //
        carList=new ArrayList<>(Abdoll.getAllCars().stream().map(o->o.getCar()).collect(Collectors.toList()));
        load();
    }

    @FXML
    void back(ActionEvent event) {
        Abdoll.goBack(event);
    }

    @FXML
    void but1(ActionEvent event) {

    }

    @FXML
    void but2(ActionEvent event) {

    }

    @FXML
    void but3(ActionEvent event) {

    }

    @FXML
    void but4(ActionEvent event) {

    }

    @FXML
    void but5(ActionEvent event) {

    }

    @FXML
    void but6(ActionEvent event) {

    }

    @FXML
    void but7(ActionEvent event) {

    }

    @FXML
    void but9(ActionEvent event) {

    }

    @FXML
    void card(ActionEvent event) {
        if(Abdoll.getCurrentAcc() instanceof customer) {
            int temp = ((int) ((Button) event.getSource()).getId().charAt(4)) - 48;
            ((customer) Abdoll.getCurrentAcc()).addToCard(new carPack(carList.get(temp -1+ 9 * (page - 1)), 1));
            System.out.println("kk");
        }
    }

    @FXML
    void close(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    void favList(ActionEvent event) {

    }

    @FXML
    void goMian(ActionEvent event) {

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
        Abdoll.goTo("logIn",event);
    }

    @FXML
    void min(ActionEvent event) {
        GSA.primaryStage.setIconified(true);
    }

    @FXML
    void minus(ActionEvent event) {

    }

    @FXML
    void newList(ActionEvent event) {
Abdoll.goTo("newList",event);
    }

    @FXML
    void notif(ActionEvent event) {
        if(Abdoll.getCurrentAcc()==null){
            Abdoll.goTo("logIn", event);
        }else {
            Abdoll.goTo("userChat", event);
        }
    }

    @FXML
    void plus(ActionEvent event) {

    }

    @FXML
    void search(ActionEvent event) {

    }

    @FXML
    void nextPage(ActionEvent event) {
        if ((carList.size() % 9 == 0&&page<carList.size()/9)||(carList.size() % 9 != 0&&page<carList.size()/9+1)) {
            page++;
            load();
        }
    }

    @FXML
    void backPage(ActionEvent event) {
        if(page>1){
            page--;
            load();
        }
    }

    void load(){
        if(carList.size()>9*page){
            thisPage=9;
        }else {
            thisPage=carList.size()-(9*(page-1));
        }
        int temp=0;
        car car;
        for(int i=9*(page-1);i<9*(page-1)+thisPage;i++){
            stackPanes[temp].setVisible(true);
            car=carList.get(i);
            Image pic=new Image(car.getPicture().toURI().toString());
            images[temp].setImage(pic);
            names[temp].setText(car.getName());
            prices[temp].setText(String.valueOf(car.getPrice()));
            years[temp++].setText(String.valueOf(car.getYear()));
        }
    }

}
