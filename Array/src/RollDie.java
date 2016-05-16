import java.security.SecureRandom;

//Die-rolling program using arrays instead of switch
public class RollDie {

	public static void main(String[] args) {
		SecureRandom randomNumbers = new SecureRandom();
		int[] frequency = new int[7]; //array of frequency counters
		
		//roll die 6,000,000 times; use die value as frequency index
		for(int i = 1; i <= 6000000; i++){
			++frequency[1 + randomNumbers.nextInt(6)];
		}
		
		System.out.printf("%s%10s%n", "Face", "Frequency");
		
		//output each array element's value
		for(int i = 1; i < frequency.length; i++){
			System.out.printf("%4d%10d%n", i, frequency[i]);
		}
		
	}
}
