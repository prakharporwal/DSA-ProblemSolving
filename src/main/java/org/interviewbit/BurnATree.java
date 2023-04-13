package org.interviewbit;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class BurnATree {
    public static void main(String[] args) {
        TreeNode A = new TreeNode();
        int B = 6;
        System.out.println(solve(A,B));
    }

    private static void traverse(TreeNode A, Map<TreeNode,TreeNode> nodeToParent){
        if(A.left!=null) {
            nodeToParent.put(A.left, A);
            traverse(A.left,nodeToParent);
        }

        if(A.right!=null) {
            nodeToParent.put(A.right, A);
            traverse(A.right,nodeToParent);
        }
    }

    private static void getTargetNode(TreeNode A, int B, TreeNode ans) {
        if(A==null)
            return;

        if (A.val == B){
            ans = A;
            return;
        }

        getTargetNode(A.left,B,ans);
        getTargetNode(A.right,B,ans);
    }

    public static int solve(TreeNode A, int B) {
        Map<TreeNode,TreeNode> nodeToParent = new HashMap<>();
        TreeNode ans = null;

        getTargetNode(A,B,ans);

        // now do BFS
        Queue<TreeNode> q = new LinkedList<>();
        q.add(ans);

        int time=0;

        while(!q.isEmpty()){
            TreeNode top = q.peek();
            q.poll();

            boolean isNodeAdded = false;
            if(nodeToParent.containsKey(A)){
                q.add(nodeToParent.get(A));
                isNodeAdded=true;
            }
            if(top.left != null){
                q.add(top.left);
                isNodeAdded=true;
            }
            if(top.right != null){
                q.add(top.right);
                isNodeAdded=true;
            }

            if(isNodeAdded)
                time++;
        }

        return time;
    }
}
