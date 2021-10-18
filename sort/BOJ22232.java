package sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class BOJ22232 {

    public static int N, M;
    public static ArrayList<File> files;
    public static HashSet<String> exts;

    public static class File implements Comparable<File>{
        String fullName;
        String name;
        String ext;

        public File(String fullName){
            this.fullName = fullName;
            divideNameAndExt();
        }

        public void divideNameAndExt(){
            String[] arr = fullName.split("\\.");
            this.name = arr[0];
            this.ext = arr[1];
        }

        @Override
        public int compareTo(File f){
            int rs = this.name.compareTo(f.name);
            if(rs == 0){
                int cur = exts.contains(this.ext) ? 0: 1;
                int next = exts.contains(f.ext) ? 0: 1;
                if(cur != next){
                    rs = cur - next;
                } else {
                    rs = this.ext.compareTo(f.ext);
                }
            }
            return rs;
        }
    }

    public static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        files = new ArrayList<File>();
        exts = new HashSet<String>();

        for(int i = 0 ; i < N; i++){
            files.add(new File(br.readLine()));
        }
        for(int i = 0; i < M; i++){
            exts.add(br.readLine());
        }
    }

    public static void main(String[] args) throws Exception {
        input();
        Collections.sort(files);
        StringBuilder sb = new StringBuilder();
        for(File file : files){
            sb.append(file.fullName + "\n");
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(sb.toString());
        bw.flush();
    }
}
