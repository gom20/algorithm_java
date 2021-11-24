package math;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ2981 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        // 오름차순으로 정렬
        Arrays.sort(arr);

        // 차이 값의 최대공약수 구하기
        int M = arr[1] - arr[0];
        for(int i = 2; i < N; i++){
            M = getGCD(M, arr[i]- arr[i-1]);
        }
        for(int i = 2; i <= M; i++){
            if(M%i == 0) sb.append(i).append(" ");
        }
        System.out.println(sb.toString());
    }

    public static int getGCD(int a, int b){
        //great common divisor 최대공약수
        if(b > a){
            int temp = a;
            a = b;
            b = temp;
        }

        while(b != 0){
            int r = a%b;
            a = b;
            b = r;
        }
        return a;
    }
}
