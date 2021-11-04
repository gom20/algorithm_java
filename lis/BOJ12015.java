package lis;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ12015 {

    public static int N;
    public static int[] lis;
    public static int[] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        // 수열, LIS 저장할 배열 초기화
        lis = new int[N+1];
        arr = new int[N+1];

        //수열 저장
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int lisIdx = 1;
        // 첫 번째 원소를 넣는다.
        lis[lisIdx] = arr[1];

        // 수열을 순회하면서 lowerbound 값을 찾는다.
        for(int i = 2; i <= N; i++){
            // lis의 마지막 원소가 현재값 보다 작다면,
            // lis에는 현재 값의 lowerbound가 존재하지 않는다. 그러므로 그대로 넣어준다.
            if(lis[lisIdx] < arr[i]){
                lisIdx++;
                lis[lisIdx] = arr[i];
            } else {
               // lis배열에서 arr[i]의 lowerbound값에 해당하는 index를 찾는다.
               int idx = lowerbound(1, lisIdx, arr[i]);
               // 현재 값으로 치환
               lis[idx] = arr[i];
            }
        }
        System.out.println(lisIdx);

    }

    public static int lowerbound(int L, int R, int n){
        int mid = 0;
        while(L < R){
            mid = (L+R)/2;
            if(n <= lis[mid]) R = mid; // n 이상 값을 포함해야하므로 mid+1이 아니라 mid값을 취한다.
            else L = mid + 1;
        }
        return L;
    }
}
