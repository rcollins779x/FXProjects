package Lab8;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {
    @FXML private TextField value1, value2;
    @FXML private Label answer;

    @FXML void onActionAdd() {
        if (value1.getText().equals("")) value1.setText("0");
        if (value2.getText().equals("")) value2.setText("0");
        int temp1 = Integer.parseInt(value1.getText());
        int temp2 = Integer.parseInt(value2.getText());
        answer.setText(temp1 + " + " + temp2 + " = " + (temp1 + temp2));
    }

    @FXML void onActionClear() {
        value1.setText("");
        value2.setText("");
        answer.setText("");
    }

    @Override
    public String toString() {
        return value1.getText() + " + " + value2.getText() + " = " + answer;
    }
}