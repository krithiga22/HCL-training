
package com.hcl.collections;
//mport java.util.*;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class EmployeeDirectory {

    public static void main(String[] args) {

        Map<Integer, Employee> employeeMap = new HashMap<>();

        Employee e1 = new Employee(103, "Arun", "IT", 60000);
        Employee e2 = new Employee(101, "Priya", "HR", 75000);
        Employee e3 = new Employee(102, "Kumar", "IT", 50000);
        Employee e4 = new Employee(104, "Divya", "Finance", 65000);
        Employee e5 = new Employee(105, "Ravi", "HR", 55000);
        Employee e6 = new Employee(106, "Meena", "IT", 80000);

        employeeMap.put(e1.getId(), e1);
        employeeMap.put(e2.getId(), e2);
        employeeMap.put(e3.getId(), e3);
        employeeMap.put(e4.getId(), e4);
        employeeMap.put(e5.getId(), e5);
        employeeMap.put(e6.getId(), e6);

        System.out.println("===== EMPLOYEE LOOKUP =====");

        int searchId = 102;

        Employee found = employeeMap.get(searchId);

        if (found != null) {
            System.out.println("Employee found: " + found);
        } else {
            System.out.println("Employee not found: " + searchId);
        }

        System.out.println("\n===== MISSING EMPLOYEE =====");

        int missingId = 999;
        Employee missing = employeeMap.get(missingId);

        if (missing == null) {
            System.out.println("No employee with ID " + missingId);
        }
        
        System.out.println("\n===== DEPARTMENT FREQUENCY =====");

        Map<String, Integer> departmentCount = new HashMap<>();

        for (Employee employee : employeeMap.values()) {
            departmentCount.merge(
                employee.getDepartment(),
                1,
                Integer::sum
            );
        }

        System.out.println(departmentCount);
        
            System.out.println("\n===== TOP 5 HIGHEST PAID EMPLOYEES =====");

            Comparator<Employee> salaryComparator =
                    Comparator.comparingDouble(Employee::getSalary)
                            .reversed()
                            .thenComparingInt(Employee::getId);

            List<Employee> sortedEmployees =
                    new ArrayList<>(employeeMap.values());

            sortedEmployees.sort(salaryComparator);

            int limit = Math.min(5, sortedEmployees.size());

            for (int i = 0; i < limit; i++) {
                System.out.println(sortedEmployees.get(i));
            }
            
            System.out.println("\n===== EMPLOYEES SORTED BY NAME =====");

            Comparator<Employee> nameComparator =
                    Comparator.comparing(Employee::getName)
                            .thenComparingInt(Employee::getId);

            sortedEmployees.sort(nameComparator);

            for (Employee employee : sortedEmployees) {
                System.out.println(employee);
            }


    }
}