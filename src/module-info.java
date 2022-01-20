module com.example.fxprojects {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires lombok;

    opens Assignment8 to javafx.fxml;
    exports Assignment8;
    opens EightPuzzle to javafx.fxml;
    exports EightPuzzle;
    opens Lab8 to javafx.fxml;
    exports Lab8;
    opens TicTacToe to javafx.fxml;
    exports TicTacToe;
    opens RestaurantFX to javafx.fxml;
    exports RestaurantFX;


}