package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11057 {

    public static int R, C, GR, GC, PR, PC;
    public static void input() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        GR = Integer.parseInt(st.nextToken());
        GC = Integer.parseInt(st.nextToken());
        PR = Integer.parseInt(st.nextToken());
        PC = Integer.parseInt(st.nextToken());

        int pArea = PR*PC;

        int count = 0;
        for(int i = 0; i < R; i++){
            String s = br.readLine();
            for(int j = 0; j < C; j++){
                char val = s.charAt(j);
                if('P' == val){
                    count++;
                }
            }
        }
        if(pArea == count){
            // 베개가 모두 보여짐
            System.out.println(0);
        } else {
            // 베개가 일부 가려짐
            System.out.println(1);
        }
    }
    public static void main(String[] args) throws Exception {
        input();
    }
}
