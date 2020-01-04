import java.util.*;

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
        String grid = "";

        //Taking the input grid of the number;
        //initialize, terminate, increment;
        for(int row = 0; row < 5; ++row){
            String line = userInput.nextLine();
            grid += line;
        }

        //------------------------------------------------------------------------------------------------------------


        // Stage 1: Set up the predefined weights of the input neuron.
        int[] WEIGHTS = new int[]{2,1,2,4,-4,4,2,-1,2};
//        int BIAS = -5;


        //Stage 2: Setting up network with two layers.
        /**
         * The values of the neurons depend on the whether we have a filled square. X = 1, _ = 0
         * For instance: _X_ -> 0 1 0
         * The weights for each neuron also depend on the filled square. X = 1, _ = -1,
         * however each number has it's own representation which corresponds to the output neurons.
         * For instance: _X_ -> -1 1 -1
         *               _X_
         *               _X_
         *               _X_
         *               _X_
         * -> {-1, +1, -1, -1, +1, -1, -1, +1, -1, -1, +1, -1, -1, +1, -1};
         * Bias is constant preset. [6,1,0,2,0,-1,3,-2,-1,-1]
         *
         * Output neurons: 1,2,3,4,5,6,7,8,9,0
         */

        //Creating a 2D array to store the input neurons at row 1  and output neurons at row 2;
        int[][] twoLayerNetwork = new int[2][];
        twoLayerNetwork[0] = new int[15]; //15 input neurons (+1 BIAS)
        twoLayerNetwork[1] = new int[10]; //10 output neurons

        int[] BIAS = new int[] {6,1,0,2,0,-1,3,-2,-1,-1}; //Corresponding to each of the output nodes. 6 -> Output neuron 1.

        //The rows represent the number and the columns represent the value of each neuron.
        //-1 Not activated and 1 activated.
        int[][] weights = new int[10][];

        weights[0] = new int[] {-1, +1, -1, -1, +1, -1, -1, +1, -1, -1, +1, -1, -1, +1, -1}; //1
        weights[1] = new int[] {+1, +1, +1, -1, -1, +1, +1, +1, +1, +1, -1, -1, +1, +1, +1}; //2
        weights[2] = new int[] {+1, +1, +1, -1, -1, +1, +1, +1, +1, -1, -1, +1, +1, +1, +1}; //3
        weights[3] = new int[] {+1, -1, +1, +1, -1, +1, +1, +1, +1, -1, -1, +1, -1, -1, +1}; //4
        weights[4] = new int[] {+1, +1, +1, +1, -1, -1, +1, +1, +1, -1, -1, +1, +1, +1, +1}; //5
        weights[5] = new int[] {+1, +1, +1, +1, -1, -1, +1, +1, +1, +1, -1, +1, +1, +1, +1}; //6
        weights[6] = new int[] {+1, +1, +1, -1, -1, +1, -1, -1, +1, -1, -1, +1, -1, -1, +1}; //7
        weights[7] = new int[] {+1, +1, +1, +1, -1, +1, +1, +1, +1, +1, -1, +1, +1, +1, +1}; //8
        weights[8] = new int[] {+1, +1, +1, +1, -1, +1, +1, +1, +1, -1, -1, +1, +1, +1, +1}; //9
        weights[9] = new int[] {+1, +1, +1, +1, -1, +1, +1, -1, +1, +1, -1, +1, +1, +1, +1}; //0


        setValueInputNeurons(twoLayerNetwork, grid);
        calculateOutputNeurons(twoLayerNetwork, weights, BIAS);

        System.out.println(findMaxIndex(twoLayerNetwork));
    }

    //Finding the output note with maximum activation.
    public static int findMaxIndex(int[][] twoLayerNetwork){
        int max = 0;
        int index = 0;
        for(int m = 0; m < 10; ++m){
            if(twoLayerNetwork[1][m] > max){
                max = twoLayerNetwork[1][m];
            }
        }

        for(int i = 0; i < 10; ++i){
            if(twoLayerNetwork[1][i] == max){
                index = i+1;
            }
        }
        //If the last neuron has the biggest activation set to 0.
        if(index == 10){ index = 0;}
        return index;
    }

    /**
     * Stage 2.2:
     * Setting the values of the neurons to 0 OR 1
     * @param twoLayerNetwork the 2D array which is used to store the input and output neurons' values
     * @param weights the weight for each of the numbers 1,2,3,4,5,6,7,8,9 and the neurons activated, representing them.
     * @param BIAS the preset biases which stabalize the nework. (16th neuron)
     */
    public static void calculateOutputNeurons(int[][] twoLayerNetwork, int[][] weights, int[]BIAS){
        for(int i = 0; i < 10; ++i){
            for(int j = 0; j < 15; ++j){
                twoLayerNetwork[1][i] += (twoLayerNetwork[0][j] * weights[i][j]); //Calculating for each input neuron * weight.
            }
            twoLayerNetwork[1][i] += BIAS[i]; //Adding the 16th bias neuron.
        }
    }

    /**
     * Stage 2.1:
     * Setting the values of the neurons to 0 OR 1
     * @param twoLayerNetwork the 2D array which is used to store the input and output neurons' values
     * @param grid the input grid which consists of '_' AND 'X'
     */
    public static void setValueInputNeurons(int[][] twoLayerNetwork, String grid){
        for(int neuron = 0; neuron < grid.length(); neuron++){
            if(grid.charAt(neuron)=='X'){
                twoLayerNetwork[0][neuron] = 1;
            }else{
                twoLayerNetwork[0][neuron] = 0;
            }
        }
    }

    /**
     * Stage 1:
     * Returning 0 for positive numbers and 1 for negative numbers.
     * @param weights is an array of the 9 weights for the 9 neurons.
     * @param bias is the default bias for the network.
     *
     * @return digit is either 1 or 0.
     */
    public static int recognizeNum(int[] weights, String grid, int bias){
        int digit = 0;
        for(int neuron = 0; neuron < weights.length; neuron++){
            if(grid.charAt(neuron)=='X'){
                digit += weights[neuron];
            }
        }
        //Adding the bias
        digit += bias;

        digit = digit < 0 ? 1 : 0;

        return digit;
    }
}