package hw3;

public class Q2 {

	// 建立一個名為Direction的列舉型別,依序包含 North, Northeast, East, Southeast, South,
	// Southwest, West, Northwest 八個方向,
	// 每個方位包含一個整數參數 degree 輸入該方位角度從North開始分別是0,45,90,135,180,225,270,315
	// 並提供 getDegree() 方法已取得該方位之角度值。

	public static void main(String[] args) {
		System.out.println(Direction.West);

	}

}

enum Direction {

	North(0), Northeast(45), East(90), Southeast(135), South(180), Southwest(225), West(270), Northwest(315);

	private final int degree;

	Direction(int degree) {
		this.degree = degree;
	}

	public int getDegree() {
		return degree;
	}
}
