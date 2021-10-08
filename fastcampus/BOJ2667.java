package fastcampus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class BOJ2667 {

    public static int N, count;
    public static int arr[][];
    public static ArrayList<Integer> result;

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        for(int i = 0; i < N; i++){
             char[] charArr = br.readLine().toCharArray();
             for(int j = 0; j < N; j++){
                 arr[i][j] = Integer.parseInt(String.valueOf(charArr[j]));
             }
        }
        result = new ArrayList<Integer>();
    }

    public static void dfs(int x, int y){
        if(x >= N || y >= N || x < 0 || y < 0) return;
        if(arr[x][y] == -1 || arr[x][y] == 0) return;
        arr[x][y] = -1;
        count++;
        dfs(x, y+1);
        dfs(x, y-1);
        dfs(x+1, y);
        dfs(x-1, y);

    }

    public static void main(String[] args) throws Exception {
        input();
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(arr[i][j] == -1 || arr[i][j] == 0) continue;
                dfs(i, j);
                result.add(count);
                count = 0;
            }
        }

        Collections.sort(result);
        System.out.println(result.size());
        for(Integer number : result){
            System.out.println(number);
        }
    }

}
