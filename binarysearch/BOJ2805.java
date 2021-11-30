package binarysearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2805 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 나무의 수
        long M = Long.parseLong(st.nextToken()); // 필요한 나무의 길이

        long[] tree = new long[N];

        long left = 0;
        long right = 0;
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            tree[i] = Long.parseLong(st.nextToken());
            right = Math.max(right, tree[i]);
        }
        Arrays.sort(tree);

        long answer = 0;
        while(left <= right){
            long mid = (left+right)/2;
            if(getMeter(mid, tree) >= M){
                // 자른 나무길이가 필요한 나무 길이보다 같거나 큰 경우
                // H를 높여서 덜 잘라야 함
                answer = Math.max(mid, answer);
                left = mid+1;
            } else {
                // 자른 나무길이가 필요한 나무 길이보다 작은 경우
                // H를 낮춰서 더 많이 잘라야 함
                right = mid-1;
            }
        }
        System.out.println(answer);
    }
    public static long getMeter(long H, long[] tree){
        long ans = 0;
        for(int i = tree.length-1; i >= 0; i--){
            long t = tree[i];
            if(t <= H) break;
            ans += (t-H);
        }
        return ans;
    }
}
