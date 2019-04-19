package com.test;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class IPAddressRecovery {

	
	public static ArrayList<String> generateIPAddrs(String input) {
		  class IpLevelNode {
		    public int level = 0;
		    public String predecessor;
		    public String successor;

		    public IpLevelNode(int level, String ipToAppend, String predecessor, String successor) {
		      this.level = level;
		      this.successor = successor;
		      if (level == 0) {
		          this.predecessor = ipToAppend;
		      } else {
		          this.predecessor = predecessor + "." + ipToAppend;
		      }
		    }
		  }
		  
		  ArrayList<String> out = new ArrayList<>();
		  Deque<IpLevelNode> stack = new LinkedList<>();
		  // Push 3 possibilities onto the stack
		  stack.addFirst(new IpLevelNode(0, input.substring(0,1),"", input.substring(1)));
		  stack.addFirst(new IpLevelNode(0, input.substring(0,2),"", input.substring(2)));
		  stack.addFirst(new IpLevelNode(0, input.substring(0,3),"", input.substring(3)));

		  while(!stack.isEmpty()){
		    IpLevelNode node = stack.removeFirst();
		    int curlevel = node.level;
		    String predecessor = node.predecessor;
		    String remaining = node.successor;
		    if(curlevel == 3 && remaining.length() == 0){
		        out.add(node.predecessor);
		        continue;
		    }
		    int i = 1;
		    while(i <= 3){
		      if(remaining.length() < i) break;
		      String ipToAppend = remaining.substring(0,i);
		      String successor = remaining.substring(i);
		      if(ipToAppend.length() > 0){
		        int numIpToAppend = Integer.parseInt(ipToAppend);
		        if(numIpToAppend <= 255) stack.addFirst(new IpLevelNode(curlevel+1,ipToAppend,predecessor,successor));
		      }
		      i++;
		    }
		  }
		  return out; 
		}
	
}
