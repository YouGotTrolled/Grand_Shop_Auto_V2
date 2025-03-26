package com.example.grand_shop_auto_v2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class main {

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
    private ComboBox<String> brandListFilter;

    @FXML
    private ComboBox<filterOptions> detaileFilter;

    @FXML
    private Button upSort;

    @FXML
    private CheckBox onlyAv;

    @FXML
    private Button downSort;

    @FXML
    private Button favListB;

    @FXML
    private Button cardB;

    //
    AnchorPane[] items;
    TextArea[] textAreas;
    Button[] removeFromFavListB;
    ImageView[] image;
    Label[] errors;
    AnchorPane[] editCard;
    Button[] editB;
    Label[] cardQ;
    Button[] addToCardB;
    Button[] addToFavB;
    //
    List<carPack> list;
    int page=0;
    int size;
    int pageSize;
    char sortOption='u';
    //

    @FXML
    void initialize() {
        searchIn.setOnAction(e->filter(e));
        //
        if(Abdoll.getCurrentAcc()!=null){
            loginB.setVisible(false);
            infoB.setVisible(true);
            if(Abdoll.getCurrentAcc() instanceof customer){
                if(((customer) Abdoll.getCurrentAcc()).getNotification()){
                    notifC.setVisible(true);
                }
                favListB.setVisible(true);
                cardB.setVisible(true);

            }
        }
        //
        items= new AnchorPane[]{item1, item11, item12, item13};
        textAreas= new TextArea[]{textArea1, textArea11, textArea12, textArea13};
        removeFromFavListB = new Button[]{removeFromFavListB1, removeFromFavListB11, removeFromFavListB12, removeFromFavListB13};
        image = new ImageView[]{image1, image11, image12, image13};
        errors = new Label[]{error1, error11, error12, error13};
        editCard = new AnchorPane[]{editCard1, editCard11, editCard12, editCard13};
        editB = new Button[]{edit1, edit11, edit12, edit13};
        cardQ = new Label[]{cardQ1, cardQ11, cardQ12, cardQ13};
        addToCardB = new Button[]{addToCardB1, addToCardB11, addToCardB12, addToCardB13};
        addToFavB = new Button[]{addToFavListB1, addToFavListB11, addToFavListB12, addToFavListB13};
        //
        detaileFilter.getItems().addAll(filterOptions.values());
        detaileFilter.setValue(filterOptions.NAME);
        brandListFilter.getItems().add("All Cars");
        brandListFilter.getItems().addAll(Abdoll.getAllBrand().stream().map(o->o.getBrandName()).toList());
        brandListFilter.setValue("All Cars");
        //
        filter(new ActionEvent());
    }

    void resetPage(){
        page=0;
        loadPage();
    }

    void loadItem(carPack carPack,int pos){
        car car=carPack.getCar();
        //
        items[pos].setVisible(true);
        //
        image[pos].setImage(new Image(car.getPicture().toURI().toString()));
        //
        String isAvillable;
        if(car.isAvailability()){
            isAvillable="هست";
        }else{
            isAvillable="نیست";
        }
        String massage=String.format("نام خودرو:%s   سال تولید:%d"+"\n"+
                        "قیمت:%,d تومن  تعداد موجود در فروشگاه:%d"+"\n"+
                        "برند تولید:%s   موجود%s"+"\n"+
                        "%s"
                ,car.getName(),car.getYear(),car.getPrice(),carPack.getQuantity(),car.getBrand(),isAvillable,car.getDetail());
        textAreas[pos].setText(massage);
        //
        if(Abdoll.getCurrentAcc()==null){
            addToCardB[pos].setVisible(false);
            addToFavB[pos].setVisible(false);
            editB[pos].setVisible(false);
        }else if(Abdoll.getCurrentAcc() instanceof customer){
            editB[pos].setVisible(false);
            int i=pos+4*page;
            customer customer=((customer) Abdoll.getCurrentAcc());
            if(customer.getCard().stream().anyMatch(o->o.getCar().equals(list.get(i).getCar()))){
                carPack temp=customer.getCard().stream().filter(o->o.getCar().equals(list.get(i).getCar())).findAny().get();
                addToCardB[pos].setVisible(false);
                editCard[pos].setVisible(true);
                cardQ[pos].setText(String.valueOf(temp.getQuantity()));
            }else{
                cardQ[pos].setText("1");
            }
            if(customer.getFavouriteCard().stream().anyMatch(o->o.equals(list.get(i).getCar()))){
                car temp=customer.getFavouriteCard().stream().filter(o->o.equals(list.get(i).getCar())).findAny().get();
                addToFavB[pos].setVisible(false);
                removeFromFavListB[pos].setVisible(true);
            }
        }else {
            addToCardB[pos].setVisible(false);
            addToFavB[pos].setVisible(false);
        }
    }

    void firstIni(){
        size=list.size();
        pageSize=size/4;
        if(size%4!=0)
            pageSize++;
        if(pageSize<2)
            nextPageB.setVisible(false);
    }

    void loadPage(){
        for (int i = 0; i < 4; i++) {
            items[i].setVisible(false);
            removeFromFavListB[i].setVisible(false);
            addToFavB[i].setVisible(true);
            editCard[i].setVisible(false);
            addToCardB[i].setVisible(true);
        }
        int thisPageQ;
        if (size >= 4 * (page + 1)) {
            thisPageQ = 4;
        } else {
            thisPageQ = (size - 4 * page) % 4;
        }
        //
        for (int i = 0; i < thisPageQ;)
            loadItem(list.get(i+4*page),i++);
        nextPageB.setVisible(size!=thisPageQ+page*4);
        prePageB.setVisible(page != 0);
    }

    @FXML
    void addToCard(ActionEvent event) {
        //
        int selcted = select(event, 12);
        //
        if (list.get(selcted).getCar().isAvailability() && list.get(selcted).getQuantity() > 0) {
            ((customer) Abdoll.getCurrentAcc()).addToCard(new carPack(list.get(selcted).getCar(), 1));
            addToCardB[selcted % 4].setVisible(false);
            editCard[selcted % 4].setVisible(true);
        }
    }

    @FXML
    void addToFavList(ActionEvent event) {
        //
        int selcted=select(event,15);
        //
        ((customer) Abdoll.getCurrentAcc()).addToFavouriteCard(list.get(selcted).getCar());
        addToFavB[selcted%4].setVisible(false);
        removeFromFavListB[selcted%4].setVisible(true);
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
        //
        int selcted=select(event,6);
        //
        ((admin) Abdoll.getCurrentAcc()).setTempForEdit(list.get(selcted));
        Abdoll.goTo("editCar",event);
    }

    @FXML
    void editCardM(ActionEvent event) {
        //
        int selcted=select(event,12);
        //
        customer customer=((customer) Abdoll.getCurrentAcc());
        //
        carPack temp=customer.getCard().stream().filter(o->o.getCar().equals(list.get(selcted).getCar())).findAny().get();
        int q=temp.getQuantity()-1;
        if(q!=0) {
            temp.setQuantity(q);
            cardQ[selcted%4].setText(String.valueOf(q));
        }else{
            ((customer) Abdoll.getCurrentAcc()).removeFromCard(list.get(selcted));
            editCard[selcted%4].setVisible(false);
            addToCardB[selcted%4].setVisible(true);
        }
    }

    @FXML
    void editCardP(ActionEvent event) {
        //
        int selcted=select(event,12);
        //
        customer customer=((customer) Abdoll.getCurrentAcc());
        //
        carPack temp=customer.getCard().stream().filter(o->o.getCar().equals(list.get(selcted).getCar())).findAny().get();
        int q=temp.getQuantity()+1;
        if (q <= list.get(selcted).getQuantity()) {
            temp.setQuantity(q);
            cardQ[selcted%4].setText(String.valueOf(q));
        }
    }

    @FXML
    void favList(ActionEvent event) {
        Abdoll.goTo("favList",event);
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
    void nextPage(ActionEvent event) {
        page++;
        loadPage();
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
    void card(ActionEvent event) {
        Abdoll.goTo("card", event);
    }

    @FXML
    void prePage(ActionEvent event) {
        page--;
        loadPage();
    }

    @FXML
    void removeFromFavList(ActionEvent event) {
        //
        int selcted=select(event,20);
        //
        ((customer) Abdoll.getCurrentAcc()).removeFromFavouriteCard(list.get(selcted).getCar());
        removeFromFavListB[selcted%4].setVisible(false);
        addToFavB[selcted%4].setVisible(true);
    }

    int select(ActionEvent event,int longestNameLength){
        int selcted=page*4;
        String temp=((Button) event.getSource()).getId();
        if(temp.charAt(temp.length()-1)=='1'){
            if(temp.length()==longestNameLength)
                selcted++;
        } else if (temp.charAt(temp.length()-1)=='2') {
            selcted+=2;
        }else{
            selcted+=3;
        }
        return selcted;
    }

    @FXML
    void filter(ActionEvent event) {
        if (brandListFilter.getValue().equals("All Cars")) {
            list = Abdoll.getAllCars();
        } else {
            list = Abdoll.getAllBrand().stream().filter(o -> o.getBrandName().equals(brandListFilter.getValue())).findAny().map(o -> o.getBrandList()).get();
        }
        //
        if (!searchIn.getText().isEmpty())
            list = list.stream().filter(o -> o.getCar().getName().contains(searchIn.getText())).collect(Collectors.toList());
        //
        if(list.size()>1){
            if (detaileFilter.getValue() == filterOptions.NAME) {
                if (sortOption == 'u') {
                    list.sort((o1, o2) -> o1.getCar().getName().compareTo(o2.getCar().getName()));
                } else {
                    list.sort((o1, o2) -> o2.getCar().getName().compareTo(o1.getCar().getName()));
                }
            } else if (detaileFilter.getValue() == filterOptions.BRAND) {
                if (sortOption == 'u') {
                    list.sort((o1, o2) -> o1.getCar().getBrand().compareTo(o2.getCar().getBrand()));
                } else {
                    list.sort((o1, o2) -> o2.getCar().getBrand().compareTo(o1.getCar().getBrand()));
                }
            } else if (detaileFilter.getValue() == filterOptions.PRICE) {
                if (sortOption == 'u') {
                    list.sort(Comparator.comparing(o -> o.getCar().getPrice()));
                } else {
                    list.sort(Comparator.comparing(o -> o.getCar().getPrice()));
                    List<carPack> temp = list;
                    list = new ArrayList<>();
                    temp.forEach(o -> list.addFirst(o));
                }
            } else if (detaileFilter.getValue() == filterOptions.QUANTITY) {
                if (sortOption == 'u') {
                    list.sort((o1, o2) -> o1.getQuantity() - o2.getQuantity());
                } else {
                    list.sort((o1, o2) -> o2.getQuantity() - o1.getQuantity());
                }
            } else if (detaileFilter.getValue() == filterOptions.YEAR) {
                if (sortOption == 'u') {
                    list.sort((o1, o2) -> o1.getCar().getYear() - o2.getCar().getYear());
                } else {
                    list.sort((o1, o2) -> o2.getCar().getYear() - o1.getCar().getYear());
                }
            }
        }
        //
        if(onlyAv.isSelected()){
            list=list.stream().filter(o->o.getCar().isAvailability()).toList();
        }
        firstIni();
        resetPage();
    }

    @FXML
    void sortUpOrDown(ActionEvent event) {
        if(((Button) event.getSource()).getId().charAt(0)=='u'){
            upSort.setVisible(false);
            downSort.setVisible(true);
            sortOption='u';
        }else{
            upSort.setVisible(true);
            downSort.setVisible(false);
            sortOption='d';
        }
        filter(event);
    }
}
enum filterOptions{NAME,BRAND,PRICE,YEAR,QUANTITY}