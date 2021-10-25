package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ2580 {

    public static int[][] arr;
    public static ArrayList<int[]> zeros;
    public static int zeroCnt;

    public static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = new int[9][9];
        zeros = new ArrayList<>();

        // 스도쿠 정보를 2차 배열에 담는다.
        // 이 때, 0 값을 갖는 좌표를 ArrayList에 저장한다.
        for(int i = 0; i < 9; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 9; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 0){
                    zeros.add(new int[]{i, j});
                }
            }
        }

        // 0값의 개수를 int 변수에 저장한다.
        zeroCnt = zeros.size();
    }

    public static void recur(int k){
        // k 값이 0의 개수에 도달했다면 모든 0 좌표의 값이 채워진 것이므로 프로그램을 종료시킨다.
        // 올바른 스도쿠판이 여러개가 될 수 있으므로, 가장 처음에 채워진 스도쿠 판으로 print 하고 프로그램을 종료시켜야 한다.
        // 종료시키지 않으면 시간초과 발생
        if(k == zeroCnt){
            printSudoku();
            System.exit(0);
        }

        // 0 좌표의 값을 구한다.
        int[] xy = zeros.get(k);
        int x = xy[0]; int y = xy[1];

        // 1~9 값을 차례대로 넣어보면서 넣을 수 있는지 체크하고 넣는게 가능하다면 해당 값을 배열에 할당하고 k+1로 recur함수를 호출한다.
        // 그러면 다음 index의 0값을 채우는 로직이 반복된다.
        // recur 함수를 호출했지만 다음 index에서 1~9값이 모두 불가능할 경우, 다시 이전 recur함수로 되돌아 와서 다음 index를 체크하게 된다.
        // 만약 for문이 끝났다면 모든 경우의 수가 맞지 않는 것이므로 해당 배열의 값을 다시 0으로 원복시킨다.
        // 이렇게 함수가 끝나면 이 함수를 호출한 recur 함수의 다음 절차가 실행됨.
        // 재귀 함수는... 머리가 핑핑 돈다.
        for(int i = 1; i <= 9; i++){
            if(isPossible(x, y, i)){
                arr[x][y] = i;
                recur(k+1);
            }
            if(i==9) arr[x][y] = 0;
        }
    }

    public static boolean isPossible(int x, int y, int val){
        // 가로 체크
        for(int i = 0; i < 9; i ++){
            if(i == x) continue;
            if(val == arr[i][y]) return false;
        }
        // 세로 체크
        for(int i = 0; i < 9; i++){
            if(i == y) continue;
            if(val == arr[x][i]) return false;
        }
        // 해당 좌표가 속한 3*3 정사각형 배열의 값을 체크
        for(int i = (x/3)*3; i < (x/3)*3+3; i++){
            for(int j = (y/3)*3; j < (y/3)*3+3; j++){
                if(i == x && j == y) continue;
                if(val == arr[i][j]) return false;
            }
        }
        return true;
    }

    public static void printSudoku(){
        for(int i = 0; i < 9; i++){
            for(int j =0 ; j < 9; j++){
                System.out.print(arr[i][j]);
                if(j < 8) System.out.print(" ");
            }
            if(i < 8) System.out.println();
        }
    }

    public static void main(String[] args) throws Exception {
        input();
        // zero 좌표의 정보를 가지고 있는 ArrayList의 원소를 재귀함수를 거치면서 값을 채워나갈 것이다.
        recur(0);
    }
}
