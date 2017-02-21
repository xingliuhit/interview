package Google;

public class StringSubstring {
    public static void main(String[] args) {
	    StringSubstring test = new StringSubstring();
	    String s = "abcdeavabcdcdab";
	    String[] substrings = {"ab", "cd"};
	    System.out.println(test.bowtie(s, substrings));
    }
    public String bowtie(String s, String[] substrings){
    	if(s == null || s.length() == 0) return s;
    	if(substrings.length == 0) return s;
    	int len = substrings.length;
    	int start = 0;
    	StringBuilder sb = new StringBuilder();
    	while(true){
    		if(start >= s.length()) break;
    		int end = help(s, substrings, start);
    		if(start == end){
    			sb.append(s.charAt(start));
    			start++;
    		}
    		else{
    			sb.append("<b>"+s.substring(start, end)+"</b>");
    			start = end;
    		}
    	}
    	return sb.toString();
    }
    
    private int help(String s, String[] substrings, int start){
    	int end = findOne(s, substrings, start);
	//	System.out.println("33 :"+start+" "+end);
    	while(start <= end){
    		end = Math.max(end, findOne(s, substrings, start++));
    	//	System.out.println(start+" "+end);
    	}
    	return end;
    }
    
    private int findOne(String s, String[] substrings, int start){
    	int end = start;
    	for(String sub : substrings){
    		if(start+sub.length() <= s.length() && sub.equals(s.substring(start, start+sub.length()))){
    			end = Math.max(end, start+sub.length());
    		}
    	}
    	return end;
    }
}
