package Google;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Directory { 
    
	public static void main(String[] args) {
	    Directory solution = new Directory();
	    String s = "dir1\n dir11\n dir12\n  picture.jpeg\n  dir121\n  file1.txt\ndir2\n file2.gif";
	    List<String> res = solution.solve(s);
	    for(String temp : res){
	    	System.out.println(temp);
	    }
    }
    
	private List<String> solve(String s){
		List<String> res = new ArrayList<String>();
		if(s == null || s.length() == 0) return res;
		String[] dir = s.split("\n");
		HashMap<Integer, String> map = new HashMap<>();
		for(int i = 0; i < dir.length; i++){
			String temp = dir[i];
			int level = getLevel(temp);
			if(level == 0){
				if(isImage(temp)){
					res.add(temp);
				}else{
					map.put(level, "/"+temp);
				}
			}else{
				if(isImage(temp)){
					res.add(map.get(level-1)+"/"+temp.substring(level));
				}else{
					map.put(level, map.get(level-1)+"/"+temp.substring(level));
				}
			}
		}
		return res;
	}
	private boolean isImage(String s){
		if(s.contains(".jpeg")) return true;
		if(s.contains(".png")) return true;
		if(s.contains(".gif")) return true;
        return false;
	}
	private int getLevel(String s){
		int i = 0;
	    while(s.charAt(i) == ' '){
	    	i++;
	    }
	    return i;
	}
}
