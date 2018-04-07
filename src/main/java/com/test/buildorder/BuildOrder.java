package com.test.buildorder;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

import com.data.structure.NodeGraph;

public class BuildOrder {

	public static void main(String[] args) {

		List<NodeGraph> projects = new ArrayList<>();
		NodeGraph a = new NodeGraph("a");
		NodeGraph b = new NodeGraph("b");
		NodeGraph c = new NodeGraph("c");
		NodeGraph d = new NodeGraph("d");
		NodeGraph e = new NodeGraph("e");
		NodeGraph f = new NodeGraph("f");

		d.addChild(a);
		b.addChild(f);
		d.addChild(b);
		a.addChild(f);
		c.addChild(d);

		projects.add(a);
		projects.add(b);
		projects.add(c);
		projects.add(d);
		projects.add(e);
		projects.add(f);

		NodeGraph root = buildOrder(projects);

		retrieveInOrder(root, 0);
	}

	private static List<NodeGraph> list = new ArrayList();

	private static void retrieveInOrder(NodeGraph root, int order) {


		if(root != null)
		{
			if(!list.contains(root))
			{
				order = order +1;
				System.out.println(order +" "+root.name);
				list.add(root);
			}
			if(root.children != null)
			{
				for(NodeGraph child : root.children)
				{
					if(!list.contains(child))
					{
						System.out.println(order+1 +" "+child.name);
						list.add(child);
					}
				}
				for(NodeGraph child : root.children)
				{
					retrieveInOrder(child, order+1);
				}
			}
		}

	}


	public static NodeGraph buildOrder(List<NodeGraph> projects)
	{
		NodeGraph root = new NodeGraph("root");
		root.children = new ArrayList<>();

		Stack<NodeGraph> projectsStack = new Stack<NodeGraph>();
		projectsStack.push(root);

		while(!projectsStack.isEmpty())
		{

			NodeGraph currentParent = projectsStack.pop();
			Iterator<NodeGraph> it_projects = projects.iterator();
			while(it_projects.hasNext())
			{
				NodeGraph dependentProject = it_projects.next();
				if(dependentProject.children == null || dependentProject.children.contains(currentParent))
				{
					if(dependentProject.children != null )
					{
						dependentProject.children.remove(currentParent);
					}

					if(currentParent.children == null) currentParent.children = new ArrayList<NodeGraph>(); 
					currentParent.children.add(dependentProject);


					if(dependentProject.children == null || dependentProject.children.size() == 0) 
					{
						projectsStack.push(dependentProject);
						it_projects.remove();
					}
				}
			}
		}
		return root;
	}
}
