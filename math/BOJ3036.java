package math;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ3036 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int first = Integer.parseInt(st.nextToken());
        for(int i = 1; i < N; i++){
            int ring = Integer.parseInt(st.nextToken());
            bw.write(getIrreducibleFraction(ring, first) + "\n");
        }
        bw.flush();
    }
    public static String getIrreducibleFraction(int num, int divisor){
        int gcd = getGCD(num, divisor);
        return divisor/gcd + "/" + num/gcd;
    }

    public static int getGCD(int a, int b){
        if(a < b){
           int temp = a;
           a = b;
           b = temp;
        }

        while(a%b != 0){
            int temp = a;
            a = b;
            b = temp%b;
        }
        return b;
    }
}
