package math;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ21920 {

    public static int N, X;
    public static int[] arr;

    public static void input() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[N];
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        X = Integer.parseInt(br.readLine());
    }

    public static boolean isCoPrime(int a, int b){
        if(getGCD(a, b) == 1) return true;
        return false;
    }

    public static int getGCD(int a, int b){
        int big = 0, small = 0, gcd = 1;

        if(a >= b){
            big = a;
            small = b;
        } else {
            big = b;
            small = a;
        }

        while(true){
            int nmg = big%small;
            if(nmg== 0){
                gcd = small;
                break;
            } else {
                big = small;
                small = nmg;
            }
        }

        return gcd;
    }

    public static void main(String[] args) throws Exception{
        input();
        double total = 0;
        double count = 0;
        for(int i = 0; i < N; i++){
            if(isCoPrime(X, arr[i])){
//                System.out.print(arr[i] + " ");
                total += arr[i];
                count++;
            }
        }
        System.out.println(total/count);
    }
}
