package leetcode.简单题.对称二叉树;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author 小关同学
 * @Create 2022/1/18 9:56
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

//自己写的
//class Solution {
//    public boolean isSymmetric(TreeNode root) {
//        StringBuilder p1 = new StringBuilder();
//        StringBuilder q1 = new StringBuilder();
//        mfind(p1, root.left);
//        hfind(q1, root.right);
//        if (p1.toString().equals(q1.toString())){
//            System.out.println("p1:" + p1.toString());
//            System.out.println("q1:" + q1.toString());
//            return true;
//        }else{
//            System.out.println("p1:" + p1.toString());
//            System.out.println("q1:" + q1.toString());
//            return false;
//        }
//    }
//
//    private void mfind(StringBuilder result, TreeNode root){
//        if (root==null){
//            result.append("null");
//            return;
//        }
//        result.append(root.val);
//        mfind(result, root.left);
//        mfind(result, root.right);
//    }
//
//    private void hfind(StringBuilder result, TreeNode root){
//        if (root==null){
//            result.append("null");
//            return;
//        }
//        result.append(root.val);
//        hfind(result, root.right);
//        hfind(result, root.left);
//    }
//}


//自己写的，还是在判断相同的树那道题上进行修改的，只不过这次使用了深搜的方法进行搜索判断
//PS：官方的解法跟这个思想基本一样
//class Solution {
//    public boolean isSymmetric(TreeNode root) {
//        return isSameTree(root.left,root.right);
//    }
//
//    private boolean isSameTree(TreeNode p, TreeNode q) {
//        if (p == null && q == null) {
//            return true;
//        } else if (p == null || q == null) {
//            return false;
//        } else if (p.val != q.val) {
//            return false;
//        } else {
//            return isSameTree(p.left, q.right) && isSameTree(p.right, q.left);
//        }
//    }
//}


//官方写的迭代的方法
class Solution {
    public boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }

    private boolean check(TreeNode u, TreeNode v) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(u);
        q.offer(v);
        while (!q.isEmpty()) {
            u = q.poll();
            v = q.poll();
            if (u == null && v == null) {
                continue;
            }
            if ((u == null || v == null) || (u.val != v.val)) {
                return false;
            }

            q.offer(u.left);
            q.offer(v.right);

            q.offer(u.right);
            q.offer(v.left);
        }
        return true;
    }
}


public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(2);
        left.left = new TreeNode(2);
        left.right = null;
        right.left = new TreeNode(2);
        right.right = null;
        root.left = left;
        root.right = right;
        System.out.println(solution.isSymmetric(root));
    }
}
