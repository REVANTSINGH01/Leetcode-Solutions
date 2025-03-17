/**
 *    LEETCODE PROBLEM: LINKED LIST CYCLE
 *
 * Given the `head` of a linked list, determine if it has a cycle.
 *
 * Example 1:
 * Input: head = [3,2,0,-4] (pos = 1)
 * Output: true
 *
 * Example 2:
 * Input: head = [1,2] (pos = 0)
 * Output: true
 *
 * Example 3:
 * Input: head = [1] (pos = -1)
 * Output: false
 *
 * Approach:
 * - Use the Floyd’s Cycle Detection Algorithm (Tortoise and Hare method).
 * - Move `slow` one step and `fast` two steps at a time.
 * - If `slow` and `fast` meet, there is a cycle.
 * - If `fast` reaches `null`, there is no cycle.
 *
 * Time Complexity: O(N) - In the worst case, we traverse the entire list.
 * Space Complexity: O(1) - Only two pointers are used.
 */

public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}
