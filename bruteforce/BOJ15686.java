package bruteforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ15686 {
    public static class Node {
        int x;
        int y;
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public static int N, M, answer;
    public static ArrayList<Node> chickens, houses, selected;
    public static boolean[] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        chickens = new ArrayList<Node>();
        houses = new ArrayList<Node>();
        selected = new ArrayList<Node>();

        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++){
                int val = Integer.parseInt(st.nextToken());
                if(val == 1){
                    // 집의 좌표 저장
                    houses.add(new Node(i, j));
                } else if (val == 2){
                    // 치킨집 좌표 저장
                    chickens.add(new Node(i, j));
                }
            }
        }

        answer = Integer.MAX_VALUE;
        // 치킨 집 M개 선택했을 때, 집과 치킨집 최소거리의 합 구해서
        // 그 중 제일 작은 값
        select(0, 0);

        System.out.println(answer);
    }


    public static void select(int idx, int k){
        if(k == M){
            // M개 선택했다.
            int totalDistance = 0;
            for(Node h: houses){
                int min = Integer.MAX_VALUE;
                for(Node s : selected){
                    min = Math.min(min, (Math.abs(h.x - s.x) + Math.abs(h.y - s.y)));
                }
                totalDistance += min;
            }
            answer = Math.min(answer, totalDistance);
            return;
        }
        for(int i = idx; i < chickens.size(); i++){
            Node chicken = chickens.get(i);
            if(selected.contains(chicken)) continue;
            selected.add(chicken);
            select(i+1, k+1);
            selected.remove(chicken);
        }
    }
}
