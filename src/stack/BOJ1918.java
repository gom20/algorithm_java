package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class BOJ1918 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String text = br.readLine();

		char[] arr = text.toCharArray();
		
		Stack<String> stack = new Stack<String>();
		
	
		ArrayList<String> oper = new ArrayList<String>() {
			{
				add("+");
				add("-");
				add("*");
				add("/");
			}
			
		};
		
		Map<String, Integer> prior = new HashMap<String, Integer>() {
	        {
	        	put("(", 1);
	            put("+", 2);
	            put("-", 2);
	            put("*", 3);
	            put("/", 3);
	        }
		};

		String result = "";	
		for(int i = 0; i < arr.length; i++) {
			String t = String.valueOf(arr[i]);
			
			switch(t) {
			case "+":
			case "-":
			case "*":
			case "/":
				for(int j = stack.size()-1; j >= 0; j--) {
					if(prior.get(t) <= prior.get(stack.get(j))) {
						result += stack.pop();
					} else {
						break;
					}
				}
				
				stack.push(t);
				break;
			case "(":
				stack.push(t);
				break;
			case ")":
				while(stack.size() > 0){
					if(stack.peek().equals("(")) {
						stack.pop();
						break;
					}
					result += stack.pop();	
				}
				break;
			default:
				result += t;
				break;
			}
		}
		while(stack.size()>0) {
			result+= stack.pop();
		}
		
		System.out.println(result);
		
	}
}
