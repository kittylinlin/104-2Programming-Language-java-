package hw1;

public class Q3 {

	//建立方法名為 getSqrTotal 傳入一個int或double陣列
	//
	//回傳該陣列中所有成員的平方值加總
	
	public static void main(String[] args) {
		
		int[] array1 = {2,3,4};
		System.out.println(getSqrTotal(array1));
		
		double[] array2 = {2,3,4};
		System.out.println(getSqrTotal(array2));

	}
	public static double getSqrTotal(double[] array) {
		
		double total = 0;
		
		for(int i = 0; i < array.length; i++){
			total += array[i]*array[i];
		}
		
		return total;
		
	}
	
	public static int getSqrTotal(int[] array) {
		
		int total = 0;
		
		for(int i = 0; i < array.length; i++){
			total += array[i]*array[i];
		}
		
		return total;
		
	}
}
