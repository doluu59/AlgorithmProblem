package JAVA._Practice;

import java.util.*;

public class PG_lv0_기초_할일목록 {
	public static void main(String[] args){
	}
	class Solution {
		public String[] solution(String[] todo_list, boolean[] finished) {

			List<String> list = new ArrayList<>();
			for (int i=0; i<todo_list.length; i++) {
				if (!finished[i]) list.add(todo_list[i]);
			}

			String[] answer = new String[list.size()];
			for (int i=0; i<list.size(); i++) {
				answer[i] = list.get(i);
			}
			return answer;
		}
	}
}
