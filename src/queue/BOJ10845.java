package queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class CustomQueue{
	
	int size;
	int front = -1;
	int back = -1;
	int[] queue;
	
	public CustomQueue() {
		this.queue = new int[10001];
	}
	
	public void push(int num) {
		back++;
		size++;
		if(front == -1) front++;
		queue[back] = num;
	}
	
	public int pop() {
		int result;
		if(size == 0) {
			result = -1;
		} else {
			result = queue[front];
			front++;
			size--;
		}
		
		return result;
	}

	public int size() {
		return size;
	}
	
	public int empty() {
		return size > 0 ? 0: 1;	
	}
	
	public int front() {
		return size > 0? queue[front] : -1;
	}
	
	public int back() {
		return size > 0 ? queue[back] : -1;
	}
	
}

public class BOJ10845 {

	public static int idx;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		CustomQueue queue = new CustomQueue();
		
		for(int i = 0; i < N; i++) {
			String[] cmd = br.readLine().split(" ");
			
			switch(cmd[0]) {
			case "push":
				queue.push(Integer.parseInt(cmd[1]));
				break;
			case "pop":
				System.out.println(queue.pop());
				break;
			case "size":
				System.out.println(queue.size());
				break;
			case "empty":
				System.out.println(queue.empty());
				break;
			case "front":
				System.out.println(queue.front());
				break;
			case "back":
				System.out.println(queue.back());
				break;
			}	
		}
	}
}
