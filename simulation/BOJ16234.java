package simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ16234 {

    static class Union{
        int total;
        int average;
        ArrayList<Country> countries;

        Union(ArrayList<Country> countries){
            this.countries = countries;
            for(Country country: countries){
                total += map[country.x][country.y];
            }
            average = total /countries.size();
        }

        void updatePeopleCount(){
            for(Country country : countries){
                map[country.x][country.y] = average;
            }
        }
    }

    static class Country{
        int x;
        int y;

        Country(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static int N, L, R;
    static int[][] map;
    static boolean[][] visited;
    static int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static ArrayList<Union> unions = new ArrayList<Union>();
    public static void main(String[] args) throws Exception  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int day = 0;
        while(true){
            unions.clear();
            visited = new boolean[N][N];
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    if(visited[i][j]) continue;

                    visited[i][j] = true;
                    ArrayList<Country> countries = new ArrayList<Country>();
                    findUnion(i, j, countries);
                    if(countries.size() > 1){
                        unions.add(new Union(countries));
                    }
                }
            }
            for(Union union : unions){
                union.updatePeopleCount();
            }
            if(unions.size() == 0) break;
            day++;
        }

        System.out.println(day);

    }

    public static void findUnion(int x, int y, ArrayList<Country> countries){
        countries.add(new Country(x, y));
        for(int[] d : dir){
            int nx = x + d[0];
            int ny = y + d[1];
            if(isValid(map[x][y], nx, ny)){
                visited[nx][ny] = true;
                findUnion(nx, ny, countries);
            }
        }
    }

    public static boolean isValid(int val, int nx, int ny){
        if(nx < 0 || ny < 0 || nx >= N || ny >= N) return false;
        if(visited[nx][ny]) return false;
        int diff = Math.abs(val-map[nx][ny]);
        if(diff >= L && diff <= R) return true;
        return false;
    }

}
