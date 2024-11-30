class Employee {
    // Attributes
    String name;
    int empId;
    double basicSalary;
    double hra;
    double allowances;
    double grossSalary;
    double bonus;

    // Constructor
    public Employee(String name, int empId, double basicSalary) {
        this.name = name;
        this.empId = empId;
        this.basicSalary = basicSalary;
        this.hra = 0.2 * basicSalary;  // HRA is 20% of basic salary
        this.allowances = 0.1 * basicSalary;  // Allowances are 10% of basic salary
        this.grossSalary = 0;  // Gross salary will be calculated later
        this.bonus = 0;
    }

    // Method to calculate gross salary
    public double calculateGrossSalary() {
        this.grossSalary = this.basicSalary + this.hra + this.allowances;
        return this.grossSalary;
    }

    // Method to apply bonus
    public void applyBonus(double bonusPercentage) {
        this.bonus = (this.grossSalary * bonusPercentage) / 100;
        this.grossSalary += this.bonus;
    }

    // Method to print salary details
    public void printSalaryDetails() {
        System.out.println("Employee ID: " + this.empId);
        System.out.println("Name: " + this.name);
        System.out.println("Basic Salary: " + this.basicSalary);
        System.out.println("HRA: " + this.hra);
        System.out.println("Allowances: " + this.allowances);
        System.out.println("Gross Salary (without bonus): " + (this.grossSalary - this.bonus));
        System.out.println("Bonus: " + this.bonus);
        System.out.println("Updated Gross Salary (with bonus): " + this.grossSalary);
        System.out.println("--------------------------------------------------");
    }

    // Main method to test the Employee class
    public static void main(String[] args) {
        // Creating employee objects
        Employee emp1 = new Employee("John Doe", 101, 50000);
        emp1.calculateGrossSalary();
        emp1.applyBonus(10);  // Apply 10% bonus
        emp1.printSalaryDetails();

        Employee emp2 = new Employee("Jane Smith", 102, 60000);
        emp2.calculateGrossSalary();
        emp2.applyBonus(12);  // Apply 12% bonus
        emp2.printSalaryDetails();

        Employee emp3 = new Employee("Alice Johnson", 103, 75000);
        emp3.calculateGrossSalary();
        emp3.applyBonus(15);  // Apply 15% bonus
        emp3.printSalaryDetails();
    }
}
