package amazon;

import java.util.Arrays;

public class FourInteger {
    public static void main(String[] args) {
		FourInteger test = new FourInteger();
		int[] res = test.solve(0, 1, 2, 3);
		for(int num : res){
			System.out.print(num + ", ");
		}
	}
    private int[] solve(int a, int b, int c, int d){
    	int[] arr = new int[4];
    	arr[0] = a;
    	arr[1] = b;
    	arr[2] = c;
    	arr[3] = d;
    	Arrays.sort(arr);
    	exch(arr, 0, 1);
    	exch(arr, 2, 3);
    	exch(arr, 0, 3);
    	return arr;
    }
    private void exch(int[] arr, int i, int j){
    	int temp = arr[i];
    	arr[i] = arr[j];
    	arr[j] = temp;
    }
}
/*
0 1 2 3
1 0 2 3
1 0 3 2
2 0 3 1
*/