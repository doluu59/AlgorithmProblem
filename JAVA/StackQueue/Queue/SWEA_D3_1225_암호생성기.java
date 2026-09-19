package JAVA.StackQueue.Queue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class SWEA_D3_1225_암호생성기 {
 public static void main(String[] args) throws NumberFormatException, IOException {
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

  for (int tc=1; tc<=10; tc++) {
   int TC = Integer.parseInt(br.readLine());

   StringTokenizer st = new StringTokenizer(br.readLine(), " ");
   Deque<Integer> queue = new ArrayDeque<>();
   //input - queue 가장 뒤에 enqueue
   for (int i=0; i<8; i++) {
    queue.offerLast(Integer.parseInt(st.nextToken()));
   }
   loop:
   while (true) {
    for (int i=1; i<=5; i++) {
     int num = queue.pollFirst()-i;		//맨앞에서 dequeue한 후 연산
     if (num <= 0) {						//0보다 작아지면 무한 루프 탈출
      queue.offerLast(0);
      break loop;
     } else queue.offerLast(num);		//0보다 크면 그 수 그대로 넣고 마저 진행
    }
   }
   //output
   StringBuilder sb = new StringBuilder();
   sb.append("#"+tc+" ");
   for (int i=1; i<=8; i++) {
    sb.append(queue.pollFirst());
    if  (i==8) sb.append("\n");
    else sb.append(" ");
   }
   bw.write(sb.toString());
  }
  //close
  bw.flush();
  bw.close();
  br.close();
 }
}
