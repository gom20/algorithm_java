package fastcampus;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ7795 {

    public static int T, N, M, ans, idxL, idxR;
    public static int A[], B[];


    public static int lower_bound(int[] A, int L, int R, int X){
        // A[L...R] 에서 X 미만의 수 (X보다 작은 수) 중 제일 오른쪽 인덱스를 return 하는 함수
        // 그런게 없다면 L-1을 리턴한다.
        int result = L - 1;
        while (L <= R){
            int mid = (L + R) / 2;
            if(A[mid] < X){
                result = mid;
                L = mid + 1;
            } else {
                R = mid - 1;
            }
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());

        for(int i = 0; i < T; i ++){
            ans = 0;
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            int A[] = new int[N+1];
            int B[] = new int[M+1];

            st = new StringTokenizer(br.readLine());
            for(int k = 1; k <= N; k++){
                A[k] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for(int k = 1; k <= M; k++){
                B[k] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(B, 1, M+1);

            for(int j = 1; j <= N; j++){
                // A[i]를 선택했을 때 B에서 A[i]보다 작은 게 몇 개나 있는 지 count하기
                ans += lower_bound(B, 1, M, A[j]);
            }

            bw.write(ans + "\n");
        }

        bw.flush();
    }

}
