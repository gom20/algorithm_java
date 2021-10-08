package fastcampus;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ11726 {

    public static int N;
    public static int[] cache;

    public static int func(int k){
        if(cache[k] != 0) return cache[k];

        if(k == 1){
            cache[1] = 1;
            return 1;
        }
        if(k == 2){
            cache[2] = 2;
            return 2;
        }
        cache[k] = (func(k-1) + func(k-2))%10007;

        return cache[k];
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        cache = new int[N+1];
        System.out.print(func(N)%10007);

    }
}
