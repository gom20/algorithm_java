package queue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ18258 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
        int N = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new ArrayDeque<Integer>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            switch(command) {
                case "push":
                    deque.push(Integer.parseInt(st.nextToken()));
                    break;
                case "front":
                    if(deque.isEmpty()){
                        sb.append(-1).append("\n");
                    } else {
                        sb.append(deque.peekLast()).append("\n");
                    }
                    break;
                case "back":
                    if(deque.isEmpty()){
                        sb.append(-1).append("\n");
                    } else {
                        sb.append(deque.peekFirst()).append("\n");
                    }
                    break;
                case "size":
                    sb.append(deque.size()).append("\n");
                    break;
                case "empty":
                    if(deque.isEmpty()) {
                        sb.append(1).append("\n");
                    } else {
                        sb.append(0).append("\n");
                    }
                    break;
                case "pop":
                    if(deque.isEmpty()) {
                        sb.append(-1).append("\n");
                    } else {
                        sb.append(deque.pollLast()).append("\n");
                    }
                    break;
            }
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
