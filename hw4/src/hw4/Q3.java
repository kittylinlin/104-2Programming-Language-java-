package hw4;

public class Q3 {

	// (1)建立兩個例外類別 ExceptionA 與 ExceptionB
	// ExceptionA繼承自Exception類別，ExceptionB繼承自ExceptionA類別.
	// 此兩個例外類別不須添加成員且建構子皆採用預設的即可。
	// (2)同時設計一個方法 void handle() 內容為：
	// 呼叫 someMethod() 並捕獲其可能擲出之例外物件，
	// 以指定Exception類別物件捕捉，並直接用System.out.print輸出該物件。

	public static void main(String[] args) {
		handle();
	}

	public static void someMethod() throws Exception {
		throw new ExceptionA();
	}

	public static void handle() {
		try {
			someMethod();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}

class ExceptionA extends Exception {

}

class ExceptionB extends ExceptionA {

}
