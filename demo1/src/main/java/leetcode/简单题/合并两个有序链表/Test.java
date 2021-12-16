package leetcode.简单题.合并两个有序链表;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author 小关同学
 * @create 2021/12/16
 */
class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) {
         this.val = val;
     }
     ListNode(int val, ListNode next) {
         this.val = val;
         this.next = next;
     }
}

//比较容易想出来的写法
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1==null && l2==null){
            return null;
        }
        if (l1==null){
            return l2;
        }
        if (l2==null){
            return l1;
        }
        ListNode result = new ListNode();
        ListNode head = result;
        List<Integer> nums = new ArrayList<>();
        int i = 0;
        while(l1!=null){
            nums.add(l1.val);
            l1 = l1.next;
        }
        while(l2!=null){
            nums.add(l2.val);
            l2 = l2.next;
        }
        Collections.sort(nums);
        for (int j = 0;j < nums.size();j++){
            result.val = nums.get(j);
            ListNode node = new ListNode();
            if (j!=nums.size()-1){
                result.next = node;
                result = node;
            }
        }
        return head;
    }
}

//自己写的居然时间复杂度还挺不错，链表式的写法
//class Solution {
//    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//        if (l1==null && l2==null){
//            return null;
//        }
//        if (l1==null){
//            return l2;
//        }
//        if (l2==null){
//            return l1;
//        }
//        ListNode result = new ListNode();
//        ListNode head = result;
//        for (int i = 0;i<100;i++){
//            if (l1==null && l2!=null){
//                result.val = l2.val;
//                l2 = l2.next;
//            }
//            if (l2==null && l1!=null){
//                result.val = l1.val;
//                l1 = l1.next;
//            }
//            if ((l1!=null && l2!=null) && l1.val >= l2.val){
//                result.val = l2.val;
//                //l2往下
//                l2 = l2.next;
//            }else if (l1!=null && l2!=null){
//                result.val = l1.val;
//                //l1往下
//                l1 = l1.next;
//            }
//            if (l1==null && l2==null){
//                break;
//            }else{
//                ListNode node = new ListNode();
//                result.next = node;
//                result = node;
//            }
//        }
//        return head;
//    }
//}
public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(1);
        l1.next = new ListNode(3);
        l1.next.next = new ListNode(4);
        l2.next = new ListNode(2);
        l2.next.next = new ListNode(4);
        ListNode listNode = solution.mergeTwoLists(l1,l2);
        while(listNode!=null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
