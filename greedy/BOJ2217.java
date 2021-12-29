package greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ2217 {

    static int[] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        int weight = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            weight = Math.max(weight, arr[i]*(N-i));
        }

        System.out.println(weight);


    }
}
