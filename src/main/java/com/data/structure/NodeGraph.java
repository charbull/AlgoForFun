package com.data.structure;

import java.util.ArrayList;
import java.util.List;

public class NodeGraph {
	public String name;
	public List<NodeGraph> children;
	
	
	public NodeGraph(String name)
	{
		this.name = name;
	}
	
	public void addChild(NodeGraph child)
	{
		if(children == null) children = new ArrayList<NodeGraph>();
		children.add(child);
	}
}
