package leetcode.简单题.搜索插入位置;

/**
 * @author 小关同学
 * @create 2021/12/18
 */

//自己写的
//class Solution {
//    public int searchInsert(int[] nums, int target) {
//        for (int i=0;i<nums.length;i++){
//            if (nums[i]>=target){
//                return i;
//            }
//        }
//        return nums.length;
//    }
//}

//原来题目要求的时间复杂度不超过O(log n)的意思是让用二分法来做...
//二分法做法
class Solution {
    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n - 1, ans = n;
        while (left <= right) {
            //这里是除以2的操作
            int mid = ((right - left) >> 1) + left;
            if (target <= nums[mid]) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }
}
public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[]nums = new int[]{3,4,5,6,7,8};
        System.out.println(solution.searchInsert(nums,6));
    }
}
