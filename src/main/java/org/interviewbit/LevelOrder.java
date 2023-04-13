package org.interviewbit;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrder {
    public static void main(String[] args) {
        TreeNode x = TreeNode.makeTree(new int[]{3,4,5,-1,-1,-1,-1});
        levelOrder(x);
    }

    public static int[][] levelOrder(TreeNode A) {
        List<List<Integer>> out = new ArrayList();
        Queue<TreeNode> Q = new LinkedList<>();
        Q.add(A);
        Q.add(null);

        int k=0;

        while( Q.size() > 1 ) {
            TreeNode root = Q.poll();
            if(k+1>out.size())
                out.add(new ArrayList<>());
            if (root == null) {
                k++;
                Q.add(null);
                continue;
            }

            out.get(k).add(root.val);

            if (root.left != null)
                Q.add(root.left);
            if (root.right != null)
                Q.add(root.right);
        }

        int[][] arr = new int[out.size()][out.get(out.size()-1).size()];

        for(int i=0;i<out.size();i++){
            for(int j=0;j<out.get(i).size();j++){
                arr[i][j] = out.get(i).get(j);
            }
        }

        return arr;
    }
}
