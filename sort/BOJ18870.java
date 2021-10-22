package sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ18870 {

    public static int N;
    public static int[] arr, copy;
    public static HashMap<Integer, Integer> map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        map = new HashMap<Integer, Integer>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        copy = arr.clone();
        Arrays.sort(copy);

        int idx = 0;
        for(int i = 0; i < N; i++){
            if(map.containsKey(copy[i])) continue;
            map.put(copy[i], idx);
            idx++;
        }

        StringBuilder sb = new StringBuilder();
        for(int num : arr){
            sb.append(map.get(num) + " ");
        }
        System.out.println(sb.toString());
    }
}
