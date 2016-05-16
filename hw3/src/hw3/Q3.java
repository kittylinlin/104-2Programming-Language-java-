package hw3;

public class Q3 {
	// 目前已有CommissionEmployee(程式內容如下圖)為薪資採銷售抽成之職員類別程式其繼承自Employee父類別，
	// 請設計Employee類別包含firstName, lastName, socialSecurityNumber三個欄位及相應get方法，
	// 並提供toString()之輸出格式為：
	// employee:
	// social security number:
	// 以便CommissionEmployee類別能成功建立繼承關係。
	// 並同時設計HourlyEmployee類別繼承自Employee，提供以小時計薪資之職員類別程式，
	// 多了工時與時薪欄位hours,wage都是double型別，因此建構子需多增加二個double型別參數，
	// 新增setHours(double)設定hours值並檢查工時介於0~168之間、setWage(double)設定wage值並檢查薪資非負值，
	// 否則產生IllegalArgumentException例外物件擲出，
	// 分別含有訊息: "Hours must be >= 0.0 and <= 168.0" 以及 "Wage must be >= 0.0"
	// 新增getHours()與getWage()方法回傳工時與時薪數值，
	// 且earnings()方法之薪資計算公式 hours * wage ，其中hours超過40小時部分則時薪為1.5倍，
	// toString()之輸出格式亦調整新增下列粗體文字與資料：
	// hourly employee:
	// social security number:
	// hours: (時數資料小數點後取一位數)
	// wage: (時薪資料小數點後取兩位數)
	public static void main(String[] args) {

		CommissionEmployee employee = new CommissionEmployee("Bob", "Lewis", "333-33-3333", 5000, .04);
		System.out.println(employee.toString());

		HourlyEmployee employee2 = new HourlyEmployee("Bob", "Lewis", "333-33-3333", 50, 20);
		System.out.println(employee2.getClass().getSuperclass());
	}

}

class Employee {

	private final String firstName;
	private final String lastName;
	private final String socialSecurityNumber;

	public Employee(String firstName, String lastName, String socialSecurityNumber) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.socialSecurityNumber = socialSecurityNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getSocialSecurityNumber() {
		return socialSecurityNumber;
	}

	public String toString() {

		return String.format("%s: %s %s%n%s: %s", "employee", getFirstName(), getLastName(), "social security number",
				getSocialSecurityNumber());
	}

}

class CommissionEmployee extends Employee {

	private double grossSales; // gross weekly sales
	private double commissionRate; // commission percentage

	// five-argument constructor
	public CommissionEmployee(String firstName, String lastName, String socialSecurityNumber, double grossSales,
			double commissionRate) {

		super(firstName, lastName, socialSecurityNumber);
		// if grossSales is invalid throw exception
		if (grossSales < 0.0) {
			throw new IllegalArgumentException("Gross sales must be >= 0.0");
		}

		// if commissionRate is invalid throw exception
		if (commissionRate <= 0.0 || commissionRate >= 1.0) {
			throw new IllegalArgumentException("Commission rate must be > 0.0 and < 1.0");
		}

		this.grossSales = grossSales;
		this.commissionRate = commissionRate;
	} // end constructor

	// set gross sales amount
	public void setGrossSales(double grossSales) {
		if (grossSales < 0.0) {
			throw new IllegalArgumentException("Gross sales must be >= 0.0");
		}
		this.grossSales = grossSales;
	}

	// return gross sales amount
	public double getGrossSales() {
		return grossSales;
	}

	// set commission rate
	public void setCommissionRate(double commissionRate) {
		if (commissionRate <= 0.0 || commissionRate >= 1.0) {
			throw new IllegalArgumentException("Commission rate must be > 0.0 and < 1.0");
		}
		this.commissionRate = commissionRate;
	}

	// return commission rate
	public double getCommissionRate() {
		return commissionRate;
	}

	// calculate earnings
	public double earnings() {
		return getCommissionRate() * getGrossSales();
	}

	// return String representation of CommissionEmployee object
	@Override
	public String toString() {
		return String.format("%s %s%n%s: %.2f%n%s: %.2f", "commission", super.toString(), "gross sales",
				getGrossSales(), "commission rate", getCommissionRate());
	}
} // end class CommissionEmployee

class HourlyEmployee extends Employee {
	private double hours;
	private double wage;

	public HourlyEmployee(String firstName, String lastName, String socialSecurityNumber, double hours, double wage) {

		super(firstName, lastName, socialSecurityNumber);

		if (hours < 0 || hours > 168) {
			throw new IllegalArgumentException("Hours must be >= 0.0 and <= 168.0");
		}
		if (wage < 0) {
			throw new IllegalArgumentException("Wage must be >= 0.0");
		}

		this.hours = hours;
		this.wage = wage;
	}

	public void setHours(double hours) {

		if (hours < 0 || hours > 168) {
			throw new IllegalArgumentException("Hours must be >= 0.0 and <= 168.0");
		}
		this.hours = hours;
	}

	public double getHours() {
		return hours;
	}

	public void setWage(double wage) {

		if (wage < 0) {
			throw new IllegalArgumentException("Wage must be >= 0.0");
		}
		this.wage = wage;
	}

	public double getWage() {
		return wage;
	}

	public double earnings() {
		if (hours > 40) {
			return (40 * wage) + (hours - 40) * (wage * 1.5);
		} else {
			return hours * wage;
		}
	}

	@Override
	public String toString() {
		return String.format("%s %s%n%s: %.1f%n%s: %.2f", "hourly", super.toString(), "hours", getHours(), "wage",
				getWage());
	}

}