import java.util.*; 

class Solution {
    public int[][] delta = { {0, 1}, {1, 0}, {0, -1}, {-1, 0} };
    public int[][] map;
    public int y1, x1, y2, x2;
    public int[] solution(int rows, int columns, int[][] queries) {
        // input
        int idx = 0;
        map = new int[rows][columns];
        for (int i=0; i<rows; i++) {
            for (int j=0; j<columns; j++) {
                map[i][j] = ++idx;
            }
        }
        
        int[] answer = new int[queries.length];
        // rotation
        // idea: 시계 방향으로 숫자를 Queue에 담고, 시작점을 한칸 옆으로 옮긴 뒤 큐에서 꺼내기
        for (int q=0; q<queries.length; q++) {
            answer[q] = rotate(queries[q]);
        }
        
        return answer;
    }
    
    // 회전을 시킨 후, 최소값 반환
    public int rotate(int[] query) {
        int min = Integer.MAX_VALUE;
        Queue<Integer> queue = new ArrayDeque<>();
        y1 = query[0]-1; y2 = query[2]-1;
        x1 = query[1]-1; x2 = query[3]-1;
        
        // Queue에 숫자들 넣기
        queue.offer(map[y1][x1]);
        int i=y1; int j=x1; int d = 0;
        while(true) {
            // 현재 진행 방향 대로 다음 숫자 확인
            int ni = i + delta[d][0];
            int nj = j + delta[d][1];
            // 반복 종료 조건 (맨 처음 숫자)
            if (ni == y1 && nj == x1) break;
            // 범위 벗어나면 회전 방향 바꾸기
            if (isValid(ni, nj)) {
                i = ni; j = nj;
                queue.offer(map[i][j]);
            } else {
                d++;
            }
        }
        
        // 회전 시키기
        i = y1; j = x1; d=0;
        while(!queue.isEmpty()) {
            // 시작 점의 다음 점부터 차례대로 Queue에 넣은 숫자 주기
            int ni = i + delta[d][0];
            int nj = j + delta[d][1];
            if (isValid(ni, nj)) {
                i = ni; j = nj;
                min = Math.min(min, queue.peek());
                map[i][j] = queue.poll();
            } else {        // 범위 벗어나면 회전 방향 바꾸기
                d++;
            }
        }
        return min;
    }
    
    public boolean isValid(int i, int j) {
        return y1 <= i && i <= y2 && x1 <= j && j <= x2;
    }
}
