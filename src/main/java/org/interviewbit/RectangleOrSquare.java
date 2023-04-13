package org.interviewbit;

import java.util.HashMap;
import java.util.Map;

public class RectangleOrSquare {

    public static void main(String[] args) {
        int[][] A = new int[][]{};
        System.out.println(solve(A));
    }

    public static int solve(final int[][] A) {
        int m = A.length;
        int n = A[0].length;

        Map<Integer,Boolean> R = new HashMap<>();
        Map<Integer,Boolean> C = new HashMap<>();

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(A[i][j] == 1){
                    if(R.containsKey(i) && R.get(i) && C.get(j)){

                    }
                    R.put(i,j);
                    C.put(j,i);
                }
            }
        }

        return ;
    }
}
