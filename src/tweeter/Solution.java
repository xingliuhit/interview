package tweeter;

public class Solution {
    public static void main(String[] args) {
	    int[] a = {74, 659, 931, 273, 545, 879, 924, 710, 441, 166, 493, 43, 988, 504, 328, 730, 841, 613, 304, 170, 710, 158, 561, 934, 100, 279, 817, 336, 98, 827, 513, 268, 811, 634, 980, 150, 580, 822, 968, 673, 394, 337, 486, 746, 229, 92, 195, 358, 2, 154, 709, 945, 669, 491, 125, 197, 531, 904, 723, 667, 550};
        System.out.println(a.length);
        System.out.println(solve(a, 22337));
    }
    private static int solve(int[] a, int k){
    	int len = a.length;
    	int i = 0;
    	while(a[i] > k){
    		i++;
    		if(i == len) return 0;
    	}
    	// i must be correst, j-1 must be correct
    	int j = i+1;
    	int max = 1;
    	int sum = a[i];
    	while(j < len){
    		if(sum + a[j] <= k){
    			sum += a[j];
    			j++;
        		max = Math.max(max, j-i);
    		}else{
    			i++;
    			sum = sum - a[i-1];
    			
    		}
    	}
    	return max;
    }
}
