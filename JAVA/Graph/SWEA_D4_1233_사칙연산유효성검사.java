package JAVA.Graph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_D4_1233_사칙연산유효성검사 {
    static Node head;
    static List<Node> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int tc=1; tc<=10; tc++) {
            int N = Integer.parseInt(br.readLine());

            list = new ArrayList<>();
            for (int i=1; i<=N; i++) {
                list.add(addnode(br.readLine()));
            }

            int ans = bfs()?1:0;
            bw.write("#"+tc+" "+ans+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
    public static Node addnode(String line) {
        StringTokenizer st = new StringTokenizer(line, " ");
        int idx = Integer.parseInt(st.nextToken());
        char data = st.nextToken().charAt(0);
        int leftidx, rightidx;
        if (st.hasMoreTokens()) {
            leftidx = Integer.parseInt(st.nextToken());
            if (st.hasMoreTokens()) {
                rightidx = Integer.parseInt(st.nextToken());
            } else {
                rightidx = (Integer) null;
            }
        } else {
            leftidx = (Integer) null;
            rightidx = (Integer) null;
        }

        return new Node(idx, data, leftidx, rightidx);
    }

    public static boolean bfs() {
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(list.get(0));
        while (!queue.isEmpty()) {
            Node curNode = queue.poll();
            if (isComputable(curNode)) {
                queue.offer(list.get(curNode.left));
                queue.offer(list.get(curNode.right));
            } else {
                return false;
            }
        }

        return true;
    }

    public static boolean isComputable(Node node) {
        boolean rt;
        switch (node.data) {
            case '+': case '-': case '*': case '/':
                rt = (isComputable(list.get(node.left-1)) && isComputable(list.get(node.right-1)));
                break;
            default:
                if (node.left==(Integer) null&&node.right==(Integer) null) rt = true;
                else rt = false;
                break;
        }
        return rt;
    }

    static class Node {
        int index;
        char data;
        int left;
        int right;
        public Node(int index, char data, int left, int right) {
            this.index = index;
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
}