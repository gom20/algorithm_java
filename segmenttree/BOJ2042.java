package segmenttree;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ2042 {
    public static long[] tree;
    public static long[] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 수의 개수
        int M = Integer.parseInt(st.nextToken()); // 수의 변경이 일어나는 횟수
        int K = Integer.parseInt(st.nextToken()); // 구간의 합을 구하는 횟수

        arr = new long[N+1];
        for(int i = 1; i <= N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        // 1. 구간 합을 가지는 세그먼트 트리 생성하기
        tree = new long[N*4];
        set(1, N, 1);

        for(int i = 0; i < M+K; i++){
            st = new StringTokenizer(br.readLine());
            int flag = Integer.parseInt(st.nextToken());
            if(flag == 1){
                int from = Integer.parseInt(st.nextToken());
                long to = Long.parseLong(st.nextToken());
                update(1, N, 1, from, to-arr[from]);
                arr[from] = to;
            } else {
                int left = Integer.parseInt(st.nextToken());
                int right = Integer.parseInt(st.nextToken());
                bw.write(sum(1, N, left, right, 1) + "\n");
            }
        }
        bw.flush();
    }

    public static void update(int start, int end, int node, int target, long diff){
        if(target < start || target > end) return;
        tree[node] += diff;
        if(start == end) return;
        int mid = (start+end)/2;
        update(start, mid, node*2, target, diff);
        update(mid+1, end, node*2+1, target, diff);
    }

    public static long sum(int start, int end, int left, int right, int node){
        // 범위를 벗어남
        if(right < start || left > end) return 0;
        // tree node의 합이 구간합 범위 안에 있음
        if(left <= start && end <= right ) {
            return tree[node];
        }

        // 필요한 구간 합보다, tree node의 구간합 범위가 더 클 경우, 쪼개서 다시 진행
        int mid = (start + end)/2;
        return sum(start, mid, left, right, node*2) +  sum(mid+1, end, left, right, node*2+1);
    }

    public static long set(int start, int end, int node){
        if(start == end) return tree[node] = arr[start];
        int mid = (start + end)/2;
        return tree[node] = set(start, mid, node*2) + set(mid+1, end, node*2+1);
    }
}
