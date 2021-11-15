package queue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;

public class BOJ5430 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i ++){
            String command = br.readLine();
            int N = Integer.parseInt(br.readLine());
            String[] arr = br.readLine().replaceAll("^\\[", "")
                    .replaceAll("\\]$", "")
                    .split(",");
            bw.write(solution(command, arr) + "\n");
        }
        bw.flush();
    }

    private static String solution(String command, String[] arr){
        LinkedList<String> deque = new LinkedList<String>();
        for(int i = 0; i < arr.length; i++){
            if(arr[i].equals("")) continue;
            deque.offerFirst(arr[i]);
        }

        boolean fifo = true; // offerFirst -> pollLast <-> offerLast -> pollFirst
        for(int i = 0; i < command.length(); i++){
            char c = command.charAt(i);
            if(c == 'R'){
                if(fifo) fifo = false;
                else fifo = true;
            } else {
                if(deque.isEmpty()) return "error";
                if(fifo){
                    deque.pollLast();
                } else {
                    deque.pollFirst();
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        while(!deque.isEmpty()){
            if(fifo) sb.append(deque.pollLast());
            else sb.append(deque.pollFirst());
            if(!deque.isEmpty()) sb.append(",");
        }
        sb.append("]");
        return sb.toString();
    }

}
