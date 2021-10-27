package queue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ10866 {

    public static void main(String[] args) throws Throwable {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> deque = new LinkedList<Integer>();
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            String comm = st.nextToken();
            switch(comm){
                case "push_back":
                    deque.addLast(Integer.parseInt(st.nextToken()));
                    break;
                case "push_front":
                    deque.addFirst(Integer.parseInt(st.nextToken()));
                    break;
                case "pop_front":
                    if(deque.isEmpty()){
                        sb.append(-1).append("\n");
                    } else {
                        sb.append(deque.pollFirst()).append("\n");
                    }
                    break;
                case "pop_back":
                    if(deque.isEmpty()){
                        sb.append(-1).append("\n");
                    } else {
                        sb.append(deque.pollLast()).append("\n");
                    }
                    break;
                case "size":
                    sb.append(deque.size()).append("\n");
                    break;
                case "empty":
                    if(deque.isEmpty()){
                        sb.append(1).append("\n");
                    } else {
                        sb.append(0).append("\n");
                    }
                    break;
                case "front":
                    if(deque.isEmpty()){
                        sb.append(-1).append("\n");
                    } else {
                        sb.append(deque.peekFirst()).append("\n");
                    }
                    break;
                case "back":
                    if(deque.isEmpty()){
                        sb.append(-1).append("\n");
                    } else {
                        sb.append(deque.peekLast()).append("\n");
                    }
                    break;
            }
        }
        System.out.println(sb.toString());
    }
}
