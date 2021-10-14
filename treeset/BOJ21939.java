package treeset;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ21939 {

    public static class Problem implements Comparable<Problem>{
        int no;
        int level;

        public Problem(int no, int level){
            this.no = no;
            this.level = level;
        }

        @Override
        public int compareTo(Problem p){
            int result = this.level - p.level;
            if(result == 0){
                result = this.no - p.no;
            }
            return result;
        }

    }

    public static TreeSet<Problem> treeSet;
    public static HashMap<Integer, Integer> problems;
    public static StringBuffer sb;
    public static int N, M;

    public static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        treeSet = new TreeSet<Problem>();
        problems = new HashMap<Integer, Integer>();
        sb = new StringBuffer();
        StringTokenizer st = null;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int no =Integer.parseInt(st.nextToken());
            int level = Integer.parseInt(st.nextToken());
            treeSet.add(new Problem(no, level));
            problems.put(no, level);
        }


        M = Integer.parseInt(br.readLine());
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            switch(command){
                case "add":
                    int no = Integer.parseInt(st.nextToken());
                    int level = Integer.parseInt(st.nextToken());
                    treeSet.add(new Problem(no, level));
                    problems.put(no, level);
                    break;
                case "solved":
                    int dno = Integer.parseInt(st.nextToken());
                    int dlevel = problems.get(dno);
                    problems.remove(dno);
                    treeSet.remove(new Problem(dno, dlevel));
                    break;
                case "recommend":
//                    System.out.println(treeSet.last().no);
                    int x = Integer.parseInt(st.nextToken());
                    if(x == 1){
                        sb.append(treeSet.last().no + "\n");
                    } else {
                        sb.append(treeSet.first().no + "\n");
                    }
                    break;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        input();
        System.out.println(sb.toString());

    }
}
