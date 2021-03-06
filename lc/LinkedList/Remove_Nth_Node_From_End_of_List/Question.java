package Remove_Nth_Node_From_End_of_List;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Question q = new Question();
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		node1.next = node2;
		node2.next = node3;
		ListNode head = node1;
		ListNode current = head;		
		
		while(current != null){
			System.out.print(current.val + ",");
			current = current.next;
		}
		System.out.println("=========");
		q.removeNthFromEnd(head, 1);
		current = head;
		while(current != null){
			System.out.print(current.val + ",");
			current = current.next;
		}

	}
	
	/**
	 * https://oj.leetcode.com/problems/remove-nth-node-from-end-of-list/
	 * Given a linked list, remove the nth node from the end of list and return
	 * its head.
	 * 
	 * For example,
	 * Given linked list: 1->2->3->4->5, and n = 2.
	 * After removing the second node from the end, the linked list becomes
	 * 1->2->3->5. 
	 * 
	 * Note: Given n will always be valid. Try to do this in one pass.
	 */

	// 【注】1.想删掉倒数第n个，runner应该比walker提前走n-1步
	// 【注】2.这里之所以用pre.next来代替cur作为walker的原因是：
	// 当我们把cur移动到倒数第n的时候，这是我们想要删除cur，但是如果没有pre的指针 是做不到的，
	// 所以我们必须维护pre，然后用pre.next = pre.next.next来删除pre.next(即cur)
	//http://answer.ninechapter.com/solutions/remove-nth-node-from-end-of-list/
	public ListNode removeNthFromEnd(ListNode head, int n) {
		if (head == null || head.next == null) {
    		return null;
    	}
    	ListNode dummy = new ListNode(0); //用了dummy，因为有可能head就是要删除的
    	dummy.next = head;
    	ListNode pre = dummy; // 用pre.next表示walker
    	ListNode runner = head;
    	for (int i = 1; i < n; i++) { // 让runner提前走n - 1步。
    		if (runner == null) {//如果链表长度不足n，则返回原链表
    			return head;
    		} else {
    			runner = runner.next;
    		}
    	}
    	while (runner.next != null) {
    		runner = runner.next;
    		pre = pre.next;
    	}
    	pre.next = pre.next.next; //删去pre.next那个位置的node
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