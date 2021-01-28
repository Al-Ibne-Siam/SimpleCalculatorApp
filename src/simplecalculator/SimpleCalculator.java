package simplecalculator;

import simplecalculator.Serialiazation.SerializeCalculations;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class SimpleCalculator extends Application {
    //Launches the Calculator
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("SimpleCalculator.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("AIS Calculator");
        stage.getIcons().add(new Image(SimpleCalculator.class.getResourceAsStream("CalculatorIcon.png")));
        stage.show();
    }

    public static void main(String[] args) throws IOException, FileNotFoundException, URISyntaxException {
        launch(args);
        SerializeCalculations.Serialize(SimpleCalculatorController.objects);
        //Serializes the arraylist when the calculator is closed so that any changes made to the observable
        //array list is saved
    }

}
