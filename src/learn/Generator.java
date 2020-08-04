package learn;
import java.lang.Math;
import java.util.Random;

public class Generator{

    // 1. Set the idea values of the 15 neurons.
    int[][] idealInputNeurons;
    // 2. Set up 160 weights 15 input neurons X 10 output neurons + 10 BIASES
    double[][] weights; // [10][16] output x weights+b
    // 3. learnig coefficent   Δw(ai,aj)= η ∗ ai ∗ (aj ideal − aj)
    double LEARNING_RATE_COEFFICIENT = 0.5;
    // 4.
    // 5.

    
    public Generator(){
        
        int[][] idealInputNeurons = new int[10][15];
        
    }
    
    private void setIdealInputNeurons(){
        this.idealInputNeurons[0] = new int[] {1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1};
        this.idealInputNeurons[1] = new int[] {0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0};
        this.idealInputNeurons[2] = new int[] {1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1};
        this.idealInputNeurons[3] = new int[] {1, 1, 1, 0, 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1};
        this.idealInputNeurons[4] = new int[] {1, 0, 1, 1, 0, 1, 1, 1, 1, 0, 0, 1, 0, 0, 1};
        this.idealInputNeurons[5] = new int[] {1, 1, 1, 1, 0, 0, 1, 1, 1, 0, 0, 1, 1, 1, 1};
        this.idealInputNeurons[6] = new int[] {1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1};
        this.idealInputNeurons[7] = new int[] {1, 1, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1};
        this.idealInputNeurons[8] = new int[] {1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1};
        this.idealInputNeurons[9] = new int[] {1, 1, 1, 1, 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1};
    }


    
    
    /**
     *  Helper method.
     *  The Sigmoid function is needed because the value of the neurons
     *  has to be between 0 or 1 as to how activated the neuron is.
     *  Using the fun. will help us fit into the range from 0 to 1
     *
     * @param x The initial value of the output neuron.
     * @return Value between 0 and 1.
     */
    private static double sigmoid(double x){
        return 1/(1 + Math.exp(-x));
    }







}