package leetcode.简单题.删除排序链表中的重复元素;

/**
 * @Author 小关同学
 * @Create 2021/12/24 17:05
 */
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

//自己写的链表遍历法
//class Solution {
//    public ListNode deleteDuplicates(ListNode head) {
//        ListNode result = head;
//        if (head==null){
//            return null;
//        }
//        while(head!=null){
//            //这里要注意的是，如果进行了元素删除，千万不要再遍历到下一个元素
//            if (head.next!=null && head.val==head.next.val){
//                ListNode node = head.next;
//                head.next = node.next;
//            }else{
//                head = head.next;
//            }
//        }
//        return result;
//    }
//}

//网上的递归法，时间复杂度都一样
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        //第一次传入null
        if (head == null) {
            return null;
        }

        //结束条件
        if (head.next == null) {
            return head;
        }

        head.next = deleteDuplicates(head.next);
        if (head.val == head.next.val) {
            return head.next;
        } else {
            return head;
        }
    }
}

public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode head = new ListNode(1);
        ListNode target = head;
        for (int i = 1;i<5;i++){
            ListNode node = new ListNode(1);
            head.next = node;
            head = node;
        }
        ListNode node = new ListNode(4);
        head.next = node;
        head = solution.deleteDuplicates(target);
        while(head!=null){
            System.out.println(head.val);
            head = head.next;
        }
    }
}
