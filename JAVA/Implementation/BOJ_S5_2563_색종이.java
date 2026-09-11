package JAVA.Implementation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_S5_2563_색종이 {
    static final int LEN = 10;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());	//색종이 수
        boolean[][] paper = new boolean[100][100];	//전체 종이 크기
        for (int n=0; n<N; n++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            ColorPaper cp = new ColorPaper(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));	//색종이 하나
            //색종이를 종이에 붙이기
            for (int i=cp.y; i<cp.y+10; i++) {
                for (int j=cp.x; j<cp.x+10; j++) {
                    if (!paper[i][j]) paper[i][j] = true;
                }
            }
        }
        //칠해진 면 count
        int count=0;
        for (int i=0; i<100; i++) {
            for (int j=0; j<100; j++) {
                if (paper[i][j]) count++;
            }
        }
        //output
        bw.write(Integer.toString(count));
        //close
        bw.flush(); bw.close(); br.close();
    }
}
class ColorPaper {
    int x;
    int y;
    public ColorPaper(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
