package facebook;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KNearestPoint{
    
	public static void main(String[] args) {
		KNearestPoint test = new KNearestPoint();
		int k = 3;
		Point target = new Point(0, 0);
		Point[] points = new Point[5];
		points[0] = new Point(1, 2);
		points[1] = new Point(2, 3);
		points[2] = new Point(3, 4);
		points[3] = new Point(1, 6);
		points[4] = new Point(8, 9);
	
		Point[] res1 = test.solve1(points, target, k);
		for(int i = 0; i < res1.length; i++){
			System.out.println(res1[i].x+", "+res1[i].y);
		}
		System.out.println();
		Point[] res2 = test.solve2(points, target, k);
		for(int i = 0; i < res2.length; i++){
			System.out.println(res2[i].x+", "+res2[i].y);
		}
	}
    
	public Point[] solve1(Point[] points, Point target, int k){
		if(points == null || points.length == 0) return null;
		Comparator<Point> com = new Comparator<Point>(){
			public int compare(Point a, Point b){
				int dis1 = getDis(a, target);
				int dis2 = getDis(b, target);
				return dis2-dis1;
			}
		};
		PriorityQueue<Point> maxHeap = new PriorityQueue<Point>(k, com);
		for(Point point : points){
			if(maxHeap.size() < k){
				maxHeap.offer(point);
			}else{
				if(com.compare(point, maxHeap.peek()) > 0){
					maxHeap.poll();
					maxHeap.offer(point);
				}
			}
		}
		Point[] res = new Point[k];
		int i = k-1;
		while(!maxHeap.isEmpty()){
			res[i--] = maxHeap.poll();
		}
		return res;
	}
	private int getDis(Point a, Point b){
		return (a.x-b.x)*(a.x-b.x)+(a.y-b.y)*(a.y-b.y);
	}
	
	private Point[] solve2(Point[] points, Point target, int k){
		if(points == null || points.length == 0) return null;
		int len = points.length;
		if(k >= len) return points;
		int low = 0, high = len-1;
		while(low < high){
			int j = partition(points, low, high, target);
			if(j == k-1) break;
			else if(j > k-1) high = j-1;
			else low = j+1;
		}
		Point[] res = new Point[k];
		for(int i = 0; i < k; i++){
			res[i] = points[i];
		}
		return res;
	} 
	private int partition(Point[] points, int low, int high, Point target){
		if(low >= high) return low;
		int i = low, j = high+1;
		while(i < j){
			while(getDis(points[++i], target) < getDis(points[low], target)){
				if(i == high) break;
			}
			while(getDis(points[--j], target) > getDis(points[low], target)){
				if(j == low) break;
			}
			if(i >= j) break;
			exch(points, i, j);
		}
		exch(points, low, j);
		return j;
	}
	private void exch(Point[] points, int i, int j){
		Point temp = points[i];
		points[i] = points[j];
		points[j] = temp;
	}
}
