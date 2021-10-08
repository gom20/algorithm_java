package fastcampus;

import java.util.*;
import java.io.*;
public class BOJ9470 {

    public static int T, K, M, P;
    public static BufferedReader br;
    public static int[] indeg, orders;
    public static ArrayList<Integer>[] parentOrdersList;
    public static ArrayList<Integer>[] adjs;
    public static Queue<Integer> que;

    public static void input() throws Exception{
        StringTokenizer st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        indeg = new int[M+1];
        orders = new int[M+1];
        adjs = new ArrayList[M+1];
        que = new LinkedList<Integer>();
        parentOrdersList = new ArrayList[M+1];
        for(int i = 1; i <= M; i++){
            adjs[i] = new ArrayList<Integer>();
            parentOrdersList[i] = new ArrayList<Integer>();
        }
        for(int i = 0; i < P; i++){
            st = new StringTokenizer(br.readLine());
            int node = Integer.parseInt(st.nextToken());
            int adj = Integer.parseInt(st.nextToken());
            indeg[adj]++;
            adjs[node].add(adj);
        }
    }

    public static void sort(){
        for(int i = 1; i <= M; i++){
            if(indeg[i] == 0){
                orders[i] = 1;
                que.offer(i);
            }
        }
        while(!que.isEmpty()){
            int node = que.poll();
            for(int adj : adjs[node]){
                parentOrdersList[adj].add(orders[node]);
                indeg[adj]--;
                if(indeg[adj] == 0){
                    orders[adj] = getOrder(adj);
                    que.offer(adj);
                }
            }
        }
    }

    public static int getOrder(int node){
        ArrayList<Integer> ParentOrders = parentOrdersList[node];
        Collections.sort(ParentOrders, Collections.reverseOrder());
        if(ParentOrders.size() < 2) return ParentOrders.get(0);
        if(ParentOrders.get(0) == ParentOrders.get(1)) return ParentOrders.get(0)+1;
        return ParentOrders.get(0);
    }

    public static void main(String[] args) throws Exception{
        br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++){
            input();
            sort();

            Arrays.sort(orders);
            System.out.println(K + " " + orders[orders.length-1]);
        }

    }
}
