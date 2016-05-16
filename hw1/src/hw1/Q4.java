package hw1;

public class Q4 {
	
	//建立一方法名為 getAverage ，可傳入任意個數的double型別數值，為其參數
	//	
	//傳回所有傳入參數之平均值

	public static void main(String[] args) {
		
		System.out.printf("%.1f%n",getAverage(20,30,40,50));
		System.out.printf("%.1f",getAverage(10,100,0));
		
	}
	
	public static double getAverage(double...num){
		
		double sum = 0; 
		
		for(int i = 0; i < num.length; i++){
			sum += num[i];			
		}
		
		return sum/num.length;
		
	}

}
