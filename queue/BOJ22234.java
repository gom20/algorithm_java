package queue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ22234 {

    public static class Guest implements Comparable<Guest>{
        int id;
        int consumeTime;
        int enterTime;
        boolean visit;

        public Guest(int id, int consumeTime){
            this.id = id;
            this.consumeTime = consumeTime;
            this.enterTime = 0;
            this.visit = false;
        }

        public Guest(int id, int consumeTime, int enterTime){
            this.id = id;
            this.consumeTime = consumeTime;
            this.enterTime = enterTime;
            this.visit = false;
        }

        @Override
        public int compareTo(Guest g){
            int rs = this.enterTime - g.enterTime;
            if(rs == 0){
                int cur = this.visit ? 1 : 0;
                int next = g.visit ? 1 : 0;
                if(cur != next) rs = cur - next;
            }
            return rs;
        }

        public String toString(){
            return "id: "+ id+ ", consumeTime: "+ consumeTime + ", enterTime: "+enterTime;
        }
    }

    public static int N, T, W, M;
    public static PriorityQueue<Guest> que;

    public static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        que = new PriorityQueue<Guest>();
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            que.offer(new Guest(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        M = Integer.parseInt(br.readLine());
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            que.offer(new Guest(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
    }

    public static ArrayList<Integer> ids;

    public static void addId(int start, int end, int id){
        for(int i = start ; start < end; start ++){
            ids.add(id);
        }
    }

    public static void main(String[] args) throws Exception {
        input();

        ids = new ArrayList<Integer>();
        int curTime = 0;
        while(!que.isEmpty()){
            Guest g = que.poll();
            if(g.consumeTime > T){
                addId(curTime, curTime + T, g.id);
                curTime += T;
                g.consumeTime = g.consumeTime - T;
                g.enterTime = curTime;
                g.visit = true;
               que.offer(g);
            } else {
                addId(curTime, curTime + g.consumeTime, g.id);
                curTime += g.consumeTime;
            }
            if(curTime > W) break;
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < W; i++){
            sb.append(ids.get(i)+"\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
