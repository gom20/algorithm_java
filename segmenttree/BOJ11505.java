package segmenttree;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ11505 {

    public static int[] arr;
    public static long[] tree;
    public static int mod = 1000000007;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 수의 개수
        int M = Integer.parseInt(st.nextToken()); // 수의 변경이 일어난 횟수
        int K = Integer.parseInt(st.nextToken()); // 구간의 곱을 구하는 횟수

        // 수를 저장할 배열
        arr = new int[N+1];
        for(int i = 1; i <= N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        // 구간 곱 세그먼트 트리 생성
        tree = new long[N*4];
        init(1, N, 1);

        for(int i = 0; i < M+K; i++){
            st = new StringTokenizer(br.readLine());
            int flag = Integer.parseInt(st.nextToken());
            if(flag == 1){
                // 수를 변경하기
                int target = Integer.parseInt(st.nextToken());
                int from = arr[target];
                int to = Integer.parseInt(st.nextToken());
                update(1, N, target, from , to, 1);
                arr[target] = to;
            } else {
                // 구간의 곱 구하기
                int left = Integer.parseInt(st.nextToken());
                int right = Integer.parseInt(st.nextToken());
                bw.write(multiply(1, N, left, right, 1) + "\n");
            }
        }
        bw.flush();
    }

    public static long update(int start, int end, int target, int from, int to, int node){
        if(target < start || target > end ) return tree[node];
        if(start == end){
            tree[node] = (from == 0)? to : (tree[node]/from*to) % mod;
            return tree[node];
        }
        int mid = (start+end)/2;
        return tree[node] = (update(start, mid, target, from, to, node*2) * update(mid+1, end, target, from, to, node*2+1)) % mod;
    }

    public static long multiply(int start, int end, int left, int right,  int node){
        if(left > end || right < start) return 1;
        if(left <= start && end <= right) return tree[node];
        int mid = (start + end)/2;
        return (multiply(start, mid, left, right, node*2) * multiply(mid+1, end, left, right, node*2+1)) % mod;
    }

    public static long init(int start, int end, int node){
        if(start == end) return tree[node] = arr[start];
        int mid = (start + end)/2;
        return tree[node] = (init(start, mid, node*2) * init(mid+1, end, node*2+1)) % mod;
    }
}
