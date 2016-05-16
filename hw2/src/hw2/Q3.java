package hw2;

public class Q3 {

	// 在Date Class(如下圖)中至少新增一個方法:
	// public void nextDay() //將Date物件增加一天
	// 答案不須建立Date類別，只需撰寫方法。

	public static void main(String[] args) {

		Date d = new Date(4, 25, 2016);
		d.nextDay();
		System.out.println(d.toString());

	}

}

class Date {

	private int month; // 1-12
	private int day; // 1-31
	private int year; // any year

	private static final int[] daysPerMonth = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	// constructor: confirm proper value for month and day given the year
	public Date(int month, int day, int year) {

		// check if month in range
		if (month <= 0 || month > 12) {
			throw new IllegalArgumentException("month (" + month + ") must be 1-12");
		}

		// check if day in range for month
		if (day <= 0 || day > daysPerMonth[month] && !(month == 2 && day == 29)) {
			throw new IllegalArgumentException("day (" + day + ") out-of-range for the specified month and year");
		}

		// check for leap year if month is 2 and day is 29
		if (month == 2 && day == 29 && !(year % 400 == 0 || (year % 4 == 0 && year % 100 != 0))) {
			throw new IllegalArgumentException("day (" + day + ") out-of-range for the specified month and year");
		}

		this.month = month;
		this.day = day;
		this.year = year;
	}

	// return a string of the form month/day/year
	public String toString() {
		return String.format("%d/%d/%d", month, day, year);
	}

	// 將Date物件增加一天
	public void nextDay() {
		day = day + 1;
		if (day > daysPerMonth[month] && !(month == 2 && day == 29)) {
			month = month + 1;
			day = 1;
		}
		if (month == 2 && day == 29 && !(year % 400 == 0 || (year % 4 == 0 && year % 100 != 0))) {
			day = 1;
			month = month + 1;
		}
		if (month > 12) {
			month = 1;
			year = year + 1;
		}
	}
}