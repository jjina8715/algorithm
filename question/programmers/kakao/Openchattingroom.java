package practice;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Openchattingroom {

	public static void main(String[] args) {
		String[] ans = solution(new String[] {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"});
		for(String a:ans)
			System.out.println(a);
	}

	public static String[] solution(String[] record) {
		int len = record.length;
		String[] answer = null, rcd = null;
		HashMap<String, String> room = new HashMap<>();
		Queue<String[]> order = new LinkedList<>();
		StringBuilder sb = new StringBuilder();
		String come = "님이 들어왔습니다.", out = "님이 나갔습니다.";
		for(int i = 0; i<len;i++) {
			rcd = record[i].split(" ");
			if(!rcd[0].equals("Change"))
				order.add(new String[] {rcd[0], rcd[1]});
			if(!rcd[0].equals("Leave")) 
				room.put(rcd[1], rcd[2]);
		}
		len = order.size();
		answer = new String[len];
		for(int i = 0; i<len;i++) {
			rcd = order.remove();
			if(rcd[0].equals("Enter"))
				sb.append(room.get(rcd[1])).append(come);
			else if(rcd[0].equals("Leave"))
				sb.append(room.get(rcd[1])).append(out);
			answer[i] = sb.toString();
			sb.delete(0, sb.length());
		}
		return answer;
	}
}
