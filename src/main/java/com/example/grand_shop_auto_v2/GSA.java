package com.example.grand_shop_auto_v2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class GSA extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(GSA.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1280, 720);
        stage.setTitle("GSA");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
class car {
    private String name;
    private String brand;
    private int year;
    private long price;
    private boolean availability;

    //Constructors
    public car(String name, String brand, int year, long price, boolean availability) {
        this.name = name;
        this.brand = brand;
        this.year = year;
        this.price = price;
        this.availability = availability;
    }

    public car(String name, String brand, int year, long price) {
        this(name, brand,year, price, true);
    }

    public car(String name) {
        this(name, "Null",2000, 1_000_000_000, true);
    }

    public car() {
        this("testCar", "Null",2000, 1_000_000_000, true);
    }

    // Getter and Setter for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
    //methods
    public boolean equals(Object o){
        boolean result=false;
        car tempCar=(car)o;
        if(name.equals(tempCar.getName())&&year==tempCar.getYear()&&brand.equals(tempCar.getBrand())&&price==tempCar.getPrice())
            result=true;
        return result;
    }
}
class carPack{
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
}
class accunt {
    private String userName;
    private String password;
    private String name;
    private String lastName;
    private String address;
    private int dateOfBirth;
    private long id;
    private long phoneNumber;
    private long balance;
    private File personalLog;
    // Constructors
    public accunt(String userName, String password, String name, String lastName, String address, int dateOfBirth, long id, long phoneNumber, long balance, File personalLog) {
        this.userName = userName;
        this.password = password;
        this.name = name;
        this.lastName = lastName;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.balance = balance;
        this.personalLog = personalLog;
    }
    public accunt(String userName, String password, String name, String lastName, String address, int dateOfBirth, long id, long phoneNumber) {
        this(userName,password,name,lastName,address,dateOfBirth,id,phoneNumber,0,new File(".\\systemFiles\\userLog\\"+userName+".txt"));
    }
    public accunt(String userName, String password, String name, String lastName, String address, int dateOfBirth, long id, long phoneNumber, long balance) {
        this(userName,password,name,lastName,address,dateOfBirth,id,phoneNumber,balance,new File(".\\systemFiles\\userLog\\"+userName+".txt"));
    }
    public accunt(){
        this("defaultUserName","1234","defaultName","defaultLastName","iran",1350_1_1,1,1,0,new File(".\\systemFiles\\userLog\\defaultUserNameLog.txt"));
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
    // Getter and Setter for address
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
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
    // Getter and Setter for balance
    public long getBalance() {
        return balance;
    }
    public void setBalance(long balance) {
        this.balance = balance;
    }
    // Getter and Setter for personalLog
    public File getPersonalLog() {
        return personalLog;
    }
    public void setPersonalLog(File personalLog) {
        this.personalLog = personalLog;
    }
}
class customer extends accunt{
    private ArrayList<carPack> card;
    private ArrayList<carPack> purchaseHistory;
    private ArrayList<car> favouriteCard;
    private File chatFile;
    //Constructors
    public customer(String userName, String password, String name, String lastName, String address, int dateOfBirth, long id, long phoneNumber,long balance,File personalLog,File chatFile) {
        super(userName,password,name,lastName,address,dateOfBirth,id,phoneNumber,balance,personalLog);
        this.chatFile=chatFile;
    }
    public customer(String userName, String password, String name, String lastName, String address, int dateOfBirth, long id, long phoneNumber) {
        this(userName,password,name,lastName,address,dateOfBirth,id,phoneNumber,0,new File(".\\systemFiles\\userLog\\"+userName+".txt"),new File(".\\systemFiles\\userChat\\"+userName+".txt"));
    }
    public customer(String userName, String password, String name, String lastName, String address, int dateOfBirth, long id, long phoneNumber, long balance) {
        this(userName,password,name,lastName,address,dateOfBirth,id,phoneNumber,balance,new File(".\\systemFiles\\userLog\\"+userName+".txt"),new File(".\\systemFiles\\userChat\\"+userName+".txt"));
    }
    public customer(){
        this("defaultUserName","1234","defaultName","defaultLastName","iran",1350_1_1,1,1,0,new File(".\\systemFiles\\userLog\\defaultUserNameLog.txt"),new File(".\\systemFiles\\userChat\\defaultUserNameLog.txttxt"));
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
        card.add(carPack);
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
}
class admin extends accunt{
    
}