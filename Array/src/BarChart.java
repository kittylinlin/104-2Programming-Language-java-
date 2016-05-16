//bar chart printing program
public class BarChart {

	public static void main(String[] args) {
		int[] array = {0,0,0,0,0,0,1,2,4,2,1};
		
		System.out.println("Grade distribution:");
		
		//for each array element, output a bar of the chart
		for(int i = 0; i < array.length; i++){
			//output bar label ("00-09: ", ... , "90-99: ", "100: ")
			if(i == 10){
				System.out.printf("%5d: ", 100);
			}
			else {
				System.out.printf("%02d-%02d: ", i * 10, i * 10 + 9);
			}
			
			//print bar of asterisks
			for(int j = 0; j < array[i]; j++){
				System.out.printf("*");
			}
			
			System.out.println();
		}
	}
}
