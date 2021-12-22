package math;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ2485 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(br.readLine());
            min = Math.min(arr[i], min);
            max = Math.max(arr[i], max);
        }
        int[] interval = new int[N-1];
        for(int i = 0; i < N-1; i++){
            interval[i] = arr[i+1] - arr[i];
        }

        int gcd = getGCD(interval[0], interval[1]);
        for(int i = 2; i < N-1; i++){
            gcd = getGCD(gcd, interval[i]);
        }

        System.out.println(((max-min)/gcd)+1 - (arr.length));
    }

    public static int getGCD(int a, int b){
        // great common divisor
        if(a < b){
            int temp = b;
            b = a;
            a = temp;
        }

        while(b != 0){
            int r = a%b;
            a = b;
            b = r;
        }
        return a;
    }

}
