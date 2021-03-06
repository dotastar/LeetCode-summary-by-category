package Swap_Nodes_in_Pairs;


public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Question q = new Question();
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		ListNode l5 = new ListNode(5);
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		ListNode head = l1;
		while(head != null){
			System.out.print(head.val + ",");
			head = head.next;
		}
		System.out.println("");
		ListNode head2 = q.swapPairs(l1);
		while(head2 != null){
			System.out.print(head2.val + ",");
			head2 = head2.next;
		}
	}
	
	/**
	 * https://oj.leetcode.com/problems/swap-nodes-in-pairs/
	 * Given a linked list, swap every two adjacent nodes and return its head.
	 * 
	 * For example, 
	 * Given 1->2->3->4, you should return the list as 2->1->4->3.
	 * 
	 * Your algorithm should use only constant space. You may not modify the
	 * values in the list, only nodes itself can be changed.
	 */
	
	public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode pre = dummy;
		ListNode cur = head;
		while (cur != null && cur.next != null) { // 画图
			ListNode next = cur.next;
			cur.next = next.next;
			next.next = cur;
			pre.next = next;
			pre = cur;
			cur = cur.next;
		}
		return dummy.next;
	}
}


class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }