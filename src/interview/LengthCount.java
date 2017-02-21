package interview;

import java.util.LinkedList;
import java.util.Queue;

public class LengthCount {
    public static void main(String[] args) {
	    int[][] m = new int[4][5];
	    m[0][0] = 0;
	    m[0][1] = 1;
	    m[0][2] = 2;
	    m[0][3] = 3;
	    m[0][4] = 4;
	    
	    m[1][0] = 0;
	    m[1][1] = 3;
	    m[1][2] = 0;
	    m[1][3] = 1;
	    m[1][4] = 7;
	    
	    m[2][0] = 0;
	    m[2][1] = 3;
	    m[2][2] = 0;
	    m[2][3] = 1;
	    m[2][4] = 7;
	    
	    m[3][0] = 0;
	    m[3][1] = 3;
	    m[3][2] = 3;
	    m[3][3] = 1;
	    m[3][4] = 7;
	    int res = cal(m, 2, 1);
        System.out.println(res);
    }
    public static int cal(int[][] g, int row, int col){
    	if(g == null || g.length == 0) return 0;
    	if(g[0].length == 0) return 0;
    	int m = g.length;
    	int n = g[0].length;
    //	System.out.println("m="+m+",n="+n);
    	int t = g[row][col];
    	Queue<Integer> queue = new LinkedList<>();
    	int res = 0;
    	queue.add(row);
    	queue.add(col);
    	boolean[][] visited = new boolean[m][n];
    	// visited 要放在 add后面，如果放在pop后面，会出问题的
    	visited[row][col] = true;
    	while(queue.size() != 0){
    		int i = queue.poll();
    		int j = queue.poll();
    		System.out.println("visited, i = "+i+" , j = "+j);
    		int nei = 0;
    		if(i > 0){
    			if((!visited[i-1][j]) && (g[i-1][j] == t)){
    				queue.offer(i-1);
    				queue.offer(j);
    		    	visited[i-1][j] = true;
    			}
    			if(g[i-1][j] == t){
    				nei++;
    			}
    		}
    		if(i < m-1){
    			if((!visited[i+1][j]) && (g[i+1][j] == t)){
    				queue.offer(i+1);
    				queue.offer(j);
    		    	visited[i+1][j] = true;
    			}
    			if(g[i+1][j] == t){
    				nei++;
    			}
    		}
    		if(j > 0){
    			if((!visited[i][j-1]) && (g[i][j-1] == t)){
    				queue.offer(i);
    				queue.offer(j-1);
    		    	visited[i][j-1] = true;
    			}
    			if(g[i][j-1] == t){
    				nei++;
    			}
    		}
    		if(j < n-1){
    			if((!visited[i][j+1]) && (g[i][j+1] == t)){
    				queue.offer(i);
    				queue.offer(j+1);
    		    	visited[i][j+1] = true;
    			}
    			if(g[i][j+1] == t){
    				nei++;
    			}
    		}
    //		System.out.println("nei = "+nei);
    		res += 4-nei;
    		System.out.println("i = "+i+" , j = "+j+", res = "+res);
    	}
    	return res;
    }
}
