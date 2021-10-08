package fastcampus;

import java.util.Arrays;
import java.util.Comparator;

public class Greedy {

    public static void main(String[] args){
        Integer[][] objectList = {{10, 10}, {15, 12}, {20, 10}, {25, 8}, {30, 5}};

        Arrays.sort(objectList, new Comparator<Integer[]>(){
           @Override
           public int compare(Integer[] object1, Integer[] object2){
               return object1[1]/object1[0] - object2[1]/object2[0];
            }
        });


        for(int i = 0; i < objectList.length; i++){
            System.out.println(objectList[i][0]);
            System.out.println(objectList[i][1]);
        }
    }
}
