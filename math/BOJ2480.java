package math;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2480 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[3];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 3; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int reword = 0;
        Arrays.sort(arr);
        if(arr[0] == arr[1]){
            if(arr[1] == arr[2]){
                reword = arr[2]*1000 + 10000;
            } else {
                reword = arr[1]*100 + 1000;
            }
        } else {
            if(arr[1] == arr[2]){
                reword = arr[1]*100 + 1000;
            } else {
                reword = arr[2]*100;
            }
        }
        System.out.println(reword);
    }

}
