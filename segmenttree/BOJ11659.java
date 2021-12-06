package segmenttree;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ11659 {
    public static int[] tree, arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 구간합을 가지는 segment tree 구성
        tree = new int[N*4];
        init(1, N, 1);

        // 특정 구간합 구하기
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());
            bw.write(sum(1, N, left, right, 1) + "\n");
        }

        bw.flush();

    }

    public static int sum(int start, int end, int left, int right, int node){
        if(left > end || right < start) return 0;
        if(left <= start && end <= right) return tree[node];
        int mid = (start + end)/2;
        return sum(start, mid, left, right, node*2) + sum(mid+1, end, left, right, node*2+1);
    }

    public static int init(int start, int end, int node){
        if(start == end) return tree[node] = arr[start];
        int mid = (start+end)/2;
        return tree[node] = init(start, mid, node*2) + init(mid+1, end, node*2+1);
    }
}
