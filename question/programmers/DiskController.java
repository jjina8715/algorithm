package programmers;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class DiskController {
	//SJF
	public static void main(String[] args) {
		//{0, 9}, {0, 4}, {0, 5}, {0, 7}, {0, 3} 13
		//{0, 5}, {1, 2}, {5, 5} 6
		System.out.println(solution(new int[][] 
				{{0, 5}, {1, 2}, {5, 5}}));
	}
	static public int solution(int[][] jobs) {
        int answer = 0, len = jobs.length, time=0;
        Queue<Job> q = new PriorityQueue<Job>(len);
        Job cur;
        //순서 정렬
        Collections.sort(list, c);
        for(int i = 0; i<len;i++)
        	q.offer(new Job(jobs[i][0],jobs[i][1]));
        
        while(!q.isEmpty()) {
        	cur = q.poll();
        	time+=answer-cur.getStart();
        	answer+= cur.getTime();
        }
        answer += time;
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
		if(this.start>o.getStart())
			if(this.time>=o.getTime()) 
				return 1;
			else
				return -1;
		else if(this.start==o.getStart())
			if(this.time>=o.getTime()) 
				return 1;
			else
				return -1;
		else
			if(this.time>=o.getTime()) 
				return 1;
			else
				return -1;
		/*
		 if(this.time+this.start>o.getStart())
			if(this.time>=o.getTime()) 
				return 1;
			else
				return -1;
		else 
			return -1;
		 */
	}
	@Override
	public String toString() {
		return "Job [start=" + start + ", time=" + time + "]";
	}
}