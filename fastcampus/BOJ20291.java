package fastcampus;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;

public class BOJ20291 {

    public static int N;
    public static HashMap<String, Integer> extMap;
    public static String ext;
    public static StringBuilder sb;

    public static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        extMap = new HashMap<String, Integer>();
        for(int i = 0; i < N; i++){
            ext = br.readLine().split("\\.")[1];
            extMap.put(ext, extMap.getOrDefault(ext, 0) + 1);
        }
    }

    public static void output() throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(sb.toString());
        bw.flush();
    }


    public static void main(String[] args) throws Exception {
        input();

        Object[] keys  = extMap.keySet().toArray();
        Arrays.sort(keys);

        sb = new StringBuilder();
        for(Object key :  keys){
            sb.append((String)key + " " + extMap.get((String)key) + "\n");
        }

        output();
    }

}
