package org.interviewbit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MeetingRooms {
    public static void main(String[] args) {
        int[][] A = {{1, 10}, {1, 2}, {3, 5}, {4, 6}};
        System.out.println(Solve(A));
    }

    public static int Solve(int[][] A) {
        int count = 0;
        List<List<Integer>> x = new ArrayList<>();

        for (int i = 0; i < A.length; i++) {
            x.add(Arrays.asList(A[i][0], 2));
            x.add(Arrays.asList(A[i][1], 1));
        }

        x.sort(new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> a, List<Integer> b) {
                if (a.get(0) == b.get(0))
                    return a.get(1) - b.get(1);
                return a.get(0) - b.get(0);
            }
        });

        int ans=0;

        for(int i=0;i<x.size();i++){
            if(x.get(i).get(1)==2)
                count++;
            else if(x.get(i).get(1)==1)
                count--;
            ans = Integer.max(count, ans);
        }

        return ans;
    }
}
