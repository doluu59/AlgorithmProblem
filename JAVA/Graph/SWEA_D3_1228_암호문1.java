package JAVA.Graph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SWEA_D3_1228_암호문1 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        //TC 반복
        for (int tc=1; tc<=10; tc++) {
            Node head = new Node(0, null);	//head
            // 원본 암호문 개수 Input
            int N = Integer.parseInt(br.readLine());
            // 원본 암호문 Input
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int i=0; i<N; i++) {
                int data = Integer.parseInt(st.nextToken());
                push(data, head);
            }
            //명령어 개수
            int Inum = Integer.parseInt(br.readLine());
            //명령어 하나 당
            st = new StringTokenizer(br.readLine(), "I ");
            for (int i=0; i<Inum; i++) {
                int index = Integer.parseInt(st.nextToken());		//1
                int insertNum = Integer.parseInt(st.nextToken());	//5
                Node prev = find(index, head);
                for (int in=0; in< insertNum; in++) {
                    Node next = prev.link;
                    // 새로운 노드를 이전 인덱스의 링크로 연결, 새로운 노드의 링크는 원래 노드의 링크
                    Node newnode = new Node(Integer.parseInt(st.nextToken()), next);
                    prev.link = newnode;
                    //새로운 노드를 직전 노드로 변경 => 반복문 돌때마다 뒤로 삽입
                    prev = newnode;

                }
            }

            //output
            sb.append("#"+tc+" ");
            Node temp = head;
            for (int i=0; i<10; i++) {
                sb.append(temp.link.data);
                if (i!=9) sb.append(" ");
                else sb.append("\n");
                temp = temp.link;
            }

        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static void push(int data, Node prev) {
        Node newnode = new Node(data, null);
        if (prev.link == null) {
            prev.link = newnode;
            return;
        }

        Node temp = prev;
        while (temp.link != null) {
            temp = temp.link;
        }
        temp.link = newnode;
    }

    static Node find(int index, Node head) {
        Node temp = head;
        for (int i=0; i<index; i++) {
            //index번째 노드 찾아서 링크를 바꿔줌
            temp = temp.link;

        }
        return temp;
    }

    static class Node {
        int data;
        Node link;
        Node(int data, Node link) {
            this.data = data;
            this.link = link;
        }
    }
}


