package leetcode.简单题.相同的树;

/**
 * @Author 小关同学
 * @Create 2022/1/11 8:56
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
//自己写的，直接使用字符串比较的方法进行判断两棵树是否是一样的
//class Solution {
//    public boolean isSameTree(TreeNode p, TreeNode q) {
//        StringBuilder p1 = new StringBuilder();
//        StringBuilder q1 = new StringBuilder();
//        find(p1, p);
//        find(q1, q);
//        if (p1.toString().equals(q1.toString())){
//            System.out.println("p1:" + p1.toString());
//            System.out.println("q1:" + q1.toString());
//            return true;
//        }else{
//            return false;
//        }
//    }
//    private void find(StringBuilder result, TreeNode root){
//        if (root==null){
//            result.append("null");
//            return;
//        }
//        result.append(root.val);
//        find(result, root.left);
//        find(result, root.right);
//    }
//}

//深度优先搜索，哈哈，我自己肯定是想不到这种解法的啦
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        } else if (p.val != q.val) {
            return false;
        } else {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
    }
}
public class Test {
    public static void main(String[] args) {

    }
}
//[1,1]
//[1,null,1]