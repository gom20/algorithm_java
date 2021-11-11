package greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ13305 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cityCnt = Integer.parseInt(br.readLine());
        long[] dist = new long[cityCnt-1];
        long[] costs = new long[cityCnt-1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < dist.length; i++){
            dist[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < costs.length; i++){
            costs[i] = Integer.parseInt(st.nextToken());
        }

        long totalCost = 0;
        long prev = 0;
        for(int i = 0; i < costs.length; i++){
            if(i != 0 && prev < costs[i]){
                costs[i] = prev;
            }
            totalCost += costs[i]*dist[i];
            prev = costs[i];
        }
        System.out.println(totalCost);
    }
}
