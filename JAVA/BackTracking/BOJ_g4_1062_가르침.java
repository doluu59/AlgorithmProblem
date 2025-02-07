package JAVA.BackTracking;

/**
 * @from BOJ
 * @index 1062
 * @title 가르침
 * @grade Gold 4
 * @classification 백트래킹
 * @solve
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_g4_1062_가르침 {
    static int N, K;
    //	static
    static int MaxReadCnt = Integer.MIN_VALUE;
    static String[] words;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        words = new String[N];
        for (int i=0; i<N; i++) {
            words[i] = br.readLine();
        }
        int isLearned = 0;
        //a n t i c 을 먼저 방문한 걸로...
        isLearned = isLearned | 1<<'a'-'a';
        isLearned = isLearned | 1<<'n'-'a';
        isLearned = isLearned | 1<<'t'-'a';
        isLearned = isLearned | 1<<'i'-'a';
        isLearned = isLearned | 1<<'c'-'a';

        //k<5면 못배움
        if (K<5) {
            MaxReadCnt = 0;
        } else {
            //알파벳Ck 조합으로 (알파벳에서 antic 뺴고 k는 5뺴고) 만큼 조합 돌아
            chooseAlpha(0, 0, isLearned);
        }
        //output
        bw.write(Integer.toString(MaxReadCnt));
        //close
        bw.flush();
        bw.close();
        br.close();
    }
    //알파벳 전체 중에서 a c i n t 빼고 나머지 문자들 중에서 k-5개 만큼 뽑기
    private static void chooseAlpha(int cnt, int idx, int isLearned) {
        if (cnt == K-5) {
            //조합 골랐으면, 이제 배운 알파벳으로 몇개나 읽나 세보기
            readWord(isLearned);
            return;
        }
        if (idx==26) return;
//		for (int i=idx; i<26; i++) {
        switch(idx) {
            case 'a'-'a': case 'c'-'a': case 'i'-'a': case 'n'-'a': case 't'-'a':
                chooseAlpha(cnt, idx+1, isLearned);
                break;
            default:
                isLearned = isLearned | 1<<idx;		//알파벳 선택 마킹
                chooseAlpha(cnt+1, idx+1, isLearned);			//이번 알파벳 선택 했을 때
                isLearned = isLearned & ~(1<<idx);
                chooseAlpha(cnt, idx+1, isLearned);			//이번 알파벳 선택 안했을 때
                break;
        }
//		}
    }
    //읽을 수 있는 알파벳이 정해지면 단어 개수만큼 읽으면서 읽을 수 있는 단어 개수 세고 최대값 갱신
    private static void readWord(int isLearned) {
        int readCnt=0;
        for (int n=0; n<N; n++) {						//총 단어 N개 읽기, n: 현재 몇번째 단어인지
            boolean canRead = true;
            for (int i=0; i < words[n].length(); i++) { 		//현재 단어에서 단어 길이만큼 알파벳 비교, i: 현재 단어에서 몇번째 알파벳인지
                if(( isLearned & (1<<(words[n].charAt(i)-'a')) ) != 0 ) {
                    continue;
                } else {	//배운 알파벳 중에 현재 단어에서 읽은 알파벳이 없을 때
                    canRead = false;
                    break;
                }
            }
            if (canRead) readCnt++;
        }
        if (readCnt > MaxReadCnt) MaxReadCnt=readCnt;	//최대값 갱신
    }

}