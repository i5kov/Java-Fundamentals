package moreexercise_tasks;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ME01_CompanyRoster {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfEmployees = Integer.parseInt(scanner.nextLine());
        List<Employee> allEmployees = new ArrayList<>();
        List<Department> allDepartments = new ArrayList<>();

        for (int i = 0; i < numberOfEmployees; i++) {
            String[] employeeInfo = scanner.nextLine().split("\\s+");
            String name = employeeInfo[0];
            double salary = Double.parseDouble(employeeInfo[1]);
            String position = employeeInfo[2];
            String departmentName = employeeInfo[3];

            Employee employee = new Employee(name, salary, position, departmentName);

            switch (employeeInfo.length) {
                case 5:
                    if (employeeInfo[4].contains("@")) {
                        employee.setEmail(employeeInfo[4]);
                    } else {
                        employee.setAge(Integer.parseInt(employeeInfo[4]));
                    }
                    break;
                case 6:
                    employee.setEmail(employeeInfo[4]);
                    employee.setAge(Integer.parseInt(employeeInfo[5]));
            }
            allEmployees.add(employee);
        }
        List<String> departmentsList = allEmployees.stream().map(Employee::getDepartment).distinct().collect(Collectors.toList());

        for (String department : departmentsList) {
            allDepartments.add(new Department(department,
                    allEmployees.stream().filter(employee -> employee.getDepartment().equals(department)).collect(Collectors.toList())));
        }

        allDepartments.sort(Comparator.comparingDouble(Department::getAvgSalary).reversed());
        Department department = allDepartments.get(0);
        department.getEmployee().sort(Comparator.comparingDouble(Employee::getSalary).reversed());

        System.out.printf("Highest Average Salary: %s%n", department.getName());
        for (Employee employee : department.getEmployee()) {
            System.out.printf("%s %.2f %s %d%n", employee.getName(), employee.getSalary(), employee.getEmail(), employee.getAge());
        }
    }
}

class Employee {

    String name;
    double salary;
    String position;
    String department;
    String email;
    int age;

    public Employee(String name, double salary, String position, String department) {
        setName(name);
        setSalary(salary);
        this.position = position;
        setDepartment(department);
        setEmail("n/a");
        setAge(-1);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }
}

class Department {

    String name;
    List<Employee> employee;
    double avgSalary;

    Department(String name, List<Employee> employee) {
        this.name = name;
        this.employee = employee;
        this.avgSalary = employee.stream().mapToDouble(Employee::getSalary).average().getAsDouble();
    }

    double getAvgSalary() {
        return avgSalary;
    }

    String getName() {
        return name;
    }

    List<Employee> getEmployee() {
        return employee;
    }
}
