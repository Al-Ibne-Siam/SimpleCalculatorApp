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
public class DistanceConversionController implements Initializable {

    @FXML
    private TextField km = new TextField();
    @FXML
    private TextField miles = new TextField();
    @FXML
    private Label warning;

    /**
     * Initializes the controller class.
     */
    
    /*
        For conversion, two listener objects is used, so it is bi-directional.
        Any changes made in taka will change the dollar value and vice versa
        Validator is used to make sure that the user input can be parsed to double
        x%(int)x==0 ensures that if the user is in the integer phase, it stays in the integer phase
        and no decimal pops up all of a sudden
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) throws NumberFormatException {
        km.textProperty().addListener((ObservableValue<? extends String> obs, String oldText, String newText) -> {
            if ((!km.getText().equals("")) && NumberValidator.NumberValidityChecker(km.getText())) {
                double x = Double.parseDouble(km.getText()) * 0.62;
                if (x % (int) x == 0 || x == 0) {
                    miles.setText((int) x + "");
                } else {
                    miles.setText("" + x);
                }
                warning.setText("");
            } else if ((km.getText().equals(""))) {
                miles.setText("");
                warning.setText("");
            } else {
                warning.setText("Invalid Input");
            }
        });

        miles.textProperty().addListener((ObservableValue<? extends String> obs, String oldText, String newText) -> {
            if ((!miles.getText().equals("")) && NumberValidator.NumberValidityChecker(miles.getText())) {
                double x = Double.parseDouble(miles.getText()) / 0.62;
                if (x % (int) x == 0 || x == 0) {
                    km.setText("" + (int) x);
                } else {
                    km.setText(x + "");
                }
                warning.setText("");
            } else if ((miles.getText().equals(""))) {
                km.setText("");
                warning.setText("");
            } else {
                warning.setText("Invalid Input");
            }
        });
    }

}
