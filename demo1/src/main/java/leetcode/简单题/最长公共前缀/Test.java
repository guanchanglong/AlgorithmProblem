package leetcode.简单题.最长公共前缀;

/**
 * @author 小关同学
 * @create 2021/12/15
 */
//自己想出来的写法
class Solution {
    public String longestCommonPrefix(String[] strs) {
        //选定第一个为公共子串
        String result = strs[0];
        for (String s:strs){
            //子串长度
            int length = result.length();
            //如果不匹配的话就一直将子串长度缩短，直到子串长度为0
            while(s.indexOf(result)!=0){
                if (length!=0){
                    //缩短子串长度
                    result = result.substring(0,length--);
                }else{
                    //子串长度为0时就是没有匹配的，直接返回空字符串
                    return "";
                }
            }
        }
        //匹配完所有后返回最长公共前缀子串
        return result;
    }
}

//另一种写法，大同小异，只是更加简洁了
//class Solution {
//    public String longestCommonPrefix(String[] strs) {
//        if(strs.length==0){
//            return "";
//        }
//        //公共前缀比所有字符串都短，随便选一个先
//        String s = strs[0];
//        for (String string : strs) {
//            //startsWith() 方法用于检测字符串是否以指定的前缀开始。
//            while(!string.startsWith(s)){
//                if(s.length() == 0){
//                    return "";
//                }
//                //公共前缀不匹配就让它变短！
//                s = s.substring(0,s.length()-1);
//            }
//        }
//        return s;
//    }
//}

public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[]strings = new String[]{"flower","flow","flight"};
        System.out.println(solution.longestCommonPrefix(strings));
    }
}
