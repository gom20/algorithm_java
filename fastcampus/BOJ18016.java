package fastcampus;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ18016 {

    public static int N, M;
    public static int[] arrN, arrM;
    public static HashMap<Integer, Integer> hm;

    public static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arrN = new int[N+1];
        hm = new HashMap<Integer, Integer>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1 ; i <= N ; i++){
            arrN[i] = Integer.parseInt(st.nextToken());
            hm.put(arrN[i], hm.getOrDefault(arrN[i], 0) + 1);
        }
        M = Integer.parseInt(br.readLine());
        arrM = new int[M+1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1 ; i <= M ; i++){
            arrM[i] = Integer.parseInt(st.nextToken());
        }

    }

    public static int getCountInArrN(int[] arrN, int L, int R, int X){
        // arrN 배열에서 X의 수의 개수를 찾는다.
        // X가 있는지 찾고, 그 Idx 를 알아야 함.
        // 이후 Idx 좌우로 살피면서 X의 개수를 Count

        boolean isExist = false;
        int targetIdx = 0;
        while(L <= R){
            int mid = (L+R)/2;
            if(arrN[mid] > X){
                R = mid - 1;
            }
            if(arrN[mid] < X){
                L = mid + 1;
            }
            if(arrN[mid] == X){
                // 찾았다!
                isExist = true;
                targetIdx = mid;
                break;
            }
        }

        int count = 1;
        if(isExist){
            return hm.getOrDefault(arrN[targetIdx], 0);
        }
        return 0;
    }

    public static void main(String[] args) throws Exception {
        input();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Arrays.sort(arrN, 1, N+1);
        for(int i = 1; i <= M; i++){
            bw.write(getCountInArrN(arrN, 1, N, arrM[i])+" ");
        }
        bw.flush();

    }

}
