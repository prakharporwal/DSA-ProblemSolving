package org.interviewbit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicates {
    public static void main(String[] args) {
        System.out.println(solve(new ArrayList<>(Arrays.asList(5000,5000,5000))));
    }

    private static int solve(ArrayList<Integer> A) {
        int cnt = 0;
        int j=0;
        // 0 ,0,0 0 0 0,1,2,2,2,2,2,4,4,4,4,4
        for (int i = 0; i < A.size(); i++) {
            while (j<A.size() && A.get(i).compareTo(A.get(j))==0) j++;

            int swap = A.get(cnt);
            A.set(cnt,A.get(i));
            A.set(i,swap);

            cnt++;
            i = j - 1;
        }

        while(A.size()>cnt){
            A.remove(A.size()-1);
        }

        return cnt;
    }
}
