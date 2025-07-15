class Solution {
    public int solution(int n, int w, int num) {
        int answer = 0;
        int h = n/w;    // 박스를 쌓은 높이
        h = n%w == 0 ? h : h+1;
        
        int[][] map = new int[h][w];
        for (int i=0; i<h; i++) {
            for (int j=0; j<w; j++) {
                // 홀수 열에는 순서대로 숫자 넣기
                if (i%2 == 0) map[i][j] = i*w + j+1;
                // 짝수 열은 반대로
                else map[i][j] = (i+1)*w - j;
            }
        }
        
        /*
        // output test
        for (int i=0; i<h; i++) {
                System.out.println (Arrays.toString(map[i]));
        }
        */
        
        int x=0; int y=0;
        Loop1:
        for (int i=0; i<h; i++) {
            Loop2:
            for (int j=0; j<w; j++) {
                if (map[i][j]==num) {
                    y = i;
                    x = j;
                    break Loop1;
                }
            }
        }
        
        // 박스 꺼내기
        for (int i=y; i<h; i++) {
            if (map[i][x] <= n) answer++;
        }
        
        return answer;
    }
}
