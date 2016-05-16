package hw2;

public class Q1 {

	// Create a class Rectangle with attributes length and width, each of which
	// defaults to 1.
	// Provides methods perimeter() and area() that calculate the rectangle's
	// perimeter and area.
	// It has set and get methods for both length and width.
	// The set methods should verify that length and width are each
	// double-precision floating-point numbers larger than 0.0 and less than
	// 20.0,
	// otherwise it will be set to default value 1.

	public static void main(String[] args) {
		Rectangle r = new Rectangle();
		r.setLength(3);
		r.setWidth(5);
		System.out.println(r.perimeter());
	}
}

class Rectangle {
	private double length;
	private double width;

	public Rectangle() {

	}

	public double setLength(double length) {
		this.length = length;
		if (this.length > 0.0 && this.length < 20.0) {
			return this.length;
		}
		return 1;
	}

	public double setWidth(double width) {
		this.width = width;
		if (this.width > 0.0 && this.width < 20.0) {
			return this.width;
		}
		return 1;
	}

	public double perimeter() {
		return (setLength(length) + setWidth(width)) * 2;
	}

	public double area() {
		return (setLength(length) * setWidth(width));
	}
}