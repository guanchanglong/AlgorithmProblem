package leetcode.简单题.两数之和;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 小关同学
 * @create 2021/12/13
 */
//暴力破解法
//class Solution {
//    public int[] twoSum(int[] nums, int target) {
//        int[]result = new int[2];
//        for (int i=0;i<nums.length;i++){
//            for (int j=0;j<i;j++){
//                if (nums[i]+nums[j]==target){
//                    result[0] = i;
//                    result[1] = j;
//                }
//            }
//        }
//        return result;
//    }
//}
//使用hashmap的特性解法
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[]result = new int[2];
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0;i<nums.length;i++){
            //如果不包含就把它放进入
            if (map.containsKey(nums[i])){
                result[0] = i;
                result[1] = map.get(nums[i]);
            }
            map.put(target-nums[i],i);
        }
        return result;
    }
}
public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[]nums = new int[]{3,3};
        int[]result = solution.twoSum(nums,6);
        System.out.println(result[0]);
        System.out.println(result[1]);
    }
}
