//Class		CSE1322L
//Teacher	Peter Adeojo
//Student	Ronnin Collins
package RestaurantFX;

import RestaurantFX.backend.Controller;
import RestaurantFX.frontend.HomePage;
import RestaurantFX.frontend.LoginPage;
import RestaurantFX.frontend.MenuPage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import static RestaurantFX.backend.Controller.getString;

public class Restaurant extends javafx.application.Application {

    public static void main(String[] args) {
        launch();
        Controller.LoadSettings();
        new HomePage();
        getString();
        new MenuPage();
        new LoginPage();
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
