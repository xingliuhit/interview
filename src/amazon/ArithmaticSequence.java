package amazon;

import java.util.Arrays;

public class ArithmaticSequence {
    public static void main(String[] args) {
		ArithmaticSequence test = new ArithmaticSequence();
		int[] input = new int[]{-1,1,3,3,3,2,1,0};
		System.out.println(test.solve(input));
	}
    private int solve(int[] input){
    	if(input == null || input.length == 0) return 0;
    	if(input.length <= 2) return input.length;
    	Arrays.sort(input);
    	// -1 0 1 1 2 3 3 3 
    	int len = input.length;
    	boolean[][] dp = new boolean[len][len];
    	for(int i = 0; i+1 < len; i++){
    		dp[i][i+1] = true;
    	}
    	int size = 3;
    	for(; size <= len; size++){
    		boolean found = false;
    		for(int i = 0; i+size-1 < len; i++){
    			if(dp[i][i+size-2] && 2*input[i+size-2] == input[i+size-3]+input[i+size-1]){
    				found = true;
    				System.out.println("i = "+i+", j = "+(i+size-1));
    				dp[i][i+size-1] = true;
    			}
    		}
    		if(!found) return size-1;
    	}
    	return size;
    }
}
