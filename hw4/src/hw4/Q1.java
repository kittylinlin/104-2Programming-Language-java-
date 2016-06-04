package hw4;

public class Q1 {

	// 設計三個抽象(abstract)類別：Shape, TwoDimensionalShape,
	// ThreeDimensionalShape與四個實體類別：Circle, Square, Sphere, Cube
	// Shape抽象類別中宣告double getArea()抽象方法，並覆寫(override)toString()回傳"This is a
	// shape"字串。
	// TwoDimensionalShape抽象類別覆寫toString()回傳"This is a shape of 2D
	// (類別名稱即getClass().getName()), whose area=(getArea()之數值取小數點2位)"。
	// ThreeDimensionalShape抽象類別中宣告double getVolume()抽象方法，並覆寫toString()回傳"This
	// is a shape of 3D (類別名稱即getClass().getName()), whose
	// area=(getArea()之數值取小數點2位) and volume=(getVolume()之數值取小數點2位)"。
	// Circle類別建構子傳入一個double型別數值將其指定為半徑(radius)，覆寫getArea()回傳 π * radius2
	// (可使用Math.PI與pow方法)
	// Square類別建構子傳入一個double型別數值將其指定為邊長(length)，覆寫getArea()回傳 length2
	// Sphere類別建構子傳入一個double型別數值將其指定為半徑(radius)，覆寫getArea()回傳 4 * π * radius2
	// 及getVolume()回傳 4 * π * radius3 / 3
	// Cube類別建構子傳入一個double型別數值將其指定為邊長(length)，覆寫getArea() 6 *
	// length2回傳及getVolume()回傳 length3

	public static void main(String[] args) {
		Shape shape = new Circle(5);
		System.out.println(shape.toString());
	}

}

abstract class Shape {
	public abstract double getArea();

	@Override
	public String toString() {
		return String.format("This is a shape");
	}
}

abstract class TwoDimensionalShape extends Shape {
	@Override
	public String toString() {
		return String.format("%s of 2D %s, whose area=%.2f", super.toString(), getClass().getName(), getArea());
	}
}

abstract class ThreeDimensionalShape extends Shape {
	public abstract double getVolume();

	@Override
	public String toString() {
		return String.format("%s of 3D %s, whose area=%.2f and volume=%.2f", super.toString(), getClass().getName(),
				getArea(), getVolume());
	}
}

class Circle extends TwoDimensionalShape {
	private double radius;

	public Circle(double radius) {
		if (radius < 0.0) {
			throw new IllegalArgumentException("radius must be >= 0.0");
		}
		this.radius = radius;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		if (radius < 0.0) {
			throw new IllegalArgumentException("radius must be >= 0.0");
		}
		this.radius = radius;
	}

	@Override
	public double getArea() {
		return (Math.PI) * Math.pow(getRadius(), 2);
	}
}

class Square extends TwoDimensionalShape {
	private double length;

	public Square(double length) {
		if (length < 0.0) {
			throw new IllegalArgumentException("length must be >= 0.0");
		}
		this.length = length;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		if (length < 0.0) {
			throw new IllegalArgumentException("length must be >= 0.0");
		}
		this.length = length;
	}

	@Override
	public double getArea() {
		return Math.pow(getLength(), 2);
	}
}

class Sphere extends ThreeDimensionalShape {
	private double radius;

	public Sphere(double radius) {
		if (radius < 0.0) {
			throw new IllegalArgumentException("radius must be >= 0.0");
		}
		this.radius = radius;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		if (radius < 0.0) {
			throw new IllegalArgumentException("radius must be >= 0.0");
		}
		this.radius = radius;
	}

	@Override
	public double getArea() {
		return 4 * Math.PI * Math.pow(getRadius(), 2);
	}

	@Override
	public double getVolume() {
		return 4 * Math.PI * Math.pow(getRadius(), 3) / 3;
	}
}

class Cube extends ThreeDimensionalShape {
	private double length;

	public Cube(double length) {
		if (length < 0.0) {
			throw new IllegalArgumentException("length must be >= 0.0");
		}
		this.length = length;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		if (length < 0.0) {
			throw new IllegalArgumentException("length must be >= 0.0");
		}
		this.length = length;
	}

	@Override
	public double getArea() {
		return 6 * Math.pow(getLength(), 2);
	}

	@Override
	public double getVolume() {
		return Math.pow(getLength(), 3);
	}
}