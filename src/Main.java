import java.util.*;
import recognize.SimpleNum;

public class Main {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);

        /*
         *  Input grid:
         *  _X_
         *  _X_
         *  XX_
         *  XX_
         *  _XX
         */

        StringBuilder grid = new StringBuilder();

        //Taking the input grid of the number;
        for (int row = 0; row < 5; ++row) {
            String line = userInput.nextLine();
            grid.append(line);
        }

        SimpleNum recognizer = new SimpleNum(grid.toString());
        recognizer.setInputNeurons();
        recognizer.setUpWeights();
        recognizer.getOutputNeurons();
        int result = recognizer.findMaxIndex();

        System.out.println(result);
    }
}