package amazon;

import java.util.LinkedList;
import java.util.Queue;

public class RoundRobin {
	class Process{
		int arriveTime;
		int executeTime;
		Process(int arriveTime, int executeTime){
			this.arriveTime = arriveTime;
			this.executeTime = executeTime;
		}
	}
    public static void main(String[] args) {
		RoundRobin test = new RoundRobin();
		int[] arrive = new int[]{0, 1, 4};
		int[] execute = new int[]{5, 2, 3};
		int q = 3;
		System.out.println(test.solve(arrive, execute, q));
	}
    private double solve(int[] arrive, int[] execute, int q){
    	Queue<Process> queue = new LinkedList<>();
    	// curTime是找下一个process开始的时间
    	int curTime = 0;
    	int waitTime = 0;
    	int nextId = 0;
    	while(!queue.isEmpty() || nextId < arrive.length){
    		if(!queue.isEmpty()){
    			Process cur = queue.poll();
    			System.out.println("cur process, arriveTime = "+cur.arriveTime + " , executeTime = "+cur.executeTime);
    			waitTime += curTime - cur.arriveTime;
    			System.out.println(curTime - cur.arriveTime);
    			curTime += Math.min(cur.executeTime, q);
    			for(int i = nextId; i < arrive.length; i++){
    				if(arrive[i] <= curTime){
    					queue.offer(new Process(arrive[i], execute[i]));
    					nextId = i+1;
    				}else break;
    			}
    			if(cur.executeTime > q){
    				queue.offer(new Process(curTime, cur.executeTime-q));
    			}
    		}else{
    			queue.offer(new Process(arrive[nextId], execute[nextId]));
    			curTime = arrive[nextId++];
    		}
    	}
    	return (double)waitTime/arrive.length;
    }
}
