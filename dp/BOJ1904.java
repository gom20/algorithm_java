package dp;

import java.util.Scanner;

public class BOJ1904 {

    public static void main(String[] args) {
        // N = 1, 1
        // N = 2, 00, 11
        // N = 3, 100, 001, 111
        // N = 4, 1001, 0011, 1111, 0000, 1100

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] rs = new int[n+1];
        for(int i = 1; i <= n; i++){
            if(i == 1){
                rs[i] = 1;
                continue;
            }
            if(i == 2) {
                rs[i] = 2;
                continue;
            }
            rs[i] = (rs[i-1] + rs[i-2])%15746;
        }
        System.out.println(rs[n]);
    }
}
