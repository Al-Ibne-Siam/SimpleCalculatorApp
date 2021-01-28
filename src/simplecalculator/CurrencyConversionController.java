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
public class CurrencyConversionController implements Initializable {

    @FXML
    private TextField taka = new TextField();
    @FXML
    private TextField dollar = new TextField();
    @FXML
    private Label warning;

    /*
        For conversion, two listener objects is used, so it is bi-directional.
        Any changes made in taka will change the dollar value and vice versa
        Validator is used to make sure that the user input can be parsed to double
        x%(int)x==0 ensures that if the user is in the integer phase, it stays in the integer phase
        and no decimal pops up all of a sudden
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        dollar.textProperty().addListener((ObservableValue<? extends String> obs, String oldText, String newText) -> {
            if ((!dollar.getText().equals("")) && NumberValidator.NumberValidityChecker(dollar.getText())) {
                double x = Double.parseDouble(dollar.getText()) * 85;
                if (x % (int) x == 0 || x == 0) {
                    taka.setText((int) x + "");
                } else {
                    taka.setText(x + "");
                }
                warning.setText("");
            } else if ((dollar.getText().equals(""))) {
                taka.setText("");
                warning.setText("");
            } else {
                warning.setText("Invalid Input");
            }
        });

        taka.textProperty().addListener((ObservableValue<? extends String> obs, String oldText, String newText) -> {
            if ((!taka.getText().equals("")) && NumberValidator.NumberValidityChecker(taka.getText())) {
                double x = Double.parseDouble(taka.getText()) / 85;
                if (x % (int) x == 0 || x == 0) {
                    dollar.setText((int) x + "");
                } else {
                    dollar.setText(x + "");
                }
                warning.setText("");
            } else if ((taka.getText().equals(""))) {
                dollar.setText("");
                warning.setText("");
            } else {
                warning.setText("Invalid Input");
            }
        });
    }

}
