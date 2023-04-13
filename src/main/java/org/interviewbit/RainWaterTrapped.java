package org.interviewbit;

import java.util.Comparator;
import java.util.Stack;

public class RainWaterTrapped {
    public static void main(String[] args) {
        int[] A = {1,4,2,3,6};
        System.out.println(trap(A));
    }

    public static int trap(final int[] A) {
        int n = A.length;
        int[] left = new int[n];
        int[] right = new int[n];

        left[0] = A[0];
        for(int i=1;i<n;i++){
            left[i] = Integer.max(left[i-1],A[i]);
        }

        right[n-1] = A[n-1];
        for(int i=n-2; i>=0; i--){
            right[i] = Integer.max(right[i+1],A[i]);
        }

        int ans=0;

        for(int i=0;i<n;i++){
            int side = Integer.min(left[i], right[i]);
            if(side > A[i])
                ans += side - A[i];
        }

        return  ans;
    }
}
