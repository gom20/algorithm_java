package heap;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class BOJ1655 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>((o1, o2) -> o1-o2);
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((o1, o2) -> o2-o1);

        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++){
            int x = Integer.parseInt(br.readLine());
            if(maxHeap.isEmpty()){
                maxHeap.offer(x);
                bw.write(maxHeap.peek() + "\n");
                continue;
            }
            if(maxHeap.size() == minHeap.size()){
                if(x <= maxHeap.peek() || (maxHeap.peek() <= x && x <= minHeap.peek())){
                    maxHeap.offer(x);
                } else {
                    maxHeap.offer(minHeap.poll());
                    minHeap.offer(x);
                }
            } else {
                if(maxHeap.peek() <= x){
                    minHeap.offer(x);
                } else {
                    minHeap.offer(maxHeap.poll());
                    maxHeap.offer(x);
                }

            }
            bw.write(maxHeap.peek() + "\n");
        }
        bw.flush();
    }
}
