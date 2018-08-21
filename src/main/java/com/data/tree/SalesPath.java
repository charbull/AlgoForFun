package com.data.tree;

class Solution {

	/*
	 * The car manufacturer Honda holds their distribution system in the form of a tree (not necessarily binary). The root is the company itself, and every node in the tree represents a car distributor that receives cars from the parent node and ships them to its children nodes. The leaf nodes are car dealerships that sell cars direct to consumers. In addition, every node holds an integer that is the cost of shipping a car to it.

Take for example the tree below:

alt

A path from Honda’s factory to a car dealership, which is a path from the root to a leaf in the tree, is called a Sales Path. The cost of a Sales Path is the sum of the costs for every node in the path. For example, in the tree above one Sales Path is 0→3→0→10, and its cost is 13 (0+3+0+10).

Honda wishes to find the minimal Sales Path cost in its distribution tree. Given a node rootNode, write a function getCheapestCost that calculates the minimal Sales Path cost in the tree.

Implement your function in the most efficient manner and analyze its time and space complexities.

For example:

Given the rootNode of the tree in diagram above

Your function would return:

7 since it’s the minimal Sales Path cost (there are actually two Sales Paths in the tree whose cost is 7: 0→6→1 and 0→3→2→1→1)

Constraints:

    [time limit] 5000ms

    [input] Node rootNode
        0 ≤ rootNode.cost ≤ 100000

    [output] integer

	 * 
	 * 
	 * */
	
	
	static class Node {

		int cost;
		Node[] children;
		Node parent;

		Node(int cost) {
			this.cost = cost;
			children = null;
			parent = null;
		}
	}

	static class SalesPath {

		int getCheapestCost(Node rootNode) {

			if(rootNode == null) return 0;
			else
			{
				if(rootNode.children == null) return rootNode.cost;
				else
				{
					int min = Integer.MAX_VALUE;
					for(Node child: rootNode.children)
					{
						min = Math.min(min, getCheapestCost(child));
					}
					return min + rootNode.cost;
				}
			}

		}
	}
	/*
    function getCheapestCost(rootNode):
    n = rootNode.numberOfChildren()

    if (n == 0):
        return rootNode.cost
    else:
        # initialize minCost to the largest integer in the system
        minCost = MAX_INT
        for i from 0 to n-1:
            tempCost = getCheapestCost(rootNode.child[i])
            if (tempCost < minCost):
                minCost = tempCost

    return minCost + rootNode.cost
    O(n) 

    //for all positive values
     0
   2   10

   1    2   7



  /*********************************************
	 * Driver program to test above method     *
	 *********************************************/

	public static void main(String[] args) {

		Node n0 = new Node(0);
		Node n6 = new Node(6);
		Node n3 = new Node(3);
		Node n5 = new Node(5);
		n0.children = new Node[3];
		n0.children[0] = n5;
		n0.children[1] = n3;
		n0.children[2] = n6;

		Node n1 = new Node(1);
		Node n55 = new Node(5);
		n6.children = new Node[2];
		n6.children[0] = n55;
		n6.children[1] = n1;


		Node n4 = new Node(4);
		n5.children = new Node[1];
		n5.children[0] = n4;

		Node n2 = new Node(2);
		Node n00 = new Node(0);
		n3.children = new Node[2];
		n3.children[0] = n2;
		n3.children[1] = n00;

		n00.children = new Node[1];

		Node n11 = new Node(1);
		n2.children = new Node[1];
		n2.children[0] = n11;


		Node n10 = new Node(10);
		n00.children[0] = n10;
		Node n111 = new Node(1);    
		n11.children = new Node[1];
		n11.children[0] = n111;

		SalesPath spath = new SalesPath();
		System.out.println("Cost "+spath.getCheapestCost(n0));



	}
}
