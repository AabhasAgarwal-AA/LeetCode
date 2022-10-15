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
    public ListNode sortList(ListNode head) {
        return mergeSort(head);
    }
    public ListNode mergeSort(ListNode head){
        if(head == null || head.next == null)
            return head;
        
        ListNode mid = midNode(head);
        ListNode nHead = mid.next;
        mid.next = null;
        
        ListNode l1 = mergeSort(head);
        ListNode l2 = mergeSort(nHead);
        
        return mergeTwoSLL(l1, l2);
    }
    private ListNode midNode(ListNode node){
        if(node == null || node.next == null)
            return node;
        ListNode fast = node, slow = node;
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    
    private ListNode mergeTwoSLL(ListNode l1, ListNode l2){
        if(l1 == null || l2 == null)
            return l1 != null ? l1 : l2;
        
        ListNode c1 = l1, c2 = l2;
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        
        while(c1 != null && c2 != null){
            if(c1.val < c2.val){
                prev.next = c1;
                c1 = c1.next;
            }else{
                prev.next = c2;
                c2 = c2.next;
            }
            prev = prev.next;
        }
        prev.next = (c1 != null ? c1 : c2);
        return dummy.next;
    }
}