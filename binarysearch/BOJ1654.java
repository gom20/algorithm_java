package binarysearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1654 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 이미 가지고 있는 랜선 K, 필요한 랜선 개수 N
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[] rans = new int[K];

        long left = 1;
        long right = 0;
        for(int i = 0; i < K; i++){
            rans[i] = Integer.parseInt(br.readLine());
            right = Math.max(right, rans[i]);
        }

        long ans = 1;
        while(left <= right){
            System.out.println("left: " + left + ", right: " + right);
            long mid = (left + right)/2;
            if(getCount(rans, mid) >= N){
                // mid 길이로 가지고 있는 랜선을 짤랐을 때, 필요한 랜선 개수 N이상 으로 나옴.
                // 더 길게 자르자
                ans = mid;
                left = mid + 1;
            } else {
                // mid 길이로 가지고 있는 랜선을 짤랐을 때, 필요한 랜선 개수 N 미만으로 나옴.
                // 더 짧게 자르자
                right = mid -1;

            }
        }
        System.out.println(ans);
    }

    public static int getCount(int[] rans, long mid){
        int cnt = 0;
        for(int i = 0; i < rans.length; i++){
            cnt += rans[i]/mid;
        }
        return cnt;
    }
}
