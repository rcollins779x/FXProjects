package EightPuzzle;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class EightPuzzle extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(EightPuzzle.class.getResource("EightPuzzle.fxml"));
        stage.setScene(new Scene(fxmlLoader.load(), 315, 375));
        stage.setTitle("8 Puzzle");

        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}