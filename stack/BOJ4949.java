package stack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class BOJ4949 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while(true){
            String s = br.readLine();
            if(s.equals(".")) break;

            if(solution(s.substring(0, s.length()-1))) bw.write("yes\n");
            else bw.write("no\n");
            bw.flush();
        }
    }

    public static boolean solution(String s){
        s = s.replaceAll("[a-z]*[A-Z]*", "");
        s = s.replaceAll(" ", "");

        Stack<Character> st = new Stack<Character>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '(' || c == '['){
                st.push(c);
            } else {
                if(st.isEmpty()){
                    return false;
                } else {
                    if((c == ']' && st.peek() == '[')||
                            ( c == ')' && st.peek() == '(')) {
                        st.pop();
                    } else {
                        return false;
                    }
                }
            }
        }
        if(st.isEmpty()) return true;
        return false;
    }
}
