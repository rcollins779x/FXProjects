//Class		CSE1322L
//Teacher	Peter Adeojo
//Student	Ronnin Collins
package Assignment8;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MegaCalc extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader fxm = new FXMLLoader(getClass().getResource("MegaCalc.fxml"));
        //fxm.setController(new Controller());
        Scene scene = new Scene(fxm.load());
        primaryStage.setTitle("MegaCalc");
        primaryStage.setWidth(300);
        primaryStage.setHeight(400);
        primaryStage.setMinWidth(200);
        primaryStage.setMinHeight(350);
        primaryStage.setMaxWidth(400);
        primaryStage.setMaxHeight(700);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
