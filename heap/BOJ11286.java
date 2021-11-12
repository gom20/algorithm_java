package heap;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;

public class BOJ11286 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        PriorityQueue<Integer> pque = new PriorityQueue<Integer>(new Comparator<Integer>(){
            @Override
            public int compare(Integer a, Integer b){
                int rs = Math.abs(a) - Math.abs(b);
                if(rs == 0) rs = a-b;
                return rs;
            }
        });

        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++){
            int x = Integer.parseInt(br.readLine());
            if(x == 0) {
                if(pque.isEmpty()) {
                    bw.write("0\n");
                } else {
                    bw.write(pque.poll() + "\n");
                }
            } else {
                pque.offer(x);
            }
        }
        bw.flush();
    }
}
