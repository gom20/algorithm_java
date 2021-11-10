package greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ1541 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        String[] arr = s.split("-");
        String[] subarr = null;
        int sum = 0;
        int first = 0;
        for(int i = 0; i < arr.length; i++){
            subarr = arr[i].split("\\+");
            for(int j = 0;j < subarr.length; j++){
                int num = Integer.parseInt(subarr[j]);
                if(i == 0) {
                    first += num;
                } else {
                    sum += num;
                }
            }
        }

        if(s.contains("-")){
            System.out.println(first-sum);
        } else {
            System.out.println(first+sum);
        }
    }
}
