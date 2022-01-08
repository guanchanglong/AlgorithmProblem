package leetcode.简单题.实现Sqrt;

/**
 * @Author 小关同学
 * @Create 2022/1/8 8:34
 */
//怎么感觉这是取巧的方法
//class Solution {
//    public int mySqrt(int x) {
//        return (int)Math.sqrt((double)x);
//    }
//}

//由于 x 平方根的整数部分 ans 是满足 k^2 ≤ x 的最大 k 值，因此我们可以对 k 进行二分查找，从而得到答案。
//二分查找除了那个条件不一样之外，其他的都可以照着这个模板来写
/**
 * 第一种：基于有序数组，最基础的二分查找法查找目标值
 * @param arr 需要查找的数组
 * @param n 数组的个数
 * @param target 查找的目标值
 * @return
 * @desc 在arr[]中查找target，如果找到返回相应的index，如果没有找到就返回-1
 */
//public int binarySearch(int arr[], int n,int target) {
//    //在[l...r]上查询
//        int l=0,r=n-1,mid;
//
//        while (l<=r) {
//        mid = l + (r-l)/2;
//        if(arr[mid] == target) {
//        return mid;
//        } else if (arr[mid] > target) {
//        //在[l...mid-1]上查找
//        r = mid -1;
//        } else {
//        //在[mid+1...r]上查找
//        l = mid +1;
//        }
//        }
//        return -1;
//        }


class Solution {
    public int mySqrt(int x) {
        if (x == 0){
            return 0;
        }
        if (x == 1){
            return 1;
        }
        int left = 1,right = x-1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if (mid * mid == x){
                return mid;
            }else if (mid > x / mid){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return right;
    }
}
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.mySqrt(2));
    }
}
