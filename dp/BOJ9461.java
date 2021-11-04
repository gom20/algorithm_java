package dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
public class BOJ9461 {

    public static int T;
    public static int N;
    public static long[] mem;
    public static void input() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        mem = new long[101];
        T = Integer.parseInt(br.readLine());
        for(int i = 0 ;i < T ; i++){
            N = Integer.parseInt(br.readLine());
            bw.write(dp(N) + "\n");
        }

        bw.flush();
    }

    public static long dp(int n){
        if(mem[n] != 0) return mem[n];
        for(int i = 1; i <= n; i++){
            if(mem[i] != 0) continue;
            if(i <= 3) {
                mem[i] = 1;
            } else if(i == 4 || i == 5) {
                mem[i] = 2;
            } else {
                mem[i] = mem[i-1] + mem[i-5];
            }
        }

        return mem[n];
    }

    public static void main(String[] args) throws Exception{
        input();
    }
}
