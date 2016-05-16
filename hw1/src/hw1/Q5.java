package hw1;

public class Q5 {

	//建立一類別 ArrayTest 內含一"靜態"(static)方法，名為 getSortedArrayList
	//
	//傳入可變參數String若干個，傳出所有字串排序後的ArrayList型別物件
	//
	//提示：該類別前需指定匯入下列兩個套件
	//
	//import java.util.ArrayList;
	//
	//import java.util.Collections;
	
	public static void main(String[] args) {
		
		System.out.println(ArrayTest.getSortedArrayList("Mark", "Andrew", "Beth"));
		System.out.println(ArrayTest.getSortedArrayList("Hello","World","Java"));
	
	}

}
