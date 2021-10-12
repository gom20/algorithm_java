package bruteforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ21921 {


    public static int N, X, max;
    public static int[] arr;
    public static HashMap<Integer, Integer> hm;

    public static void input() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        arr = new int[N+1];
        hm = new HashMap<Integer, Integer>();
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

    }

    public static void main(String[] args) throws Exception{
        input();

        int sum = 0;
        int R = 1;
        for(int L = 1; L <= N; L++){
            if(L == 1){
                for(R = 1; R <= X; R++){
                    sum += arr[R];
                }
            } else {
                if(R > N) break;
//                System.out.println(R);
                sum -= arr[L-1];
                sum += arr[R];
                R++;
            }
            hm.put(sum, hm.getOrDefault(sum, 0) + 1);
            max = Math.max(sum, max);
        }

        if(max == 0 ) {
            System.out.println("SAD");
        } else {
            System.out.println(max);
            System.out.println(hm.get(max));

        }
    }
}
