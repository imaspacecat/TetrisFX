module com.dubiner.tetrisfx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.dubiner.tetrisfx to javafx.fxml;
    exports com.dubiner.tetrisfx;
    exports com.dubiner.tetrisfx.tetrominos;
    opens com.dubiner.tetrisfx.tetrominos to javafx.fxml;
}