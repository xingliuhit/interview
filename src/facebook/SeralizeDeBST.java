package facebook;

import java.util.ArrayList;
import java.util.List;

public class SeralizeDeBST {
    public static void main(String[] args) {
	
    }
    private List<Integer> seralize(TreeNode root){
    	List<Integer> res = new ArrayList<>();
    	help(root, res);
    	return res;
    }
    private void help(TreeNode root, List<Integer> res){
        if(root == null) return;
        res.add(root.val);
        help(root.left, res);
        help(root.right, res);
    }
    
    private TreeNode deseralize(List<Integer> preOrder){
    	if(preOrder == null || preOrder.size() == 0) return null;
    	return helpDe(preOrder, 0, preOrder.size()-1);
    }
    private TreeNode helpDe(List<Integer> preOrder, int start, int end){
    	if(start > end) return null;
    	if(start == end) return new TreeNode(preOrder.get(start));
    	TreeNode root = new TreeNode(preOrder.get(start));
    	if(preOrder.get(end) < preOrder.get(start)){
    		root.left = helpDe(preOrder, start+1, end);
    		return root;
    	}
    	int index = start+1;
    	while(preOrder.get(index) < preOrder.get(start)){
    		index++;
    	}
    	root.left = helpDe(preOrder, start+1, index-1);
    	root.right = helpDe(preOrder, index, end);
    	return root;
    }
}
