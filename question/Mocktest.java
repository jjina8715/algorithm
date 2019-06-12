package practice;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Mocktest {

	public static void main(String[] args) {
		int[] answers = {4, 4, 4, 5, 1};
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
	        for(int[] i : grades)
	        	System.out.println(i[0]+" "+i[1]);
	        if(grades[1][1]>grades[0][1]&&grades[1][1]>grades[2][1])
	        	swap(grades, 1,2);
	        else if(grades[2][1]>grades[0][1]&&grades[2][1]>grades[1][1])
	        	swap(grades, 1,3);
	        if(grades[2][1]>grades[1][1])
	        	swap(grades, 2,3);
	       
	        if(grades[0][1]>grades[1][1]) {
	        	answer = new int[1];
	        	answer[0] = grades[0][0];
	        }else if(grades[1][1]>grades[2][1]) {
	        	answer = new int[2];
	        	answer[0] = grades[0][0];
	        	answer[1] = grades[1][0];
	        }else {
	        	answer = new int[3];
	        	answer[0] = grades[0][0];
	        	answer[1] = grades[1][0];
	        	answer[2] = grades[2][0];
	        }
	       
	        return answer;
	    }
	   public static int scoring(int[] answers, int[] method) {
		   int grade = 0, len=method.length;
		   for(int i = 0; i<answers.length;i++) 
			   if(answers[i]==method[i%len])
				   grade++;
		   
		   return grade;
	   }
	   public static void swap(int[][] grades, int i, int j) {
		   int temp;
		   temp = grades[i-1][0];
		   grades[i-1][0] = grades[j-1][0];
		   grades[j-1][0] = temp;
		   temp = grades[i-1][1];
		   grades[i-1][1] = grades[j-1][1];
		   grades[j-1][1] = temp;
	   }
}
