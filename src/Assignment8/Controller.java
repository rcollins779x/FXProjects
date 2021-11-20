//Class		CSE1322L
//Teacher	Peter Adeojo
//Student	Ronnin Collins
package Assignment8;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller {
    @FXML private Button negative;
    @FXML private Label total;
    @FXML private Label formula;
    @FXML private String value = "";
    private double num = 0;
    private double lastResult = 0;
    private double result = Double.MAX_VALUE;
    private double operator = 0;
    private int sign = 1;

/*    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }*/

    private void button (String text) {         //Logic for all numerical button press
        if(operator == 5) operator = 0;
        if(value.equals("") && sign == -1) {
            value = "-" + value;
            sign = 1;
            formula.setText(formula.getText()+"-");
            System.out.print("-");
        }
        value += text;
        formula.setText(formula.getText()+text);
        System.out.print(text);
    }
    @FXML private void onActionButtonDot() {    //Logic for when and how to use the decimal
        if(operator == 5) operator = 0;
        String text = ".";
        if (value.equals("")) text = "0.";
        value += text;
        formula.setText(formula.getText()+text);
        System.out.print(text);
    }
    @FXML private void onActionSignal() {       //Logic for Positive and Negative modifier
        if(value.equals(""))
            if(sign == 1) {
                sign = -1;
                negative.setText("Neg");
            } else {
                sign = 1;
                negative.setText("Pos");
            }
    }

    @FXML private void onActionButtonClear() {        //Logic for Clear button
        result = Double.MAX_VALUE;
        num = 0;
        value = "";
        operator = 0;
        formula.setText("");
        total.setText("");
        System.out.println();
        negative.setText("+/-");
        sign = 1;
    }

    @FXML private void onActionButton0() {
        button("0");
    }
    @FXML private void onActionButton1() {
        button("1");
    }
    @FXML private void onActionButton2() {
        button("2");
    }
    @FXML private void onActionButton3() {
        button("3");
    }
    @FXML private void onActionButton4() {
        button("4");
    }
    @FXML private void onActionButton5() {
        button("5");
    }
    @FXML private void onActionButton6() {
        button("6");
    }
    @FXML private void onActionButton7() {
        button("7");
    }
    @FXML private void onActionButton8() {
        button("8");
    }
    @FXML private void onActionButton9() {
        button("9");
    }

    @FXML private void onActionButtonAdd() {
        operator(" + ",1);
    }
    @FXML private void onActionButtonSubtract() {
        operator(" - ",2);
    }
    @FXML private void onActionButtonMultiply() {
        operator(" * ",3);
    }
    @FXML private void onActionButtonDivide() {
        operator(" / ",4);
    }
    @FXML private void onActionButtonEqual() {
        operator(" is ",5);
    }

    private void operator (String text, int op) {
        negative.setText("+/-");    //Reset of Positive Negative Button Label
        if(op == 5)                 //If equals button was just pressed...
            if(result == Double.MAX_VALUE) {
                formula.setText("");
            }
        if(operator == 5) {         //If the operation requires the last answer
            value = lastResult + "";
            formula.setText(""+round(3, Double.parseDouble(value)));
            System.out.print(round(3, Double.parseDouble(value)));
        } else {
            if (value.equals("")) return;
        }
        num = Double.parseDouble(value);    //Stores number as Int for calculation
        if(result == Double.MAX_VALUE) result = num;
        if(operator == 1) result += num;
        if(operator == 2) result -= num;
        if(operator == 3) result *= num;
        if(operator == 4) result /= num;

        formula.setText(formula.getText() + text);
        if(op == 5) text = " = ";
        System.out.print(text);
        if(op == 5) {                       //If equals button was just pressed...
            total.setText(formula.getText() + round(8,result));
            System.out.println(round(8,result));
            formula.setText("");
            lastResult = result;
            result = Double.MAX_VALUE;
        }
        else total.setText(String.valueOf(round(8,result)));
        value = "";
        operator = op;
    }
    //Aesthetic format/rounding changes
    private double round (int places, double value) {
        String temp1 = Double.toString(Math.abs(value));
        int decimal = temp1.length() - 1 - temp1.indexOf('.');
        double temp2 = ((decimal > places) ? Double.parseDouble(String.format("%."+places+"f", value)) : value);

        return (((temp2*10)%10) == 0) ? (int)temp2: temp2;
    }
}