package facebook;

import java.util.HashMap;

public class Solution {
	 public static void main(String[] args) {
		System.out.println("res = "+lengthOfLongestSubstringTwoDistinct("abcabcabc"));
	 }
	 public static int lengthOfLongestSubstringTwoDistinct(String s) {
	        if(s == null || s.length() == 0) return 0;
	        if(s.length() <= 2) return s.length();
	        HashMap<Character, Integer> map = new HashMap<>();
	        int left = 0;
	        int max = 1;
	        for(int right = 0; right < s.length(); right++){
	            char c = s.charAt(right);
	            if(map.containsKey(c)){
	                map.put(c, map.get(c)+1);
	            }else{
	                if(map.size() <= 1){
	                    map.put(c, 1);
	                }else{
	                    // map.put(c, 1)这个不能忘
	                    map.put(c, 1);
	                    while(left < right){
	                        char leftc = s.charAt(left);
	                        if(map.get(leftc) == 1){
	                            map.remove(leftc);
	                            left++;
	                            break;
	                        }else{
	                            map.put(leftc, map.get(leftc)-1);
	                            left++;
	                        }
	                    }
	                }
	            }
	            max = Math.max(max, right-left+1);
	            System.out.println(max);
	        }
	        max = Math.max(max, s.length()-left);
	        return max;
	   }
}
