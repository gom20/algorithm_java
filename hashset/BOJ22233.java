package hashset;

import sort.BOJ22232;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ22233 {

    public static int N, M;

    public static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        HashSet<String> memo = new HashSet<String>();
        for(int i = 0; i < N; i++){
            memo.add(br.readLine());
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine(), ",");
            while(st.hasMoreTokens()){
                String keyword = st.nextToken();
                if(memo.contains(keyword)){
                    memo.remove(keyword);
                }
            }
            System.out.println(memo.size());
        }


    }

    public static void main(String[] args) throws Exception {
        input();
    }
}
