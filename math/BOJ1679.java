package math;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ1679 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int twoCnt = 0;
        int fiveCnt = 0;

        for(int i = 2; i <= N; i*=2){
             twoCnt+= N/i;
        }
        for(int i = 5; i <= N; i*=5){
             fiveCnt+= N/i;
        }

        System.out.println(twoCnt < fiveCnt ? twoCnt : fiveCnt);

    }

}
