package leetcode.简单题.最大子数组和;

/**
 * @author 小关同学
 * @create 2021/12/18
 */
//这道题硬是没想出来解法...

//这道题居然可以用贪心，我服了。。。
//贪心的思想
//class Solution {
//    public int maxSubArray(int[] nums) {
//        if (nums==null){
//            return 0;
//        }
//        int ans = nums[0]; // 遍历所有的情况中的最大和
//
//        int sum = 0; // 当前子数组的和情况
//
//        // 遍历数组  如果有正数  那么最大和子数组应该是以正数开头正数结尾的
//        // 对于全都是负数的情况  那么遍历获取最大的负数就可以了
//        // 当正数开始  并且一直相加和>0的时候  允许你中间有部分容错（即中间存在部分负数）
//        // 此时记录遍历的最大和情况  即 ans=Math.max(sum,ans);
//        //如果和<=0了 那么代表容错没有了 加上后续的值无论后面的是正负哪种，都还不如不加
//        // 直接以后面的值作为新的子数组开头 继续遍历
//        for(int num:nums){
//            //如果和大于0  则加上遍历的数字  即使num<0也没事  允许其有部分容错
//            if (sum > 0){
//                sum += num;
//            }else{
//                // 和小于0了  那么就让和等于num  就代表从该值重新开启新的连续子数组
//                sum = num;
//            }
//            //保存获得此时最大和
//            ans = Math.max(sum,ans);
//        }
//        return ans;
//    }
//}

//官方动态规划解法
//怎么看着也是一个贪心...
class Solution {
    public int maxSubArray(int[] nums) {
        int pre = 0, maxAns = nums[0];
        for (int x : nums) {
            pre = Math.max(pre + x, x);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }
}

public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[]nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(solution.maxSubArray(nums));
    }
}
