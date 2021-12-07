package segmenttree;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class BOJ5419 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i ++){
            bw.write(solution(br, bw) + "\n");
        }
        bw.flush();
    }

    public static class Node {
        int x;
        int y;
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static long solution(BufferedReader br, BufferedWriter bw) throws Exception{
        // 좌표 개수
        int N = Integer.parseInt(br.readLine());
        // 좌표를 저장할 리스트
        ArrayList<Node> list = new ArrayList<Node>();

        // 좌표 저장
        StringTokenizer st = null;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            list.add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        // y좌표 내림차순으로 정렬
        Collections.sort(list, new Comparator<Node>(){
            @Override
            public int compare(Node n1, Node n2){
                return n2.y - n1.y;
            }
        });

        // 좌표 압축
        // 북쪽에 있는 섬부터 y를 새로 매김
        // 북쪽에 있는 섬이 가장 작은 값을 가지게 됨.
        int ny = 1;
        int prev = list.get(0).y;
        for(Node n : list){
            if(n.y == prev){
                n.y = ny;
                continue;
            }
            prev = n.y;
            n.y = ++ny;
        }

        // x좌표 오름차순. x좌표 같을 경우 y좌표 북쪽 부터 정렬
        Collections.sort(list, new Comparator<Node>(){
            @Override
            public int compare(Node n1, Node n2){
                int rs = n1.x - n2.x;
                if(rs == 0) rs = n1.y - n2.y;
                return rs;
            }
        });

        long ans = 0;
        // 세그먼트 트리에 쿼리를 한 후, 해당 값을 업데이트 한다.
        int[] tree = new int[N*4];
        for(Node node : list){
            ans += query(tree,1, ny, 1, node.y, 1);
            update(tree, 1, ny, node.y, 1);
        }

        return ans;
    }

    public static long query(int[] tree, int start, int end, int left, int right, int node){
        if(left > end || right < start) return 0;
        if(left <= start && end <= right) return tree[node];
        int mid = (start + end)/2;
        return query(tree, start, mid, left, right, node*2) + query(tree, mid+1, end, left, right, node*2+1);
    }

    public static int update(int[] tree, int start, int end, int target, int node){
        if(target < start || target > end) return tree[node];
        if(start == end) {
            tree[node] += 1;
            return tree[node];
        }
        int mid = (start + end)/2;
        return tree[node] = update(tree, start, mid, target, node*2) + update(tree, mid+1, end, target, node*2+1);
    }

}
