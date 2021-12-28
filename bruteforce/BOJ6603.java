package bruteforce;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ6603 {

    static int k;
    static int[] arr, result;
    static boolean[] used;
    static BufferedWriter bw;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());
            if(k == 0) break;

            arr = new int[k];
            result = new int[6];
            used = new boolean[k];
            for(int i = 0; i < k ; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            recur(0, 0, result);
            bw.flush();
            bw.write("\n");
        }
    }

    public static void recur(int idx, int cnt, int[] result) throws Exception {
        if(cnt == 6){
            Arrays.sort(result);
            StringBuilder sb = new StringBuilder();
            for(int num : result){
                sb.append(num + " ");
            }
            bw.write(sb.toString());
            bw.write("\n");
            return;
        }

        for(int i = idx; i < k; i++){
            if(used[i]) continue;
            used[i] = true;
            result[cnt] = arr[i];
            recur(i+1, cnt+1, result);
            used[i] = false;
        }
    }
}
