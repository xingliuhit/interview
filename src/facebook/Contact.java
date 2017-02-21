package facebook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Contact {
    public static void main(String[] args) {
	    Contact test = new Contact();
	    String[] contacts = new String[4];
	    contacts[0] = "Tom: tom@gmail.com, tom@yahoo.com";
	    contacts[1] = "Tommy: tom@yahoo.com, tommy@hotmail.com";
	    contacts[2] = "Jack: jack@fb.com";
	    contacts[3] = "Jackie: jack@fb.com, jackie@uber.com";
	    test.solve(contacts);
    }
    private void solve(String[] contacts){
    	if(contacts == null || contacts.length == 0) return;
    	// email - name, name ... 
    	HashMap<String, List<String>> emailMap = new HashMap<>();
    	// name - email, email
    	HashMap<String, List<String>> nameMap = new HashMap<>();
    	// name
    	HashSet<String> nameSet = new HashSet<>();
    	for(String contact : contacts){
    		String name = getName(contact);
    		List<String> emails = getEmails(contact);
    		nameSet.add(name);
    		nameMap.put(name, emails);
    		for(String email : emails){
    			if(!emailMap.containsKey(email)){
    				emailMap.put(email, new ArrayList<String>());
    			}
    			emailMap.get(email).add(name);
    		}
    	}
    	HashSet<String> visited = new HashSet<>();
    	List<HashSet<String>> groups = new ArrayList<>(); 
    	for(String name : nameSet){
    		if(visited.contains(name)) continue;
            HashSet<String> set = new HashSet<>();
            dfs(name, set, emailMap, nameMap);
            for(String v : set){
            	visited.add(v);
            }
            groups.add(set);
    	}
    	for(HashSet<String> ele : groups){
    		for(String s : ele){
    			System.out.print(s+" , ");
    		}
    		System.out.println();
    	}
    }
    private void dfs(String name, HashSet<String> set, HashMap<String, List<String>> emailMap, HashMap<String, List<String>> nameMap){
    	if(set.contains(name)) return;
    	set.add(name);
    	if(nameMap.containsKey(name)){
    		for(String email : nameMap.get(name)){
    			if(emailMap.containsKey(email)){
    				for(String nameOther : emailMap.get(email)){
    					dfs(nameOther, set, emailMap, nameMap);
    				}
    			}
    		}
    	}
    }
    private String getName(String contact){
    	String[] array = contact.split(":");
    	return array[0];
    }
    private List<String> getEmails(String contact){
    	String[] array = contact.split(":")[1].split(",");
    	List<String> res = new ArrayList<String>();
    	for(String email : array){
    		res.add(email);
    	}
    	return res;
    }
}
