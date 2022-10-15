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
    ListNode tempHead = null;
    ListNode tempTail = null;
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null)
            return head;
        
        int len = length(head);
        ListNode curr = head;
        ListNode origHead = null, origTail = null;
        while(len >= k){
            int tempk = k;
            while(tempk-- > 0){
                ListNode forw = curr.next;
                curr.next = null;
                addFirstNode(curr);
                curr = forw;
            }
            if(origHead == null){
                origHead = tempHead;
                origTail = tempTail;
            }else{
                origTail.next = tempHead;
                origTail = tempTail;
            }
            tempHead = null;
            tempTail = null;
            len -= k;
        }
        origTail.next = curr;
        return origHead;
    }
    
    private int length(ListNode head){
        int len = 0;
        ListNode curr = head;
        while(curr != null){
            curr = curr.next;
            len++;
        }
        return len;
    }
    
    private void addFirstNode(ListNode node){
        if(tempHead == null){
            tempHead = node;
            tempTail = node;
        }else{
            node.next = tempHead;
            tempHead = node;
        }
    }
}