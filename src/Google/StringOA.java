package Google;

public class StringOA {
    public static void main(String[] args) {
	    StringOA solution = new StringOA();
	    String s = "-a-a-bsf-dsfs";
	    s = s.toUpperCase();
	    String res = solution.solve(s, 3);
	    System.out.println(res);
    }
    private String solve(String s, int k){
    	if(s == null) return s;
    	StringBuilder sb = new StringBuilder();
    	for(int i = 0; i < s.length(); i++){
    		char c = s.charAt(i);
    		if(c == '-') continue;
    		sb.append(c);
    	}
    	String res = "";
    	int count = 0;
    	for(int i = sb.length()-1; i >= 0 ; i--){
    		count++;
    		res = sb.charAt(i)+res;
    		if(count % k == 0){
    			res = "-"+res;
    		}
    	}
    	if(res.charAt(0) == '-') res = res.substring(1);
    	return res;
    }
}
