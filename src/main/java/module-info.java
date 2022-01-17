module com.dubiner.tetrisfx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.dubiner.tetrisfx to javafx.fxml;
    exports com.dubiner.tetrisfx;
}