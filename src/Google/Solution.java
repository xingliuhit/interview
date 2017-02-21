package Google;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

class Solution{
	private int size = 8;
	boolean[][] visited;
	HashMap<int[], int[]> parent = new HashMap<>();
	int[] start;
	int[] end;
	public ArrayList<int[]> solve(int[] start, int[] end){
		visited = new boolean[size][size];
		Queue<int[]> queue = new LinkedList<int[]>();
		this.start = start;
		this.end = end;
		queue.add(start);
		visited[start[0]][start[1]] = true;
		int count = 1;
		while(!queue.isEmpty()){
			int size = queue.size();
			for(int i = 0; i < size; i++){
				int[] current = queue.poll();
				if(current[0] == end[0] && current[1] == end[1]){
					return findPath();
                }
				for(int[] nei : move(current)){
					if(visited[nei[0]][nei[1]]) continue;
					queue.offer(nei);
					parent.put(nei, current);
                }
            }
			count++;
        }	
		return null;
	}
	private ArrayList<int[]> findPath(){
		ArrayList<int[]> path = new ArrayList<>();
		int[] point = end;
		path.add(0, end);
		while(parent.get(point) != start){
			path.add(0, parent.get(point));
			point = parent.get(point);
		}
		path.add(0, start);
		return path;
	}
    private ArrayList<int[]> move(int[] point){
        ArrayList<int[]> array = new ArrayList<int[]>();
		int[] temp ;
		int[] row = {2, -2, 1, -1};
		int[] col = {1, -1, 1, -1, 2, -2, 2, -2};
		for(int i = 0; i < row.length; i++){
			if(point[0]+row[i] >= 0 && point[0]+row[i] < size && point[1]+col[2*i] >= 0 && point[1]+col[2*i] < size){
				temp = new int[2];
				temp[0] = point[0]+row[i];
				temp[1] = point[1]+col[2*i];
				array.add(temp);
                    }
                    if(point[0]+row[i] >= 0 && point[0]+row[i] < size && point[1]+col[2*i+1] >= 0 && point[1]+col[2*i+1] < size){
				temp = new int[2];
				temp[0] = point[0]+row[i];
				temp[1] = point[1]+col[2*i+1];
				array.add(temp);
                    }
             }
		     return array;
        }	
}
