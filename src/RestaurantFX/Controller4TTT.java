//Class		CSE1322L
//Teacher	Peter Adeojo
//Student	Ronnin Collins
package RestaurantFX;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Controller4TTT implements Initializable {
    public Button reset,nw,n,ne,w,c,e,sw,s,se;
    @FXML private Label topText;
    private int playerTurn = 0;
    @FXML ArrayList<Button> buttons; //buttons are added from the fxml fx:define function

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        for (Button button : buttons) {
            setupButton(button);
            button.setFocusTraversable(false);
        }
    }

    private void setupButton(Button button) {
        button.setOnMouseClicked(mouseEvent -> {
            setPlayerSymbol(button);
            button.setDisable(true);
            checkIfGameIsOver();
        });
    }

    public void setPlayerSymbol(Button button) {
        button.setText(playerTurn++ % 2 == 0 ? "X" : "0");
    }

    public void checkIfGameIsOver() {
        for (int a = 0; a < 8; a++) {
            String line = switch (a) {
                case 0 -> buttons.get(0).getText() + buttons.get(1).getText() + buttons.get(2).getText();
                case 1 -> buttons.get(3).getText() + buttons.get(4).getText() + buttons.get(5).getText();
                case 2 -> buttons.get(6).getText() + buttons.get(7).getText() + buttons.get(8).getText();
                case 3 -> buttons.get(0).getText() + buttons.get(3).getText() + buttons.get(6).getText();
                case 4 -> buttons.get(1).getText() + buttons.get(4).getText() + buttons.get(7).getText();
                case 5 -> buttons.get(2).getText() + buttons.get(5).getText() + buttons.get(8).getText();
                case 6 -> buttons.get(0).getText() + buttons.get(4).getText() + buttons.get(8).getText();
                case 7 -> buttons.get(2).getText() + buttons.get(4).getText() + buttons.get(6).getText();
                default -> null;
            };

            if (line.equals("XXX") || line.equals("000")) topText.setText(line.equals("XXX") ? "X won!" : "O won!");
        }
    }

    @FXML
    void restartGame() {
        buttons.forEach(this::resetButton);
        topText.setText("Tic-Tac-Toe");
    }

    public void resetButton(Button button) {
        button.setDisable(false);
        button.setText("");
    }
}