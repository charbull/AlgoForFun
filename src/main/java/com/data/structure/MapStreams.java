package com.data.structure;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MapStreams {

	static Map<String, Set<String>> GroupByKey = new HashMap<>();
	
	public static void init() {
	
	Set<String> floor1List = new HashSet<String>();
	floor1List.add("fan1");
	floor1List.add("fan2");
	GroupByKey.put("floor1", floor1List);
	
	Set<String> floor2List = new HashSet<String>();
	floor2List.add("fan3");
	floor2List.add("fan4");
	GroupByKey.put("floor2", floor2List);
		
	}
	public static void main(String[] args) {
		init();
		StringBuilder sb = new StringBuilder();
		GroupByKey.entrySet().stream().forEach(entry -> {
			sb.append(" Floor :").append(entry.getKey()).append("\n");
			Set<String> typesList = entry.getValue();
			for (String type : typesList) {
				sb.append("- ").append(type).append("\n");
			}
		});
		System.out.println(sb.toString());
		
	}
	
}
