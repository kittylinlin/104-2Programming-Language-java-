package hw1;

public class Q1 {

	// 建立一個方法，其名稱與參數如下：
	//
	// getSecondRight(double[] array)
	//
	// 傳回array陣列倒數第二個值

	public static void main(String[] args) {

		double[] array1 = { 10, 9, 8, 7, 6 };
		System.out.printf("%.2f%n", getSecondRight(array1));

		double[] array2 = { 1.1, 2.2, 3.3, 4.4, 5.5 };
		System.out.printf("%.2f%n", getSecondRight(array2));

	}

	public static double getSecondRight(double[] array) {

		return array[array.length - 2];

	}

}
