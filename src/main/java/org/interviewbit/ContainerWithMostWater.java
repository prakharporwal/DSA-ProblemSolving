package org.interviewbit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        System.out.println(solve(Arrays.asList(1,5,4,3)));
    }

    private static int solve(List<Integer> A){
        int ans = 0;
        for(int i=0;i<A.size();i++){
            for(int j=0;j<A.size();j++){
                ans = Integer.max(ans,Math.abs(A.get(j)-A.get(i))*(j-i));
            }
        }

        return ans;
    }
}
