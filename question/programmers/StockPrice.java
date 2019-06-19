package programmers;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class StockPrice {

	public static void main(String[] args) {
		int[] price = {1,2,3,2,3};
		int[] ans = solution2(price);
		for(int i:ans)
		System.out.print(i+" ");
	}
	public static int[] solution(int[] prices) {
		int len = prices.length,price;
        int[] answer = new int[len];
        Queue<Integer> q = new LinkedList<>();
        for(int i: prices)
        	q.add(i);
        for(int i =0; i<len;i++) {
        	price = q.remove();
        	for(int j = i+1; j<len;j++) {
        		answer[i]++;
        		if(prices[j]<price)
        			break;      		
        	}
        }
        return answer;
    }
	public static int[] solution2(int[] prices) {
		int len = prices.length,price;
        int[] answer = new int[len];
        Stack<Integer> s = new Stack<>();
        for(int i = len-1; i>=0;i--)
        	s.push(prices[i]);
        for(int i =0; i<len;i++) {
        	price = s.pop();
        	for(int j = i+1; j<len;j++) {
        		answer[i]++;
        		if(prices[j]<price)
        			break;      		
        	}
        }
        return answer;
	}
}
