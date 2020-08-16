package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Controller {

    StringBuilder exp = new StringBuilder();
    Calculator calc = Calculator.getInstance();

    @FXML
    private Label myLabel;

    @FXML
    private void checkButton(ActionEvent e){
        Button sourceButton = (Button) e.getSource();
        String expression = sourceButton.getText();
        if(expression.equals("CL")){
            exp.replace(0,exp.length()," ");
            setResult(exp);
            return;
        }else if(expression.equals("=")){
            finalResult();
            return;
        }
        exp.append(expression);
        setResult(exp);
    }

    private void finalResult() {
        System.out.println(exp);
        if (exp.toString().contains(" ")) {
            exp.delete(0, 1);
        }
        if (exp.toString().contains("-")) {
            myLabel.setText(Float.toString(calc.showResult(exp.toString(), "\\-")));
        } else if (exp.toString().contains("/")) {
            myLabel.setText(Float.toString(calc.showResult(exp.toString(), "/")));
        } else if (exp.toString().contains("*")) {
            myLabel.setText(Float.toString(calc.showResult(exp.toString(), "\\*")));
        } else if (exp.toString().contains("+")) {
            myLabel.setText(Float.toString(calc.showResult(exp.toString(), "\\+")));
        } else {
            System.out.println("loh");
        }
        exp.replace(0, exp.length(), " ");
    }

    private void setResult(StringBuilder exp){
        myLabel.setText(exp.toString());
    }

}
