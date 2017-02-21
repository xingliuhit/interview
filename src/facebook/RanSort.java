package facebook;

import java.util.Random;

public class RanSort {
    public static void main(String[] args) {
	     RanSort test = new RanSort();
	     int[] input = new int[10];
	     for(int i = 0; i < 10; i++){
	    	 input[i] = i;
	     }
	     int[] sum = new int[10];
	     for(int i = 0; i < 100000; i++){
	    	int[] res = test.solve(input, 5);
	    	for(int j = 0; j < res.length; j++){
	    		sum[res[j]]++;
	    	}
	     }
	     for(int i = 0; i < 10; i++){
	    	 System.out.println(" i = "+i+" , "+sum[i]);
	     }
    }
    private int[] solve(int[] input, int k){
    	if(input == null || input.length == 0  || k >= input.length) return input;
    	int len = input.length;
    	Random r = new Random();
    	int[] res = new int[k];
    	for(int i = 0; i < len; i++){
    		if(i < k) res[i] = input[i];
    		else{
    			int t = r.nextInt(i+1);
    			if(t < k){
    				res[t] = input[i];
    			}
    			
    		}
    	}
    	return res;
    }
}
