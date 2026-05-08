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

    public int findSize(ListNode head) {
        int count = 0;

        while (head != null) {
            count++;
            head = head.next;
        }

        return count;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {

        int len = findSize(head);

        // If head itself should be removed
        if (len == n) {
            return head.next;
        }

        int nodeToRemove = len - n;

        ListNode temp = head;

        // Move to previous node of target
        while (nodeToRemove > 1) {
            temp = temp.next;
            nodeToRemove--;
        }

        // Remove node
        temp.next = temp.next.next;

        return head;
    }
}