package com.babel.es;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Khushboo Taneja
 *
 */
public class TestList {
	
	
	public int add(int a, int b)
	{
		int c = a+ b;
		return c;
	}
	
	public static void main(String[] args) {
		
		TestList tl = new TestList();
		System.out.println(tl.add(3, 4));
		
		
		
		/*List<String> dataList = new ArrayList<>();	
		dataList.add("apple");
		dataList.add("mango");
		dataList.add("orange");
		dataList.add("peach");
		dataList.add("grapes");
		dataList.add("dates");
		
		Collections.sort(dataList);
		
		for(String fruitName : dataList)
		{
			System.out.println(fruitName);
		}*/
	}

}
