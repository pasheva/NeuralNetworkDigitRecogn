package learn;
import java.lang.Math;
import java.util.Random;

/**
 *   ============================== TASKS ===========================
 *   Handle exceptions, test if the input format matches. (regular expressions,IOexception)
 *   Calculate output neurons
 *   
 */


public class Generator{

    double LEARNING_RATE_COEFFICIENT = 0.5; // Δw(ai,aj)= η ∗ ai ∗ (aj ideal − aj)

    // Set the ideal values of the 15 neurons.
    int[][] idealInputNeurons;

    // Set up 160 weights. ( 15 Input Neurons X 10 Output Neurons + 10 Biases)
    double[][] weights; // [10][16]


    
    public Generator(){
        
        this.idealInputNeurons = new int[10][15];
        this.weights = new double[10][16];
    }

    /**
     *  Helper method.
     *  The Sigmoid function is needed because the value of the neurons
     *  has to be between 0 or 1 as to how activated the neuron is.
     *  Using the function will help us fit into the range from 0 to 1
     *
     * @param x The initial value of the output neuron.
     * @return Value between 0 and 1.
     */
    private static double sigmoid(double x){
        return 1/(1 + Math.exp(-x));
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
     *  generateWeights()
     */
    public void generateWeights( ){
        Random random = new Random();
        for( int n  = 0; n < 10; n++){
            for(int i = 0; i<16; i++){
                // Rounding to second decimal point -> 1 * 10^2 = 100
                double neuronWeight = Math.round( (random.nextGaussian()) * 1e2) / 1e2;

                //Restricting to values between 1.0 and -1.0
                if (neuronWeight >= 1.0 || neuronWeight <= -1.0){
                    i--;
                }else{
                    this.weights[n][i] = neuronWeight;
                }
            }
        }
    }







}