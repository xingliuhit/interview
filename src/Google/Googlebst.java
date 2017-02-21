package Google;

import java.util.Comparator;

import interview.Node;

public class Googlebst {
	// 第二道题考的是BST，对我这种基础不好的人来说就很花时间了，在家里的白板上倒腾了半个多小时... 
	// 题目是说给你一个BST的root，再给你一个数字范围[A, B]（2-side-inclusive)，要求找出来一个subtree，
	// 这个subtree里面所有的node的value都必须是在这个范围里面，output是subtree当中node的个数。如果你找到
	// 多个subtree符合条件，那就返回最大值。我看到题的时候就懵逼了... 后来想了想第一反应是得借助DFS，再想着DFS得用recursion吧，
	// 于是楼主开始试着用了recursion。Turns out到最后我发现我的solution method和我的helper method都用了recursion，一团乱，
	// 没想到最后慢慢debug还真过了test cases... 大概想法就是看我的root的值，如果大于B，我就完全抛弃右边的subtree不看了，只看左边；
	// 同理如果小于A，我就完全抛弃左边的subtree不看了，只看右边；如果root的value在valid的范围内的话，我就用DFS去查它的每一个children，
	// 只要有一个children的value不在范围内，就说明这个root肯定不在最终最大的subtree当中，我就分别看它的left和right （recursion）。
	// 至于count我是在helper里面写的，楼主用了c++写第二道题，count pass by reference进去helper function，所以这个不难实现。
    // bottom up
	public static void main(String[] args) {
    	Node node15 = new Node(15);
		Node node10 = new Node(10);
		Node node20 = new Node(20);
		Node node8 = new Node(8);
		Node node13 = new Node(13);
		Node node17 = new Node(17);
		node15.left = node10;
		node15.right = node20;
		node10.left = node8;
		node10.right = node13;
		node20.left = node17;
		
		Node node40 = new Node(40);
		Node node50 = new Node(50);
		Node node45 = new Node(45);
		Node node60 = new Node(60);
		node20.right = node40;
		node40.right = node50;
		node50.left = node45;
		node50.right = node60;
		
		int min = 20;
		int max = 60;
		System.out.println(solve(node15, min, max));
	}
	private static int nummax = 0;
	private static int solve(Node root, int min, int max){
    	if(root == null) return 0;
    	if(root.value < min) return solve(root.right, min, max);
    	if(root.value > max) return solve(root.left, min, max);
    	help(root, min, max);
    	return nummax;
    }
	
	private static int help(Node root, int min, int max){
		if(root == null) return 0;
		if(root.left == null && root.right == null){
			if(root.value >= min && root.value <= max){
				return 1;
			}else return -1;
		}
		int left = help(root.left, min, max);
		int right = help(root.right, min, max);
		nummax = Math.max(left, Math.max(right, nummax));
		if(left == -1 || right == -1){
			return -1;
		}
		if(root.value < min || root.value > max){
			return -1;
		}
		nummax = Math.max(left+right+1, nummax);
		return left+right+1;
 	}
}
