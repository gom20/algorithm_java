package twopointer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2003 {

    public static int N, S, ans;
    public static int[] arr;

    public static void input() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        arr = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }
    public static void main(String[] args) throws Exception{
        input();
        int R = 0, ans = 0, sum = 0;
        for(int L = 1; L <= N; L++){
            sum -= arr[L-1];
            while(R+1 <= N && sum < S){
                R++;
                sum += arr[R];
            }
            if(sum == S){
                ans++;
            }
        }
        System.out.println(ans);

    }
}
