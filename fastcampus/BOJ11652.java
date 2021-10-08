package fastcampus;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class BOJ11652 {

    public static int N, maxCnt, cnt;
    public static long[] nums;
    public static long ansNum;

    public static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        nums = new long[N];
        for(int i = 0; i < N; i++){
            nums[i] = Long.parseLong(br.readLine());
        }
    }

    public static void output() throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        bw.write(String.valueOf(ansNum));
        bw.flush();
    }


    public static void main(String[] args) throws Exception {
        input();

        Arrays.sort(nums);
        for(int i = 0; i < N; i++){
            if(i == 0){
                ansNum = nums[i];
                cnt = 1;
                maxCnt = cnt;
                continue;
            }
            if(nums[i] == nums[i-1]){
                cnt++;
            } else {
                cnt = 1;
            }
            if(maxCnt < cnt){
                maxCnt = cnt;
                ansNum = nums[i];
            }

        }

//        output();
        System.out.println(ansNum);
    }


}
