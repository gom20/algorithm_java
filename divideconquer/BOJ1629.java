package divideconquer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1629 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        System.out.println(recur(a, b, c));
    }

    public static long recur(long a, long b, long c){
        if(a==1 || b==1) return a%c;
        a = a%c;
        if(b%2 == 0){
            return recur(a*a%c, b/2, c) % c;
        } else {
            return a * recur(a*a%c, b/2, c) % c;
        }
    }
}
