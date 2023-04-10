module com.danke.xtendedsurvival {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;


    opens com.danke.xtendedsurvival to javafx.fxml;
    exports com.danke.xtendedsurvival;
}