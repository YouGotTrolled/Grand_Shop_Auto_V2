package com.example.grand_shop_auto_v2;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class GSA extends Application {
    static Stage primaryStage;
    @Override
    public void start(Stage stage) throws IOException {
        //
        primaryStage=stage;
        //
        Abdoll.loadAllCars();
        Abdoll.loadAllAccounts();
        if(!(Abdoll.getAllAccounts().stream().map(o->o.getUserName()).collect(Collectors.toList())).contains("admin")){
            Abdoll.getAllAccounts().add(new admin());
        }
        //Files
        (new File(".\\systemFiles")).mkdir();
        (new File(".\\systemFiles\\carPictures")).mkdir();
        (new File(".\\systemFiles\\brandIcons")).mkdir();
        (new File(".\\systemFiles\\userLog")).mkdir();
        (new File(".\\systemFiles\\userChat")).mkdir();
        (new File(".\\systemFiles\\allBrand.dat")).createNewFile();
        (new File(".\\systemFiles\\allAccounts.dat")).createNewFile();
        //
        FXMLLoader fxmlLoader = new FXMLLoader(GSA.class.getResource("main.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1280, 720);
        stage.setResizable(false);
        stage.setTitle("GSA");
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
class car implements Serializable{
    private String name;
    private String brand;
    private String detail;
    private int year;
    private long price;
    private boolean availability;
    private File picture;
    //Constructors
    public car(String name, String brand, String detail, int year, long price, boolean availability, File picture) {
        this.name = name;
        this.brand = brand;
        this.detail= detail;
        this.year = year;
        this.price = price;
        this.availability = availability;
        this.picture= picture;
    }
    public car(String name, String brand,String detail, int year, long price) {
        this(name,brand,detail,year,price,true,new File(".\\systemFiles\\carPictures\\"+name+".png"));
    }
    public car(String name) {
        this(name, "Null","null",2000, 1_000_000_000, true,new File(".\\systemFiles\\carPictures\\"+name+".png"));
    }
    public car() {
        this("testCar", "Null","null",2000, 1_000_000_000, true,new File(".\\systemFiles\\carPictures\\testCar.png"));
    }
    // Getter and Setter for name
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    // Getter and Setter for detail
    public String getDetail() {
        return detail;
    }
    public void setDetail(String detail) {
        this.detail = detail;
    }
    // Getter and Setter for brand
    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }
    // Getter and Setter for year
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }
    // Getter and Setter for price
    public long getPrice() {
        return price;
    }
    public void setPrice(long price) {
        this.price = price;
    }
    // Getter and Setter for availability
    public boolean isAvailability() {
        return availability;
    }
    public void setAvailability(boolean availability) {
        this.availability = availability;
    }
    // Getter and Setter for picture
    public File getPicture() {
        return picture;
    }
    public void setPicture(File picture) {
        this.picture = picture;
    }
    //methods
    public boolean equals(Object o){
        boolean result=false;
        car tempCar=(car)o;
        if(name.equals(tempCar.getName())&&year==tempCar.getYear()&&brand.equals(tempCar.getBrand())&&price==tempCar.getPrice()&&detail.equals(tempCar.getDetail()))
            result=true;
        return result;
    }
    public String toString(){
        return (name+" "+year);
    }
}
class carPack implements Serializable{
    private car carName;
    private int quantity;
    //Constructors
    carPack(car carName,int quantity){
        this.carName=carName;
        this.quantity=quantity;
    }
    carPack(car carName){
        this(carName,1);
    }
    carPack(){
        this(new car(),1);
    }
    //Getter for car
    public car getCar(){
        return carName;
    }
    //Getter and Setter for quantity
    public int getQuantity(){
        return quantity;
    }
    public void setQuantity(int quantity){
        this.quantity=quantity;
    }
    //methods
    public  String toString(){
        return carName.toString()+" ("+quantity+")";
    }
}
class accunt implements Serializable{
    private String userName;
    private String password;
    private String name;
    private String lastName;
    private int dateOfBirth;
    private long id;
    private long phoneNumber;
    private File personalLog;
    // Constructors
    public accunt(String userName, String password, String name, String lastName, int dateOfBirth, long id, long phoneNumber, File personalLog) {
        this.userName = userName;
        this.password = password;
        this.name = name;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.personalLog = personalLog;
    }
    public accunt(String userName, String password, String name, String lastName, String address, int dateOfBirth, long id, long phoneNumber) {
        this(userName,password,name,lastName,dateOfBirth,id,phoneNumber,new File(".\\systemFiles\\userLog\\"+userName+".txt"));
    }
    public accunt(String userName, String password, String name, String lastName, String address, int dateOfBirth, long id, long phoneNumber, long balance) {
        this(userName,password,name,lastName,dateOfBirth,id,phoneNumber,new File(".\\systemFiles\\userLog\\"+userName+".txt"));
    }
    public accunt(){
        this("defaultUserName","1234","defaultName","defaultLastName",1350_1_1,1,1,new File(".\\systemFiles\\userLog\\defaultUserNameLog.txt"));
    }
    // Getter and Setter for userName
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    // Getter and Setter for password
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    // Getter and Setter for name
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    // Getter and Setter for lastName
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    // Getter and Setter for dateOfBirth
    public int getDateOfBirth() {
        return dateOfBirth;
    }
    public void setDateOfBirth(int dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    // Getter and Setter for id
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    // Getter and Setter for phoneNumber
    public long getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    // Getter and Setter for personalLog
    public File getPersonalLog() {
        return personalLog;
    }
    public void setPersonalLog(File personalLog) {
        this.personalLog = personalLog;
    }
    //methods
    public String toString(){
        return userName;
    }
}
class customer extends accunt{
    private ArrayList<carPack> card;
    private ArrayList<carPack> purchaseHistory;
    private ArrayList<car> favouriteCard;
    private File chatFile;
    private String address;
    private long balance;
    private boolean notification;
    //Constructors
    public customer(String userName, String password, String name, String lastName, String address, int dateOfBirth, long id, long phoneNumber,long balance,File personalLog,File chatFile) {
        super(userName,password,name,lastName,dateOfBirth,id,phoneNumber,personalLog);
        this.chatFile=chatFile;
        this.address = address;
        this.balance = balance;
        card=new ArrayList<>();
        purchaseHistory=new ArrayList<>();
        favouriteCard=new ArrayList<>();
    }
    public customer(String userName, String password, String name, String lastName, String address, int dateOfBirth, long id, long phoneNumber) {
        this(userName,password,name,lastName,address,dateOfBirth,id,phoneNumber,0,new File(".\\systemFiles\\userLog\\"+userName+".txt"),new File(".\\systemFiles\\userChat\\"+userName+".txt"));
    }
    public customer(String userName, String password, String name, String lastName, String address, int dateOfBirth, long id, long phoneNumber, long balance) {
        this(userName,password,name,lastName,address,dateOfBirth,id,phoneNumber,balance,new File(".\\systemFiles\\userLog\\"+userName+".txt"),new File(".\\systemFiles\\userChat\\"+userName+".txt"));
    }
    public customer(){
        this("defaultUserName","1234","defaultName","defaultLastName","iran",1350_1_1,1,1,0,new File(".\\systemFiles\\userLog\\defaultUserNameLog.txt"),new File(".\\systemFiles\\userChat\\defaultUserNameLog.txt"));
    }
    // Getter and Setter for notification
    public boolean getNotification() {
        return notification;
    }
    public void setNotification(boolean notification) {
        this.notification = notification;
    }
    // Getter and Setter for balance
    public long getBalance() {
        return balance;
    }
    public void setBalance(long balance) {
        this.balance = balance;
    }
    // Getter and Setter for address
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    // Getter and Setter for chatFile
    public File getChatFile() {
        return chatFile;
    }
    public void setChatFile(File chatFile) {
        this.chatFile = chatFile;
    }
    //Getter and Adder for card
    public ArrayList<carPack> getCard(){
        return card;
    }
    public void addToCard(carPack carPack){
        int i=card.stream().map(o1->o1.getCar()).collect(Collectors.toList()).indexOf(carPack.getCar());
        if(i!=-1){
            card.get(i).setQuantity((card.get(i).getQuantity())+1);
        }else {
            card.add(carPack);
        }
    }
    public void removeFromCard(int i){
        card.remove(i);
    }
    public void removeFromCard(car car){
        boolean flag=true;
        int i=0;
        for(;i<card.size()&&flag;i++){
            if(car.equals(card.get(i).getCar()))
                flag=false;
        }
        removeFromCard(--i);
    }
    public void removeFromCard(carPack carPack){
        removeFromCard(carPack.getCar());
    }
    //Getter and Adder for purchaseHistory
    public ArrayList<carPack> getPurchaseHistory(){
        return purchaseHistory;
    }
    public void addToPurchaseHistory(carPack carPack){
        purchaseHistory.add(carPack);
    }
    public void removeFromPurchaseHistory(int i){
        purchaseHistory.remove(i);
    }
    public void removeFromPurchaseHistory(car car){
        boolean flag=true;
        int i=0;
        for(;i<purchaseHistory.size()&&flag;i++){
            if(car.equals(purchaseHistory.get(i).getCar()))
                flag=false;
        }
        removeFromPurchaseHistory(--i);
    }
    public void removeFromPurchaseHistory(carPack carPack){
        removeFromPurchaseHistory(carPack.getCar());
    }
    //Getter and Adder for FavouriteCard
    public ArrayList<car> getFavouriteCard(){
        return favouriteCard;
    }
    public void addToFavouriteCard(car car){
        if(!favouriteCard.contains(car))
            favouriteCard.add(car);
    }
    public void removeFromFavouriteCard(int i){
        favouriteCard.remove(i);
    }
    public void removeFromFavouriteCard(car car){
        boolean flag=true;
        int i=0;
        for(;i<favouriteCard.size()&&flag;i++){
            if(car.equals(favouriteCard.get(i)))
                flag=false;
        }
        removeFromFavouriteCard(--i);
    }
    public void removeFromFavouriteCard(carPack carPack){
        removeFromFavouriteCard(carPack.getCar());
    }
    //Remover for chatFile
    public void deleteChatHistory(){
        chatFile.delete();
    }
    //methods
}
class admin extends accunt{
    //Constructors
    public admin(String userName,String password,String name,String lastName,int dateOfBirth,long id,long phoneNumber,File personalLog) {
        super(userName,password,name,lastName,dateOfBirth,id,phoneNumber,personalLog);
    }
    public admin(String userName, String password, String name, String lastName,int dateOfBirth, long id, long phoneNumber) {
        this(userName,password,name,lastName,dateOfBirth,id,phoneNumber,new File(".\\systemFiles\\userLog\\"+userName+".txt"));
    }
    public admin(){
        this("admin","1234","MohammadAmin","Abdollahnia",1384_12_28,1,9123456789L,new File(".\\systemFiles\\userLog\\admin.txt"));
    }
    //methods
}
class carBrand implements Serializable{
    private ArrayList<carPack> brandList;
    private String brandName;
    private String brandOwnerName;
    private String brandCountry;
    private String brandDetail;
    private int year;
    private File brandIcon;

    // Constructors
    public carBrand(String brandName, String brandOwnerName, String brandCountry, String brandDetail, int year, File brandIcon) {
        this.brandName = brandName;
        this.brandOwnerName = brandOwnerName;
        this.brandCountry = brandCountry;
        this.year = year;
        this.brandIcon = brandIcon;
        this.brandDetail=brandDetail;
        brandList=new ArrayList<>();
    }
    public carBrand(String brandName, String brandOwnerName, String brandCountry, String brandDetail, int year){
        this(brandName,brandOwnerName,brandCountry,brandDetail,year,new File(".\\systemFiles\\brandIcons\\"+brandName+".png"));
    }
    public carBrand(){
        this("defaultName","defaultOwnerName","defaultCountry","idk",2000,new File(".\\systemFiles\\brandIcons\\defaultName.png"));
    }
    // Getter and Adder and Remover for brandList
    public ArrayList<carPack> getBrandList() {
        return brandList;
    }
    public void addToBrandList(carPack carPack) {
        brandList.add(carPack);
    }
    public void removeFromBrandList(int i){
        brandList.remove(i);
    }
    public void removeFromBrandList(car car){
        boolean flag=true;
        int i=0;
        for(;i<brandList.size()&&flag;i++){
            if(car.equals(brandList.get(i)))
                flag=false;
        }
        removeFromBrandList(--i);
    }
    public void removeFromBrandList(carPack carPack){
        removeFromBrandList(carPack.getCar());
    }
    // Getter and Setter for brandName
    public String getBrandName() {
        return brandName;
    }
    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }
    // Getter and Setter for brandOwnerName
    public String getBrandOwnerName() {
        return brandOwnerName;
    }
    public void setBrandOwnerName(String brandOwnerName) {
        this.brandOwnerName = brandOwnerName;
    }
    // Getter and Setter for brandCountry
    public String getBrandCountry() {
        return brandCountry;
    }
    public void setBrandCountry(String brandCountry) {
        this.brandCountry = brandCountry;
    }
    // Getter and Setter for brandDetail
    public String getBrandDetail() {
        return brandDetail;
    }
    public void setBrandDetail(String brandDetail) {
        this.brandDetail = brandDetail;
    }
    // Getter and Setter for year
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }
    // Getter and Setter for brandIcon
    public File getBrandIcon() {
        return brandIcon;
    }
    public void setBrandIcon(File brandIcon) {
        this.brandIcon = brandIcon;
    }
    //methods
    public String toString(){
        return brandName;
    }
}
class Abdoll {
    private static accunt currentAcc;
    private static ArrayList<carPack> allCars;
    private static ArrayList<carBrand> allBrand;
    //allCars is reading allBrand and dumping it in itself
    private static ArrayList<accunt> allAccounts;
    private static ArrayList<String> lastPageName;
    static {
        System.out.println("starting");
        lastPageName=new ArrayList<>();
        allAccounts=new ArrayList<>();
        allBrand=new ArrayList<>();
        lastPageName.add("main");
        //add the main menu first
    }
    //Getters and Setters
    public static accunt getCurrentAcc() {
        return currentAcc;
    }

    public static void setCurrentAcc(accunt currentAcc) {
        Abdoll.currentAcc = currentAcc;
    }

    public static ArrayList<carPack> getAllCars() {
        return allCars;
    }

    public static void setAllCars(ArrayList<carPack> allCars) {
        Abdoll.allCars = allCars;
    }

    public static ArrayList<carBrand> getAllBrand() {
        return allBrand;
    }

    public static void setAllBrand(ArrayList<carBrand> allBrand) {
        Abdoll.allBrand = allBrand;
    }

    public static ArrayList<accunt> getAllAccounts() {
        return allAccounts;
    }

    public static void setAllAccounts(ArrayList<accunt> allAccounts) {
        Abdoll.allAccounts = allAccounts;
    }

    public static ArrayList<String> getLastPageName() {
        return lastPageName;
    }

    public static void setLastPageName(ArrayList<String> lastPageName) {
        Abdoll.lastPageName = lastPageName;
    }
    //methods
    public static void goBack(ActionEvent event){
        if(lastPageName.size()>1){
            try {
                Parent parent = FXMLLoader.load(GSA.class.getResource(lastPageName.get(lastPageName.size()-2)+".fxml"));
                Scene scene = new Scene(parent, 1280, 720);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
                lastPageName.removeLast();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public static void goTo(String pageName,ActionEvent event){
        goToWithNoFootPrint(pageName,event);
        lastPageName.add(pageName);
    }
    public static void goToWithNoFootPrint(String pageName,ActionEvent event){
        try {
            Parent parent = FXMLLoader.load(GSA.class.getResource(pageName+".fxml"));
            Scene scene = new Scene(parent, 1280, 720);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void loadAllCars(){
        try{
            ObjectInputStream in=new ObjectInputStream(new FileInputStream(".\\systemFiles\\allBrand.dat"));
            allBrand=(ArrayList<carBrand>)in.readObject();
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        allCars=new ArrayList<>();
        for(int i=0;i<allBrand.size();i++){
            for(int j=0;j<allBrand.get(i).getBrandList().size();j++) {
                allCars.add(allBrand.get(i).getBrandList().get(j));
            }
        }
    }
    public static void loadAllAccounts(){
        try{
            ObjectInputStream in=new ObjectInputStream(new FileInputStream(".\\systemFiles\\allAccounts.dat"));
            allAccounts=(ArrayList<accunt>)in.readObject();
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //allAccounts.sort(Comparator.comparing(accunt::getUserName));
    }
    public static void saveAllCarBrands(){
        try{
            ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream(".\\systemFiles\\allBrand.dat"));
            out.writeObject(allBrand);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void saveAllAccounts(){
        try{
            ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream(".\\systemFiles\\allAccounts.dat"));
            out.writeObject(allAccounts);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static String[] checkLogIn(String userName,String password){
        //variable
        String[] errorList = new String[3];
        for (String s : errorList) {
            s="";
        }
        /*
        0_allError
        1_userNameError
        2_passwordError
        */
        //flags
        boolean userNameFlag=true;
        boolean passwordFlag=true;
        if (userName.isEmpty()){
            userNameFlag=false;
            errorList[1]="نام کاربری خود را وارد کنید";
            errorList[0]="error";
        }
        if (password.isEmpty()){
            passwordFlag=false;
            errorList[2]="رمز عبور خود را وارد کنید";
            errorList[0]="error";
        }
        if(userNameFlag&&passwordFlag){
            int index = isUserNameUsed(userName);
            if (index==-1){
                errorList[0]="حسابی با این مشخصات وجود ندارد ، از بخش  ثبت نام یکی ایجاد کنید";
            }
            else{
                if(allAccounts.get(index).getPassword().equals(password)) {
                    currentAcc = allAccounts.get(index);
                    errorList[0]="enter";
                    logThisMessageInPersonalLog("user loged in");
                }else{
                    errorList[0]="رمز عبور اشتباه است";
                }
            }
        }
        return errorList;
    }
    public static String[] checkLogInF(String userName,String password){
        //variable
        String[] errorList = new String[3];
        for (String s : errorList) {
            s="";
        }
        /*
        0_allError
        1_userNameError
        2_passwordError
        */
        //flags
        boolean userNameFlag=true;
        boolean passwordFlag=true;
        if (userName.isEmpty()){
            userNameFlag=false;
            errorList[1]="نام کاربری خود را وارد کنید";
            errorList[0]="error";
        }
        if (password.isEmpty()){
            passwordFlag=false;
            errorList[2]="کد ملی خود را وارد کنید";
            errorList[0]="error";
        }
        if(userNameFlag&&passwordFlag){
            int index = isUserNameUsed(userName);
            if (index==-1){
                errorList[0]="حسابی با این مشخصات وجود ندارد ، از بخش  ثبت نام یکی ایجاد کنید";
            }
            else{
                if(String.valueOf(allAccounts.get(index).getId()).equals(password)) {
                    currentAcc = allAccounts.get(index);
                    errorList[0]="enter";
                    logThisMessageInPersonalLog("user loged in");
                }else{
                    errorList[0]="کد ملی اشتباه است";
                }
            }
        }
        return errorList;
    }
    public static String[] customerSignUp(String userName,String password,String rePassword,String name,String lastName,String address,String dateOfBirst,String id,String phoneNumber) {
        //flags
        boolean userFlag = true;
        boolean passFlag = true;
        boolean rePassFlag = true;
        boolean flagPas1 = true;
        boolean flagPas2 = true;
        boolean flagPas3 = true;
        boolean flagPas4 = true;
        boolean nameFlag = true;
        boolean lNameFlag = true;
        boolean idFlag = true;
        boolean phoneFlag = true;
        boolean addFlag = true;
        boolean birthFlag = true;
        //variable
        String[] errorList = new String[10];
        for (String s : errorList) {
            s="";
        }
        /*
        0_allError
        1_nameError
        2_lastNameError
        3_userNameError
        4_passwordError
        5_rePasswordError
        6_addressError
        7_idError
        8_phoneNumberError
        9_dateOfBirstError
        */
        //userNameFlag
        if (userName.isEmpty()) {
            userFlag = false;
            errorList[3] = "فیلد خالی است";
            errorList[0] = "error";
        } else {
            for (int i = 0; userFlag && i < userName.length(); i++) {
                if ((int) userName.charAt(i) > 122 || ((int) userName.charAt(i) > 90 && (int) userName.charAt(i) < 97) || ((int) userName.charAt(i) > 57 && (int) userName.charAt(i) < 65) || (int) userName.charAt(i) < 48) {
                    userFlag = false;
                    errorList[3] = "یوزرنیم فقط میتواند عدد و حروف انگلیسی باشد";
                    errorList[0] = "error";
                }
            }
        }
        if (userFlag && isUserNameUsed(userName)!=-1) {
            userFlag = false;
            errorList[3] = "نام کاربری تکراری است";
            errorList[0] = "error";
        }
        //passwordFlag
        if (password.isEmpty()) {
            passFlag = false;
            errorList[4] = "فیلد خالی است";
            errorList[0] = "error";
        } else {
            for (int i = 0; passFlag && i < password.length(); i++) {
                if ((int) password.charAt(i) > 122 || ((int) password.charAt(i) > 90 && (int) password.charAt(i) < 97) || ((int) password.charAt(i) > 57 && (int) password.charAt(i) < 65) || ((int) password.charAt(i) > 38 && (int) password.charAt(i) < 48) || (int) password.charAt(i) < 33) {
                    passFlag = false;
                    errorList[4] = "رمز فقط میتواند عدد و حروف انگلیسی و حروف خاص باشد";
                    errorList[0] = "error";
                }
            }
        }
        if (passFlag) {
            flagPas1 = !(charCheck(password, 48, 57));
            if (flagPas1) {
                errorList[4] = "رمز عدد ندارد";
                errorList[0] = "error";
            }
            flagPas2 = !(charCheck(password, 97, 122));
            if (flagPas2) {
                errorList[4] = "رمز حرف کوچک انگلیسی ندارد";
                errorList[0] = "error";
            }
            flagPas3 = !(charCheck(password, 65, 90));
            if (flagPas3) {
                errorList[4] = "رمز حرف بزرگ انگلیسی ندارد";
                errorList[0] = "error";
            }
            flagPas4 = !(charCheck(password, 33, 38));
            if (flagPas4) {
                errorList[4] = "رمز کاراکتر خاص ندارد ندارد";
                errorList[0] = "error";
            }
            if (flagPas4 || flagPas3 || flagPas2 || flagPas1) {
                passFlag = false;
            }
        }
        //rePasswordFlag
        if (rePassword.isEmpty()) {
            rePassFlag = false;
            errorList[5] = "فیلد خالی است";
            errorList[0] = "error";
        }
        if (rePassFlag && !(password.equals(rePassword))) {
            rePassFlag = false;
            errorList[5] = "رمز ها یکی نیستن";
            errorList[0] = "error";
        }
        //nameFlag
        if (name.isEmpty()) {
            nameFlag = false;
            errorList[1] = "فیلد خالی است";
            errorList[0] = "error";
        } else {
            nameFlag = !((charCheckOut(name, 1740, 1570) && !charCheck(name, 32, 32)));
            if (!nameFlag) {
                errorList[1] = "نام فقط باید حروف فارسی باشد";
                errorList[0] = "error";
            }
        }
        //lastNameFlag
        if (lastName.isEmpty()) {
            lNameFlag = false;
            errorList[2] = "فیلد خالی است";
            errorList[0] = "error";
        } else {
            lNameFlag = !((charCheckOut(lastName, 1740, 1570) && !charCheck(lastName, 32, 32)));
            if (!lNameFlag) {
                errorList[2] = "نام خوانوادگی فقط باید حروف فارسی باشد";
                errorList[0] = "error";
            }
        }
        //idFlag
        if (id.isEmpty()) {
            idFlag = false;
            errorList[7] = "فیلد خالی است";
            errorList[0] = "error";
        } else {
            idFlag = !(charCheckOut(id, 57, 48));
            if (!idFlag) {
                errorList[7] = "کد ملی فقط باید عدد باشد";
                errorList[0] = "error";
            } else if (id.length() != 10) {
                idFlag = false;
                errorList[7] = "شماره فقط باید 10 رقم باشد";
                errorList[0] = "error";
            }
        }
        //dateOfBirstFlag
        if (dateOfBirst.isEmpty()) {
            birthFlag = false;
            errorList[9] = "فیلد خالی است";
            errorList[0] = "error";
        }else{
            if (dateOfBirst.length() != 10) {
                birthFlag = false;
                errorList[9] = "غیر قابل قبول";
                errorList[0] = "error";
            }else{
                if(charCheckOut(dateOfBirst, 57, 47) || dateOfBirst.charAt(4) != '/' || dateOfBirst.charAt(7) != '/'){
                    birthFlag=false;
                    errorList[9] = "تاریخ تولد فقط باید عدد و / باشد";
                    errorList[0] = "error";
                }
            }
        }
        //phoneNumberFlag
        if(phoneNumber.isEmpty()){
            phoneFlag=false;
            errorList[8] = "فیلد خالی است";
            errorList[0] = "error";
        }else{
            phoneFlag = !(charCheckOut(phoneNumber, 57, 48));
            if (!phoneFlag) {
                errorList[8] = "شماره فقط باید عدد باشد";
                errorList[0] = "error";
            }else{
                if(phoneNumber.length()!=11){
                    phoneFlag=false;
                    errorList[8] = "شماره فقط باید 11 رقم باشد";
                    errorList[0] = "error";
                }
            }
        }
        //addressFlag
        if (address.isEmpty()) {
            addFlag = false;
            errorList[6] = "فیلد خالی است";
            errorList[0] = "error";
        }
        //
        if (userFlag && passFlag && rePassFlag && nameFlag && lNameFlag && addFlag && idFlag && phoneFlag && birthFlag) {
            int dateOfBirstInNumber=(dateOfBirst.charAt(0)-48)*1000_00_00+(dateOfBirst.charAt(1)-48)* 100_00_00 +(dateOfBirst.charAt(2)-48)*10_00_00+(dateOfBirst.charAt(3)-48)*1_00_00+(dateOfBirst.charAt(5)-48)*10_00+(dateOfBirst.charAt(6)-48)*1_00+(dateOfBirst.charAt(8)-48)*10+(dateOfBirst.charAt(9)-48);
            currentAcc=new customer(userName,password,name,lastName,address,dateOfBirstInNumber,Long.parseLong(id),Long.parseLong(phoneNumber));
            addAccToAllAccounts(currentAcc);
            logThisMessageInPersonalLog("Wellcom");
        }
        return errorList;
    }
    private static boolean charCheck(String a, int b, int c) {
        boolean an = false;
        for (int i = 0; (!an) && i < a.length(); i++) {
            if ((int) a.charAt(i) >= b && (int) a.charAt(i) <= c)
                an = true;
        }
        return an;
    }
    private static boolean charCheckOut(String a, int b, int c) {
        boolean an = false;
        for (int i = 0; (!an) && i < a.length(); i++) {
            if ((int) a.charAt(i) > b || (int) a.charAt(i) < c)
                an = true;
        }
        return an;
    }
    private static int isUserNameUsed(String userName){
        int index=-1;
        boolean result=false;
        if(allAccounts==null)
            loadAllAccounts();
        int top=allAccounts.size()-1;
        int bottom=0;
        int mid=(top+bottom)/2;
        while(!result&&bottom<=top){
            if(allAccounts.get(mid).getUserName().equals(userName)){
                result=true;
            }else if(allAccounts.get(mid).getUserName().compareTo(userName)>0){
                top=mid-1;
                mid=(top+bottom)/2;
            }else{
                bottom=mid+1;
                mid=(top+bottom)/2;
            }
        }
    if(result)
        index=mid;
    return index;
    }
    private static void addAccToAllAccounts(accunt accunt){
        boolean result=false;
        if(allAccounts==null)
            loadAllAccounts();
        if(allAccounts.isEmpty()){
            allAccounts.add(accunt);
        }else {
            if(accunt.getUserName().compareTo(allAccounts.getFirst().getUserName())<0){
                allAccounts.addFirst(accunt);
            }else if(accunt.getUserName().compareTo(allAccounts.get(allAccounts.size()-1).getUserName())>0){
                allAccounts.add(accunt);
            }else {
                int top = allAccounts.size() - 1;
                int bottom = 0;
                int mid = (top + bottom) / 2;
                while (!result && bottom <= top) {
                    if (mid + 1 < allAccounts.size()) {
                        if (accunt.getUserName().compareTo(allAccounts.get(mid).getUserName()) >= 0 && accunt.getUserName().compareTo(allAccounts.get(mid + 1).getUserName()) <= 0) {
                            result = true;
                            allAccounts.add(mid + 1, accunt);
                        } else if (allAccounts.get(mid).getUserName().compareTo(accunt.getUserName()) > 0) {
                            top = mid - 1;
                            mid = (top + bottom) / 2;
                        } else {
                            bottom = mid + 1;
                            mid = (top + bottom) / 2;
                        }
                    } else {
                        allAccounts.add(mid, accunt);
                    }
                }
            }
        }
    }
    public static String customerSendChatMessage(String message){
        message= "("+LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))+")"+currentAcc.getUserName()+":"+message;
        try{
            PrintWriter printWriter=new PrintWriter(new FileOutputStream(((customer)(currentAcc)).getChatFile().getAbsolutePath(),true));
            printWriter.println(message);
            printWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        logThisMessageInPersonalLog("send a message");
        return message;
    }
    public static String adminSendChatMessage(String message,accunt accunt){
        message= "("+LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))+")Admin:"+message;
        try{
            PrintWriter printWriter=new PrintWriter(new FileOutputStream(((customer)(accunt)).getChatFile().getAbsolutePath(),true));
            printWriter.println(message);
            printWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        logThisMessageInPersonalLog("send message to"+accunt.getUserName());
        return message;
    }
    public static void logThisMessageInPersonalLog(String message){
        logThisMessageInSystemLog(message);
        message= "("+LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))+")"+currentAcc.getName()+":"+message;
        try{
            PrintWriter printWriter=new PrintWriter(new FileOutputStream((currentAcc).getPersonalLog().getAbsolutePath(),true));
            printWriter.println(message);
            printWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void logThisMessageInSystemLog(String message){
        message= "("+LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))+")"+currentAcc.getName()+":"+message;
        try{
            PrintWriter printWriter=new PrintWriter(new FileOutputStream(".\\systemFiles\\systemLog.txt",true));
            printWriter.println(message);
            printWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static String customerBuyTheCard(){
        long allPrice=0;
        ArrayList<carPack> card=((customer) currentAcc).getCard();
        String result="";
        boolean flag=true;
        int[] index=new int[card.size()];
        if(card.isEmpty()){
            result="صبد خرید خالی است";
        }else {
            for (int i = 0; flag && i < card.size(); i++) {
                allPrice += card.get(i).getQuantity() * card.get(i).getCar().getPrice();
                index[i]=card.stream().map(o->o.getCar()).collect(Collectors.toList()).indexOf(card.get(i).getCar());
                if (card.get(i).getQuantity() > allCars.get(index[i]).getQuantity()) {
                    flag = false;
                    result = "در انبار کم است" + card.get(i).getCar().getName() + "تعداد خودرو ی";
                } else if (!allCars.get(index[i]).getCar().isAvailability()) {
                    flag = false;
                    result = "در انبار موجود نیست" + card.get(i).getCar().getName() + "خودرو ی";
                }
            }
            if (flag && ((customer) currentAcc).getBalance() >= allPrice) {
                int temp=0;
                while (!card.isEmpty()) {
                    int q=allCars.get(index[temp]).getQuantity()-card.getFirst().getQuantity();
                    allCars.get(index[temp]).setQuantity(q);
                    if(q==0){
                        allCars.get(index[temp++]).getCar().setAvailability(false);
                    }
                    ((customer) currentAcc).addToPurchaseHistory(card.getFirst());
                    ((customer) currentAcc).removeFromCard(0);
                }
                ((customer) currentAcc).setBalance(((customer) currentAcc).getBalance()-allPrice);
                result="خرید با موفقیت انجام شد";
            }
        }
        return result;
    }
    public static String[] createNewCar(String name,String brand,String detail,String year,String price,String availability,String quantity) {
        //flags
        boolean nameFlag = true;
        boolean brandFlag = true;
        boolean detailFlag = true;
        boolean yearFlag = true;
        boolean priceFlag = true;
        boolean availabilityFlag = true;
        boolean quantityFlag = true;
        //variable
        String[] errorList = new String[8];
        for (String s : errorList) {
            s="";
        }
        int index=-1;
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
        //nameFlag
        if (name.isEmpty()) {
            nameFlag = false;
            errorList[1] = "فیلد خالی است";
            errorList[0] = "error";
        }
        //brandFlag
        if (brand.isEmpty()) {
            brandFlag = false;
            errorList[2] = "فیلد خالی است";
            errorList[0] = "error";
        }else{
            index=allBrand.stream().map(o->o.getBrandName()).collect(Collectors.toList()).indexOf(brand);
            if(index==-1){
                brandFlag = false;
                errorList[2] = "این برند در سیستم موجود نیست";
                errorList[0] = "error";
            }
        }
        //detailFlag
        if (detail.isEmpty()) {
            detailFlag = false;
            errorList[3] = "فیلد خالی است";
            errorList[0] = "error";
        }
        //yearFlag
        if (year.isEmpty()) {
            yearFlag = false;
            errorList[4] = "فیلد خالی است";
            errorList[0] = "error";
        } else {
            yearFlag = !(charCheckOut(year, 57, 48));
            if (!yearFlag) {
                errorList[4] = "سال تولید فقط باید عدد باشد";
                errorList[0] = "error";
            } else if (year.length() != 4) {
                yearFlag = false;
                errorList[4] = "سال تولید فقط باید 4 رقم باشد";
                errorList[0] = "error";
            }
        }
        //priceFlag
        if (price.isEmpty()) {
            priceFlag = false;
            errorList[5] = "فیلد خالی است";
            errorList[0] = "error";
        } else {
            priceFlag = !(charCheckOut(price, 57, 48));
            if (!priceFlag) {
                errorList[5] = "سال تولید فقط باید عدد باشد";
                errorList[0] = "error";
            }
        }
        //availabilityFlag
        if (availability.isEmpty()) {
            availabilityFlag = false;
            errorList[6] = "فیلد خالی است";
            errorList[0] = "error";
        }else if(!(availability.equals("true")||availability.equals("false"))) {
            availabilityFlag = false;
            errorList[6] = "فیلد مشکل دارد";
            errorList[0] = "error";
        }
        //quantityFlag
        if (quantity.isEmpty()) {
            quantityFlag = false;
            errorList[7] = "فیلد خالی است";
            errorList[0] = "error";
        } else {
            quantityFlag = !(charCheckOut(year, 57, 48));
            if (!quantityFlag) {
                errorList[7] = "سال تولید فقط باید عدد باشد";
                errorList[0] = "error";
            }
        }
        //
        if (nameFlag && brandFlag && detailFlag && yearFlag && priceFlag && availabilityFlag && quantityFlag) {
            allBrand.get(index).getBrandList().add(new carPack(new car(name,brand,detail,Integer.parseInt(year),Long.parseLong(price)),Integer.parseInt(quantity)));
            allCars.add(allBrand.get(index).getBrandList().getLast());
            logThisMessageInPersonalLog("created a car named"+name);
        }
        return errorList;
    }
    public static String[] createNewBrand(String brandName,String brandOwnerName,String brandCountry,String brandDetail,String year) {
        //flags
        boolean brandNameFlag = true;
        boolean brandOwnerFlag = true;
        boolean brandCountryFlag = true;
        boolean brandDetailFlag = true;
        boolean yearFlag = true;
        //variable
        String[] errorList = new String[6];
        for (String s : errorList) {
            s="";
        }
        /*
        0_allError
        1_brandNameError
        2_brandOwnerNameError
        3_brandCountryError
        4_brandDetailError
        5_yearError
        */
        //brandNameFlag
        if (brandName.isEmpty()) {
            brandNameFlag = false;
            errorList[1] = "فیلد خالی است";
            errorList[0] = "error";
        }
        //brandOwnerFlag
        if (brandOwnerName.isEmpty()) {
            brandOwnerFlag = false;
            errorList[2] = "فیلد خالی است";
            errorList[0] = "error";
        }
        //brandCountryFlag
        if (brandCountry.isEmpty()) {
            brandCountryFlag = false;
            errorList[3] = "فیلد خالی است";
            errorList[0] = "error";
        }
        //brandDetailFlag
        if (brandDetail.isEmpty()) {
            brandDetailFlag = false;
            errorList[4] = "فیلد خالی است";
            errorList[0] = "error";
        }
        //yearFlag
        if (year.isEmpty()) {
            yearFlag = false;
            errorList[5] = "فیلد خالی است";
            errorList[0] = "error";
        } else {
            yearFlag = !(charCheckOut(year, 57, 48));
            if (!yearFlag) {
                errorList[5] = "سال تولید فقط باید عدد باشد";
                errorList[0] = "error";
            } else if (year.length() != 4) {
                yearFlag = false;
                errorList[5] = "سال تولید فقط باید 4 رقم باشد";
                errorList[0] = "error";
            }
        }
        //
        if (brandNameFlag && brandOwnerFlag && brandCountryFlag && brandDetailFlag && yearFlag) {
            allBrand.add(new carBrand(brandName,brandOwnerName,brandCountry,brandDetail,Integer.parseInt(year)));
            logThisMessageInPersonalLog("created a brand named"+brandName);
        }
        return errorList;
    }
    public static String[] editBrand(carBrand brand,String brandName,String brandOwnerName,String brandCountry,String brandDetail,String year) {
        //flags
        boolean brandNameFlag = true;
        boolean brandOwnerFlag = true;
        boolean brandCountryFlag = true;
        boolean brandDetailFlag = true;
        boolean yearFlag = true;
        //variable
        String[] errorList = new String[6];
        for (String s : errorList) {
            s="";
        }
        /*
        0_allError
        1_brandNameError
        2_brandOwnerNameError
        3_brandCountryError
        4_brandDetailError
        5_yearError
        */
        //brandNameFlag
        if (brandName.isEmpty()) {
            brandNameFlag = false;
            errorList[1] = "فیلد خالی است";
            errorList[0] = "error";
        }
        //brandOwnerFlag
        if (brandOwnerName.isEmpty()) {
            brandOwnerFlag = false;
            errorList[2] = "فیلد خالی است";
            errorList[0] = "error";
        }
        //brandCountryFlag
        if (brandCountry.isEmpty()) {
            brandCountryFlag = false;
            errorList[3] = "فیلد خالی است";
            errorList[0] = "error";
        }
        //brandDetailFlag
        if (brandDetail.isEmpty()) {
            brandDetailFlag = false;
            errorList[4] = "فیلد خالی است";
            errorList[0] = "error";
        }
        //yearFlag
        if (year.isEmpty()) {
            yearFlag = false;
            errorList[5] = "فیلد خالی است";
            errorList[0] = "error";
        } else {
            yearFlag = !(charCheckOut(year, 57, 48));
            if (!yearFlag) {
                errorList[5] = "سال تولید فقط باید عدد باشد";
                errorList[0] = "error";
            } else if (year.length() != 4) {
                yearFlag = false;
                errorList[5] = "سال تولید فقط باید 4 رقم باشد";
                errorList[0] = "error";
            }
        }
        //
        if (brandNameFlag && brandOwnerFlag && brandCountryFlag && brandDetailFlag && yearFlag) {
            brand.setBrandName(brandName);
            brand.setBrandOwnerName(brandOwnerName);
            brand.setBrandCountry(brandCountry);
            brand.setYear(Integer.parseInt(year));
            brand.setBrandDetail(brandDetail);
            logThisMessageInPersonalLog("edited a brand named "+brandName);
        }
        return errorList;
    }
    public static void closeTheApp(){
        saveAllAccounts();
        saveAllCarBrands();
        System.exit(0);
    }
    public static String[] editCar(carPack carPack,String name,String brand,String detail,String year,String price,boolean availability,String quantity) {
        //flags
        boolean nameFlag = true;
        boolean brandFlag = true;
        boolean detailFlag = true;
        boolean yearFlag = true;
        boolean priceFlag = true;
        boolean availabilityFlag = true;
        boolean quantityFlag = true;
        //variable
        String[] errorList = new String[8];
        for (String s : errorList) {
            s="";
        }
        int index=-1;
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
        //nameFlag
        if (name.isEmpty()) {
            nameFlag = false;
            errorList[1] = "فیلد خالی است";
            errorList[0] = "error";
        }
        //brandFlag
        if(!carPack.getCar().getBrand().equals(brand)) {
            if (brand.isEmpty()) {
                brandFlag = false;
                errorList[2] = "فیلد خالی است";
                errorList[0] = "error";
            } else {
                index = allBrand.stream().map(o -> o.getBrandName()).collect(Collectors.toList()).indexOf(brand);
                if (index == -1) {
                    brandFlag = false;
                    errorList[2] = "این برند در سیستم موجود نیست";
                    errorList[0] = "error";
                }
            }
        }

        //detailFlag
        if (detail.isEmpty()) {
            detailFlag = false;
            errorList[3] = "فیلد خالی است";
            errorList[0] = "error";
        }
        //yearFlag
        if (year.isEmpty()) {
            yearFlag = false;
            errorList[4] = "فیلد خالی است";
            errorList[0] = "error";
        } else {
            yearFlag = !(charCheckOut(year, 57, 48));
            if (!yearFlag) {
                errorList[4] = "سال تولید فقط باید عدد باشد";
                errorList[0] = "error";
            } else if (year.length() != 4) {
                yearFlag = false;
                errorList[4] = "سال تولید فقط باید 4 رقم باشد";
                errorList[0] = "error";
            }
        }
        //priceFlag
        if (price.isEmpty()) {
            priceFlag = false;
            errorList[5] = "فیلد خالی است";
            errorList[0] = "error";
        } else {
            priceFlag = !(charCheckOut(price, 57, 48));
            if (!priceFlag) {
                errorList[5] = "سال تولید فقط باید عدد باشد";
                errorList[0] = "error";
            }
        }
        //availabilityFlag
        //quantityFlag
        if (quantity.isEmpty()) {
            quantityFlag = false;
            errorList[7] = "فیلد خالی است";
            errorList[0] = "error";
        } else {
            quantityFlag = !(charCheckOut(year, 57, 48));
            if (!quantityFlag) {
                errorList[7] = "سال تولید فقط باید عدد باشد";
                errorList[0] = "error";
            }
        }
        //
        if (nameFlag && brandFlag && detailFlag && yearFlag && priceFlag  && quantityFlag) {
            //removing from old list and adding it to new one
            if(!carPack.getCar().getBrand().equals(brand)){
                int index1=-1;
                for (int i =0;index1==-1&&i<allBrand.size();i++) {
                    if (allBrand.get(i).getBrandName().equals(carPack.getCar().getBrand()))
                        index1=i;
                }
                allBrand.get(index1).removeFromBrandList(carPack);
                allBrand.get(index).getBrandList().add(carPack);
            }
            //
            carPack.setQuantity(Integer.parseInt(quantity));
            car car=carPack.getCar();
            car.setAvailability(availability);
            car.setBrand(brand);
            car.setDetail(detail);
            car.setName(name);
            car.setPrice(Long.parseLong(price));
            car.setYear(Integer.parseInt(year));
            logThisMessageInPersonalLog("edited a car named "+name);
        }
        return errorList;
    }
}