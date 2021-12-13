package leetcode.简单题.罗马数字转整数;

/**
 * @author 小关同学
 * @create 2021/12/13
 */
//暴力破解
//class Solution {
//    public int romanToInt(String s) {
//        Map<String,Integer> map = new HashMap<>();
//        map.put("I",1);
//        map.put("IV",4);
//        map.put("V",5);
//        map.put("IX",9);
//        map.put("X",10);
//        map.put("XL",40);
//        map.put("L",50);
//        map.put("XC",90);
//        map.put("C",100);
//        map.put("CD",400);
//        map.put("D",500);
//        map.put("CM",900);
//        map.put("M",1000);
//        int num = 0;
//        for (int i = s.length();i>=0;i--){
//            int target = 0;
//            if (i>1){
//                String s1 = s.substring(i-2,i);
//                if (map.containsKey(s1)){
//                    num += map.get(s1);
//                    i = i-1;
//                    target = 1;
//                }
//            }
//            if ((i-1)>=0 && target==0){
//                String s2 = s.substring(i-1,i);
//                if (map.containsKey(s2)){
//                    num += map.get(s2);
//                }
//            }
//        }
//        return num;
//    }
//}
//1         I
//2         II
//3         III
//4         IV
//5         V
//6         V+I
//7         V+II
//8         V+III
//9         IX
//10        X
//11        X+I
//12        X+II
//13        X+III
//14        X+IV
//15        X+V
//16        X+V+I
//17        X+V+II
//18        X+V+III
//19        X+IX
//20        X+X
//40        XL
//50        L
//90        XC
//100       C
//400       CD
//500       D
//900       CM
//1000      M

//一个很秀的解法
//没有使用Map，纯粹靠字符串的操作解答题目
class Solution {
    public int romanToInt(String s) {
        s = s.replace("IV","a");
        s = s.replace("IX","b");
        s = s.replace("XL","c");
        s = s.replace("XC","d");
        s = s.replace("CD","e");
        s = s.replace("CM","f");

        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            res += getValue(s.charAt(i));
        }
        return res;
    }

    public int getValue(char c) {
        switch(c) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            case 'a': return 4;
            case 'b': return 9;
            case 'c': return 40;
            case 'd': return 90;
            case 'e': return 400;
            case 'f': return 900;
        }
        return 0;
    }
}


public class Test1 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.romanToInt("LVIII"));
    }
}
//L+V+III       50+5+3
//M+CM+XC+IV    1000+900+90+4