package leetcode.简单题.有效的括号;

import java.util.Stack;

/**
 * @author 小关同学
 * @create 2021/12/15
 */
//自己写的利用栈的特性的玩意
//class Solution {
//    public boolean isValid(String s) {
//        if (s.length()%2!=0){
//            return false;
//        }
//        char[]chars = s.toCharArray();
//        int[]stack = new int[chars.length];
//        for (char c:chars){
//            if (!push(stack,c)){
//                return false;
//            }
//        }
//        if (stack[0]!=0){
//            return false;
//        }
//        return true;
//    }
//
//    public boolean push(int[]nums,char c){
//        for (int i = 0;i<nums.length;i++){
//            //还未被使用
//            if (nums[i]==0){
//                //如果是第一次被插入的话
//                if (i==0){
//                    nums[i] = isChar(c);
//                    return true;
//                }else{
//                    //小于0表示是左括号，还不能匹配
//                    if (isChar(c)<0){
//                        nums[i] = isChar(c);
//                        return true;
//                    }else{
//                        //如果匹配的话
//                        if ((nums[i-1]+isChar(c))==0){
//                            nums[i-1] = 0;
//                            return true;
//                        }else{
//                            return false;
//                        }
//                    }
//                }
//            }
//        }
//        return true;
//    }
//
//
//    public int isChar(char c){
//        switch (c){
//            case '(':
//                return (-1)*('(');
//            case '[':
//                return (-1)*('[');
//            case '{':
//                return (-1)*('{');
//            case ')':
//                return '(';
//            case ']':
//                return '[';
//            case '}':
//                return '{';
//        }
//        return 0;
//    }
//}

//一个很秀的写法，但是时间复杂度很高
//class Solution {
//    public boolean isValid(String s) {
//        int length = s.length() / 2;
//        for(int i = 0; i < length; i++){
//            s = s.replace("()", "").replace("{}", "").replace("[]", "");
//        }
//        return s.length() == 0;
//    }
//}

//这个也是栈操作，但是怎么感觉比我的强了好多
//class Solution {
//    public boolean isValid(String s) {
//        char[] items = new char[s.length() / 2];
//        int count = 0;
//        char[] chars = s.toCharArray();
//        char tmp;
//        try {
//            for (char aChar : chars) {
//                if (aChar == '(' || aChar == '{' || aChar == '[') {
//                    items[count++] = aChar;
//                } else {
//                    if (count == 0) {
//                        return false;
//                    }
//                    tmp = items[--count];
//                    if (aChar == ')' && tmp == '(') {
//                        continue;
//                    }
//                    if (aChar == '}' && tmp == '{') {
//                        continue;
//                    }
//                    if (aChar == ']' && tmp == '[') {
//                        continue;
//                    }
//                    return false;
//                }
//            }
//        } catch (ArrayIndexOutOfBoundsException e) {
//            return false;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return count == 0;
//    }
//}

//直接使用Java里面的栈操作
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(char c: s.toCharArray()){
            if(c=='('){
                stack.push(')');
            }
            else if(c=='['){
                stack.push(']');
            }
            else if(c=='{'){
                stack.push('}');
            }
            else if(stack.isEmpty()||c!=stack.pop()){
                return false;
            }
        }
        return stack.isEmpty();
    }
}

public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isValid("(){}[]{[]}"));
    }
}
