module com.example.grand_shop_auto_v2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.grand_shop_auto_v2 to javafx.fxml;
    exports com.example.grand_shop_auto_v2;
}