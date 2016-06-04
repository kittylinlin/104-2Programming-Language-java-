package hw1;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayTest{

	public static ArrayList<String> getSortedArrayList(String... items1){
		
		ArrayList<String> items2 = new ArrayList<String>();
		
		for(int i = 0; i < items1.length; i++){
			items2.add(i,items1[i]);
		}
		
		Collections.sort(items2);
		return items2;
	}
}

