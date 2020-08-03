package recognize;
import java.lang.String;


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
public class SimpleNum {


    private String grid;
    private int[][] twoLayerNetwork;
    private int[] BIAS;
    private int[][] weights;

    public SimpleNum(String inputGrid) {

        this.grid = inputGrid;

        //Creating a 2D array to store the *input* neurons at row 1  and *output* neurons at row 2;
        this.twoLayerNetwork = new int[2][];
        this.twoLayerNetwork[0] = new int[15]; //15 input neurons (+1 BIAS)
        this.twoLayerNetwork[1] = new int[10]; //10 output neurons

        //Corresponding to each of the output nodes. 6 -> Output neuron 1.
        this.BIAS = new int[] {6,1,0,2,0,-1,3,-2,-1,-1};

        // Weights
        this.weights = new int[10][15];
    }


    /**
     * The rows represent the number and the columns represent the value of each neuron.
     * -1 Not activated and 1 activated.
     */
    public void setUpWeights(){

        this.weights[0] = new int[] {-1, +1, -1, -1, +1, -1, -1, +1, -1, -1, +1, -1, -1, +1, -1}; //1
        this.weights[1] = new int[] {+1, +1, +1, -1, -1, +1, +1, +1, +1, +1, -1, -1, +1, +1, +1}; //2
        this.weights[2] = new int[] {+1, +1, +1, -1, -1, +1, +1, +1, +1, -1, -1, +1, +1, +1, +1}; //3
        this.weights[3] = new int[] {+1, -1, +1, +1, -1, +1, +1, +1, +1, -1, -1, +1, -1, -1, +1}; //4
        this.weights[4] = new int[] {+1, +1, +1, +1, -1, -1, +1, +1, +1, -1, -1, +1, +1, +1, +1}; //5
        this.weights[5] = new int[] {+1, +1, +1, +1, -1, -1, +1, +1, +1, +1, -1, +1, +1, +1, +1}; //6
        this.weights[6] = new int[] {+1, +1, +1, -1, -1, +1, -1, -1, +1, -1, -1, +1, -1, -1, +1}; //7
        this.weights[7] = new int[] {+1, +1, +1, +1, -1, +1, +1, +1, +1, +1, -1, +1, +1, +1, +1}; //8
        this.weights[8] = new int[] {+1, +1, +1, +1, -1, +1, +1, +1, +1, -1, -1, +1, +1, +1, +1}; //9
        this.weights[9] = new int[] {+1, +1, +1, +1, -1, +1, +1, -1, +1, +1, -1, +1, +1, +1, +1}; //0

    }

    /**
     * Setting the values of the neurons to 0 OR 1
     */
    public void setInputNeurons(){
        for(int neuron = 0; neuron < this.grid.length(); neuron++){
            if(this.grid.charAt(neuron) == 'X'){
                this.twoLayerNetwork[0][neuron] = 1;
            }else{
                this.twoLayerNetwork[0][neuron] = 0;
            }
        }
    }

    /**
     * Setting the values of the neurons to 0 OR 1
     * twoLayerNetwork the 2D array which is used to store the input and output neurons' values
     *  weight the weight for each of the numbers 1,2,3,4,5,6,7,8,9 and the neurons activated, representing them.
     *  BIAS the preset biases which stabalize the nework. (16th neuron)
     */
    public void getOutputNeurons(){
        for(int i = 0; i < 10; ++i){
            for(int j = 0; j < 15; ++j){
                //Calculating for each input neuron * weight.
                this.twoLayerNetwork[1][i] += (this.twoLayerNetwork[0][j] * this.weights[i][j]);
            }
            this.twoLayerNetwork[1][i] += this.BIAS[i]; //Adding the 16th bias neuron.
        }
    }

    /** Finding the output note with maximum activation.
     * @return
     */
    public int findMaxIndex(){
        int max = 0;
        int index = 0;
        for(int m = 0; m < 10; ++m){
            if(this.twoLayerNetwork[1][m] > max){
                max = this.twoLayerNetwork[1][m];
            }
        }

        for(int i = 0; i < 10; ++i){
            if(this.twoLayerNetwork[1][i] == max){
                index = i+1;
            }
        }
        //If the last neuron has the biggest activation set to 0.
        if(index == 10){ index = 0;}
        return index;
    }

}