package org.interviewbit;

import java.util.Stack;

public class NEXTGREATER {
    public static void main(String[] args) {
        int[] A = {4,5,5,2,10};
        System.out.println(Solve(A));
    }
    private static int[] Solve(int[] A){
        Stack<Integer> S =new Stack<>();
        int[] out = new int[A.length];

        for(int i=A.length-1;i>=0;i--){
            while(!S.empty() && S.peek()<=A[i])
                S.pop();
            if(S.empty())
                out[i]=-1;
            else
                out[i]=S.peek();

            S.push(A[i]);
        }
        return out;
    }
}
