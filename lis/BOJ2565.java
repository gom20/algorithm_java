package lis;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ2565 {

    public static int[][] arr;
    public static int[] temp;
    public static int N;
    public static void main(String[] args) throws Throwable {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][2];
        temp = new int[N];
        StringTokenizer st = null;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                return o1[0] - o2[0];
            }
        });

        int idx = 0;
        temp[idx] = arr[idx][1];
        for(int i = 1; i < N; i++){
            if(temp[idx] < arr[i][1]){
                idx++;
                temp[idx] = arr[i][1];
                continue;
            }
            temp[lowerbound(0, idx, arr[i][1])] = arr[i][1];
        }

        System.out.println(N - (idx + 1)); //idx 0부터 데이터가 있으므로
    }

    public static int lowerbound(int L, int R, int num){
        // temp배열에서 num의 lowerbound를 찾아서 index를 리턴
        int mid = 0;
        while(L < R){
            mid = (L+R)/2;
            if(num <= temp[mid]) R = mid;
            else L = mid+1;
        }
        return R;
    }
}
