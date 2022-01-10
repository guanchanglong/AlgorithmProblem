package leetcode.简单题.合并两个有序数组;

/**
 * @Author 小关同学
 * @Create 2022/1/10 8:21
 */
//自己的写法(双指针写法)
//双100版本
class Solution {
    static {
        System.gc();//告诉垃圾收集器打算进行垃圾收集，而垃圾收集器进不进行收集是不确定的
        System.runFinalization();//强制调用已经失去引用的对象的finalize方法
    }
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //n等于0的话，直接不用考虑nums2数组了
        while(n > 0){
            //大家都有元素的情况
            if (m > 0){
                if (nums1[m-1] >= nums2[n-1]){
                    nums1[m+n-1] = nums1[m-1];
                    m--;
                }else{
                    nums1[m+n-1] = nums2[n-1];
                    n--;
                }
            }else{ //nums1没有元素的情况，直接将nums2的元素往nums1里面放即可
                nums1[n-1] = nums2[n-1];
                n--;
            }
        }
    }
}

//看到这个解法，我震惊了...
//居然还有先合并，再用Arrays.sort排序的人才
//class Solution {
//    public void merge(int[] nums1, int m, int[] nums2, int n) {
//        int j = m;
//        for(int i = 0;i < n;i++){
//            nums1[j] = nums2[i];
//            j++;
//        }
//        Arrays.sort(nums1);
//    }
//}
public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[]nums1 = new int[]{0};
        int[]nums2 = new int[]{1};
        solution.merge(nums1,0,nums2,1);
    }
}
