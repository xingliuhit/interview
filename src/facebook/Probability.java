package facebook;

import java.util.Random;

public class Probability {
    public static void main(String[] args) {
	    int[] input = new int[]{4, 1, 1, 1, 1};
	    Probability test = new Probability();
	    int[] res = new int[5];
	    for(int i = 0; i < 10000; i++){
	        int temp = test.solve(input);
	        res[temp]++;
	    }
	    for(int i = 0; i < res.length; i++){
	    	System.out.println(" i = "+res[i]);
	    }
    }
    private int solve(int[] input){
    	int len = input.length;
    	int sum = 0;
    	for(int num : input){
    		sum += num;
    	}
    	double[] percent = new double[len];
    	for(int i = 0; i < len; i++){
    		if(i == 0){
    			percent[0] = (double) input[0]/sum;
    			continue;
    		}
    		percent[i] = percent[i-1] + (double) input[i]/sum;
    	}
    	Random r = new Random();
    	double probability = r.nextDouble();
    	for(int i = 0; i < len; i++){
    		if(probability < percent[i]) return i;
    	}
    	return 0;
    }
}
