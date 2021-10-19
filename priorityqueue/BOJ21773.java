package priorityqueue;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ21773 {
    public static class Work implements Comparable<Work>{
        int id;
        int time;
        int priority;

        public Work(int id, int time, int priority){
            this.id =id;
            this.time = time;
            this.priority = priority;
        }

        @Override
        public int compareTo(Work w){
            int rs = w.priority - this.priority;
            if(rs == 0) rs = this.id - w.id;
            return rs;
        }
    }

    public static int T, n;
    public static PriorityQueue<Work> que;
    public static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        que = new PriorityQueue<Work>();
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            que.offer(new Work(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
    }

    public static void main(String[] args) throws Exception{
        input();

        StringBuilder sb = new StringBuilder();
        int curTime = 0;
        while(!que.isEmpty()){
            if(++curTime > T) break;
            Work w = que.poll();
            sb.append(w.id + "\n");
            w.time--;
            w.priority--;
            if(w.time > 0) que.offer(w);
        }
        System.out.println(sb.toString());
    }

}
