package fastcampus;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ1182 {


    public static int N, S, ans;
    public static int[] nums;
    public static boolean[] numContainYNs;

    public static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        nums = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }
    }

    public static void output() throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(ans));
        bw.flush();
    }

    public static void recurFunc(int k, int val){
       if(k == N){
            if(val == S){
                ans++;
            }
       } else {
           recurFunc(k+1, val);
           recurFunc(k+1, val + nums[k]);
       }

    }


    public static void main(String[] args) throws Exception {
        input();

        recurFunc(0, 0);
        if(S == 0){
            ans--;
        }

        output();
    }

}
