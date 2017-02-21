package facebook;

public class SortKColors {
    public static void main(String[] args) {
	    int[] array = new int[]{0, 3, 2, 0, 1, 2, 2, 1, 0, 1, 0, 1, 4, 3, 4, 2, 0, 4, 0, 2, 1, 3, 4, 1, 0, 3, 4, 2, 0, 1};
	    SortKColors test = new SortKColors();
	    test.sortColors2(array, 5);
	    for(int i = 0; i < array.length; i++){
	    	System.out.print(array[i]+" ");
	    }
    }
    
    public void sortColors2(int[] colors, int k) {
        if(colors == null || colors.length <= 1) return;
        int len = colors.length;
        int min = 0, max = k-1;
        int start = 0, end = len-1;
        while(min < max && start < end){
        	int[] temp = sort2(colors, min, max, start, end);
        	start = temp[0];
        	end = temp[1];
        	min++;
        	max--;
        }
    }
    
    private int[] sort2(int[] colors, int min, int max, int start, int end){
    	int j = start, k = end;
    	for(int i = start; i <= end; i++){
    		if(colors[i] == min && i > j){
    			exch(colors, i--, j++);
    		}else if(colors[i] == max && i < k){
    			exch(colors, i--, k--);
    		}
    	}
    	int[] res = new int[]{j, k};
    	return res;
    }
    
    void exch(int[] colors, int i, int j) {
        int tmp = colors[i];
        colors[i] = colors[j];
        colors[j] = tmp;
    }
}
