package divideconquer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1780 {

    public static int pOneCnt, zeroCnt, nOneCnt;
    public static int[][] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int N = Integer.parseInt(br.readLine());
        arr = new int[N+1][N+1];
        pOneCnt = 0;
        nOneCnt = 0;
        zeroCnt = 0;
        for(int i = 1; i <= N; i++){
           st = new StringTokenizer(br.readLine());
           for(int j = 1; j <= N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
           }
        }

        divide(1, 1, N);
        System.out.println(nOneCnt);
        System.out.println(zeroCnt);
        System.out.println(pOneCnt);
    }

    private static void divide(int x, int y, int N){
        int tempOneCnt = 0;
        int tempZeroCnt = 0;
        for(int i = x;  i < x+N; i++ ){
            for(int j = y; j < y+N; j++){
                if(arr[i][j] == 1){
                    tempOneCnt++;
                } else if (arr[i][j] == 0){
                    tempZeroCnt++;
                } else {

                }
            }
        }
        if(tempOneCnt == N*N){
            pOneCnt++;
        } else if(tempZeroCnt == N*N){
            zeroCnt++;
        } else if(tempOneCnt == 0 && tempZeroCnt == 0){
            nOneCnt++;
        } else {
            divide(x, y, N/3); // up-left
            divide(x,y+N/3, N/3); // up-center
            divide(x,y+2*(N/3), N/3); // up-right

            divide(x+N/3, y, N/3); // left
            divide(x+N/3,y+N/3, N/3); // center
            divide(x+N/3,y+2*(N/3), N/3); // right

            divide(x+2*(N/3), y, N/3); // down-left
            divide(x+2*(N/3),y+N/3, N/3); // center
            divide(x+2*(N/3), y+2*(N/3), N/3); //down-right
        }

    }
}
