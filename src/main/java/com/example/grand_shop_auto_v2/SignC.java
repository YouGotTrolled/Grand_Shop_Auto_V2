package com.example.grandshopauto;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.*;
import java.time.LocalDateTime;
import java.util.StringTokenizer;

public class SignC {
    private PrintWriter loger;

    private PrintWriter adder;

    private StringTokenizer spt;

    private PrintWriter systemFile;

    @FXML
    private TextField name;
    @FXML
    private TextField Lname;
    @FXML
    private TextField ID;
    @FXML
    private TextField ADD;
    @FXML
    private TextField DOB;
    @FXML
    private TextField num;
    @FXML
    private TextField user;
    @FXML
    private TextField pas;
    @FXML
    private TextField Tpas;
    @FXML
    private Label label;
    @FXML
    private Label addError;
    @FXML
    private Label dobError;
    @FXML
    private Label idError;
    @FXML
    private Label lNameError;
    @FXML
    private Label nameError;
    @FXML
    private Label passError;
    @FXML
    private Label phoneError;
    @FXML
    private Label tPassError;
    @FXML
    private Label userfError;



    @FXML
    public void sub(ActionEvent actionEvent) {
        try {
            //flags
            boolean flagPas1 = true;
            boolean flagPas2 = true;
            boolean flagPas3 = true;
            boolean flagPas4 = true;
            boolean userFlag = true;
            boolean passFlag = true;
            boolean rePassFlag = true;
            boolean nameFlag = true;
            boolean lNameFlag = true;
            boolean idFlag = true;
            boolean phoneFlag = true;
            boolean addFlag = true;
            boolean birthFlag = true;
            //
            loger = new PrintWriter(new BufferedOutputStream(new FileOutputStream(".\\systemFiles\\log.txt", true)));
            File userCheck=new File(".\\userInfo\\"+user.getText());
            File acInfo=new File(".\\userInfo\\"+user.getText()+"\\acInfo.txt");
            systemFile = new PrintWriter(new BufferedOutputStream(new FileOutputStream(".\\systemFiles\\cUser.txt")));
            String bob;
            //start
            nameError.setText("");
            lNameError.setText("");
            userfError.setText("");
            passError.setText("");
            tPassError.setText("");
            addError.setText("");
            idError.setText("");
            phoneError.setText("");
            dobError.setText("");
            //userFlag
            if(user.getText().isEmpty()){
                userFlag = false;
                userfError.setText("فیلد خالی است");
            }
            for (int i = 0; (userFlag) && i < user.getText().length(); i++) {
                if ((int) user.getText().charAt(i) > 122 || ((int) user.getText().charAt(i) > 90 && (int) user.getText().charAt(i) < 97) || ((int) user.getText().charAt(i) > 57 && (int) user.getText().charAt(i) < 65) || (int) user.getText().charAt(i) < 48) {
                    userFlag = false;
                    userfError.setText("یوزرنیم فقط میتواند عدد و حروف انگلیسی باشد");
                }
            }
            if(userFlag&&userCheck.exists()){
                userFlag = false;
                userfError.setText("نام کاربری تکراری است");
            }
            //passwordFlag
            if(pas.getText().isEmpty()){
                passFlag = false;
                passError.setText("فیلد خالی است");
            }
            for (int i = 0; (passFlag) && i < pas.getText().length(); i++) {
                if ((int) pas.getText().charAt(i) > 122 || ((int) pas.getText().charAt(i) > 90 && (int) pas.getText().charAt(i) < 97) || ((int) pas.getText().charAt(i) > 57 && (int) pas.getText().charAt(i) < 65) || ((int) pas.getText().charAt(i) > 38 && (int) pas.getText().charAt(i) < 48) || (int) pas.getText().charAt(i) < 33) {
                    passFlag = false;
                    passError.setText("رمز فقط میتواند عدد و حروف انگلیسی و حروف خاص باشد");
                }
            }
            if (passFlag) {
                flagPas1 = !(charCheck(pas.getText(), 48, 57));
                if (flagPas1) {
                    passError.setText("رمز عدد ندارد");
                }
                flagPas2 = !(charCheck(pas.getText(), 97, 122));
                if (flagPas2) {
                    passError.setText("رمز حرف کوچک انگلیسی ندارد");
                }
                flagPas3 = !(charCheck(pas.getText(), 65, 90));
                if (flagPas3) {
                    passError.setText("رمز حرف بزرگ انگلیسی ندارد");
                }
                flagPas4 = !(charCheck(pas.getText(), 33, 38));
                if (flagPas4) {
                    passError.setText("رمز کاراکتر خاص ندارد ندارد");
                }
                if (flagPas4 || flagPas3 || flagPas2 || flagPas1) {
                    passFlag = false;
                }
            }
            //rePassFlagg
            if(Tpas.getText().isEmpty()){
                rePassFlag = false;
                tPassError.setText("فیلد خالی است");
            }
            if (rePassFlag&&!(pas.getText().equals(Tpas.getText()))) {
                tPassError.setText("رمز ها یکی نیستن");
                rePassFlag = false;
            }
            //nameFlag
            if(name.getText().isEmpty()){
                nameFlag=false;
                nameError.setText("فیلد خالی است");
            }
            else {
                nameFlag = !((charCheckOut(name.getText(), 1740, 1570) && !charCheck(name.getText(), 32, 32)));
                if (!nameFlag) {
                    nameError.setText("نام فقط باید حروف فارسی باشد");
                }
            }
            //lNameFlag
            if(Lname.getText().isEmpty()){
                lNameFlag=false;
                lNameError.setText("فیلد خالی است");
            }
            else {
                lNameFlag = !((charCheckOut(Lname.getText(), 1740, 1570) && !charCheck(Lname.getText(), 32, 32)));
                if (!lNameFlag) {
                    lNameError.setText("نام خوانوادگی فقط باید حروف فارسی باشد");
                }
            }
            //idFlag
            if(ID.getText().isEmpty()){
                idFlag=false;
                idError.setText("فیلد خالی است");
            }
            else {
                idFlag = !(charCheckOut(ID.getText(), 57, 48));
                if (!idFlag) {
                    idError.setText("کد ملی فقط باید عدد باشد");
                }
                else if(ID.getText().length()!=10){
                    idFlag=false;
                    idError.setText("شماره فقط باید 10 رقم باشد");

                }
            }
            //birthFlag
            if (DOB.getText().isEmpty()) {
                birthFlag = false;
                dobError.setText("فیلد خالی است");
            }
            if(birthFlag&&DOB.getText().length()!=10){
                birthFlag = false;
                dobError.setText("غیر قابل قبول");
            }
            if(birthFlag&&(charCheckOut(DOB.getText(), 57, 47) || DOB.getText().charAt(4) != '/' || DOB.getText().charAt(7) != '/')){
                dobError.setText("تاریخ تولد فقط باید عدد و / باشد");
                birthFlag=false;
            }
            //phoneFlag
            if(num.getText().isEmpty()){
                phoneFlag=false;
                phoneError.setText("فیلد خالی است");
            }
            else {
                phoneFlag = !(charCheckOut(num.getText(), 57, 48));
                if (!phoneFlag) {
                    phoneError.setText("شماره فقط باید عدد باشد");
                }
                else if(num.getText().length()!=11){
                    phoneFlag=false;
                    phoneError.setText("شماره فقط باید 11 رقم باشد");

                }
            }
            //addFlag
            if (ADD.getText().isEmpty()) {
                addFlag = false;
                addError.setText("ادرس داده نشد");
            }
            for (int i = 0; addFlag && i < ADD.getText().length(); i++) {
                if (ADD.getText().charAt(i) == ':') {
                    addFlag = false;
                    addError.setText("از کاراکتر های غیر مجاز در ادرس استفاده نکنید");
                }
            }
            //
            if (userFlag && passFlag && rePassFlag && nameFlag && lNameFlag && addFlag && idFlag && phoneFlag && birthFlag) {
                userCheck.mkdir();
                acInfo.createNewFile();
                File pLog=new File(".\\userInfo\\"+user.getText()+"\\pLog.txt");
                pLog.createNewFile();
                PrintWriter pLogger = new PrintWriter(new BufferedOutputStream(new FileOutputStream(".\\userInfo\\"+user.getText()+"\\pLog.txt",true)));
                pLogger.println("(" + LocalDateTime.now() + "):" + user.getText() + "ثبت نام با موفقیت انجام شد با اطلاعات:");
                pLogger.close();
                adder = new PrintWriter(new BufferedOutputStream(new FileOutputStream(".\\userInfo\\"+user.getText()+"\\acInfo.txt", true)));
                adder.println("username:" + user.getText() + "\npassword:" + pas.getText() + "\nid:" + ID.getText() + "\ndate of birth:" + DOB.getText() + "\naddress:" + ADD.getText() + "\nphone number:" + num.getText() + "\nname:" + name.getText() + "\nlast name:" + Lname.getText()+"\nadministrator:false\nbalance:0");
                adder.close();
                systemFile.print("username:"+user.getText()+"\nadministrator:false");
                systemFile.close();
                bob = "ثبت نام با موفقیت انجام شد با اطلاعات:" + "[" + user.getText() + "," + pas.getText() + "," + ID.getText() + "," + DOB.getText() + "," + ADD.getText() + "," + num.getText() + "," + name.getText() + "," + Lname.getText() + "]";
                Parent sign = FXMLLoader.load(getClass().getResource("root2.fxml"));
                Scene scene = new Scene(sign, 1280, 720);
                scene.getStylesheets().add(getClass().getResource("app2.css").toExternalForm());
                Stage sign1 = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                sign1.setScene(scene);
                sign1.show();
            }
            else{
                label.setText("خطا در ثبت نام");
                bob="خطا در ثبت نام";
            }
            loger.println("(" + LocalDateTime.now() + "):" + user.getText() + ":\"" + bob + "\"");
            loger.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("error in file finding");
            loger.println("(" + LocalDateTime.now() + "):\"" + e.getMessage() + "\"in SingC.java");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("error");
            loger.println("(" + LocalDateTime.now() + "):\"" + e.getMessage() + "\"in SingC.java");
        }
    }

    private boolean charCheck(String a, int b, int c) {
        boolean an = false;
        for (int i = 0; (!an) && i < a.length(); i++) {
            if ((int) a.charAt(i) >= b && (int) a.charAt(i) <= c) {
                an = true;
            }
        }
        return an;
    }

    private boolean charCheckOut(String a, int b, int c) {
        boolean an = false;
        for (int i = 0; (!an) && i < a.length(); i++) {
            if ((int) a.charAt(i) > b || (int) a.charAt(i) < c) {
                an = true;
            }
        }
        return an;
    }

    @FXML
    private void back(ActionEvent actionEvent) {
        try {
            Parent back1 = FXMLLoader.load(getClass().getResource("loginJ.fxml"));
            Scene scene = new Scene(back1, 1280 ,720);
//            scene.getStylesheets().add(getClass().getResource(".css").toExternalForm());
            Stage back2 = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
            back2.setScene(scene);
            back2.show();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}