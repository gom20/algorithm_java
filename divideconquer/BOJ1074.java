package divideconquer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1074 {

    static int N, R, C, answer;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        // 2^N * 2^N 행렬

        divide(0, 0, (int)Math.pow(2, N));
    }

    public static int[][] order = {{0, 0}, {0, 1}, {1, 0}, {1, 1}};
    public static void divide(int x, int y, int n){
        if(n > 2){
            int quarterSpace = getQuarterSpace(x, y, n);
            if(quarterSpace == 1){
                divide(x, y, n/2); // up left 1
            } else if(quarterSpace == 2){
                answer += Math.pow(n, 2)*((double)1/4);
                divide(x, y+n/2, n/2); // up right 2
            }else if(quarterSpace == 3){
                answer += Math.pow(n, 2)*((double)2/4);
                divide(x+n/2, y, n/2); // down left 3
            } else {
                answer += Math.pow(n, 2)*((double)3/4);
                divide(x+n/2, y+n/2, n/2); // down right 4
            }
        } else {
//            System.out.println(x + ", " + y);
            for(int[] o : order){
                int r = x + o[0];
                int c = y + o[1];
                if(r == R && c == C){
                    System.out.println(answer);
                    System.exit(0);
                }
                answer++;
            }
        }
    }

    public static int getQuarterSpace(int x, int y, int n){
        int rs = 0;
        if(R >= x && R < x+n/2 && C >= y && C < y+n/2) rs = 1;
        if(R >= x && R < x+n/2 && C >= y+n/2 && C < y+n/2+n/2) rs = 2;
        if(R >= x+n/2 && R < x+n/2+n/2 && C >= y && C < y+n/2) rs = 3;
        if(R >= x+n/2 && R < x+n/2+n/2 && C >= y+n/2 && C < y+n/2+n/2) rs = 4;
        return rs;
    }
}
