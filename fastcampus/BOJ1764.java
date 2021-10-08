package fastcampus;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1764 {

    public static int N, M;
    public static String[] arrN, arrM;
    public static ArrayList<String> result;
    public static StringBuilder sb;

    public static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arrN = new String[N+1];
        arrM = new String[M+1];

        for(int i = 1 ; i <= N; i++){
            arrN[i] = br.readLine();
        }
        for(int i = 1; i <= M; i++){
            arrM[i] = br.readLine();
        }
    }

    public static void output() throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    public static boolean find(String[] arrM, int L, int R, String X){
        while(L <= R){
            int mid = (L+R)/2;
            int compareVal = arrM[mid].compareTo(X);
            if(compareVal > 0){
                // mid 이전에 X가 있음
                R = mid -1;
            }
            if(compareVal < 0){
                // mid 이후에 X가 있음
                L = mid + 1;
            }
            if(compareVal == 0){
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) throws Exception {
        input();

        result = new ArrayList<String>();
        sb = new StringBuilder();

        Arrays.sort(arrN, 1, N+1);
        Arrays.sort(arrM, 1, M+1);

        // N을 순회하면서 N[i] 의 값이 M 배열에 있는지 체크해서 있다면 배열에 insert
        for(int i = 1; i <= N; i++){
            if(find(arrM, 1, M, arrN[i])){
                result.add(arrN[i]);
            }
        }
        sb.append(result.size() + "\n");
        for(String str : result){
            sb.append(str + "\n");
        }

        output();
    }

}
