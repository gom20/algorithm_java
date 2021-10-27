package stack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;


public class BOJ6549 {

    public static class Bar{
        int index;
        long height;
        public Bar(int index, long height){
            this.index = index;
            this.height = height;
        }
    }

    public static BufferedReader br;
    public static BufferedWriter bw;

    public static void pro(String s){
        long maxArea = 0;
        Stack<Bar> stack = new Stack<Bar>();

        StringTokenizer st = new StringTokenizer(s);
        int n = Integer.parseInt(st.nextToken());
        for(int i = 0; i <= n+1; i++){
            int h = (i == 0 || i == n+1) ? 0 : Integer.parseInt(st.nextToken());
            if(i == 0) {
                stack.push(new Bar(0, 0));
                continue;
            }
            while(stack.peek().height > h){
                Bar b = stack.pop();
                long height = b.height;
                int width = stack.isEmpty()? i : i - stack.peek().index-1;
                maxArea = Math.max(maxArea, height*width);
            }
            stack.push(new Bar(i, h));
        }
        System.out.println(maxArea);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while(true){
            String s = br.readLine();
            if("0".equals(s)) System.exit(0);
            pro(s);
        }
    }
}
