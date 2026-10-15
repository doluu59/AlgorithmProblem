package JAVA._Practice;

/**
 * [PG] PCCE. 8번 (lv0)
 * @category Algorithm / Simulation
 * @implNote
 * - 문제 요약   : 
 * - 풀이 전략   : 
 * - 시간 복잡도 : O()
 *
 * @see      <a href="">Problem Link</a>
 * @author   ysyoo
 * @since    26. 9. 26.
 */
 
public class PG_lv0_PCCE_8번_창고정리 {
	public static void main(String[] args){
	}
	class Solution {
		public String solution(String[] storage, int[] num) {
			int num_item = 0;
			String[] clean_storage = new String[storage.length];
			int[] clean_num = new int[num.length];

			for(int i=0; i<storage.length; i++){
				int clean_idx = -1;
				for(int j=0; j<num_item; j++){
					if(storage[i].equals(clean_storage[j])){
						clean_idx = j;
						break;
					}
				}
				if(clean_idx == -1){
					clean_storage[num_item] = storage[i];
					clean_num[num_item] = num[i];
					num_item += 1;
				}
				else{
					clean_num[clean_idx] += num[i];
				}
			}

			int num_max = -1;
			String answer = "";
			for(int i=0; i<num_item; i++){
				if(clean_num[i] > num_max){
					num_max = clean_num[i];
					answer = clean_storage[i];
				}
			}
			return answer;
		}
	}
}
