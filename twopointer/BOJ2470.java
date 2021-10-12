package twopointer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ2470 {

    public static int N;
    public static ArrayList<Integer> arr;
    public static int[] ans;

    public static void input() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        arr = new ArrayList<Integer>();
        ans = new int[3]; //0 min, 1 x, 2 y
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++){
            arr.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(arr);

    }
    public static void main(String[] args) throws Exception{
        input();
        ans[0] = Integer.MAX_VALUE;
        while(arr.size() >=2){
            int max = arr.get(arr.size()-1);
            int min = arr.get(0);
            if(Math.abs(max+min) < ans[0]){
                ans[0] = Math.abs(max+min);
                ans[1] = min;
                ans[2] = max;
            }

            if(max+min> 0){
                arr.remove(arr.size()-1);
            } else if (max+min < 0){
                arr.remove(0);
            } else {
                break;
            }
        }

        System.out.print(ans[1] + " " + ans[2]);

    }
}
