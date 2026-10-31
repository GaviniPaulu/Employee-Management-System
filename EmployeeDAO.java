
package com.employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {

    // 1. INSERT EMPLOYEE
    public void insertEmployee(Employee e) {

        String query = "INSERT INTO employees "
                + "(employee_id, employee_name, employee_age, "
                + "employee_gender, salary, designation) "
                + "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection con = DBConnection.getConnection()) {

            if (con == null) {
                System.out.println("Database connection failed!");
                return;
            }

            try (PreparedStatement ps = con.prepareStatement(query)) {

                ps.setInt(1, e.getEmployeeId());
                ps.setString(2, e.getEmployeeName());
                ps.setInt(3, e.getEmployeeAge());
                ps.setString(4, String.valueOf(e.getEmployeeGender()));
                ps.setDouble(5, e.getSalary());
                ps.setString(6, e.getDesignation());

                int rows = ps.executeUpdate();

                if (rows > 0) {
                    System.out.println("Employee inserted successfully!");
                }
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    // 2. READ ALL EMPLOYEES
    public List<Employee> getAllEmployees() {

        List<Employee> employees = new ArrayList<>();

        String query = "SELECT * FROM employees";

        try (Connection con = DBConnection.getConnection()) {

            if (con == null) {
                System.out.println("Database connection failed!");
                return employees;
            }

            try (PreparedStatement ps = con.prepareStatement(query);
                 ResultSet rs = ps.executeQuery()) {

                while (rs.next()) {

                    Employee e = new Employee(
                            rs.getInt("employee_id"),
                            rs.getString("employee_name"),
                            rs.getInt("employee_age"),
                            rs.getString("employee_gender").charAt(0),
                            rs.getDouble("salary"),
                            rs.getString("designation")
                    );

                    employees.add(e);
                }
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return employees;
    }

    // 3. DELETE EMPLOYEE
    public void deleteEmployee(int id) {

        String query = "DELETE FROM employees WHERE employee_id = ?";

        try (Connection con = DBConnection.getConnection()) {

            if (con == null) {
                System.out.println("Database connection failed!");
                return;
            }

            try (PreparedStatement ps = con.prepareStatement(query)) {

                ps.setInt(1, id);

                int rows = ps.executeUpdate();

                if (rows > 0) {
                    System.out.println("Employee deleted successfully!");
                } else {
                    System.out.println("Employee ID not found.");
                }
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    // 4. UPDATE SALARY
    public void updateSalary(int id, double salary) {

        String query = "UPDATE employees SET salary = ? WHERE employee_id = ?";

        try (Connection con = DBConnection.getConnection()) {

            if (con == null) {
                System.out.println("Database connection failed!");
                return;
            }

            try (PreparedStatement ps = con.prepareStatement(query)) {

                ps.setDouble(1, salary);
                ps.setInt(2, id);

                int rows = ps.executeUpdate();

                if (rows > 0) {
                    System.out.println("Salary updated successfully!");
                } else {
                    System.out.println("Employee ID not found.");
                }
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    // 5. UPDATE DESIGNATION
    public void updateDesignation(int id, String designation) {

        String query = "UPDATE employees SET designation = ? WHERE employee_id = ?";

        try (Connection con = DBConnection.getConnection()) {

            if (con == null) {
                System.out.println("Database connection failed!");
                return;
            }

            try (PreparedStatement ps = con.prepareStatement(query)) {

                ps.setString(1, designation);
                ps.setInt(2, id);

                int rows = ps.executeUpdate();

                if (rows > 0) {
                    System.out.println("Designation updated successfully!");
                } else {
                    System.out.println("Employee ID not found.");
                }
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
