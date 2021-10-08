package sort;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;


class Person implements Comparable<Person> {
	int age;
	int order;
	String name;
	
	public Person(int age, int order, String name) {
		this.age = age;
		this.order = order;
		this.name = name;
	}

	@Override
	public int compareTo(Person o) {
		int result = 0;
		if(this.age > o.age) {
			result = 1;
		} else if (this.age < o.age) {
			result = -1;
		} 
		
		if(result == 0) {
			if(this.order > o.order) {
				result = 1;
			} else if (this.order < o.order) {
				result = -1;
			} 
		}
		
		return result;
	}
}

public class BOJ10814 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		ArrayList<Person> arr = new ArrayList<Person>();
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			arr.add(new Person(Integer.parseInt(st.nextToken()), i, st.nextToken()));
		}
		
		Collections.sort(arr);
		
		for(Person p : arr) {
			bw.write(p.age +" " + p.name +"\n");
		}
		
		
		
		bw.flush();
		bw.close();
		br.close();
	}
}
