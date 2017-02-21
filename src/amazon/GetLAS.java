package amazon;

public class GetLAS {
    public static void main(String[] args) {
    	int[] input = new int[]{1, 2 , 3, 4, 5, 6};
		System.out.println(solve(input));
	}
    public static int solve(int[] input){
    	if(input.length < 3) return 0;
    	int res = 0;
    	int diff = Integer.MIN_VALUE;
    	int count = 0;
    	int start = 0;
    	for(int i = 1; i < input.length; i++){
    		int curDiff = input[i]-input[i-1];
    		if(diff == curDiff){
    			count += i - start - 1 > 0 ? i - start - 1 : 0;
    		}else{
    			start = i-1;
    			diff = curDiff;
    			res += count;
    			count  = 0;
    		}
    	}
    	res += count;
    	return res;
    }
}
