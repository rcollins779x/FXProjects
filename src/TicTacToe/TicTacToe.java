//Class		CSE1322L
//Teacher	Peter Adeojo
//Student	Ronnin Collins
package TicTacToe;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TicTacToe extends Application {

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("TTT.fxml"));
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
