package leetcode.简单题.整数反转;

/**
 * @author 小关同学
 * @create 2021/12/14
 */
//暴力破解法
//class Solution {
//    public int reverse(int x) {
//        if (x == 0){
//            return 0;
//        }
//        int i = 0;
//        int flag = 0;
//        String s = String.valueOf(x);
//        if (x<0){
//            s = s.substring(1);
//            flag++;
//        }
//        char[] chars = s.toCharArray();
//        for (;i<chars.length/2;i++){
//            char low = chars[i];
//            char height = chars[chars.length-1-i];
//            chars[i] = height;
//            chars[chars.length-1-i] = low;
//        }
//        long result = Long.parseLong(String.valueOf(chars));
//        if (result>Integer.MAX_VALUE){
//            return 0;
//        }else{
//            result = Integer.parseInt(String.valueOf(chars));
//        }
//        if (flag>0){
//            return (int)result*(-1);
//        }
//        return (int)result;
//    }
//}

//数字计算（可惜题目说最好不能使用long类型）
//class Solution{
//    public int reverse(int x) {
//        long n = 0;
//        while(x != 0) {
//            n = n*10 + x%10;
//            x = x/10;
//        }
//        return (int)n == n? (int)n : 0;
//    }
//}

//反转字符串
class Solution{
    public int reverse(int x) {
        String xString = Integer.toString(x);
        String string = xString;

        int flag = 1;
        if (x < 0) {
            flag = -1;
            string = xString.substring(1);
        }
        try {
            return Integer.valueOf((new StringBuilder(string)).reverse().toString()) * flag;
        }catch (Exception e){
            return 0;
        }
    }
}

public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reverse(-1534236));
    }
}
