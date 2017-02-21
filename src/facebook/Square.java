package facebook;

public class Square {
    public static void main(String[] args) {
		Square test = new Square();
		int[] input = new int[]{-6, -3, -1, 0, 1, 4, 5};
		int[] res = test.solve(input);
		for(int num : res){
			System.out.println(num);
		}
	}
    private int[] solve(int[] input){
    	if(input == null || input.length == 0) return input;
    	int len = input.length;
    	int index = len-1, i = 0, j = len-1;
    	int[] res = new int[len];
    	for(; index >= 0; index--){
    		if(Math.abs(input[i]) >= Math.abs(input[j])){
    			res[index] = input[i]*input[i];
    			i++;
    		}else{
    			res[index] = input[j]*input[j];
    			j--;
    		}
    	}
    	return res;
    }
}
