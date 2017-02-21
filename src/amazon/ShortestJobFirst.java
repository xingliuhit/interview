package amazon;

public class ShortestJobFirst{
	class Process{
		int arriveTime;
		int executeTime;
		Process(int arriveTime, int executeTime){
			this.arriveTime = arriveTime;
			this.executeTime = executeTime;
		}
	}
    public static void main(String[] args) {
		ShortestJobFirst test = new ShortestJobFirst();
		int[] arrive = new int[]{1, 1, 4};
		int[] execute = new int[]{5, 2, 3};
		double res = test.solve(arrive, execute);
		System.out.println(res);
	}
    private double solve(int[] arrive, int[] execute){
    	int len = arrive.length;
    	int finish = 0;
    	boolean[] visited = new boolean[len];
    	int waitTime = 0;
    	int curTime = 0;
    	while(finish < len){
    		int shortTime = Integer.MAX_VALUE, id = 0;
    		System.out.println("curTime "+curTime);
    		for(int i = 0; i < len; i++){
    			if(!visited[i] && arrive[i] <= curTime && execute[i] < shortTime){
    				id = i;
    				shortTime = execute[i];
    			}
    		}
    		if(shortTime == Integer.MAX_VALUE){
    			// no wait
    			curTime = arrive[finish];
    		}else{
    			visited[id] = true;
				finish++;
				waitTime += curTime - arrive[id];
				System.out.println(waitTime);
				curTime = curTime+execute[id];
    		}
    		
    	}
    	return (double) waitTime/len;
    }
}
