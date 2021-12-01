package binarysearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ1300 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long k = Long.parseLong(br.readLine());

        long left = 1;
        long right = k;
        long ans = 0;

        while(left <= right){
            long mid = (left+right)/2;

            // mid 보다 작은 수가 k 개 이상이라면?
            if(count(mid, N) >= k){
                ans = mid;
                right = mid - 1;
            } else {
                // mid 보다 작은 수가 K개 미만이라면?
                left = mid + 1;
            }
        }
        System.out.println(ans);
    }

    public static int count(long mid, int N){
        // arr[i][j] = i * j 배열에서 mid 값보다 작은 숫자의 개수를 구한다.
        int cnt = 0;
        for(int i = 1; i <= N; i++){
            cnt += Math.min(mid/i, N);
        }
        return cnt;
    }
}
