package math;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class BOJ1934 {

    public static int N;

    public static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;
        for(int i = 0;i < N; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(a*b/getGCD(a, b)).append("\n");
        }
        System.out.print(sb.toString());
    }

    public static int getGCD(int a, int b){
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

    public static void main(String[] args) throws Exception {
        input();
    }
}
