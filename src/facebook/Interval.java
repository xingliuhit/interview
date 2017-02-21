package facebook;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Interval{
	class Point{
		int value;
		boolean start;
		Point(int value, boolean start){
			this.value = value;
			this.start = start;
		}
	}
	private int solve(List<int[]> list){
		int size = list.size();
		int res = 0;
		List<Point> array = new ArrayList<>();
		for(int[] ele : list){
			Point temp1 = new Point(ele[0], true);
			Point temp2 = new Point(ele[1], false);
			array.add(temp1);
			array.add(temp2);
		}
		Comparator<Point> com = new Comparator<Point>(){
			public int compare(Point a, Point b){
				if(a.value != b.value) return a.value - b.value;
				else{
					if(a.start) return -1;
					return 1;
				}
			}
		};
		Collections.sort(array, com);
		int count = 0;
		for(Point point : array){
			if(point.start){
				count++;
				res = Math.max(res, count);
			}else{
				count--;
			}
		}
		return res;
	}
	public static void main(String[] args) {
	    Interval test = new Interval();
	    List<int[]> list = new ArrayList<>();
	    list.add(new int[]{0, 1});
	    list.add(new int[]{0, 3});
	    list.add(new int[]{2, 3});
	    System.out.println(test.solve(list));
    }
}
