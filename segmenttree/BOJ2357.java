package segmenttree;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ2357 {

    public static long tree[][], arr[];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 수열의 개수
        int M = Integer.parseInt(st.nextToken()); // 구간의 최대, 최소 출력 횟수

        arr = new long[N+1];
        for(int i = 1; i <= N; i++){
            arr[i] = Long.parseLong(br.readLine());
        }

        // 최대, 최소값을 가지는 세그먼트 트리 생성
        tree = new long[N*4][2];
        init(1, N, 1);

        // 특정 구간의 최대, 최소값 출력
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());
            long[] result = getMinMax(1, N, left, right, 1);
            bw.write(result[0] + " " + result[1] + "\n");
        }
        bw.flush();
    }

    public static long[] getMinMax(int start, int end, int left, int right, int node){
        if(start > right || end < left) return new long[]{Long.MAX_VALUE, Long.MIN_VALUE};
        if(left <= start && end <= right){
            return tree[node];
        }
        int mid = (start+end)/2;
        long[] leftNode = getMinMax(start, mid, left, right, node*2);
        long[] rightNode = getMinMax(mid+1, end, left, right, node*2+1);
        return new long[]{Math.min(leftNode[0], rightNode[0]), Math.max(leftNode[1], rightNode[1])};
    }

    public static long[] init(int start, int end, int node){
        if(start == end) {
            tree[node][0] = arr[start];
            tree[node][1] = arr[start];
            return tree[node];
        }
        int mid = (start+end)/2;
        long[] left = init(start, mid, node*2);
        long[] right = init(mid+1, end, node*2+1);
        tree[node][0] = Math.min(left[0], right[0]);
        tree[node][1] = Math.max(left[1], right[1]);
        return tree[node];
    }


}
