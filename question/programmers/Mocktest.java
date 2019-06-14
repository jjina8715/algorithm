package practice;

import java.util.LinkedList;

public class Mocktest {

	public static void main(String[] args) {
		int[] answers = {2,3,4,1,5,2,1,3,2,4,2,1,1,2,4,5,3,2,5,1,2,2,3,2,};
		//int[] answers = {1,3,2,4,2};
		for(int i: solution(answers)) {
			System.out.println(i+" ");
		}
	}
	   public static int[] solution(int[] answers) {
	        int[] answer = {};
	        int[][] method= {
	        		{1, 2, 3, 4, 5},
	        		{2, 1, 2, 3, 2, 4, 2, 5},
	        		{3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
	        };
	        int len = method.length;
	        int[][] grades = new int[3][2];
	        for(int i= 0; i<len;i++) { 
	        	grades[i][0]=i+1;
	        	grades[i][1]=scoring(answers, method[i]); 	
	        }

	        int max = Math.max(grades[0][1], Math.max(grades[1][1], grades[2][1]));        
	        LinkedList<Integer> list = new LinkedList<Integer>();
	        for(int[] i : grades)
	        	if(i[1]==max)list.add(i[0]);
	        answer = new int[list.size()];
	        for(int i = 0; i<list.size();i++)
	        	answer[i] = list.get(i);
	        return answer;
	    }
	   public static int scoring(int[] answers, int[] method) {
		   int grade = 0, len=method.length;
		   for(int i = 0; i<answers.length;i++) 
			   if(answers[i]==method[i%len])
				   grade++;
		   
		   return grade;
	   }

}
