package EightPuzzle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Font;

import java.net.URL;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    Button[][] buttons;
    @FXML
    private Button b0 = new Button(), b1 = new Button(), b2 = new Button(), b3 = new Button(), b4 = new Button(), b5 = new Button(), b6 = new Button(), b7 = new Button(), b8 = new Button();
    @FXML
    private Label status;
    int[][] array = new int[][]{{0, 1, 2}, {3, 4, 5}, {6, 7, 8}};
    int x0 = 0, y0 = 0;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        buttons = new Button[][]{{b0, b1, b2}, {b3, b4, b5}, {b6, b7, b8}};

        for (Button[] value : buttons)
            for (Button button : value) {
                button.setFont(new Font(25));
                button.setMinHeight(100);
                button.setMaxHeight(100);
                button.setMinWidth(100);
                button.setMaxWidth(100);
                button.setOnMouseClicked(mouseEvent -> swap(button));   //assigns event to click
            }
        setupButton();
    }

    private void setupButton() {
        status.setText("");                                     //updates status bar
        for (int i = 0; i < buttons.length; i++)
            for (int j = 0; j < buttons[i].length; j++) {
                status.setText(status.getText() + array[i][j]); //builds new status bar
                buttons[i][j].setText(array[i][j] == 0 ? "" : "" + array[i][j]);
                buttons[i][j].setDisable((Math.abs(x0 - i) != 1 || y0 != j) && (Math.abs(y0 - j) != 1 || x0 != i));
            }                                                   //sets Enable based on 0 location
    }

    private void swap(Button button) {
        int num = Integer.parseInt(button.getText());   //gets num from button

        for (int i = 0, k = 0; i < array.length; i++)
            for (int j = 0; j < array[i].length && k == 0; j++)
                if (array[i][j] == num) {               //finds location of num
                    array[x0][y0] = array[i][j];        //swaps num with 0
                    k = 1 + (array[x0 = i][y0 = j] = 0);//sets counter to 1|updates 0 location
                }
        setupButton();
    }

    public void NewGame() {
        Random rand = new Random();

        for (int i = 0, x1, x2, y1, y2; i < 20; i++) {    //swap buttons 20 times
            int swap = array[x1 = rand.nextInt(3)][y1 = rand.nextInt(3)];
            array[x1][y1] = array[x2 = rand.nextInt(3)][y2 = rand.nextInt(3)];
            array[x2][y2] = swap;
        }
        for (int i = 0; i < array.length; i++)
            for (int j = 0; j < array[i].length; j++)
                if (array[i][j] == 0) {                  //identifies where 0 is located
                    x0 = i;
                    y0 = j;
                }
        setupButton();                                  //updates GUI
    }

    public void Astar() {
        int[][] current, solved = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 0}};
        int cost, steps;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

    }
}
