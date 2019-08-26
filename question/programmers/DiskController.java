import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0, len = jobs.length, size, i, time=0;
        PriorityQueue<Job> q = new PriorityQueue<Job>();
        List<Job> wait = new ArrayList<>(); 
        Job cur;
        
        for(i = 0; i<len;i++)
        	q.add(new Job(jobs[i][0], jobs[i][1]));
        for(i = 0; i<len;i++)
        	wait.add(q.remove());
        size =wait.size();
        while(size>0) {
        	for(i = 0; i<size; i++) {
        		if(wait.get(i).getStart()<=time) {
        			cur=wait.remove(i);
        			time += cur.getTime();
        			answer+=time-cur.getStart();
        			size--;
        			break;
        		}
        		if(i==size-1)
            		time++;
        	}
        }
        return answer/len;
    }
}
class Job implements Comparable<Job>{
	int start;
	int time;
	public Job(int s, int t) {
		this.start = s;
		this.time = t;
	}
	public int getStart() {
		return start;
	}
	public int getTime() {
		return time;
	}
	@Override
	public int compareTo(Job o) {
		int time=o.getTime();
		int start=o.getStart();
		if(time>this.time)  return -1;
		else if(time==this.time)
			if(start>this.start) return -1;
			else  return 1;
		else return 1;
	}
}