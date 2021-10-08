package fastcampus;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ9095 {

    public static int T, N;

    public static int func(int k){
        if(k == 1){
            return 1;
        }
        if(k == 2){
            return 2;
        }
        if(k == 3){
            return 4;
        }
        return func(k-1) + func(k-2) + func(k-3);
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++){
            System.out.println(func(Integer.parseInt(br.readLine())));
        }

    }
}
