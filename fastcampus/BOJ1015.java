package fastcampus;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1015 {


    public static int N;
    public static int[] arrA, arrP, arrB;

    public static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        arrA = new int[N];
        arrP = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arrA[i] = Integer.parseInt(st.nextToken());
        }
    }

    public static void output() throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i = 0; i < N; i++){
            bw.write(arrP[i] + " ");
        }
        bw.flush();
    }

    public static boolean[] isVisited;
    public static void main(String[] args) throws Exception {
        input();

        isVisited = new boolean[N];
        arrB = arrA.clone();
        Arrays.sort(arrB);
        for(int i = 0; i < N; i++){
            // arrA[i]의 값과 arrB[j]의 값이 일치할 때의 idx j
            for(int j = 0; j < N; j++){
                if(isVisited[j]) continue;
                if(arrA[i] == arrB[j]){
                    arrP[i] = j;
                    isVisited[j] = true;
                    break;
                }
            }
        }

        output();
    }

}
