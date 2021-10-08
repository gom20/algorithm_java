package fastcampus;

import java.util.ArrayList;
import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args){
        ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(7, 3, 1, 8, 4, 3, 9, 2, 11));
        System.out.println(quickSort(list).toString());

    }

    public static ArrayList<Integer> quickSort(ArrayList<Integer> list){
        if(list.size() <= 1){
            return list;
        }

        ArrayList<Integer> result = new ArrayList<Integer>();
        int pivotVal = list.get(0);
        ArrayList<Integer> left = new ArrayList<Integer>();
        ArrayList<Integer> right = new ArrayList<Integer>();
        for(int i = 1; i < list.size(); i++){
            if(list.get(i) < pivotVal){
                left.add(list.get(i));
            } else {
                right.add(list.get(i));
            }
        }

        result.addAll(quickSort(left));
        result.add(pivotVal);
        result.addAll(quickSort(right));
        return result;
    }


}
