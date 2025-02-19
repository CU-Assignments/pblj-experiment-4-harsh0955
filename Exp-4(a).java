import java.util.ArrayList;
import java.util.Scanner;

class Employee {
    int id;
    String name;
    double salary;

    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Salary: " + salary;
    }
}

public class EmployeeManager {

    static ArrayList<Employee> employees = new ArrayList<>();

    public static void addEmployee(int id, String name, double salary) {
        Employee emp = new Employee(id, name, salary);
        employees.add(emp);
        System.out.println("Employee added successfully.");
    }

    public static void updateEmployee(int id, String name, double salary) {
        for (Employee emp : employees) {
            if (emp.id == id) {
                emp.name = name;
                emp.salary = salary;
                System.out.println("Employee updated successfully.");
                return;
            }
        }
        System.out.println("Employee not found.");
    }

    public static void removeEmployee(int id) {
        for (Employee emp : employees) {
            if (emp.id == id) {
                employees.remove(emp);
                System.out.println("Employee removed successfully.");
                return;
            }
        }
        System.out.println("Employee not found.");
    }

    public static void searchEmployee(int id) {
        for (Employee emp : employees) {
            if (emp.id == id) {
                System.out.println(emp);
                return;
            }
        }
        System.out.println("Employee not found.");
    }

    public static void displayEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No employees to display.");
        } else {
            for (Employee emp : employees) {
                System.out.println(emp);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        
        do {
            System.out.println("\nEmployee Management System");
            System.out.println("1. Add Employee");
            System.out.println("2. Update Employee");
            System.out.println("3. Remove Employee");
            System.out.println("4. Search Employee");
            System.out.println("5. Display All Employees");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Employee ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    System.out.print("Enter Employee Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Employee Salary: ");
                    double salary = scanner.nextDouble();
                    addEmployee(id, name, salary);
                    break;
                case 2:
                    System.out.print("Enter Employee ID to Update: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    System.out.print("Enter New Employee Name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter New Employee Salary: ");
                    double newSalary = scanner.nextDouble();
                    updateEmployee(updateId, newName, newSalary);
                    break;
                case 3:
                    System.out.print("Enter Employee ID to Remove: ");
                    int removeId = scanner.nextInt();
                    removeEmployee(removeId);
                    break;
                case 4:
                    System.out.print("Enter Employee ID to Search: ");
                    int searchId = scanner.nextInt();
                    searchEmployee(searchId);
                    break;
                case 5:
                    displayEmployees();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 6);

        scanner.close();
    }
}
