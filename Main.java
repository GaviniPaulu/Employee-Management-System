
package com.employee;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        EmployeeDAO dao = new EmployeeDAO();

        while (true) {

            System.out.println("\n===== EMPLOYEE MANAGEMENT SYSTEM =====");
            System.out.println("1. Insert Employee Details");
            System.out.println("2. Read Employees Details");
            System.out.println("3. Remove Employee Details");
            System.out.println("4. Update Designation or Salary");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1: {

                    System.out.print("Enter Employee ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Employee Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Employee Age: ");
                    int age = sc.nextInt();

                    System.out.print("Enter Employee Gender (M/F): ");
                    char gender = sc.next().charAt(0);

                    System.out.print("Enter Salary: ");
                    double salary = sc.nextDouble();
                    sc.nextLine();

                    System.out.print("Enter Designation: ");
                    String designation = sc.nextLine();

                    Employee e = new Employee(
                        id, name, age, gender, salary, designation
                    );

                    dao.insertEmployee(e);
                    break;
                }

                case 2: {

                    System.out.println("\n===== EMPLOYEE DETAILS =====");

                    List<Employee> employees = dao.getAllEmployees();

                    if (employees.isEmpty()) {
                        System.out.println("No employee records found.");
                    }

                    for (Employee emp : employees) {
                        System.out.println(emp);
                        System.out.println("--------------------------");
                    }

                    break;
                }

                case 3: {

                    System.out.print("Enter Employee ID to delete: ");
                    int id = sc.nextInt();

                    dao.deleteEmployee(id);
                    break;
                }

                case 4: {

                    System.out.print("Enter Employee ID: ");
                    int id = sc.nextInt();

                    System.out.println("1. Update Employee Salary");
                    System.out.println("2. Update Employee Designation");

                    int option = sc.nextInt();

                    if (option == 1) {

                        System.out.print("Enter new salary: ");
                        double salary = sc.nextDouble();

                        dao.updateSalary(id, salary);

                    } else if (option == 2) {

                        sc.nextLine();

                        System.out.print("Enter new designation: ");
                        String designation = sc.nextLine();

                        dao.updateDesignation(id, designation);

                    } else {
                        System.out.println("Invalid option.");
                    }

                    break;
                }

                case 5: {

                    System.out.println("Program ended.");
                    sc.close();
                    return;
                }

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
