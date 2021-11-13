package stack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ17298 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack<Integer> stack = new Stack<Integer>();

        for(int i = 1; i <= N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = N; i >= 1; i--){
            int num = arr[i];
            while(!stack.isEmpty() && stack.peek() <= num){
                stack.pop();
            }
            if(stack.isEmpty()) arr[i] = -1;
            else arr[i] = stack.peek();
            stack.push(num);
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= N; i++){
            sb.append(arr[i]).append(" ");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
