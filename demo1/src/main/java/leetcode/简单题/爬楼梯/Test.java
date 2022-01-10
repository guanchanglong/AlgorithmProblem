package leetcode.简单题.爬楼梯;

/**
 * @Author 小关同学
 * @Create 2022/1/10 7:49
 */
//解析：
//我们用f(x)表示爬到第x级台阶的方案数，考虑最后一步可能跨越了一级台阶，
//也有可能跨越了两级台阶，所以我们可以列出如下式子：
//f(x) = f(x-1) + f(x-2)
//以上是动态规划的转移方程

//循环的方法
class Solution {
    public int climbStairs(int n) {
        if (n < 3){
            return n;
        }
        int n1 = 1;
        int n2 = 2;
        int n3 = n1 + n2;
        //模拟动态推导
        for (int i = 3;i < n;i++){
            n1 = n2;
            n2 = n3;
            n3 = n1 + n2;
        }
        return n3;
    }
}

//递归的解法(殊途同归)
//递归的方法会超出时间限制，在这题中不能使用
//class Solution {
//    public int climbStairs(int n) {
//        if (n < 3){
//            return n;
//        }else{
//            return climbStairs(n-1) + climbStairs(n-2);
//        }
//    }
//}

public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.climbStairs(45));
    }
}
