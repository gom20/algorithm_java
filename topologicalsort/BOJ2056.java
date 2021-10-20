package topologicalsort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ2056 {

    public static int N;
    public static ArrayList<Integer>[] adjs;
    public static int[] indegs, needTimes, times;
    public static void input() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        indegs = new int[N+1];
        needTimes = new int[N+1];
        times = new int[N+1];
        adjs = new ArrayList[N+1];
        for(int i = 0; i <= N; i ++){
            adjs[i] = new ArrayList<Integer>();
        }

        StringTokenizer st = null;
        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            needTimes[i] = Integer.parseInt(st.nextToken());
            st.nextToken();
            while(st.hasMoreTokens()){
                adjs[Integer.parseInt(st.nextToken())].add(i);
                indegs[i]++;
            }
        }
    }

    public static void topologicalSort(){
        Queue<Integer> que = new LinkedList<Integer>();
        for(int i = 1; i <= N; i++){
            if(indegs[i] == 0){
                que.offer(i);
                times[i] = needTimes[i];
            }
        }

        while(!que.isEmpty()){
            int node = que.poll();
            for(int adj : adjs[node]){
                indegs[adj]--;
                times[adj] = Math.max(times[adj], times[node] + needTimes[adj]);
                if(indegs[adj] == 0){
                    que.offer(adj);
                }
            }
        }

        int ans = Integer.MIN_VALUE;
        for(int i = 1; i < times.length; i++){
            ans = Math.max(ans, times[i]);
        }
        System.out.println(ans);
    }

    public static void main(String[] args) throws Exception {
        input();
        topologicalSort();
    }
}
