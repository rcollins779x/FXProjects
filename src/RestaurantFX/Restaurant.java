package RestaurantFX;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import static RestaurantFX.backend.LoadController.*;

public class Restaurant extends javafx.application.Application {

    public static void main(String[] args) {
        launch();
        LoadSettings();
        LoadHomePage();
        System.out.println("0. Exit\n1. Menu\n2. Login");
        int choice = getInt();
        switch (choice) {
            case 1 -> LoadMenu();
            case 2 -> LoadLoginPage();
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("restaurant.fxml"));
        //loader.setController(new Controller());
        Scene scene = new Scene(loader.load());
        primaryStage.setTitle("TicTacToe");
        primaryStage.setWidth(300);
        primaryStage.setHeight(400);
        primaryStage.setMinWidth(300);
        primaryStage.setMinHeight(400);
        primaryStage.setMaxWidth(300);
        primaryStage.setMaxHeight(400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
