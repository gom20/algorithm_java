package bitmask;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ11723 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());
        int[] arr = new int[21];
        int idx = 0;
        String command = "";

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            command = st.nextToken();
            if(st.hasMoreTokens()){
                idx = Integer.parseInt(st.nextToken());
            }

            switch(command){
                case "add" : arr[idx] = 1;
                break;
                case "remove": arr[idx] = 0;
                break;
                case "check": bw.write(arr[idx] + "\n");
                break;
                case "toggle": arr[idx] = arr[idx] == 1 ? 0 : 1;
                break;
                case "all" : Arrays.fill(arr, 1);
                break;
                case "empty" : Arrays.fill(arr, 0);
                break;
            }
        }

        bw.flush();
    }
}
