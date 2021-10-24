package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MergeSort {

   public static void main(String[] args){
       ArrayList<Integer> list = new ArrayList<Integer>();

       for(int i=0; i < 100; i++){
           list.add((int)(Math.random()*100));
       }
       System.out.println(mergeSplit(list).toString());
   }

    public static ArrayList<Integer> mergeSplit(ArrayList<Integer> list){
       if(list.size() <= 1){
           return list;
       }
       int mediumIdx = list.size()/2;
       ArrayList<Integer> leftList = mergeSplit(new ArrayList<Integer>(list.subList(0, mediumIdx)));
       ArrayList<Integer> rightList = mergeSplit(new ArrayList<Integer>(list.subList(mediumIdx, list.size())));

       return merge(leftList, rightList);
    }

    public static ArrayList<Integer> merge(ArrayList<Integer> left, ArrayList<Integer> right){
       ArrayList<Integer> list = new ArrayList<Integer>();
       int leftIdx = 0;
       int rightIdx = 0;
       while(leftIdx < left.size() && rightIdx < right.size()){
           if(left.get(leftIdx) < right.get(rightIdx)){
               list.add(left.get(leftIdx));
               leftIdx++;
           } else {
               list.add(right.get(rightIdx));
               rightIdx++;
           }
       }

       while(leftIdx < left.size()){
           list.add(left.get(leftIdx));
           leftIdx++;
       }

        while(rightIdx < right.size()){
            list.add(right.get(rightIdx));
            rightIdx++;
        }

        return list;
    }

}
