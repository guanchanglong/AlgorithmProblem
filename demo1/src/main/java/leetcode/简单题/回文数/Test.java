package leetcode.简单题.回文数;

/**
 * @author 小关同学
 * @create 2021/12/14
 */
class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0){
            return false;
        }
        String s = String.valueOf(x);
        for (int i = 0;i<s.length()/2;i++){
            if (s.charAt(i)!=s.charAt(s.length()-1-i)){
                return false;
            }
        }
        return true;
    }
}
public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isPalindrome(121));
    }
}
