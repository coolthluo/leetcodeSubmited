/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode plusOne(ListNode head) {
        if (dfs(head) == 0){
            return head;
        } else {
            ListNode newHead = new ListNode(1);
            newHead.next = head;
            return newHead;
        }
    }
    
    public int dfs(ListNode head){
        if(head == null) {
            return 1;
        }
        int carry = dfs(head.next);
        
        if(carry == 0) {
            return 0;
        }
        int val = head.val + 1;
        head.val = val % 10;
        return val / 10;
    }
}