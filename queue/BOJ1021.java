package queue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ1021 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        LinkedList<Integer> deque = new LinkedList<Integer>();
        for(int i = 1; i <= N; i++){
            deque.offerLast(i);
        }
        // First ---------- Last
        // 1 2 3 4 5 6 7 8 9 10
        int answer = 0;
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < C; i++){
            int num = Integer.parseInt(st.nextToken());
            if(deque.peekFirst() == num){
                deque.pollFirst();
            } else {
                int targetIdx = deque.indexOf(num)+1;
//                System.out.println("targetIdx: " + targetIdx);
                int size = deque.size();

                int idx = 1;
                if(targetIdx <= size/2 + 1){
                    while(idx <= targetIdx-1){
//                        System.out.println("peekFirst: " + deque.peekFirst());
                        deque.offerLast(deque.pollFirst());
                        answer++;
                        idx++;
                    }
                } else {
                    while(idx <= size-targetIdx + 1){
//                        System.out.println("peekLast: "+deque.peekLast() );
                        deque.offerFirst(deque.pollLast());
                        answer++;
                        idx++;
                    }
                }
                deque.pollFirst();
            }
        }

        System.out.println(answer);
    }
}
