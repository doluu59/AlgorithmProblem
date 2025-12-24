package JAVA._Practice;

import java.util.*;

 public class PG_lv1_예산 {
  public static void main(String[] args) {
  }

 class Solution {
  public int solution(int[] d, int budget) {
   int answer = 0;
   Arrays.sort(d);

   for (int department : d) {
    if (budget - department >= 0) {
     budget -= department;
     answer++;
    } else break;
   }
   return answer;
  }
 }
}
