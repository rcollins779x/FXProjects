package EightPuzzle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.text.Font;

import java.net.URL;
import java.util.Arrays;
import java.util.Random;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private MenuItem NewGame;
    @FXML
    private Astar solver;
    @FXML
    private Button b0 = new Button(), b1 = new Button(), b2 = new Button(), b3 = new Button(), b4 = new Button(), b5 = new Button(), b6 = new Button(), b7 = new Button(), b8 = new Button();
    @FXML
    private Label status;
    Button[][] buttons;
    int[][] array = new int[][]{{0,1,2},{3,4,5},{6,7,8}};
    private final int size = array.length;
    String solved;
    int empty = 8;
    boolean viewSolver = false;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        buttons = new Button[][]{{b0, b1, b2}, {b3, b4, b5}, {b6, b7, b8}};
        setupButton();
    }

    private void setupButton() {
        status.setText("");
        for (int i = 0; i < buttons.length; i++)
            for (int j = 0; j < buttons[i].length; j++) {
                buttons[i][j].setFont(new Font(25));
                buttons[i][j].setText(array[i][j] == 0 ? "" : "" + array[i][j]);
                buttons[i][j].setDisable(array[i][j] == 0);
                buttons[i][j].setMinHeight(100);
                buttons[i][j].setMaxHeight(100);
                buttons[i][j].setMinWidth(100);
                buttons[i][j].setMaxWidth(100);
                status.setText(status.getText() + array[i][j]);
            }
    }

    public void NewGame(ActionEvent actionEvent) {
        System.out.println(actionEvent);
        Random rand = new Random();
        for (int i = 0, x1, x2, y1, y2; i < 10; i++) {    //swap buttons 1000 times
            int swap = array[x1 = rand.nextInt(3)][y1 = rand.nextInt(3)];
            System.out.print("Swap: array[" + x1 + "][" + y1 + "] " + array[x1][y1]);
            array[x1][y1] = array[x2 = rand.nextInt(3)][y2 = rand.nextInt(3)];
            System.out.println(" with array[" + x2 + "][" + y2 + "] " + array[x2][y2]);
            array[x2][y2] = swap;
        }
        setupButton();
    }
}
