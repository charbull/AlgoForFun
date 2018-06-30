package com.test;

import java.io.IOException;

public class ZigZag {

	public String convert(String s, int numRows) 
	{
		char[] s_array = s.toCharArray();
		StringBuilder[] builders=new StringBuilder[numRows];
		for(int i=0; i<builders.length; i++) {
			builders[i]=new StringBuilder();
		}
		StringBuilder zigzag = new StringBuilder();

		int index = 0;
		int builderIndex = 0;
		int stringLength = s.length();

		if(stringLength < numRows || numRows == 1 || numRows == stringLength) return s;
		boolean forward = true;
		while(index < stringLength)
		{
			(builders[builderIndex]).append(s_array[index]);
			index++; 
			
			if(forward)
            {
                builderIndex++;
                if(builderIndex > numRows-1) 
                {
                    builderIndex--;
                    builderIndex--;
                    forward = false;
                }
            }
            else builderIndex--;
            if(builderIndex <0 ) 
            {
            	builderIndex = 1;
                forward = true;
            }
			
		   
		}
		for(builderIndex = 0; builderIndex< numRows; builderIndex++)
		{
			zigzag.append(builders[builderIndex].toString());
		}
		return zigzag.toString();
	}


	public static String stringToString(String input) {
		if (input == null) {
			return "null";
		}
		return input;
	}

	public static void main(String[] args) throws IOException {
		
	//	String ret = new ZigZag().convert("PAYPALISHIRING", 3);
			String ret = new ZigZag().convert("ABC", 2);
		 //ret = new ZigZag().convert("ABCD", 2);

			String out = (ret);

			System.out.print(out);
		}
}

