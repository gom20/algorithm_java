package binarysearch;

import priorityqueue.BOJ21773;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class BOJ21774 {

    public static int N, Q;
    public static ArrayList<Log>[] logs;
    public static class Log{
        long time;
        int level;
        public Log(long time, int level){
            this.time = time;
            this.level = level;
        }
    }
    public static void pro() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        logs = new ArrayList[7];
        for(int i = 0; i <= 6; i++){
            logs[i] = new ArrayList<Log>();
        }

        String s[] = null;
        for(int i = 1; i <= N; i++){
            s = br.readLine().split("#");
            long time = getTime(s[0]);
            int level = Integer.parseInt(s[1]);
            logs[level].add(new Log(time, level));
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < Q; i++){
            s = br.readLine().split("#");
            long start = getTime(s[0]);
            long end = getTime(s[1]);
            int level = Integer.parseInt(s[2]);
            sb.append(getCount(start, end, level));
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(sb.toString());
        bw.flush();
    }

    public static int getCount(long start, long end, int level){
        int count = getUpperBound(start, level, 0, N-1) - getLowerBound(end, level, 0, N-1);
        return count;
    }

    public static int getLowerBound(long target, int level, int L, int R){
        ArrayList<Log> list = logs[level];
        while(L < R){
            int mid = (L+R)/2;
            if(list.get(mid).time >= target){
                R = mid;
            } else {
                L = mid + 1;
            }
        }
        return R;
    }

    public static int getUpperBound(long target, int level, int L, int R){
        ArrayList<Log> list = logs[level];
        while(L < R){
            int mid = (L+R)/2;
            if(list.get(mid).time > target){
                R = mid;
            } else {
                L = mid + 1;
            }
        }
        return R;
    }

    public static long getTime(String text) throws Exception{
        SimpleDateFormat df = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
        Date d = df.parse(text);
        return d.getTime();
    }

    public static void main(String[] args) throws Exception {
        pro();
    }

}
