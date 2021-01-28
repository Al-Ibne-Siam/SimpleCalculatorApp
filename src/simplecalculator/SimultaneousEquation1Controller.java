package simplecalculator;

import simplecalculator.OtherClasses.Equation;
import Validator.NumberValidator;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.EmptyStackException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class SimultaneousEquation1Controller implements Initializable {

    @FXML
    private TextField SE1x1;
    @FXML
    private TextField SE1y1;
    @FXML
    private TextField SE1Constant1;
    @FXML
    private TextField SE1x2;
    @FXML
    private TextField SE1y2;
    @FXML
    private TextField SE1Constant2;
    @FXML
    private TextField SE1Display;
    @FXML
    private Button CalculateSE1;

    private double a, b, c, d, e, f;
    
    /*
            number validator is used so that number format exception is not thrown incase user
            inputs invalid inputs which can not be parsed to double or any field is empty
        */

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    @FXML
    private void CalculateSE1(ActionEvent event) throws InvocationTargetException {

        if (NumberValidator.NumberValidityChecker(SE1x1.getText())
                && NumberValidator.NumberValidityChecker(SE1y1.getText())
                && NumberValidator.NumberValidityChecker(SE1Constant1.getText())
                && NumberValidator.NumberValidityChecker(SE1x2.getText())
                && NumberValidator.NumberValidityChecker(SE1y2.getText())
                && NumberValidator.NumberValidityChecker(SE1Constant2.getText())) {
            a = Double.parseDouble(SE1x1.getText());
            b = Double.parseDouble(SE1y1.getText());
            c = Double.parseDouble(SE1Constant1.getText());
            d = Double.parseDouble(SE1x2.getText());
            e = Double.parseDouble(SE1y2.getText());
            f = Double.parseDouble(SE1Constant2.getText());
            SE1Display.setText(Equation.DoubleVariable(a, b, c, d, e, f));
        } else {
            SE1Display.setText("Invalid or Incomplete Inputs");
        }
    }
}
