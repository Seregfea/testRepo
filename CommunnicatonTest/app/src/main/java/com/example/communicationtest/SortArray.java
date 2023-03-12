package com.example.communicationtest;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class SortArray {
    private String fullNumber;

    private void intToString(int fullNumber){
        this.fullNumber = Integer.toString(fullNumber);
        Log.d("serverS2", "-------------cklickedeven----------------"+this.fullNumber);
    }

    private String listToString(List<Integer> listInt){
        String listComp = "";
        for (int i = 0; i < listInt.size(); i++) {
            listComp = listComp+listInt.get(i);
        }
        Log.d("serverA3", "-------------cklickedoteven----------------"+listComp);

        return listComp;
    }

    public String sortArray(int fullNumber){
        intToString(fullNumber);
        List<Integer> even = new ArrayList<>();
        List<Integer> notEven = new ArrayList<>();
        List<Integer> ordered = new ArrayList<>();
        int tester;
        for(int i=0; i<this.fullNumber.length(); i++) {
            tester = Integer.parseInt(this.fullNumber.charAt(i)+"");
            Log.d("serverT1", "-------------cklickedeven----------------"+tester);
            if ((tester % 2) == 0) {
                even.add(tester);
            } else {
                notEven.add(tester);
            }
        }
        Log.d("serverA1", "-------------cklickedeven----------------"+even.toString());
        Log.d("serverA2", "-------------cklickedoteven----------------"+notEven.toString());
        ordered.addAll(even);
        ordered.addAll(notEven);
        return listToString(ordered);
    }

}
