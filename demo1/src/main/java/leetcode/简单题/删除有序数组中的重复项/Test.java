package leetcode.简单题.删除有序数组中的重复项;

/**
 * @author 小关同学
 * @create 2021/12/16
 */
//这道题我挺有印象的，因为是原地删除
//所以这个就是最优的算法
class Solution {
    public int removeDuplicates(int[] nums) {
        int num = 0;
        for (int i = 1;i<nums.length;i++){
            if (nums[num] != nums[i]){
                nums[++num] = nums[i];
            }
        }
        num++;
        return num;
    }
}
public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[]nums = new int[]{0,0,1,1,1,2,2,3,3,4};
        solution.removeDuplicates(nums);
//        System.out.println(solution.removeDuplicates(nums));
    }
}
