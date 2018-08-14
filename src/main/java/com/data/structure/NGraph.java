package com.data.structure;

import java.util.ArrayList;
import java.util.List;


public class NGraph {


	int data;
	public List<NGraph> children;

	public NGraph(int d)
	{
		data = d;
	}

	public void addChild(NGraph child)
	{
		if(children != null)
		{
			children.add(child);
		}
		else 
		{
			children = new ArrayList<NGraph>();
			children.add(child);
		}
	}
}
