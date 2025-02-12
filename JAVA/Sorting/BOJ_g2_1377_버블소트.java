package JAVA.Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @from BOJ
 * @index 1377
 * @title 버블 소트
 * @grade Gold 2
 * @classification 정렬 (버블 소트)
 * @solve 버블 소트가 몇 번의 반복 만에 끝났는 지를 묻고 있다.
 *        key - 숫자 하나를 정렬할 때, 나머지 수는 최대 1번 움직임.
 *        그래서 숫자 중에 가장 많이 움직인 숫자를 찾아야 함.
 *        * 근데 우선 순위 큐랑 그냥 정렬을 정렬할 때 모두 Comparator를 똑같이 했는데
 *        우선 순위 큐는 중복되는 수를 처리를 못할까?
 */
public class BOJ_g2_1377_버블소트 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 정렬이 끝날 때까지 총 몇 개의 수가 움직였는지를 구해야 함.
        // how?
        // 가장 큰 수를 가장 오른쪽으로 옮기는 동안 나머지 데이터는 index-1만 됨.
        // 정렬 후에 인덱스가 가장 많이 움직인 것을 찾으면 됨
        Data[] arr = new Data[n];
        for (int i=0; i<n; i++) {
            arr[i] = new Data(Integer.parseInt(br.readLine()), i);
        }

        // sort
        Arrays.sort(arr, new Comparator<Data>() {
            @Override
            public int compare(Data o1, Data o2) {
                return o1.value-o2.value;
            }
        });

        // index가 움직인 양 찾기
        int max = Integer.MIN_VALUE;
        for (int i=0; i<n; i++) {
//            System.out.println(cur.value + " " + cur.indexBefore + " " + i);
            if (arr[i].index - i > max) max = arr[i].index - i;
        }

        // output
        System.out.println(max+1);
    }

    public static class Data {
        int value, index;

        public Data(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }
}
