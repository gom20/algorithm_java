package stack;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class BOJ9012 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        Stack<Character> st = new Stack<Character>();
        for(int i = 0; i < T; i++){
            st.clear();
            String s = br.readLine();
            for(int j = 0; j < s.length(); j++){
                char c = s.charAt(j);
                if(c == '('){
                    st.push(s.charAt(j));
                } else {
                    if(!st.isEmpty() && st.peek() == '('){
                        st.pop();
                    } else {
                        st.push(c);
                        break;
                    }
                }
            }
            if(st.isEmpty()) sb.append("YES\n");
            else sb.append("NO\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
