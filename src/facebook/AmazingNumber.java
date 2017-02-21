package facebook;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AmazingNumber{
    public static void main(String[] args) {
	    int[] a = new int[]{4, 3, 6, 8, 0, 3, 2, 3, 10, -1, 3, 4, 9, 12, 14, 20, 5, 4, 9, 19, 20, 8, 6, 7};
	    System.out.println("o(n) = "+amazingNumber(a));
        System.out.println("brute force = "+bruteForce(a));
        System.out.println();
        //
        a = new int[]{0, 1, 2, 3};
	    System.out.println("o(n) = "+amazingNumber(a));
        System.out.println("brute force = "+bruteForce(a));
        System.out.println();
        //
        a = new int[]{1, 0, 0};
	    System.out.println("o(n) = "+amazingNumber(a));
        System.out.println("brute force = "+bruteForce(a));
        System.out.println();
  }
  private static int bruteForce(int[] a) {
      int res = 0;
      int max = 0;
      for (int i = 0; i < a.length; i++) {
          int count = 0;
          for (int j = 0; j < a.length; j++) {
              int p = j + i;
              if (j - a[p % a.length] >= 0) count++;
          }
          if (count > max) {
              max = count;
              res = i;
          }
      }
      return res;
  }
    public static int amazingNumber(int[] a) {
        int len = a.length;
        LinkedList<Interval> intervals = new LinkedList<>();

        // find all the intervals that if the array starts at any index in the interval, there will
        // be at least 1 element is amazing number
        for (int i = 0; i < len; i++) {
            if (a[i] >= len-1 || a[i] <= -1) continue;
            int start = (i+1) % len;
            int end = (len + (i - a[i])) % len;
            if(start <= end){
            	intervals.add(new Interval(start, end));
            }else{
            	intervals.add(new Interval(start, len-1));
            	intervals.add(new Interval(0, end));
            }
        }
        // now our problem has just become: "find the year that has the maximum number of people
        // alive"
        int[] count = new int[len];
        for (Interval i : intervals) {
            count[i.start]++;
            if (i.end+1 < count.length) count[i.end+1]--;
        }
        int max = 0;
        int counter = 0;
        int idx = 0;
        for (int i = 0; i < count.length; i++) {
            counter += count[i];
            if (counter > max) {
                max = counter;
                idx = i;
            }
        }
        return idx;
    }
    static class Interval {
        int start;
        int end;
        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
