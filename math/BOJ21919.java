package math;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ21919 {

    public static int N;
    public static int[] arr;
    public static long ans;
    public static void input() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        ans = -1;
        for(int i = 0; i < N; i++){
            long num = Long.parseLong(st.nextToken());
            if(!isPrime(num)) continue;
            if(ans == -1){
                ans = num;
                continue;
            } else{
                ans = getLCM(ans, num);
            }
        }

    }

    public static long getLCM(long a, long b){
        int num = 0;
        // 최대 공약수
        // x > y  if x = yq + r -> GCD(x,y) = GCD(y,r)

        long big = 0, small = 0, nmg = 0, gcd = 0, lcm = 0;
        if(a >= b){
            big = a;
            small = b;
        } else {
            big = b;
            small= a;
        }

        while(true){
            nmg = big%small;

            if(nmg == 0){
                gcd = small;
                lcm = a*b/gcd;
                break;
            } else {
                big = small;
                small = nmg;
            }

        }
        return lcm;
    }

    public static boolean isPrime(long num){
        if(num == 2) return true;
        long mid = (long)Math.ceil(Math.sqrt(num));
        for(int i = 2; i <= mid; i++){
            if(num%i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) throws Exception{
        input();
        System.out.println(ans);


    }
}
