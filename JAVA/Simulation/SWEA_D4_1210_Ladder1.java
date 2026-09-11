package JAVA.Simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SWEA_D4_1210_Ladder1 {
 static StringBuilder sb = new StringBuilder();
 static final int MAP_SIZE = 100;
 static int[][] map = new int[MAP_SIZE][MAP_SIZE];
 public static void main(String[] args) throws NumberFormatException, IOException {
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  //첫줄은 tc 번호, TC는 열개

  for (int tc=1; tc<=10; tc++) {
   sb.delete(0, sb.length());
   sb.append("#"+br.readLine()+" ");
   //사다리 map input
   for (int i=0; i<MAP_SIZE; i++) {
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    for (int j=0; j<MAP_SIZE ; j++) {
     map[i][j] = Integer.parseInt(st.nextToken());
    }
   }

   int xpoint = 0;
   //출발지점에서 사다리 타기를 시작하여 도착지를 찾으면 true 반환
   for (int j=0; j<MAP_SIZE; j++) {
    if (map[MAP_SIZE-1][j]==2) {
     xpoint = j;
     break;
    }
   }

   LadderGame(MAP_SIZE-2, xpoint);
   //tc별 output
   bw.write(sb.toString());
  }

  //close
  br.close();
  bw.close();
 }

 private static void LadderGame(int y, int x) {
  //출발지 까지 왔다면 x좌표 찍고 종료
  if (y==0) {
   sb.append(x+"\n");
   return;
  }

  //다음 x 좌표
  int nx = x;

  //왼쪽으로 가기
  if (x-1>=0 && map[y][x-1]==1) {
   for(; nx > 0;) {
    if (nx-1<0 || map[y][nx-1] == 0) break;
    else nx--;
   }
  }
  //오른쪽으로 가기
  else if (x+1<MAP_SIZE && map[y][x+1]==1) {
   for(; nx < MAP_SIZE;) {
    if (nx+1>=MAP_SIZE || map[y][nx+1] == 0) break;
    else nx++;
   }
  }
  //위로 가기
  else {
   nx= x;
  }
  LadderGame(y-1, nx);
 }
}
