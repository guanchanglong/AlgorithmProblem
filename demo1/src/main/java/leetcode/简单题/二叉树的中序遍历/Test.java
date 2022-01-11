package leetcode.简单题.二叉树的中序遍历;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author 小关同学
 * @Create 2022/1/11 8:02
 */
//树节点
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


//完蛋，递归方法的二叉树遍历都差不多忘了
//class Solution {
//    static {
//        System.gc();
//        System.runFinalization();
//    }
//    public List<Integer> inorderTraversal(TreeNode root) {
//        List<Integer> result = new ArrayList<>();
//        find(result, root);
//        return result;
//    }
//
//    private void find(List<Integer> result, TreeNode root){
//        if (root == null){
//            return;
//        }
//        find(result, root.left);
//        result.add(root.val);
//        find(result, root.right);
//    }
//}

//好，循环的方法更是不会了
class Solution {

    // 堆栈实现
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> nodeLists = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        //如果为null则直接返回空结果
        if (root == null) {
            return nodeLists;
        }
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            nodeLists.add(root.val);
            root = root.right;
        }
        return nodeLists;
    }
}

public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(1);
        root.left = null;
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        solution.inorderTraversal(root);
    }
}
