package fastcampus;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ14888 {

    public static int N;
    public static int max, min;
    public static int[] nums, opers, orders;

    public static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        nums = new int[N];
        opers = new int[4];
        orders = new int[N-1];
        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 4; i++){
            opers[i] = Integer.parseInt(st.nextToken());
        }
        br.close();
    }

    public static void output() throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(max));
        bw.write("\n");
        bw.write(String.valueOf(min));
        bw.flush();
        bw.close();
    }

    public static int calculate(){
        int value = nums[0];
        for(int i = 0; i < nums.length-1; i ++){
            if(orders[i] == 0){
                value += nums[i+1];
            }
            if(orders[i] == 1){
                value -= nums[i+1];
            }
            if(orders[i] == 2){
                value *= nums[i+1];
            }
            if(orders[i] == 3){
                value /= nums[i+1];
            }
        }
        return value;
    }

    public static void recurFunc(int k) {
        if(k == N-1) {
            int value = calculate();
            max = Math.max(max, value);
            min = Math.min(min, value);
        } else {
            for(int cand = 0; cand < 4; cand++){
                if(opers[cand] >= 1){
                    opers[cand]--;
                    orders[k] = cand;
                    recurFunc(k+1);
                    orders[k] = 0;
                    opers[cand]++;

                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        input();
        recurFunc(0);
        output();
    }

}
