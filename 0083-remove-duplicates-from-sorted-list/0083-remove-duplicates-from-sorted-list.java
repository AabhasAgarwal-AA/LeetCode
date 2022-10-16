/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    ListNode th = null, tt = null;
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode curr = head;
        while(curr != null){
            ListNode forw = curr.next;
            curr.next = null;
            if(tt == null || tt.val != curr.val)
                addLast(curr);
            curr = forw;
        }
        return th;
    }
    private void addLast(ListNode node){
        if(tt == null){ 
            th = tt = node;
        }else{ 
            tt.next = node;
            tt = node;
        }
    }
}