package fastcampus;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ10825 {

    public static int N;
    public static ArrayList<Student> students;

    public static class Student implements Comparable<Student>{
        public String name;
        public int korean;
        public int english;
        public int math;

        Student(String name, int korean, int english, int math){
            this.name = name;
            this.korean = korean;
            this.english = english;
            this.math = math;
        }

        @Override
        public int compareTo(Student student){
            int order = student.korean - this.korean;
            if(order == 0){
                order = this.english - student.english;
            }
            if(order == 0){
                order = student.math - this.math;
            }
            if(order == 0){
                order = this.name.compareTo(student.name);
            }
            return order;
        }

    }

    public static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        students = new ArrayList<Student>();

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()){
                students.add(new Student(st.nextToken(), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
            }
        }
    }

    public static void output() throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(Student student: students){
            bw.write(student.name + "\n");
        }
        bw.flush();
    }


    public static void main(String[] args) throws Exception {
        input();
        Collections.sort(students);
        output();
    }

}
