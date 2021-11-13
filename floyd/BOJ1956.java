package floyd;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1956 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int[][] floyd = new int[V+1][V+1];

        for(int i = 1; i <= V; i++){
            for(int j = 1; j <= V; j++){
                if(i == j) floyd[i][j] = 0;
                else floyd[i][j] = 10001;
            }
        }

        for(int i = 0; i < E; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            floyd[a][b] = c;
        }

        for(int k = 1; k <= V; k++){
            for(int i = 1; i <= V; i++){
                for(int j = 1; j <= V; j++){
                    floyd[i][j] = Math.min(floyd[i][j], floyd[i][k] + floyd[k][j]);
                }
            }
        }

        long min = Long.MAX_VALUE;
        boolean exist = false;
        for(int i = 1; i <= V; i++){
            for(int j = 1; j <= V; j++){
                if(i == j) continue;
                if(floyd[i][j] == 10001 || floyd[j][i] == 10001) continue;
                exist = true;
                min = Math.min(min, floyd[i][j] + floyd[j][i]);
            }
        }

        System.out.println(exist? min : -1);

    }
}
