package unionfind;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ4195 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++){
            solution(br, bw);
        }
        bw.flush();
    }

    public static HashMap<String, String> parent;
    public static HashMap<String, Integer> setSize;
    private static void solution(BufferedReader br, BufferedWriter bw) throws Exception {
        int N = Integer.parseInt(br.readLine());
        parent = new HashMap<String, String>(); // 루트 노드 정보
        setSize = new HashMap<String, Integer>(); // 집합의 사이즈

        StringTokenizer st = null;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            String a = st.nextToken();
            String b = st.nextToken();

            // 입력 받을 때 초기화
            if(!setSize.containsKey(a)) setSize.put(a, 1);
            if(!setSize.containsKey(b)) setSize.put(b, 1);
            if(!parent.containsKey(a)) parent.put(a, a);
            if(!parent.containsKey(b)) parent.put(b, b);

            if(find(a) != find(b)){
                union(a, b);
            }
            // a, b 친구 관계를 맺었으므로 한 명의 루트 노드에 대한 사이즈만 출력하면 됨
            bw.write(setSize.get(find(a)) + "\n");
        }
    }

    private static void union(String a, String b){
        a = find(a);
        b = find(b);

        if(setSize.get(a) > setSize.get(b)){
            parent.put(b, a);
            setSize.put(a, setSize.get(a) + setSize.get(b));
            setSize.put(b, 0);
        } else {
            parent.put(a, b);
            setSize.put(b, setSize.get(b) + setSize.get(a));
            setSize.put(a, 0);
        }
    }

    private static String find(String a){
        if(parent.get(a) == a) return a;
        parent.put(a, find(parent.get(a)));
        return parent.get(a);
    }

}
