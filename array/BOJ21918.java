package array;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ21918 {

    public static int[] arr;
    public static int N, M;
    public static int[][] comm;
    public static void input() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N+1];
        comm = new int[M+1][3];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for(int i =0; i < M ; i++){
            st = new StringTokenizer(br.readLine());
            comm[i][0]= Integer.parseInt(st.nextToken());
            comm[i][1]= Integer.parseInt(st.nextToken());
            comm[i][2]= Integer.parseInt(st.nextToken());
        }
    }

    public static void command(int com, int l, int r){
        switch(com){
            case 1:
                arr[l] = r;
                break;
            case 2:
                for(int i = l ; i <= r; i++){
                    arr[i] = change(arr[i]);
                }
                break;
            case 3:
                for(int i = l ; i <= r; i++){
                    arr[i] = 0;
                }
                break;
            case 4:
                for(int i = l ; i <= r; i++){
                    arr[i] = 1;
                }
                break;
        }
    }

    public static int change(int i){
        if(i == 0) return 1;
        if(i == 1) return 0;
        return i;
    }

    public static void execute(){
        for(int[] com : comm){
            command(com[0], com[1], com[2]);
        }
    }

    public static void output(){
        StringBuffer sb = new StringBuffer();
        for(int i = 1; i <= N; i++){
            sb.append(arr[i]+" ");
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) throws Exception {
        input();
        execute();
        output();
    }
}
