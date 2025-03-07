package com.example.grand_shop_auto_v2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

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
}
class customer extends accunt{
    private ArrayList<carPack> card;
    private ArrayList<carPack> purchaseHistory;
    private ArrayList<car> favouriteCard;
    private File chatFile;
    private String address;
    private long balance;
    //Constructors
    public customer(String userName, String password, String name, String lastName, String address, int dateOfBirth, long id, long phoneNumber,long balance,File personalLog,File chatFile) {
        super(userName,password,name,lastName,dateOfBirth,id,phoneNumber,personalLog);
        this.chatFile=chatFile;
        this.address = address;
        this.balance = balance;
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
    //methods
}
class admin extends accunt{
    //methods
}
class carBrand {
    private ArrayList<carPack> brandList;
    private String brandName;
    private String brandOwnerName;
    private String brandCountry;
    private int year;
    private File brandIcon;

    // Constructors
    public carBrand(String brandName, String brandOwnerName, String brandCountry, int year, File brandIcon) {
        this.brandName = brandName;
        this.brandOwnerName = brandOwnerName;
        this.brandCountry = brandCountry;
        this.year = year;
        this.brandIcon = brandIcon;
    }
    public carBrand(String brandName, String brandOwnerName, String brandCountry, int year){
        this(brandName,brandOwnerName,brandCountry,year,new File(".\\systemFiles\\brandIcons\\"+brandName+".png"));
    }
    public carBrand(){
        this("defaultName","defaultOwnerName","defaultCountry",2000,new File(".\\systemFiles\\brandIcons\\defaultName.png"));
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
}
class abdoll{
    private static accunt currentAcc;
    private static ArrayList<carPack> allCars;
    private static ArrayList<carBrand> allBrand;
    //allCars is reading allBrand and dumping it in it self
    private static ArrayList<accunt> allAccounts;
    public static void loadAllCars(){
        allCars=new ArrayList<>();
        for(int i=0;i<allBrand.size();i++){
            for(int j=0;i<allBrand.get(i).getBrandList().size();j++) {
                allCars.add(allBrand.get(i).getBrandList().get(j));
            }
        }
    }
    public static void loadAllAccounts(){
        allAccounts=new ArrayList<>();
        try{

        } catch (Exception e) {
            e.printStackTrace();
        }
        allAccounts.sort(Comparator.comparing(accunt::getUserName));
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
                }else{
                    errorList[0]="رمز عبور اشتباه است";
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
        if (userFlag && isUserNameUsed(userName)==-1) {
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
        }
        return errorList;
    }
    private static boolean charCheck(String a, int b, int c) {
        boolean an = false;
        for (int i = 0; (!an) && i < a.length(); i++) {
            if ((int) a.charAt(i) >= b && (int) a.charAt(i) <= c) {
                an = true;
            }
        }
        return an;
    }
    private static boolean charCheckOut(String a, int b, int c) {
        boolean an = false;
        for (int i = 0; (!an) && i < a.length(); i++) {
            if ((int) a.charAt(i) > b || (int) a.charAt(i) < c) {
                an = true;
            }
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
}