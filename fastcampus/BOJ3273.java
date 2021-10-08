package fastcampus;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ3273 {

    public static int N, X, ans;
    public static int[] arrN;

    public static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arrN = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++){
            arrN[i] = Integer.parseInt(st.nextToken());
        }
        X = Integer.parseInt(br.readLine());
    }

    public static boolean find(int[] arrN, int L, int R, int X, int XIdx){
        while(L <= R){
            int mid = (L+R)/2;
            if(arrN[mid] > X){
                R = mid-1;
            }
            if(arrN[mid] < X){
                L = mid+1;
            }
            if(arrN[mid] == X){
                if(mid < XIdx) return false;
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        input();

        Arrays.sort(arrN, 1, N+1);

        for(int i = 1; i <= N; i++){
            System.out.print(arrN[i] + " ");
        }
        System.out.println();

        for(int i = 1; i <= N; i++){
            int targetNum = X - arrN[i];
            if(targetNum == arrN[i]) continue;
            if(find(arrN, 1, N, targetNum, i)){
                ans++;
            }
        }
        System.out.println(ans);
    }

}
