package pro.sky.Homework2_6.model;

import java.util.Objects;

public class Employee {
    private String firstName;
    private String lastName;
    private double salary;
    private int department;

    public Employee(String firstName, String lastName) {
    }

    public double getSalary() {
        return salary;
    }

    public int getDepartment() {
        return department;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int setDepartment(int department) {
        if (department < 1 || department > 5) {
            throw new IllegalArgumentException("Недопустимый номер отдела. Должно быть от 1 до 5.");
        }
        return department;
    }

    public Employee(String firstName, String lastName, int department, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.department = department;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }

    @Override
    public String toString() {
        return "Работник - " + firstName + " " + lastName;
    }
}
