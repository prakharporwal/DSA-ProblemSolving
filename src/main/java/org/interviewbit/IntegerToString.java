package org.interviewbit;

import java.util.ArrayList;
import java.util.List;

public class IntegerToString {
    public static void main(String[] args) {
        System.out.println(Solve("1,2,3,7,99"));
    }

    private static int[] Solve(String A){
        String[] str = A.split(",");

        List<Integer> in = new ArrayList<>();

        for(int i=0;i<str.length;i++){
            in.add(Integer.parseInt(str[i]));
        }

        int[] out = new int[in.size()];

        for(int i=0;i<in.size();i++){
            out[i] = in.get(i);
        }

        return out;
    }
}
