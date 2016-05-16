//poll analysis program
public class StudentPoll {

	public static void main(String[] args) {
		//student response array (more typically, input at runtime)
		int[] responses = {1,2,5,4,3,5,2,1,3,3,1,4,3,3,3,2,3,3,2,14};
		int[] frequency = new int[6]; //array of frequency counter
		
		//for each answer, select responses element and use that value
		//as frequency index to determine element to increment
		for(int i = 0; i < responses.length; i++){
			try {
				++frequency[responses[i]];
			}
			catch (ArrayIndexOutOfBoundsException e){
				System.out.println(e); //invoke toSrting method
				System.out.printf(" responses[%d] = %d%n%n", i, responses[i]);
			}
		}

		System.out.printf("%s%10s%n", "Rating", "Frequency");
		
		//output each array element's value
		for(int i = 1; i < frequency.length; i++){
			System.out.printf("%6d%10d%n", i, frequency[i]);
		}
	}
}
