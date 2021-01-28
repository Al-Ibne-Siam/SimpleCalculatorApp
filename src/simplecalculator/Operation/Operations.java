package simplecalculator.Operation;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Operations implements Serializable {

    private String userInput;
    private String answer;
    private LocalDateTime dateAndTime;

    public Operations(String userInput, String answer, LocalDateTime dateAndTime) {
        this.userInput = userInput;
        this.answer = answer;
        this.dateAndTime = dateAndTime;
    }

    public Operations(String userInput, String answer) {
        this.userInput = userInput;
        this.answer = answer;
    }

    public String getUserInput() {
        return userInput;
    }

    public String getAnswer() {
        return answer;
    }

    public LocalDateTime getDateAndTime() {
        return dateAndTime;
    }

    //This string representation is used in the list view
    @Override
    public String toString() {
        String dnt = dateAndTime.toString();
        return "\n" + userInput + "="
                + answer
                + "\nDate: " + dnt.substring(0, dnt.indexOf("T"))
                + "\tTime: " + dnt.substring(dnt.indexOf("T") + 1)
                + "\n";
    }
}
