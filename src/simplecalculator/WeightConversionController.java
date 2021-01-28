/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplecalculator;

import Validator.NumberValidator;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Siam
 */
public class WeightConversionController implements Initializable {
    
    @FXML
    private TextField kg = new TextField();
    
    @FXML
    private TextField lbs = new TextField();
    @FXML
    private Label warning;
    
    /*
        For conversion, two listener objects is used, so it is bi-directional.
        Any changes made in taka will change the dollar value and vice versa
        Validator is used to make sure that the user input can be parsed to double
        x%(int)x==0 ensures that if the user is in the integer phase, it stays in the integer phase
        and no decimal pops up all of a sudden
     */

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) throws NumberFormatException, IllegalArgumentException {
        
        kg.textProperty().addListener((ObservableValue<? extends String> obs, String oldText, String newText) -> {
            if ((!kg.getText().equals("")) && NumberValidator.NumberValidityChecker(kg.getText())) {
                double x = Double.parseDouble(kg.getText()) * 2.2;
                if (x % (int) x == 0||x==0) {
                    lbs.setText("" + (int) x);
                } else {
                    lbs.setText("" + x);
                }
                warning.setText("");
            } else if ((kg.getText().equals(""))) {
                lbs.setText("");
                warning.setText("");
            } else {
                warning.setText("Invalid Input");
            }
        });
        
        lbs.textProperty().addListener((ObservableValue<? extends String> obs, String oldText, String newText) -> {
            if ((!lbs.getText().equals("")) && NumberValidator.NumberValidityChecker(lbs.getText())) {
                double x = Double.parseDouble(lbs.getText()) / 2.2;
                if (x % (int) x == 0||x==0) {
                    kg.setText((int) x + "");
                } else {
                    kg.setText(x + "");
                }
                warning.setText("");
            } else if ((lbs.getText().equals(""))) {
                kg.setText("");
                warning.setText("");
            } else {
                warning.setText("Invalid Input");
            }
        });
        
    }
    
}
