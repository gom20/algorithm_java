package topologicalsort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ3665 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t ++){

            int N = Integer.parseInt(br.readLine());

            // 인접 노드를 담을 자료 구조 생성
            ArrayList<Integer>[] adjs = new ArrayList[N+1];
            for(int i = 0; i <= N; i++){
                adjs[i] = new ArrayList<Integer>();
            }

            // 작년 랭크 input 처리
            int[] rank = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++){
                rank[i] = Integer.parseInt(st.nextToken());
            }

            // indegree 자료구조 생성
            int[] indeg = new int[N+1];

            // 작년 순위에 대해 인접노드 정보 생성
            // 5, 4, 3, 2, 1 ?
            // 5 - 4, 3, 2, 1
            // 4 - 3, 2, 1
            // 3 - 2, 1
            // 2 - 1
            for(int i = 0; i < N-1; i++){
                for(int j = i+1; j < N ; j++){
                    adjs[rank[i]].add(rank[j]);
                    indeg[rank[j]]++;
                }
            }

            // 바뀐 순서쌍 Input 받기
            int C = Integer.parseInt(br.readLine());
            for(int j = 0; j < C; j++){
                st = new StringTokenizer(br.readLine());
                Integer A = Integer.parseInt(st.nextToken());
                Integer B = Integer.parseInt(st.nextToken());
                if(adjs[A].contains(B)){
                    adjs[A].remove(B);
                    adjs[B].add(A);
                    indeg[A]++;
                    indeg[B]--;
                } else {
                    adjs[B].remove(A);
                    adjs[A].add(B);
                    indeg[B]++;
                    indeg[A]--;
                }
            }

            // topological sort 시작
            // indegree가 0인 것부터 시작
            Queue<Integer> que = new LinkedList<Integer>();
            for(int i = 1; i <= N; i++){
                if(indeg[i] == 0){
                    que.offer(i);
                }
            }

            int cnt = 0;
            StringBuilder sb = new StringBuilder();
            while(!que.isEmpty()){
                if(que.size() > 1) {
                    // 순위를 정할 수 없음
                    bw.write("?" + "\n");
                    break;
                }
                int node = que.poll();
                sb.append(node+ " ");
                cnt++;
                for(int adj : adjs[node]){
                    indeg[adj]--;
                    if(indeg[adj] == 0){
                        que.offer(adj);
                    }
                }
            }
            if(cnt != N){
                bw.write("IMPOSSIBLE" + "\n");
            } else {
                bw.write(sb.toString()+"\n");
            }
        }
        bw.flush();
    }
}
