package Google;

import java.util.ArrayList;
import java.util.HashSet;

class TreeNode{
	int value;
	ArrayList<TreeNode> children;
	TreeNode(int value, ArrayList<TreeNode> children){
		this.value = value;
		this.children = children;
	}
}

public class TreeDeleteNode {
    ArrayList<TreeNode> res = new ArrayList<>();
	public ArrayList<TreeNode> delete(TreeNode root, HashSet<TreeNode> nodes){
       if(root == null) return res;
       if(nodes == null || nodes.size() == 0){
    	   res.add(root);
    	   return res;
       }
       if(!nodes.contains(root)) res.add(root);
       help(root, nodes);
       return res;
    }
	
	private void help(TreeNode root, HashSet<TreeNode> nodes){
		if(root == null) return;
		if(nodes.contains(root)){
			for(TreeNode child : root.children){
				if(!nodes.contains(child)) res.add(child);
			}
		}
		for(TreeNode child : root.children){
			help(child, nodes);
		}
	}
}
