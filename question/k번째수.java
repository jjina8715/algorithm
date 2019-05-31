package practice;

import java.util.Arrays;

public class k¹øÂ°¼ö {
	public static void main(String args[]) {
		int[] arr = {1, 5, 2, 6, 3, 7, 4};
		int[][] commands= {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
		int[] temp = solution2(arr, commands);
		for(int data:temp)
			System.out.print(data + " ");
	}
	 public static int[] solution(int[] array, int[][] commands) {
	        int[] answer = new int[commands.length];
	        int[] temp = null;
	        int sta, end;
	        for(int i = 0; i<commands.length;i++) {
	        	sta = commands[i][0]-1;
	        	end = commands[i][1]-1;
	        	temp = Arrays.copyOfRange(array, sta, end+1);
	        	Arrays.sort(temp); 
	        	answer[i] = temp[commands[i][2]-1];
	        }
	        return answer;
	   }
	 public static int[] solution2(int[] array, int[][] commands) {
	        int[] answer = new int[commands.length];
	        int[] temp = null;
	        int sta, end, min, tmp;
	        for(int i = 0; i<commands.length;i++) {
	        	sta = commands[i][0]-1;
	        	end = commands[i][1]-1;
	        	temp = new int[end-sta+1];
	        	for(int j = 0; j<temp.length;j++) 
	        		temp[j] = array[j+sta];
	        	for(int k = 0; k<temp.length-1;k++) {
	        		min = k;
	        		for(int l = k+1; l<temp.length;l++) 
	        			if(temp[min]>temp[l]) min = l;
	        		if(min!=k) {
	        			tmp=temp[min];
	        			temp[min]=temp[k];
	        			temp[k]=tmp;
	        		}
	        	}
	        	answer[i] = temp[commands[i][2]-1];
	        }
	        return answer;
	    }
}

