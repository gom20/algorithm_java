package bruteforce;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ2529 {

    public static String[] arr;
    public static boolean[] visited;
    public static long K, min, max;
    public static String minstr, maxstr;
    public static Stack<Integer> selected;
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        arr = new String[N];
        K = N;
        StringTokenizer st= new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = st.nextToken();
        }
        minstr = "";
        maxstr = "";
        min = Long.MAX_VALUE;
        max = Long.MIN_VALUE;
        visited = new boolean[10];
        selected = new Stack<Integer>();
        for(int i = 0; i <= 9; i++){
            selected.push(i);
            visited[i] = true;
            recur(i, 0, String.valueOf(i));
            selected.pop();
            visited[i] = false;
        }

        bw.write(maxstr + "\n");
        bw.write(minstr + "\n");
        bw.flush();
    }
    public static void recur(int prev, int k, String s){
        if(k == K){
            if(max < Long.parseLong(s)){
                max = Long.parseLong(s);
                maxstr = s;
            }
            if(min > Long.parseLong(s)){
                min = Long.parseLong(s);
                minstr = s;
            }
            return;
        }

        for(int cur = 0; cur <= 9; cur ++){
            if(visited[cur]) continue;
            if(arr[k].equals("<")){
                if(prev < cur){
                    selected.push(cur);
                    visited[cur] = true;
                    recur(cur, k+1, s+cur);
                    selected.pop();
                    visited[cur] = false;
                }
            } else if(arr[k].equals(">")){
                if(prev > cur){
                    selected.push(cur);
                    visited[cur] = true;
                    recur(cur,k+1, s+cur);
                    selected.pop();
                    visited[cur] = false;
                }
            }
        }
    }
}
