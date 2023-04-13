package org.interviewbit;

import java.util.Arrays;

public class LCMofKNumbers {
    public static void main(String[] args) {
        int[] A = {3,3,2,1,2,3,2,3,2,3,1,1};
//        A = {3, 1, 2, 1, 3, 1, 2, 2, 1, 1, 2, 3, 3, 1, 3, 3, 3, 2, 3, 3, 1, 1, 1, 3, 3, 1, 3, 1, 3, 3, 1, 1, 3, 2, 2, 3, 1, 2, 1, 3, 3, 3, 2, 1, 1, 2, 1};
        int x = 1;
        System.out.println(solve(A,x));
    }
    private static int findLCM(int a, int b){
        if(b == 0)
            return a;
        if(b>a)
            return findLCM(b,a);

        return findLCM(b,a%b);
    }

    public static int solve(int[] A, int x) {
        // if LCM is x its possible.
        int n = A.length;
        if(n==1)
            return 1;

        Arrays.sort(A);
        // if LCM is x its possible.
        int diff = A[n-1]-A[0];

        if(diff != x*2)
            return 0;
        // how to find a LCM for k numbers ?
        for(int i=1;i<A.length;i++){
            if(A[i] != A[0]+x && A[i]+x != A[0]+x && A[i]-x != A[0]+x)
                return 0;
        }

        return 1;
    }
}
