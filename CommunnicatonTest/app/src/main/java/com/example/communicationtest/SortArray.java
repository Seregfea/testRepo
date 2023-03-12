package com.example.communicationtest;

import java.util.ArrayList;
import java.util.List;

public class SortArray {
    int[] fullNumber;

    private void intToString(int fullNumber){
        String temp = Integer.toString(fullNumber);
        this.fullNumber = new int[temp.length()];
    }

    public List sortArray(int fullNumber){
        intToString(fullNumber);
        List<Integer> even = new ArrayList<>();
        List<Integer> notEven = new ArrayList<>();
        List<Integer> ordered = new ArrayList<>();
        for (int i = 0; i< this.fullNumber.length; i++){
            if((this.fullNumber[i] % 2) == 0){
                even.add(this.fullNumber[i]);
            }else {
                notEven.add(this.fullNumber[i]);
            }
        }
        ordered.addAll(even);
        ordered.addAll(notEven);
        return ordered;
    }

}
