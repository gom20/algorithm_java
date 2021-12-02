package lis;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14002 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
        }

        int[] track = new int[N];
        int[] lis = new int[N];

        int lIdx = 0;
        lis[lIdx] = arr[0];
        track[0] = lIdx; // i번 째 숫자의 lIdx 인덱스를 저장

        for(int i = 1; i < N; i++){
            if(lis[lIdx] < arr[i]){
                lIdx++;
                lis[lIdx] = arr[i];
                track[i] = lIdx;
            } else {
                int lowerboundIdx = lowerbound(lis, lIdx, arr[i]);
                lis[lowerboundIdx] = arr[i];
                track[i] = lowerboundIdx;
            }
        }

        System.out.println(lIdx+1);

        StringBuilder sb = new StringBuilder();
        int tIdx = lIdx;
        for(int i = N-1; i >= 0; i--){
            if(track[i] == tIdx){
                sb.insert(0, arr[i] + " ");
                tIdx--;
            }
        }

        System.out.println(sb.toString());
    }

    public static int lowerbound(int[] lis, int lIdx, int num){
        // lowerbound의 index 리턴
        int left = 0;
        int right = lIdx;

        int ans = 0;
        while(left <= right){
            int mid = (left+right)/2;
            if(num <= lis[mid]){
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }
}
