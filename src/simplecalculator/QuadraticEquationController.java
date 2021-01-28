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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Siam
 */
public class QuadraticEquationController implements Initializable {

    @FXML
    private TextArea QuadraticDisplay;
    @FXML
    private TextField QuadA;
    @FXML
    private TextField QuadB;
    @FXML
    private TextField QuadC;
    @FXML
    private Button CalculateQuad;

    private double a, b, c;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }
    
    /*
            number validator is used so that number format exception is not thrown incase user
            inputs invalid inputs which can not be parsed to double or any field is empty
        */

    @FXML
    private void HandleCalculateQuad(ActionEvent event) throws InvocationTargetException {
        if (NumberValidator.NumberValidityChecker(QuadA.getText())
                && NumberValidator.NumberValidityChecker(QuadB.getText())
                && NumberValidator.NumberValidityChecker(QuadC.getText())) {
            a = Double.parseDouble(QuadA.getText());
            b = Double.parseDouble(QuadB.getText());
            c = Double.parseDouble(QuadC.getText());
            QuadraticDisplay.setText(Equation.quadratic(a, b, c));
        } else {
            QuadraticDisplay.setText("Incomplete or Invalid Inputs");
        }
    }
}
