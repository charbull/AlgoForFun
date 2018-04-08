package com.test;

public class IsCyclic {

	  class ListNode {
		    int data;
		    ListNode next;        
		    ListNode(int data) { this.data = data; }
		 } 
	
	public Boolean isCyclic(ListNode head) {            
	      ListNode slow = head, fast = head;
	      while(slow != null && fast !=null) {
	          //slow move 1 node
	          slow = slow.next; 
	          //fast moves 2 nodes
	          if(fast.next != null) {
	              fast = fast.next.next;
	          } else {
	              break;
	          }
	          //if slow and fast meet, there is a loop
	          if(slow == fast) { 
	              return true;
	          }
	      }            
	      return false;
	  }
	
}
