/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplecalculator;

import simplecalculator.OtherClasses.Complex;
import Validator.NumberValidator;
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
public class ComplexMultiplicationController implements Initializable {

    @FXML
    private TextField R1;
    @FXML
    private TextField I1;
    @FXML
    private TextField R2;
    @FXML
    private TextField I2;
    @FXML
    private TextField Output;
    @FXML
    private Button Calculate;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void HandleCalculate(ActionEvent event) {
         /*
            number validator is used so that number format exception is not thrown incase user
            inputs invalid inputs which can not be parsed to double or any field is empty
        */
        if (NumberValidator.NumberValidityChecker(R1.getText())
                && NumberValidator.NumberValidityChecker(R2.getText())
                && NumberValidator.NumberValidityChecker(I1.getText())
                && NumberValidator.NumberValidityChecker(I2.getText())) {
            Output.setText(
                    Complex.multiplyComplex(
                            new Complex(Double.parseDouble(R1.getText()),
                                    Double.parseDouble(I1.getText())),
                            new Complex(Double.parseDouble(R2.getText()),
                                    Double.parseDouble(I2.getText()))
                    ).toString()
            );
        } else {
            Output.setText("Invalid or Incomplete Inputs");
        }
    }

}
