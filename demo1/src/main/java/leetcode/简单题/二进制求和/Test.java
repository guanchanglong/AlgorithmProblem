package leetcode.简单题.二进制求和;

import java.util.Arrays;

/**
 * @author 小关同学
 * @create 2021/12/20
 */
//自己想了半天的写法...
//class Solution {
//    public String addBinary(String a, String b) {
//        int length = Math.max(a.length(),b.length());
//        char[]result = new char[length+1];
//        char[]chars1 = new char[length];
//        char[]chars2 = new char[length];
//        int a1 = length - a.length();
//        int a2 = 0;
//        int b1 = length - b.length();
//        int b2 = 0;
//        for (int i = 0;i<length;i++){
//            if (i>=a1){
//                chars1[i] = a.charAt(a2++);
//            }
//            if (i>=b1){
//                chars2[i] = b.charAt(b2++);
//            }
//        }
//        int flag = 0;
//        for (int i = length-1;i>=0;i--){
//            if (flag == 1){
//                if (chars1[i] == '1' && chars2[i] == '1'){
//                    result[i+1] = '1';
//                    flag = 1;
//                }else if (chars1[i] == '1' || chars2[i] == '1'){
//                    result[i+1] = '0';
//                    flag = 1;
//                }else{
//                    result[i+1] = '1';
//                    flag = 0;
//                }
//            }else{
//                if (chars1[i] == '1' && chars2[i] == '1'){
//                    result[i+1] = '0';
//                    flag = 1;
//                }else if (chars1[i] == '1' || chars2[i] == '1'){
//                    result[i+1] = '1';
//                    flag = 0;
//                }else{
//                    result[i+1] = '0';
//                    flag = 0;
//                }
//            }
//        }
//        String str = null;
//        if (flag==1){
//            result[0] = '1';
//            str = String.copyValueOf(result);
//        }else{
//            result[0] = '0';
//            result = Arrays.copyOfRange(result,1,result.length);
//            str = String.copyValueOf(result);
//        }
//        return str;
//    }
//}


//官方的骚写法，结果居然还不对...
//class Solution {
//    public String addBinary(String a, String b) {
//        return Integer.toBinaryString(
//                Integer.parseInt(a, 2) + Integer.parseInt(b, 2)
//        );
//    }
//}

//别人的写法
class Solution {
    public String addBinary(String a, String b) {
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        StringBuilder builder = new StringBuilder();
        //循环相加两个字符串相同长度的低位数部分
        while (i >= 0 && j >= 0) {
            int sum = carry;
            sum += a.charAt(i--) - '0';
            sum += b.charAt(j--) - '0';
            carry = sum / 2;
            builder.append(sum % 2);
        }
        // 如果 a 还没遍历完成（a串比b串长），则继续遍历添加 a 的剩余部分
        while (i >= 0) {
            int sum = carry + a.charAt(i--) - '0';
            carry = sum / 2;
            builder.append(sum % 2);
        }
        // 如果 b 还没遍历完成（b串比a串长），则继续遍历添加 b 的剩余部分
        while (j >= 0) {
            int sum = carry + b.charAt(j--) - '0';
            carry = sum / 2;
            builder.append(sum % 2);
        }
        //如果 carry 不等于0 还有个进位数没加进去，需要补充
        if (carry == 1) {
            builder.append(carry);
        }
        //反转字符串获得正常结果
        return builder.reverse().toString();
    }
}

public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.addBinary("0","0"));
    }
}
//"10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101"
//"110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011"

//"110111101100010011000101110110100000011101000101011001000011011000001100011110011010010011000000000"
// 110111101100010011000101110110100000011101000101011001000011011000001100011110011010010011000000000