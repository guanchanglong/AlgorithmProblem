package leetcode.简单题.加一;

import java.util.Arrays;

/**
 * @author 小关同学
 * @create 2021/12/19
 */
//这个题目真是够坑的，这个数组原来就是一个数字。。。
//还要考虑到整体的进位
//这个是自己想的解法
//class Solution {
//    public int[] plusOne(int[] digits) {
//        if (digits[digits.length-1]+1<10){
//            digits[digits.length-1]++;
//            return digits;
//        }else{
//            digits[digits.length-1]++;
//            int[]result = new int[digits.length];
//            for (int i = result.length-1;i>=0;i--){
//                if (digits[i]>=10 && i!=0){
//                    result[i] = digits[i]%10;
//                    digits[i-1]++;
//                }else{
//                    if (i==0 && digits[0]>=10){
//                        result = Arrays.copyOf(result,result.length+1);
//                        result[1] = digits[0]%10;
//                        result[0] = 1;
//                        return result;
//                    }
//                    result[i] = digits[i];
//                }
//            }
//            return result;
//        }
//    }
//}

//大佬的想法
//人家的想法怎么就这么简单明了
class Solution {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            //如果没有进位了的话，则直接返回数组
            //有进位的话就继续
            if (digits[i] != 0){
                return digits;
            }
        }
        //如果是9999、999、99、9这些需要数组位数加一的话，就让数组长度加一，再在头位设置1
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
}

public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[]target = new int[]{9,9,9,9};
        int[]nums = solution.plusOne(target);
        System.out.println(nums[nums.length-1]);
    }
}
