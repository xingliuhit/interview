package facebook;

public class Module {
    public static void main(String[] args) {
    	Module test = new Module();
	    System.out.println(test.solve(3, 6, 7));
    }
    private int solve(int a, int b, int c){
    	if(b == 0) return 1;
    	if(b == 1) return a%c;
    	int pre = solve(a, b/2, c);
    	if(b%2 == 0){
    		return (pre*pre)%c;
    	}else{
    		return (a*pre*pre)%c;
    	}
    }
}
