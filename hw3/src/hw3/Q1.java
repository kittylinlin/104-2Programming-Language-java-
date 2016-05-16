package hw3;

public class Q1 {
	// 目前已有CommissionEmployee(程式如下圖)為薪資採銷售抽成之職員類別程式
	// 請設計BasePlusCommissionEmployee以合成(Composition)方式包含CommissionEmployee物件，
	// 提供有底薪之銷售抽成職員類別程式，比CommissionEmployee多了底薪欄位baseSalary，
	// 因此建構子之需多增加一double型別參數，提供getBaseSalary()方法回傳底薪數值，
	// 新增setBaseSalary(double)方法設定底薪數值，數值需檢查為非負值，
	// 否則產生IllegalArgumentException例外物件擲出，含有訊息: "Base salary must be >= 0.0"
	// 新增getCommissionEmployee()回傳所包含的CommissionEmployee物件，
	// (原CommissionEmployee類別之get方法可省略不提供)
	// 且薪資計算公式調整為 baseSalary + (commissionRate * grossSales) ，
	// toString()之輸出格式亦調整新增下列粗體文字與資料：
	// base-salaried commission employee:
	// social security number:
	// gross sales:
	// commission rate:
	// base salary: (底薪資料小數點後取兩位數)

	public static void main(String[] args) {
		BasePlusCommissionEmployee employee = new BasePlusCommissionEmployee("Bob", "Lewis", "333-33-3333", 5000, .04,
				300);
		System.out.println(employee.toString());
	}

}

class CommissionEmployee1 {

	private final String firstName;
	private final String lastName;
	private final String socialSecurityNumber;
	private double grossSales; // gross weekly sales
	private double commissionRate; // commission percentage

	// five-argument constructor
	public CommissionEmployee1(String firstName, String lastName, String socialSecurityNumber, double grossSales,
			double commissionRate) {
		// implicit call to Object constructor occurs here

		// if grossSales is invalid throw exception
		if (grossSales < 0.0) {
			throw new IllegalArgumentException("Gross sales must be >= 0.0");
		}
		// if commissionRate is invalid throw exception
		if (commissionRate <= 0.0 || commissionRate >= 1.0) {
			throw new IllegalArgumentException("Commission rate must be > 0.0 and < 1.0");
		}

		this.firstName = firstName;
		this.lastName = lastName;
		this.socialSecurityNumber = socialSecurityNumber;
		this.grossSales = grossSales;
		this.commissionRate = commissionRate;
	} // end constructor

	// return first name
	public String getFirstName() {
		return firstName;
	}

	// return last name
	public String getLastName() {
		return lastName;
	}

	// return social security number
	public String getSocialSecurityNumber() {
		return socialSecurityNumber;
	}

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
		return String.format("%s: %s %s%n%s: %s%n%s: %.2f%n%s: %.2f", "commission employee", getFirstName(),
				getLastName(), "social security number", getSocialSecurityNumber(), "gross sales", getGrossSales(),
				"commission rate", getCommissionRate());
	}
} // end class CommissionEmployee

class BasePlusCommissionEmployee {

	private CommissionEmployee1 commissionEmployee;
	private double baseSalary;

	public BasePlusCommissionEmployee(String firstName, String lastName, String socialSecurityNumber, double grossSales,
			double commissionRate, double baseSalary) {
		if (baseSalary < 0.0) {
			throw new IllegalArgumentException("Base salary must be >= 0.0");
		}
		commissionEmployee = new CommissionEmployee1(firstName, lastName, socialSecurityNumber, grossSales,
				commissionRate);
		this.baseSalary = baseSalary;
	}

	public double getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(double baseSalary) {
		if (baseSalary < 0.0) {
			throw new IllegalArgumentException("Base salary must be >= 0.0");
		}
		this.baseSalary = baseSalary;
	}

	public CommissionEmployee1 getCommissionEmployee() {
		return commissionEmployee;
	}

	public double earnings() {
		return baseSalary + commissionEmployee.earnings();
	}

	public String toString() {
		return String.format("%s %s%n%s: %.2f", "base-salaried", commissionEmployee.toString(), "base salary",
				getBaseSalary());
	}

}
