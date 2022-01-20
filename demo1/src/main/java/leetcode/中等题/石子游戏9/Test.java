package leetcode.中等题.石子游戏9;

/**
 * @Author 小关同学
 * @Create 2022/1/20 10:24
 */
//官方的解法
//class Solution {
//    public boolean stoneGameIX(int[] stones) {
//        int cnt0 = 0, cnt1 = 0, cnt2 = 0;
//        for (int val : stones) {
//            int type = val % 3;
//            if (type == 0) {
//                ++cnt0;
//            } else if (type == 1) {
//                ++cnt1;
//            } else {
//                ++cnt2;
//            }
//        }
//        if (cnt0 % 2 == 0) {
//            return cnt1 >= 1 && cnt2 >= 1;
//        }
//        return cnt1 - cnt2 > 2 || cnt2 - cnt1 > 2;
//    }
//}

//速度最快的解法
class Solution {
    public boolean stoneGameIX(int[] stones) {
        int[] cnt = new int[3] ;
        int n = stones.length;
        if(n == 1){
            return false;
        }
        for(int i = 0; i < n; i++) {
            cnt[stones[i] % 3]++;
        }
        if(cnt[0] % 2 == 0) {
            if(cnt[2] >= 1 && cnt[1] > cnt[2]-1){
                return true;
            }
            if(cnt[1] >= 1 && cnt[2] > cnt[1]-1){
                return true;
            }
        }else {
            if(cnt[1]-1 > cnt[2]+1){
                return true;
            }
            if(cnt[2]-1 > cnt[1]+1){
                return true;
            }
        }
        return false;
    }
}

//将类型 0 的石子考虑完全之后，我们就还剩下类型 1 和 2 的石子了。可以发现，为了保证移除石子的和不为 3 的倍数，操作顺序只有可能为下面的两种情况：
//如果 Alice 首先移除类型 1 的石子，那么 Bob 只能移除类型 1 的石子，在这之后 Alice 只能移除类型 2 的石子，Bob 同样只能移除类型 1 的石子。
//以此类推，移除石子的类型序列为：      1121212121...
//如果 Alice 首先移除类型 2 的石子，
//我们可以类似得到移除石子的类型序列为： 2212121212...

//作为先手的 Alice 可以在二者中选择一个序列。
//例如 Alice 选择第一种，那么 Bob 永远移除类型 1 的石子，Alice 除了第一步移除类型 1 的石子之外，后续永远移除类型 2 的石子。
//因此 Alice 可以获胜当且仅当：
//1、类型 1 的石子恰好只有 1 个，并且类型 2 的石子至少有 1 个。此时 Alice 在 Bob 完成第一步时获胜；
//
//2、类型 1 的石子至少有 2 个，并且不能比类型 2 的石子多：
//  (1)如果多 1 个，那么在 Alice 移除最后一个类型 2 的石子后，所有的石子都被移除，Bob 获胜；
//  (2)如果多 2 个，那么在 Bob 移除最后一个类型 1 的石子后，所有的石子都被移除，Bob 获胜；
//  (3)如果多超过 2 个，那么 Alice 会在某一步没有类型 2 的石子可以移除，Bob 获胜；
//  (4)如果一样多或类型 2 的石子更多，那么 Bob 会在某一步没有类型 1 的石子可以移除，Alice 获胜。
public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[]nums = new int[]{1,1,7,10,8,17,10,20,2,10};
        System.out.println(solution.stoneGameIX(nums));
    }
}