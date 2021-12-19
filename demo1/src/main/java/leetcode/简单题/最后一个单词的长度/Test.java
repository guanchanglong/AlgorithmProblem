package leetcode.简单题.最后一个单词的长度;

/**
 * @author 小关同学
 * @create 2021/12/19
 */

//自己写的，一遍遍历
class Solution {
    public int lengthOfLastWord(String s) {
        int length = 0;
        for (int i = s.length()-1;i>=0;i--){
            if (s.charAt(i) != ' '){
                length++;
            }
            if (s.charAt(i)==' ' && length!=0){
                break;
            }
        }
        return length;
    }
}
public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLastWord("luffy is still joyboy"));
    }
}
