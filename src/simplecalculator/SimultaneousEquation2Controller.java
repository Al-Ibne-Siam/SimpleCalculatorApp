/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplecalculator;

import simplecalculator.OtherClasses.Equation;
import Validator.NumberValidator;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Siam
 */
public class SimultaneousEquation2Controller implements Initializable {

    @FXML
    private TextField SE2x1;
    @FXML
    private TextField SE2y1;
    @FXML
    private TextField SE2z1;
    @FXML
    private TextField SE2Constant1;
    @FXML
    private TextField SE2x2;
    @FXML
    private TextField SE2y2;
    @FXML
    private TextField SE2z2;
    @FXML
    private TextField SE2Constant2;
    @FXML
    private TextField SE2Display;
    @FXML
    private Button CalculateSE2;
    @FXML
    private TextField SE2x3;
    @FXML
    private TextField SE2y3;
    @FXML
    private TextField SE2z3;
    @FXML
    private TextField SE2Constant3;

    private double a, b, c, d, e, f, g, h, i, j, k, l;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }
    
    /*
            number validator is used so that number format exception is not thrown incase user
            inputs invalid inputs which can not be parsed to double or any field is empty
        */

    @FXML
    private void CalculateSE12(ActionEvent event) throws InvocationTargetException {
        if (NumberValidator.NumberValidityChecker(SE2x1.getText())
                && NumberValidator.NumberValidityChecker(SE2x2.getText())
                && NumberValidator.NumberValidityChecker(SE2x3.getText())
                && NumberValidator.NumberValidityChecker(SE2y1.getText())
                && NumberValidator.NumberValidityChecker(SE2y2.getText())
                && NumberValidator.NumberValidityChecker(SE2y3.getText())
                && NumberValidator.NumberValidityChecker(SE2z1.getText())
                && NumberValidator.NumberValidityChecker(SE2z2.getText())
                && NumberValidator.NumberValidityChecker(SE2z3.getText())
                && NumberValidator.NumberValidityChecker(SE2Constant1.getText())
                && NumberValidator.NumberValidityChecker(SE2Constant2.getText())
                && NumberValidator.NumberValidityChecker(SE2Constant3.getText())) {
            a = Double.parseDouble(SE2x1.getText());
            b = Double.parseDouble(SE2y1.getText());
            c = Double.parseDouble(SE2z1.getText());
            d = Double.parseDouble(SE2Constant1.getText());
            e = Double.parseDouble(SE2x2.getText());
            f = Double.parseDouble(SE2y2.getText());
            g = Double.parseDouble(SE2z2.getText());
            h = Double.parseDouble(SE2Constant2.getText());
            i = Double.parseDouble(SE2x3.getText());
            j = Double.parseDouble(SE2y3.getText());
            k = Double.parseDouble(SE2z3.getText());
            l = Double.parseDouble(SE2Constant3.getText());
            SE2Display.setText(Equation.TripleVariable(a, b, c, d, e, f, g, h, i, j, k, l));
            System.out.println(Equation.TripleVariable(a, b, c, d, e, f, g, h, i, j, k, l));
        } else {
            SE2Display.setText("Invalid or Incomplete Inputs");
        }
    }
}
