package fastcampus;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ2579 {

    public static int N;
    public static int[] steps;
    public static int[][] dy;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        steps = new int[N+1];
        dy = new int[N+1][2];
        for(int i = 1; i <= N; i++){
            steps[i] = Integer.parseInt(br.readLine());

        }
        for(int i = 0; i <= N; i++){
            if(i == 0 || i == 1){
                dy[i][0] = steps[i];
                dy[i][1] = steps[i];
                continue;
            }
            dy[i][0] = steps[i] + dy[i-1][1];
            dy[i][1] = steps[i] + Math.max(dy[i-2][0], dy[i-2][1]);
        }

        System.out.println(Math.max(dy[N][0], dy[N][1]));

//        for(int i = 0; i < N; i++){
//            System.out.print(dy[i][0] + " ");
//        }
//        System.out.println();
//        for(int i = 0; i < N; i++){
//            System.out.print(dy[i][1] + " ");
//        }
    }

}
