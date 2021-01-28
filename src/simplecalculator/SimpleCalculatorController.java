package simplecalculator;

import simplecalculator.Serialiazation.SerializeCalculations;
import simplecalculator.Operation.Operations;
import simplecalculator.OtherClasses.Fraction;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;
import jdk.nashorn.internal.objects.Global;

public class SimpleCalculatorController implements Initializable {

    public double answer = 0;
    public String totalInput = "";
    public String numInput = "";
    public String lastOperator = "";
    public Operations memory;
    public static ArrayList<Operations> objects = null;
    public static ObservableList<Operations> obl = null;
    public static boolean memoryMode = false;

    /*
    last operator is used beacuse we have to wait for the user to enter the second number before
    doing any calculation. Memory keeps the last operation in memory. Used by
    MR(Memory Recall), MS(Memory Save) and MC(Memory Clear)
    Note:.
       memoryMode is trigerred on when M+ and M- is pressed. This indicates that the result of addition
      or subtraction  calculation also needs to be updated to the memory alongside being saved.
    
    The arraylist called objects is used for serialization and deserialization
     The observable array list is used to update the history listview inside the calculator.
        They both undergo the same changes
     */
    @FXML
    private Button Reciprocal;
    @FXML
    private Button MemoryRecall;
    @FXML
    private Button Clear;
    @FXML
    private Button ClearEntry;
    @FXML
    private Button point;
    @FXML
    private Button Divide;
    @FXML
    private Button Multiply;
    @FXML
    private Button n3;
    @FXML
    private Button n2;
    @FXML
    private Button n1;
    @FXML
    private Button Subtract;
    @FXML
    private Button Add;
    @FXML
    private Button n9;
    @FXML
    private Button n5;
    @FXML
    private Button n4;
    @FXML
    private Button Percentage;
    @FXML
    private Button MemoryClear;
    @FXML
    private Button n6;
    @FXML
    private Button n8;
    @FXML
    private Button n7;
    @FXML
    private Button Backspace;
    @FXML
    private Button Root;
    @FXML
    private Button n0;
    @FXML
    private Button equal;
    @FXML
    private Button PlusMinus;
    @FXML
    private TextArea Display;
    @FXML
    private Button MemorySave;
    @FXML
    private TextArea SecondaryDisplay;
    @FXML
    private Button SE1;
    @FXML
    private Button SE2;
    @FXML
    private Button Quadratic;
    @FXML
    private Button C_Addition;
    @FXML
    private Button C_subtraction;
    @FXML
    private Button C_Multiplication;
    @FXML
    private Button C_division;
    @FXML
    private Button WeightConv;
    @FXML
    private Button DistanceConv;
    @FXML
    private Button CurrencyConv;
    @FXML
    private Button ClearHistory;
    @FXML
    private Button Squared;
    @FXML
    private ListView HistoryListView;
    @FXML
    private Button LoadHistory;
    @FXML
    private Button DeleteHistory;
    @FXML
    private Button ViewAsFraction;
    @FXML
    private Button MemoryPlus;
    @FXML
    private Button MemoryMinus;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            try {
                objects = SerializeCalculations.Deserialize();  //Reading back the Array list of operations from the bin file
            } catch (FileNotFoundException | URISyntaxException e) {
                System.out.println(e.getMessage());
            } //Handling Exceptions thrown by the Deserialize methods.
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        if (objects == null) {
            objects = new ArrayList<>();    //If bin file is empty, the object variable is initialized with an empty Array list.
        }
        obl = FXCollections.observableArrayList(objects);   //Initializing the observable Array list with the Array list of operations.
        this.HistoryListView.setItems(obl); //Setting the history to display the contents of the observable array list.
    }

    /*
    Update Display method updates the display after each click 
    SecondaryDisplay which is the upper display is meant to show the whole calculation(totalInput+output when = in clicked)
    Display which is the lower display shows recent entry(numInput) and the overall answer.
    When the calculation is completed the answer is saved inside numInput incase user wants to do further calculation.
     */
    public void updateDispaly() {
        if (numInput.equals("NaN")) {
            Display.setText(numInput + "\nNot a (Real) Number");     //Letting user know meaning of NaN
            SecondaryDisplay.setText(totalInput);
        } else {
            Display.setText(numInput);
            SecondaryDisplay.setText(totalInput);
        }
    }

    //This operator only works on answers
    @FXML
    private void ViewAsFraction(ActionEvent event) {
        if (lastOperator.equals("=") && answer != Global.Infinity && answer != Double.NaN) {
            Fraction f = new Fraction(answer);  //The fraction class is only optimized for double numbers with few decimals. Hence the warning.
            Display.setText(f.toString() + "\n\nWarning! View As Fraction May Not Work On\nNumbers With Many Decimal Places");
        } else if (answer == Global.Infinity || answer == Double.NaN) { //wont perform if the answer is infinity or NaN
            Display.setText("Invalid Operation");
        } else {    //Only the overall answer will be viewed as Fraction.
            Display.setText("Please Complete The Calculation First");
        }
    }

    //=============Number Buttons ===============
    /* 
    if (lastOperator.equals("=")) {
            HandleClearEntry(event);
        }
    clears old entry and prepares for new entry 
    if user inputs a number for new operation without clearing it first
    Applicable for number buttons and clearance buttons
    This is the working princple behind all the number, clearance and decimal buttons.
     */
    @FXML
    private void Handle1(ActionEvent event) {
        if (lastOperator.equals("=")) {
            HandleClearEntry(event);
        }
        totalInput += "1";
        numInput += "1";
        updateDispaly();
    }

    @FXML
    private void Handle2(ActionEvent event) {
        if (lastOperator.equals("=")) {
            HandleClearEntry(event);
        }
        totalInput += "2";
        numInput += "2";
        updateDispaly();
    }

    @FXML
    private void Handle3(ActionEvent event) {
        if (lastOperator.equals("=")) {
            HandleClearEntry(event);
        }
        totalInput += "3";
        numInput += "3";
        updateDispaly();
    }

    @FXML
    private void Handle4(ActionEvent event) {
        if (lastOperator.equals("=")) {
            HandleClearEntry(event);
        }
        totalInput += "4";
        numInput += "4";
        updateDispaly();
    }

    @FXML
    private void Handle5(ActionEvent event) {
        if (lastOperator.equals("=")) {
            HandleClearEntry(event);
        }
        totalInput += "5";
        numInput += "5";
        updateDispaly();
    }

    @FXML
    private void Handle6(ActionEvent event) {
        if (lastOperator.equals("=")) {
            HandleClearEntry(event);
        }
        totalInput += "6";
        numInput += "6";
        updateDispaly();
    }

    @FXML
    private void Handle7(ActionEvent event) {
        if (lastOperator.equals("=")) {
            HandleClearEntry(event);
        }
        totalInput += "7";
        numInput += "7";
        updateDispaly();
    }

    @FXML
    private void Handle8(ActionEvent event) {
        if (lastOperator.equals("=")) {
            HandleClearEntry(event);
        }
        totalInput += "8";
        numInput += "8";
        updateDispaly();
    }

    @FXML
    private void Handle9(ActionEvent event) {
        if (lastOperator.equals("=")) {
            HandleClearEntry(event);
        }
        totalInput += "9";
        numInput += "9";
        updateDispaly();
    }

    @FXML
    private void Handle0(ActionEvent event) {
        if (lastOperator.equals("=")) {
            HandleClearEntry(event);
        }
        totalInput += "0";
        numInput += "0";
        updateDispaly();
    }

    @FXML
    private void HandlePoint(ActionEvent event) {
        if (lastOperator.equals("=")) {
            HandleClearEntry(event);
        }
        if (numInput.contains(".")) {
            //Do Nothing. Prevents a number from having two decimals.
        } else {
            if (numInput.equals("") || numInput.equals("-")) {
                //Adds a zero in case user puts decimal without entering a number first
                numInput += "0";
                totalInput += "0";
            }
            totalInput += ".";
            numInput += ".";
            updateDispaly();
        }
    }

    //==========Clearance===============
    @FXML
    private void HandleBackSpace(ActionEvent event) {
        if (lastOperator.equals("=")) {
            HandleClearEntry(event);
        } else if (numInput.equals("")) {
            //do nothing
        } else {
            totalInput = totalInput.substring(0, totalInput.length() - 1);  //removes the last input from upper screen
            numInput = numInput.substring(0, numInput.length() - 1); //removes the last input from lower screen
        }
        updateDispaly();
    }

    @FXML
    private void HandleClear(ActionEvent event) {
        if (lastOperator.equals("=")) {
            HandleClearEntry(event);
        } else {
            totalInput = totalInput.substring(0, (totalInput.length() - 1) - (numInput.length() - 1));
            //removes the current number from upper screen
            numInput = ""; //Clears current number
        }
        updateDispaly();
    }

    @FXML
    private void HandleClearEntry(ActionEvent event) {
        //Prepares for a new Operation
        answer = 0;
        totalInput = "";
        numInput = "";
        lastOperator = "";
        memoryMode = false;
        updateDispaly();
    }

    //============Instant Operation===========
    /*
    These operations operate on the current number
    
    if the calculation is complete it operates on the answer i.e the whole input
    if (lastOperator.equals("=")) is used to determine if the calculation is complete or not
    
    if (numInput.equals("")) {
            Display.setText("Please Enter A Number First");
    If the current number is null and the calculation is incomplete it prompts the user to
    enter a number or complete the calculation
     */
    @FXML
    private void HandleRoot(ActionEvent event) {
        int rootcount = 0;
        for (char x : totalInput.toCharArray()) {
            if (x == '√') {
                rootcount++;
            }
        }
        for (int j = totalInput.length() - 1; j >= 0; j--) {
            if ((totalInput.toCharArray()[j] + "").equals(lastOperator)) {
                break;
            }
            if (totalInput.toCharArray()[j] == '√') {
                totalInput = totalInput.substring(0, j);
                totalInput += "√(√(" + Math.pow(Double.parseDouble(numInput), Math.pow(2, rootcount)) + "))";
                numInput = Math.sqrt(Double.parseDouble(Display.getText())) + "";
                updateDispaly();
                break;
            }
        }
        if (rootcount == 0) {
            if (numInput.equals("")) {
                Display.setText("Please Enter A Number First or Complete the Calculation");
            } else {
                if (lastOperator.equals("=")) {
                    totalInput = totalInput.substring(0, totalInput.indexOf("="));
                    totalInput = "√(" + totalInput + ")";
                    lastOperator = "";
                } else {
                    totalInput = totalInput.substring(0, (totalInput.length() - 1) - (numInput.length() - 1));
                    totalInput += "√(" + numInput + ")";
                }
                numInput = Math.sqrt(Double.parseDouble(numInput)) + "";
                updateDispaly();
            }
        }
    }

    @FXML
    private void HandleReciprocal(ActionEvent event) {
        try {
            if (numInput.equals("")) {
                Display.setText("Please Enter A Number First or Complete the Calculation");
            } else {
                if (lastOperator.equals("=")) {
                    numInput = (1 / Double.parseDouble(numInput)) + "";
                    totalInput = numInput;
                    lastOperator = "";
                } else {
                    totalInput = totalInput.substring(0, (totalInput.length() - 1) - (numInput.length() - 1));
                    numInput = (1 / Double.parseDouble(numInput)) + "";
                    totalInput += numInput;
                }
                updateDispaly();
            }
        } catch (StringIndexOutOfBoundsException e) {
            throw e;
        }
    }

    @FXML
    private void HandlePlusMinus(ActionEvent event) {
        if (numInput.equals("")) {
            Display.setText("Please Enter A Number First or Complete the Calculation");
        } else {
            if (lastOperator.equals("=")) {
                totalInput = totalInput.substring(0, totalInput.indexOf("="));
                totalInput = "-(" + totalInput + ")";
                lastOperator = "";
                numInput = Double.parseDouble(numInput) * -1.0 + "";
            } else {
                totalInput = totalInput.substring(0, (totalInput.length() - 1) - (numInput.length() - 1));
                numInput = Double.parseDouble(numInput) * -1.0 + "";
                totalInput += numInput;
            }
            updateDispaly();
        }
    }

    @FXML
    private void HandlePercentage(ActionEvent event) {
        if (numInput.equals("")) {
            Display.setText("Please Enter A Number First or Complete the Calculation");
        } else {
            if (lastOperator.equals("=")) {
                totalInput = totalInput.substring(0, totalInput.indexOf("="));
                totalInput = "(" + totalInput + ")%";
                lastOperator = "";
            } else {
                totalInput += "%";
            }
            numInput = (Double.parseDouble(numInput) / 100.0) + "";
            updateDispaly();
        }
    }

    @FXML
    private void HandleSquared(ActionEvent event) {
        if (numInput.equals("")) {
            Display.setText("Please Enter A Number First or Complete the Calculation");
        } else {
            if (lastOperator.equals("=")) {
                totalInput = totalInput.substring(0, totalInput.indexOf("="));
                totalInput = "(" + totalInput + ")^2";
                lastOperator = "";
            } else {
                totalInput += "^2";
            }
            numInput = (Math.pow(Double.parseDouble(numInput), 2)) + "";
            updateDispaly();
        }
    }

    //===============Operations=================
    public void Operate() {
        //This method does the previous calculation or completes the calculation if user presses =
        if (numInput.equals("")) {

            /*When user continues calculation without entering the number for previous calculation
            exile directs the operation to default where the operator of the new operation is removed*/
 /* Here the operator method does the previous calculation or completes 
        it and clears current number to prepare for new number*/
            lastOperator = "exile";
        }

        switch (lastOperator) {
            case "":
                answer = Double.parseDouble(numInput);
                numInput = "";
                break;

            case "+":
                answer += Double.parseDouble(numInput);
                numInput = "";
                break;

            case "-":
                answer -= Double.parseDouble(numInput);
                numInput = "";
                break;

            case "*":
                answer *= Double.parseDouble(numInput);
                numInput = "";
                break;

            case "/":
                answer /= Double.parseDouble(numInput);
                numInput = "";
                break;
            case "=":
                answer = Double.parseDouble(numInput);
                /*since numinput contains the answer of last operation
                and user wants to continue calculation further, this restores the answer of previous calculation*/
                totalInput = totalInput.substring(0, (totalInput.length() - 1) - (numInput.length() - 1) - 1);
                // This deletes "=Answer" part in case when user wants to carry the calculation further
                numInput = "";
                break;

            default:
                totalInput = totalInput.substring(0, totalInput.length() - 1);
                break;
        }

    }

    /*memorymode=false disables M+ and M- ensuring that the changes made does not affect the answer
    that has been stored in the memory
    
    Note: Operate() in every operator button does the last operation
    
    the brackets are added in multiplication and division to ensure consistency with bodmas rule.
     */
    @FXML
    private void HandleDivide(ActionEvent event) {
        memoryMode = false;
        if (!totalInput.equals("")) {   //makes sure to do nothing if there is no user input
            Operate();
            if (!lastOperator.equals("")) {
                totalInput = "(" + totalInput + ")/";
            } else {
                totalInput += "/";  //If the first operation is division, no need to add bracket
            }
            lastOperator = "/";
            updateDispaly();
        }
    }

    @FXML
    private void HandleMultiply(ActionEvent event) {
        memoryMode = false;
        if (!totalInput.equals("")) {   //makes sure to do nothing if there is no user input
            Operate();
            if (!lastOperator.equals("")) {
                totalInput = "(" + totalInput + ")x";   //If the first operation is division, no need to add bracket
            } else {
                totalInput += "x";
            }
            lastOperator = "*";
            updateDispaly();
        }
    }

    @FXML
    private void HandleSubtract(ActionEvent event) {
        memoryMode = false;
        if (numInput.equals("")) {
            numInput = "-";
            totalInput += numInput;
        } else if (numInput.equals("-")) {
            HandleBackSpace(event); //-*-=+. So if the inputs {a some operator (--b)}, it turns to {a some operator (b)}
        } else {
            Operate();
            lastOperator = "-";
            totalInput += "-";
        }
        updateDispaly();
    }

    @FXML
    private void HandleAdd(ActionEvent event) {
        memoryMode = false;
        if (!totalInput.equals("")) {
            Operate();
            lastOperator = "+";
            totalInput += "+";
            updateDispaly();
        }
    }

    @FXML
    private void HandleEqual(ActionEvent event) throws IOException {
        if (!totalInput.equals("")) {
            Operate();
            if (answer % (int) answer == 0) {
                totalInput = totalInput + "=" + (int) answer;   //Outputs integer instead of double if the answer is integer
                numInput = (int) answer + "";
            } else {
                totalInput = totalInput + "=" + answer;
                numInput = answer + "";
            }
            lastOperator = "=";
            addDataToHistory();
            if (memoryMode) {   //When M+ and M- is used, the new answer is saved in memory
                HandleMemorySave(event);
                totalInput = memory.getUserInput() + "=" + memory.getAnswer();
                numInput = memory.getAnswer();  //These two steps are necessary as memorysave event clears
                //the primary and secondary display. So it needs to be restored.
            }
            updateDispaly();
        }
    }

    //=================Handle History & Memory===============
    public void addDataToHistory() {
        Operations op = new Operations(
                totalInput.substring(0, totalInput.indexOf("=")), //userinput,exluding = sign
                totalInput.substring(totalInput.indexOf("=") + 1), //answer
                java.time.LocalDateTime.now());     //time and date of the operation being performed
        objects.add(op);    //Adding objects to array list
        obl.add(op);    //Adding objects to list view
    }

    @FXML
    private void HandleLoadHistory(ActionEvent event) {
        int selection = HistoryListView.getSelectionModel().getSelectedIndex(); //takes user selection
        if (selection != -1) {  //Ensures nothing is loaded if no selection is made
            if (lastOperator.equals("=") || lastOperator.equals("")) {
                HandleClearEntry(event);    //Incase user loads an operation in the middle of another operation, 
                //the previous calculation is removed.
                Operations op = (Operations) HistoryListView.getItems().get(selection);
                totalInput = op.getUserInput() + "=" + op.getAnswer();
                numInput = op.getAnswer();
                answer = Double.parseDouble(numInput);
                lastOperator = "=";
                //loads back the operation
            } else {
                //Incase user wants to the loaded operation as an extension of previous operation
                Operations op = (Operations) HistoryListView.getItems().get(selection);
                totalInput += "(" + op.getUserInput() + ")";
                numInput = op.getAnswer();
            }
            updateDispaly();
        }
    }

    @FXML
    private void HandleDeleteHistory(ActionEvent event) throws IOException {
        int selection = HistoryListView.getSelectionModel().getSelectedIndex();
        if (selection != -1) {
            objects.remove(selection);  //removes the operation from the array list
            obl.remove(selection);  //removes the operation from the observable array list
        }
    }

    @FXML
    private void HandleClearHistory(ActionEvent event) throws IOException {
        objects.clear();    //clears arraylist
        obl.clear();    //clears observable array list
    }

    @FXML
    private void HandleMemoryRecall(ActionEvent event) {
        if (memory == null) {
            HandleClearEntry(event);
            Display.setText("No Memory Saved!");    //Incase nothing was stored
        } else {
            HandleClearEntry(event); //Clears any previous operations
            //loads back the memory
            totalInput = memory.getUserInput() + "=" + memory.getAnswer();
            lastOperator = "=";
            numInput = memory.getAnswer();
            answer = Double.parseDouble(memory.getAnswer());
            updateDispaly();
        }
    }

    @FXML
    private void HandleMemorySave(ActionEvent event) {
        if (lastOperator.equals("=")) {
            memory = new Operations(
                    totalInput.substring(0, totalInput.indexOf("=")), //saves the operaion in memory
                    totalInput.substring(totalInput.indexOf("=") + 1));
            HandleClearEntry(event);
            Display.setText("Operation is saved in memory. Press MR to recall");
        } else {
            Display.setText("Operation is Incomplete!");    //Incase user presses it before completing the operation
        }
    }

    @FXML
    private void HandleMemoryClear(ActionEvent event) {
        HandleClearEntry(event);    //clears the screen
        memory = null;                  //clears the memory
    }

    @FXML
    private void HandleMemoryPlus(ActionEvent event) {
        HandleMemoryRecall(event);  //to load the memoy
        HandleAdd(event);   //prepares for addition by turning last operator to +
        memoryMode = true;  //ensures any operation done also changes the operation stored
    }

    @FXML
    private void HandleMemoryMinus(ActionEvent event) {
        HandleMemoryRecall(event);  //same as above except prepares for subtraction instead
        HandleSubtract(event);
        memoryMode = true;
    }

    //=================Handle Equations=================
    /*
        Here equation windows are loaded. 
        There are three types of Equation solver
        SE1 solves a two variable simultaenous equation
        SE2 solves a three variable simultaneous equation
        Quadratic solves quadratic equations
     */
    @FXML
    private void HandleSE1(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(
                SimpleCalculatorController.class.getResource("SimultaneousEquation1.fxml"));
        stage.setScene(new Scene(root));
        stage.setTitle("AIS Calculator(Ax+By=C)");
        stage.getIcons().add(new Image(SimpleCalculator.class.getResourceAsStream("CalculatorIcon.png")));
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(
                ((Node) event.getSource()).getScene().getWindow());
        stage.show();
    }

    @FXML
    private void HandleSE2(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(
                SimpleCalculatorController.class.getResource("SimultaneousEquation2.fxml"));
        stage.setScene(new Scene(root));
        stage.setTitle("AIS Calculator(Ax+By+Cz=D)");
        stage.getIcons().add(new Image(SimpleCalculator.class.getResourceAsStream("CalculatorIcon.png")));
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(
                ((Node) event.getSource()).getScene().getWindow());
        stage.show();
    }

    @FXML
    private void HandleQuadratic(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(
                SimpleCalculatorController.class.getResource("QuadraticEquation.fxml"));
        stage.setScene(new Scene(root));
        stage.setTitle("AIS Calculator(Quadratic Equation)");
        stage.getIcons().add(new Image(SimpleCalculator.class.getResourceAsStream("CalculatorIcon.png")));
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(
                ((Node) event.getSource()).getScene().getWindow());
        stage.show();
    }

    //==============Handle Complex Operations==================
    /*
        Here the windows of complex operations are opened.
        These operations include addition, subtraction, multiplication and division of complex number
     */
    @FXML
    private void HandleC_Addition(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(
                SimpleCalculatorController.class.getResource("ComplexAddition.fxml"));
        stage.setScene(new Scene(root));
        stage.setTitle("AIS Calculator(Complex Addition)");
        stage.getIcons().add(new Image(SimpleCalculator.class.getResourceAsStream("CalculatorIcon.png")));
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(
                ((Node) event.getSource()).getScene().getWindow());
        stage.show();
    }

    @FXML
    private void HandleC_subtaction(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(
                SimpleCalculatorController.class.getResource("ComplexSubtracttion.fxml"));
        stage.setScene(new Scene(root));
        stage.setTitle("AIS Calculator(Complex Subtraction)");
        stage.getIcons().add(new Image(SimpleCalculator.class.getResourceAsStream("CalculatorIcon.png")));
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(
                ((Node) event.getSource()).getScene().getWindow());
        stage.show();
    }

    @FXML
    private void HandleC_Multiplication(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(
                SimpleCalculatorController.class.getResource("ComplexMultiplication.fxml"));
        stage.setScene(new Scene(root));
        stage.setTitle("AIS Calculator(Complex Multiplication)");
        stage.getIcons().add(new Image(SimpleCalculator.class.getResourceAsStream("CalculatorIcon.png")));
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(
                ((Node) event.getSource()).getScene().getWindow());
        stage.show();
    }

    @FXML
    private void HandleC_division(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(
                SimpleCalculatorController.class.getResource("ComplexDivision.fxml"));
        stage.setScene(new Scene(root));
        stage.setTitle("AIS Calculator(Complex Division)");
        stage.getIcons().add(new Image(SimpleCalculator.class.getResourceAsStream("CalculatorIcon.png")));
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(
                ((Node) event.getSource()).getScene().getWindow());
        stage.show();
    }

    //=================Handle Conversions==================
    /*
        Opens the conversion windows. Three conversions are included
        1. Kg to pound and vice versa
        2. Meter to miles and vice verse
        3. Taka to dollar and vice versa
     */
    @FXML
    private void HandleWeightConv(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(
                SimpleCalculatorController.class.getResource("WeightConversion.fxml"));
        stage.setScene(new Scene(root));
        stage.setTitle("AIS Calculator(Weight Conversion)");
        stage.getIcons().add(new Image(SimpleCalculator.class.getResourceAsStream("CalculatorIcon.png")));
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(
                ((Node) event.getSource()).getScene().getWindow());
        stage.show();
    }

    @FXML
    private void HandleDistanceConv(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(
                SimpleCalculatorController.class.getResource("DistanceConversion.fxml"));
        stage.setScene(new Scene(root));
        stage.setTitle("AIS Calculator(Distance Conversion)");
        stage.getIcons().add(new Image(SimpleCalculator.class.getResourceAsStream("CalculatorIcon.png")));
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(
                ((Node) event.getSource()).getScene().getWindow());
        stage.show();
    }

    @FXML
    private void HandleCurrencyConv(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(
                SimpleCalculatorController.class.getResource("CurrencyConversion.fxml"));
        stage.setScene(new Scene(root));
        stage.setTitle("AIS Calculator(Currency Conversion)");
        stage.getIcons().add(new Image(SimpleCalculator.class.getResourceAsStream("CalculatorIcon.png")));
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(
                ((Node) event.getSource()).getScene().getWindow());
        stage.show();
    }

}
