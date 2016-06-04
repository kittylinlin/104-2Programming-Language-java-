package hw4;

public class Q2 {
	
	//	請建立三個方法，分別是：
	//	void someMethod1()
	//	void someMethod2()
	//	someMethod1呼叫someMethod2, someMethod2呼叫someMethod3
	//	由someMethod3擲出Exception，someMethod2接獲例外後重擲出，
	//	someMethod1接獲例外物件後，呼叫其getStackTrace()方法，
	//	將回傳的 StackTraceElement陣列，分行列出各個項目getMethodName()內容。(可使用enhanced for)
	
	public static void main(String[] args) {
		
		someMethod1();

	}
	private static void someMethod1(){
		
		try{
			someMethod2();
		}
		catch(Exception e){
			for (StackTraceElement element : e.getStackTrace())
				System.out.println(element.getMethodName());
		}
	}

	private static void someMethod2() throws Exception{
		try{
			someMethod3();
		}
		catch(Exception e){
			throw e;
		}
	}

	private static void someMethod3() throws Exception{
		throw new Exception();
	}
}
