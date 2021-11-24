package divideconquer;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ11444 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());
        // (f(n+1) f(n)  ) = (1 1)n
        // (f(n)   f(n-1))   (1 0)

        long[][] ans = recur(N);
        System.out.println(ans[0][1]);

    }
    public static long[][] base = new long[][]{{1, 1}, {1, 0}};
    public static long[][] recur(long N){
        long[][] temp = null;
        if(N == 1) return base;
        if(N % 2 == 0){
            temp = recur(N/2);
            return multiply(temp, temp);
        } else {
            temp = recur((N-1)/2);
            return multiply(base, multiply(temp, temp));
        }
    }

    // 행렬 곱을 리턴한다.
    public static long div = 1000000007;
    public static long[][] multiply(long[][] a, long[][] b){
        long[][] answer = new long[2][2];

        // 반복문으로 행렬을 곱하거나
//        for(int i = 0; i < 2; i++){
//            for(int j = 0; j < 2; j++){
//                int ans = 0;
//                for(int w = 0; w < 2; w++){
//                    ans += (a[i][w]*b[w][j])%divisor;
//                }
//                answer[i][j] = ans%divisor;
//            }
//        }

        // 직접 곱하거나
        answer[0][0] = (a[0][0]*b[0][0] + a[0][1]*b[1][0])% div;
        answer[0][1] = (a[0][0]*b[0][1] + a[0][1]*b[1][1])% div;
        answer[1][0] = (a[1][0]*b[0][0] + a[1][1]*b[1][0])% div;
        answer[1][1] = (a[1][0]*b[0][1] + a[1][1]*b[1][1])% div;

        return answer;
    }

}
