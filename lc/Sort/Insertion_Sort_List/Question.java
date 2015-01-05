package Insertion_Sort_List;

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
		l3.next = l2;
		l2.next = l1;
		ListNode head = l3;
		while(head != null){
			System.out.print(head.val + ",");
			head = head.next;
		}
		System.out.println("");
		
		ListNode head2 = q.insertionSortList(l3);
		while(head2 != null){
			System.out.print(head2.val + ",");
			head2 = head2.next;
		}
		
	}
	
	/**
	 * https://oj.leetcode.com/problems/insertion-sort-list/
	 * Sort a linked list using insertion sort.
	 */
    
    //http://blog.csdn.net/linhuanmars/article/details/21144553
	 public ListNode insertionSortList(ListNode head) {
		 if (head == null){
			 return null;
		 }
		 ListNode dummy = new ListNode(0);
		 ListNode pre = dummy;
		 ListNode cur = head;
		 //first loop(cur == head) will cut the head from original linkedlist and
		 //put it at the tail of dummy's tail;
		 //from second loop(cur == head.next), pick each new start node and 
		 //insert it into dummy's linkedlist
		 while (cur != null) { // 【注】看图
			 pre = dummy;
			 ListNode next = cur.next;
			 while (pre.next != null && cur.val >= pre.next.val) {
				 pre = pre.next;
			 }
			 cur.next = pre.next;
			 pre.next = cur;
			 cur = next;
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
