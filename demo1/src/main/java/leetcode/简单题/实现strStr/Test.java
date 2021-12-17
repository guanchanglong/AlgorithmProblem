package leetcode.简单题.实现strStr;

/**
 * @author 小关同学
 * @create 2021/12/17
 */
//自己想的第一种解法，感觉有更优解
//class Solution {
//    public int strStr(String haystack, String needle) {
//        if (needle.length()==0){
//            return 0;
//        }
//        if (haystack.length()==0 || needle.length()>haystack.length()){
//            return -1;
//        }
//        char[]chars1 = haystack.toCharArray();
//        char[]chars2 = needle.toCharArray();
//        int flag;
//        for (int i = 0;i<haystack.length();i++){
//            int index = i;
//            flag = 0;
//            if (chars1[i] == chars2[0] && (i+needle.length())<=haystack.length()){
//                for (int j = 0;j<needle.length();j++){
//                    if (chars1[index] == chars2[j]){
//                        flag++;
//                        index++;
//                    }else{
//                        break;
//                    }
//                }
//            }
//            if (flag == needle.length()){
//                return i;
//            }
//        }
//        return -1;
//    }
//}

//这个感觉是把我的方案深度优化了一遍的结果
class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.isEmpty()){
            return 0;
        }
        char[] source = haystack.toCharArray();
        char[] need = needle.toCharArray();
        int sourceLength = source.length;
        int needLength = need.length;
        //如果剩余的长度小于搜寻串的长度的话则放弃寻找
        for (int i = 0; i <= sourceLength - needLength; i++) {
            //我靠，这个骚，直接排除了很多只有开头对应上，但结尾其实不对应的串
            if (source[i] == need[0] && source[i + needLength - 1] == need[needLength - 1]) {
                int a = i, b = 0;
                //然后从两头分别查找确定
                while (b < needLength && source[a] == need[b]) {
                    a++;
                    b++;
                }
                //如果完全一致，则返回结果
                if (b == needLength){
                    return i;
                }
            }
        }
        return -1;
    }
}
public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.strStr("mississippi","issipi"));
    }
}
//"mississippi"
//"issipi"
