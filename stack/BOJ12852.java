package stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class BOJ12852 {

    public static int N;
    public static Stack<Integer> st;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
    }

    public static void print(int k){
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
            sb.append(" ");
        }
        System.out.println(k);
        System.out.println(sb.toString().trim());
    }

}
