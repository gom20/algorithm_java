package stack;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BOJ1874 {

    public static int N;
    public static Queue<Integer> que;

    public static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        que = new LinkedList<Integer>();
        for(int i = 1; i <= N; i++){
            que.offer(Integer.parseInt(br.readLine()));
        }
    }

    public static void main(String[] args) throws Exception {
        input();
        StringBuilder sb = new StringBuilder();
        Stack<Integer> st = new Stack<Integer>();
        for(int i = 1; i <= N; i++){
            st.push(i);
            sb.append("+\n");

            while(!st.isEmpty() && st.peek().intValue() == que.peek().intValue()){
                que.poll();
                st.pop();
                sb.append("-\n");
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        if(que.size() > 0){
            bw.write("NO");
        } else {
            bw.write(sb.toString());
        }
        bw.flush();
    }
}
