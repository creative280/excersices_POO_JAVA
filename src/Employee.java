import java.util.Scanner;

// Base class Employee
public class Employee {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input for Manager
        System.out.println("Enter details for Manager:");
        System.out.print("First Name: ");
        String managerFirstName = scanner.nextLine();
        System.out.print("Last Name: ");
        String managerLastName = scanner.nextLine();
        System.out.print("Base Salary: ");
        double managerBaseSalary = scanner.nextDouble();
        System.out.print("Bonus: ");
        double managerBonus = scanner.nextDouble();
        scanner.nextLine();  // Consume newline

        Manager manager = new Manager(managerFirstName, managerLastName, managerBaseSalary, managerBonus);

        // Input for Developer
        System.out.println("\nEnter details for Developer:");
        System.out.print("First Name: ");
        String developerFirstName = scanner.nextLine();
        System.out.print("Last Name: ");
        String developerLastName = scanner.nextLine();
        System.out.print("Base Salary: ");
        double developerBaseSalary = scanner.nextDouble();
        System.out.print("Overtime Pay: ");
        double developerOvertimePay = scanner.nextDouble();
        scanner.nextLine();  // Consume newline

        Developer developer = new Developer(developerFirstName, developerLastName, developerBaseSalary, developerOvertimePay);

        // Input for Designer
        System.out.println("\nEnter details for Designer:");
        System.out.print("First Name: ");
        String designerFirstName = scanner.nextLine();
        System.out.print("Last Name: ");
        String designerLastName = scanner.nextLine();
        System.out.print("Base Salary: ");
        double designerBaseSalary = scanner.nextDouble();
        System.out.print("Project Bonus: ");
        double designerProjectBonus = scanner.nextDouble();
        scanner.nextLine();  // Consume newline

        Designer designer = new Designer(designerFirstName, designerLastName, designerBaseSalary, designerProjectBonus);

        // Display salaries
        System.out.println("\nEmployee Salaries:");
        System.out.println(manager.toString() + "'s total salary: $" + manager.calculateSalary());
        System.out.println(manager.toString() + "'s bonus: $" + manager.getBonus());
        System.out.println(developer.toString() + "'s total salary: $" + developer.calculateSalary());
        System.out.println(developer.toString() + "'s overtime pay: $" + developer.getOvertimePay());
        System.out.println(designer.toString() + "'s total salary: $" + designer.calculateSalary());
        System.out.println(designer.toString() + "'s project bonus: $" + designer.getProjectBonus());

        // Close the scanner
        scanner.close();
    }


    protected String firstName;
    protected String lastName;
    protected double baseSalary;

    public Employee(String firstName, String lastName, double baseSalary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.baseSalary = baseSalary;
    }

    // Method to calculate the total salary
    public double calculateSalary() {
        return baseSalary;  // Default salary calculation for a generic employee
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
}

// Subclass Manager
class Manager extends Employee {
    private final double bonus;

    public Manager(String firstName, String lastName, double baseSalary, double bonus) {
        super(firstName, lastName, baseSalary);
        this.bonus = bonus;
    }

    // Manager salary includes a bonus
    @Override
    public double calculateSalary() {
        return baseSalary + bonus;
    }

    // Method to get the bonus
    public double getBonus() {
        return bonus;
    }
}

// Subclass Developer
class Developer extends Employee {
    private final double overtimePay;

    public Developer(String firstName, String lastName, double baseSalary, double overtimePay) {
        super(firstName, lastName, baseSalary);
        this.overtimePay = overtimePay;
    }

    // Developer salary includes overtime pay
    @Override
    public double calculateSalary() {
        return baseSalary + overtimePay;
    }

    // Method to get the overtime pay
    public double getOvertimePay() {
        return overtimePay;
    }
}

// Subclass Designer
class Designer extends Employee {
    private final double projectBonus;

    public Designer(String firstName, String lastName, double baseSalary, double projectBonus) {
        super(firstName, lastName, baseSalary);
        this.projectBonus = projectBonus;
    }

    // Designer salary includes a project bonus
    @Override
    public double calculateSalary() {
        return baseSalary + projectBonus;
    }

    // Method to get the project bonus
    public double getProjectBonus() {
        return projectBonus;
    }
}

