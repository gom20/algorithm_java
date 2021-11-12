package heap;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class BOJ1927 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        PriorityQueue<Integer> pque = new PriorityQueue<Integer>();

        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++){
            int num = Integer.parseInt(br.readLine());
            if(num == 0){
                if(pque.isEmpty()){
                    bw.write(0 + "\n");
                } else {
                    bw.write(pque.poll() + "\n");
                }
            } else {
                pque.offer(num);
            }
        }
        bw.flush();
    }
}
