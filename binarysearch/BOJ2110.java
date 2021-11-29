package binarysearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2110 {

    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 좌표의 수
        int C = Integer.parseInt(st.nextToken()); // 공유기의 수

        int[] houses = new int[N];
        for(int i = 0; i < N; i++){
            houses[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(houses);

        int left = 1; // 최소 인접 거리
        int right = houses[N-1] - houses[0]; // 최대 인접 거리

        int result = 0;
        while(left <= right){
            int mid = (left + right)/2;
            if(getPossibleCnt(houses, mid) >= C){
                // 공유기 더 많이 설치된다. 인접 거리 더 늘리자.
                result = Math.max(result, mid);
                left = mid+1;
            } else {
                // 공유기 설치 불가능. 인접 거리를 좁혀야 함.
                right = mid-1;
            }
        }

        System.out.println(result);

    }

    public static int getPossibleCnt(int[] houses, int diff){
        // 해당 인접 거리로 공유기 설치 시 가능한 설치 개수
        int possibleCnt = 1;
        int prev = houses[0];
        for(int i = 0; i < houses.length; i++){
            if(houses[i] - prev >= diff) {
                prev = houses[i];
                possibleCnt++;
            }
        }
        return possibleCnt;
    }
}
