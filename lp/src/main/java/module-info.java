module racobafoda.lp1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.base;
    requires javafx.graphics;

    opens racobafoda.lp1 to javafx.fxml;
    exports racobafoda.lp1;
}
