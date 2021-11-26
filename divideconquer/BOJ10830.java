package divideconquer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ10830 {

    public static int N;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        long[][] arr = new long[N][N];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                arr[i][j] = Long.parseLong(st.nextToken());
            }
        }

        long[][] answer = pow(arr, B);
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                System.out.print(answer[i][j]%1000 + " ");
            }
            System.out.println();
        }

    }

    public static long[][] pow(long[][] base, long B){
        if(B == 1) return base;
        long[][] temp = null;
        if(B % 2 == 0) {
            temp = pow(base, B/2);
            return multiply(temp, temp);
        } else {
            temp = pow(base,(B-1)/2);
            return multiply(base, multiply(temp, temp));
        }
    }

    public static long[][] multiply(long[][] arr1, long[][] arr2){
        long[][] answer = new long[N][N];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                long ans = 0;
                for(int k = 0; k < N; k++){
                    ans += arr1[i][k]*arr2[k][j]%1000;
                }
                answer[i][j] = ans%1000;
            }
        }
        return answer;
    }
}
