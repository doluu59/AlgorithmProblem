package JAVA.Sorting;

/**
 * @from Programmers
 * @index High Score Kit
 * @title K번째 수
 * @grade Level 1
 * @classification Sorting
 * @solve java sorting 메서드 활용. 배열을 잘라서 정렬
 */
import java.util.*;

public class PG_lv1_K번째수 {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int n=0; n<commands.length; n++) {
            int i = commands[n][0];
            int j = commands[n][1];
            int k = commands[n][2];

            // cut arr
            int[] curArr = new int[j-i+1];
            for (int m = 0; m < curArr.length; m++) {
                curArr[m] = array[m+i-1];
            }

            // sort
            Arrays.sort(curArr);

            // get k num
            answer[n] = curArr[k-1];
        }

        return answer;
    }
}