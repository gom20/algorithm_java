package fastcampus;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ15970 {

    public static int N, ans;
    public static int[][] xys;

    public static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =  null;
        N = Integer.parseInt(br.readLine());
        xys = new int[N][2];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            xys[i][0] = Integer.parseInt(st.nextToken());
            xys[i][1] = Integer.parseInt(st.nextToken());
        }
    }

    public static void output() throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(ans));
        bw.flush();
    }


    public static void main(String[] args) throws Exception {
        input();

        // y 오름차순으로 정렬 (color)
        // y가 같으면 x 오름차순으로 정렬 (location)
        // 순회하면서 인접한 좌표 중 y값의 차이가 작은 값 SUM
        Arrays.sort(xys, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
               if(o1[1] != o2[1]) return o1[1] - o2[1];
               return o1[0] - o2[0];
            }
        });

//        for(int i = 0; i < N; i++){
//            for(int j = 0; j < 2; j++){
//                System.out.print(xys[i][j]+ " ");
//            }
//            System.out.println();
//        }

        for(int i = 0; i < N; i++){
            int distance = Integer.MAX_VALUE;
            if(i != 0 && xys[i][1] == xys[i-1][1]){
                distance = Math.abs(xys[i][0] - xys[i-1][0]);
            }
            if(i != N-1 && xys[i][1] == xys[i+1][1]){
                distance = Math.min(Math.abs(xys[i][0] - xys[i+1][0]), distance);
            }
            ans+= distance;
        }


        output();
    }

}
