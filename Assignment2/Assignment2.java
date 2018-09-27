/**
 * Assignment for your lecture 2. Please finish all the questions under 'Assignment'
 * Please try to think the extra credit question. 
 * The deadline of this assignment is 09/21/2018 23:59 PST.
 * Please feel free to contact Amanda and Zane for any questions.
 */

class Employee {
    String name;
    int age;
    Gender gender;
    double salary;// salary per month

    // Constructor. Please set all the data in constructor.
	//score:2/2
    public Employee(String name, int age, Gender gender, double salary) {
    	this.name = name;
	this.age = age;
	this.gender = gender;
	this.salary = salary;
    }
    
    // Getter for `name`. Return the current `name` data
    public String getName() {
    	return this.name;
    }

    // Setter for `name`. Set `name` data
    public void setName(String name) {
    	this.name = name;    
    }
}

enum Gender {
    MALE,
    FEMALE;
}


public class Assignment2 {
    // Assignment

    /**
     * Write a method to calculate the Social Security Tax of an employee and print it.
     * If the salary is less than or equal to 8900, the Social Security Tax is 6.2% of the salary.
     * If the salary is more than 8900, the Social Security Tax is 6.2% of 106,800.
     */
	//score:2/2
    public double socialSecurityTax(Employee employee) {
	double socialSecurityTax = 0.0;
	if(employee.salary <= 8900){
		socialSecurityTax = employee.salary * 6.2 / 100;
	}
	else {
		socialSecurityTax = 106800 * 6.2 / 100;
	}
	System.out.println(employee.name + "'s Social Security Tax is: "+socialSecurityTax);
	return socialSecurityTax;
    }

    /**
     * Write a method to calculate an employee's contribution for insurance coverage and print it.
     * Amount of deduction is computed as follows:
     * If the employee is under 35, rate is 3% of salary; if the employee is between 35 and 50(inclusive), rate is 4% of salary;
     * If the employee is between 50 and 60(exclusive), rate is 5% of salary; If the employee is above 60, rate is 6% of salary.
     */
	//score:2/2
    public double insuranceCoverage(Employee employee) {
    	double insurance = 0.0;
	if(employee.age <= 35) { // should be <35 
		insurance = employee.salary * 3 / 100;
	} else if(employee.age > 35 && employee.age <= 50) {//should be >=35
		insurance = employee.salary * 4 /100;
	} else if(employee.age > 50 && employee.age <= 60) {
		insurance = employee.salary * 5 / 100;
	} else if(employee.age > 60) {
		insurance = employee.salary * 6 /100;
	} else {
		System.out.println("Invalid age");
	}
	System.out.println(employee.name + "'s contribution towards insurance is: " + insurance);
	return insurance;
    }

    /**
     * Write a method to sort three employees' salary from low to high, and then print their name in order.
     * For example, Alice's salary is 1000, John's salary is 500, Jenny's salary is 1200, you should print:
     * John Alice Jenny
     */
	//score:2/2
    public void sortSalary(Employee e1, Employee e2, Employee e3) {
    	Employee[] emp = {e1, e2, e3};
	for(int i = 0; i < emp.length; ++i) {
		for(int j = 0; j < emp.length; ++j) {
			if (emp[i].salary > emp[j].salary){
				Employee temp = emp[i];
				emp[i] = emp[j];
				emp[j] = temp;
			}
		}
	}
	for(int i = 0 ; i < emp.length ; ++i){
		System.out.print(emp[i].name + " ");
	}
    }

    /**
     * Write a method to raise an employee's salary to three times of his/her original salary.
     * Eg: original salary was 1000/month. After using this method, the salary is 3000/month.
     * Do not change the input of this method.
     * Try to add a new method in Employee class: public void raiseSalary(double byPercent)
     */
	//score:2/2
    public void tripleSalary(Employee employee) {
    	this.raiseSalary(300, employee);
    }
    
    public void raiseSalary (double byPercent, Employee employee) {
	employee.salary = employee.salary + (employee.salary * byPercent / 100);
	System.out.println(employee.name + "'s new salary is: " + employee.salary);
    }

    //Extra credit
//score:2/2
    /**
     * I have written some code below. What I want is to swap two Employee objects.
     * One is Jenny and one is John. But after running it, I got the result below:
     * Before: a=Jenny
     * Before: b=John
     * After: a=Jenny
     * After: b=John
     * There is no change after swap()! Do you know the reason why my swap failed?
     * Write your understanding of the reason and explain it.
     */
    /*
     write your understanding here.
     
     Java doesn't passes by reference, it passes by value.
     In swap method, a and b reference (address) is passed to x and y. Initially x and a is pointing to same address 
     while b and y is pointing to same address. After swap, x is pointing to b's address and y is pointing to
     a's address. So x and y reference location is changed but a and b reference still remain the same in
     main method. So a.getName will still get Jenny and b.getName will be getting John.
     So, the original variables (a, b) from the main() function still point to the same objects.
     In the swap() function, only the new variables (x, y) pointing to objects are interchanged.
     
     If we use following swap method:
     
     public static void swap(Employee x, Employee y) {
    	String temp = x.name;
        x.name = y.name;
        y.name = temp;
     }
     
     we will this output:
     	Before: a=Jenny
	Before: b=John
	After: a=John
	After: b=Jenny
    */
    public static void main(String[] args) {
        Employee a = new Employee("Jenny", 20, Gender.FEMALE, 2000);
        Employee b = new Employee("John", 30, Gender.MALE, 2500);
        System.out.println("Before: a=" + a.getName());
        System.out.println("Before: b=" + b.getName());
        swap(a, b);
        System.out.println("After: a=" + a.getName());
        System.out.println("After: b=" + b.getName());
    }

    public static void swap(Employee x, Employee y) {
    	 Employee temp = x;
         x = y;
         y = temp;
    }
}
