//initializing the elements of an array with an array initializer
public class InitArray2 {

	public static void main(String[] args) {
		
		int[] array = {32,27,64,18,95,14,90,70,60,37};
		System.out.printf("%s%8s%n","Index","Value");
		
		for(int i = 0; i < array.length; i++){
			System.out.printf("%5d%8d%n",i,array[i]);
		}
	}

}