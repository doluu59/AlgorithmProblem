package JAVA.PermutationCombination.Permutation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_D3_6808_규영이와인영이의카드게임 {
    static final int CNT = 9;
    static int[] me, op, permed;
    static int flag;
    static int win, lose;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int TC = Integer.parseInt(br.readLine());
        for (int tc=1; tc<=TC; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            op = new int[CNT];
            permed = new int[CNT];
            me = new int[CNT];
            flag = 0;
            win=0;
            lose=0;
            //내가 낼 카드 순서
            for (int i=0; i<CNT; i++) {
                me[i] = Integer.parseInt(st.nextToken());
            }
            //상대 카드 뽑기
            int myIdx=0;
            int opIdx=0;
            //정렬된 크기
            int[] temp = Arrays.copyOf(me, CNT);
            Arrays.sort(temp);
            //18까지 올리면서 규영이 아닌 애는 배열에 넣어주기
            for (int n=1; n<=18; n++) {
                if (myIdx<9 && temp[myIdx]==n) myIdx++;	//
                else op[opIdx++]=n;
            }
            //permutation
            perm(0, flag);
            //output
            bw.write("#"+tc+" "+win+" "+lose+"\n");
        }
        //close
        bw.flush(); bw.close(); br.close();
    }
    //순열 만들어서 경우당 하나씩 승리 패턴 고르기
    private static void perm(int count, int flag) {
        //순열 완성되면
        if (count==CNT) {
            int mypoint=0; int oppoint=0;
            //9라운드 동안 대결
            for (int i=0; i<count; i++) {
                if (me[i]>permed[i]) mypoint = mypoint + me[i] + permed[i];
                else oppoint = oppoint + me[i] + permed[i];
            }
            // 승패 카운트
            if (mypoint > oppoint) win++;
            else if (mypoint < oppoint) lose++;
            return;
        }
        //순열 만들기
        for (int i=0; i<CNT; i++) {
            if ( (flag & 1<<i) != 0 ) continue;
            permed[count] = op[i];
            perm(count+1, flag | 1<<i);
        }
    }
}
