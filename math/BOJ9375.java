package math;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ9375 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++){
            HashMap<String, Integer> map = new HashMap<String, Integer>();
            int N = Integer.parseInt(br.readLine());

            for(int j = 0; j < N; j++){
                st = new StringTokenizer(br.readLine());
                st.nextToken();
                String key = st.nextToken();
                map.put(key, map.getOrDefault(key, 0) +1);
            }

            int cnt = 1;
            for(String key : map.keySet()){
                cnt *= (map.get(key) + 1);
            }
            bw.write((cnt-1) + "\n");
        }
        bw.flush();
    }
}
