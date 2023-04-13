package org.interviewbit;

import java.util.ArrayList;

public class ValidPathToRectangleCorner {
    public static void main(String[] args) {
        System.out.println();
    }

    private static boolean checkIsInsideCircle(int i,int j,int R, ArrayList<Integer> Ci, ArrayList<Integer> Cj){
        for(int k=0;k<Ci.size();k++){
            if(Math.pow(Ci.get(k)-i,2) + Math.pow(Cj.get(k)-j,2) <= R*R ){
                return true;
            }
        }
        return false;
    }

    private static boolean helper(int i,int j,int x,int y,int R,ArrayList<Integer> Ci, ArrayList<Integer> Cj,boolean[][] vis){
        if(i<0 || j<0 || i>x || j>y)
            return false;
        if(i==x && j==y)
            return true;

        vis[i][j] = true;

        if(!checkIsInsideCircle(i,j,R,Ci,Cj)){
            return helper(i+1,j,x,y,R,Ci,Cj,vis) | helper(i,j+1,x,y,R,Ci,Cj,vis)
             | helper(i-1,j,x,y,R,Ci,Cj,vis) | helper(i,j+1,x,y,R,Ci,Cj,vis);
        }
        return false;
    }

    private static String solve(int x, int y, int N, int R, ArrayList<Integer> Ci, ArrayList<Integer> Cj){
        boolean[][] vis = new boolean[x+1][y+1];

        if(helper(0,0,x,y,R,Ci,Cj,vis))
            return "YES";
        return "NO";
    }
}
