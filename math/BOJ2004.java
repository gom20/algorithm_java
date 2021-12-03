package math;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2004 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // nCm = n!/(n-m)!m!
        int twoCnt = twoCnt(n) - (twoCnt(n-m) + twoCnt(m));
        int fiveCnt = fiveCnt(n) - (fiveCnt(n-m) + fiveCnt(m));

        System.out.println(twoCnt > fiveCnt ? fiveCnt : twoCnt);

    }

    public static int twoCnt(int n){
        int cnt = 0;
        while(n >= 2){
            cnt += n/2;
            n = n/2;
        }
        return cnt;

    }
    public static int fiveCnt(int n){
        int cnt = 0;
        while(n >= 5){
            cnt += n/5;
            n = n/5;
        }
        return cnt;
    }

}
