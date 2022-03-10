package RestaurantFX;

import RestaurantFX.frontend.HomePage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Scanner;

import static RestaurantFX.backend.CartController.*;
import static RestaurantFX.backend.MenuController.*;
import static RestaurantFX.backend.LoginController.*;

public class Restaurant extends javafx.application.Application {

    public static void main(String[] args) {
        launch();
        LoadSettings();
        LoadCart();
        LoadMenu();
        new HomePage();

        for (int choice = -1; choice != 0; ) {
            System.out.println("0. Exit\n1. Menu\n2. Login\n3. Place an Order\n4. View Cart\n5. Vew Order");

            switch (choice = getInt()) {
                case 1 -> DisplayMenu();
                case 2 -> LoadLoginPage();
                case 3 -> OrderEntryPage();
                case 4 -> DisplayCart();
                case 5 -> DisplayOrder();
            }
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
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

    public static String getString() {
        Scanner scan = new Scanner(System.in);
        return scan.next();
    }

    public static int getInt() {
        Scanner scan = new Scanner(System.in);
        return scan.nextInt();
    }
}
