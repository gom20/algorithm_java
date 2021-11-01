package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11054 {

    public static int N;
    public static void pro() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[N+1];
        for(int i = 1; i <= N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // i번째 수 기준으로 왼쪽을 살펴보면서 오름차순 수의 최대 개수를 count
        int[] left = new int[N+1];
        for(int i = 1; i <= N; i++){
            if(i == 1) {
                left[i] = 0;
                continue;
            }
            int max = 0;
            boolean exist = false;
            for(int j = 1; j < i; j++){
               if(arr[i] > arr[j]){
                   max = Math.max(max, left[j]);
                   exist = true;
               }
            }

            left[i] = exist ? max + 1 : 0;
        }

        // 오른쪽도 반대로
        int[] right = new int[N+1];
        for(int i = N; i >= 1; i--){
            if(i == N) {
                right[i] = 0;
                continue;
            }
            int max = 0;
            boolean exist = false;
            for(int j = N; j > i; j--){
                if(arr[i] > arr[j]){
                    exist = true;
                    max = Math.max(max, right[j]);
                }
            }
            right[i] = exist ? max + 1 : 0;
        }

        int max = 0;
        for(int i = 1; i <= N; i++){
            max = Math.max(max, right[i]+left[i]);
        }

        System.out.println(max+1);
    }

    public static void main(String[] args) throws Exception {
        pro();
    }
}
