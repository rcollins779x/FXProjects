package Lab8;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class SimpleCalc extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader fxm = new FXMLLoader(getClass().getResource("SimpleCalc.fxml"));
        Scene scene = new Scene(fxm.load());
        primaryStage.setTitle("SimpleCalc");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    static void main(String[] args) {
        launch();
    }
}