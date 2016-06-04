package hw1;

public class Q2 {
	
	//建立一個方法其名稱參數如下:
	//
	//getArrayMax(int array[])
	//
	//傳回該array最大值
	
	public static void main(String[] args) {
		
		int[] array1 = {2,3,4,5};
		System.out.println(getArrayMax(array1));
		
		int[] array2 = {10,9,8,7,6};
		System.out.println(getArrayMax(array2));
		
	}
	
	public static int getArrayMax(int array[]){
		
		int max = Integer.MIN_VALUE;
		
		for(int i = 0; i < array.length; i++){
			if(array[i] > max){
				max = array[i];
			}
		}
		
		return max;
		
	}
	
}
