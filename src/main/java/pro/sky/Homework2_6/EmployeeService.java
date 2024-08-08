package pro.sky.Homework2_6;

import java.util.List;

public interface EmployeeService {
public void addEmployee(String firstName, String lastName);
    public void removeEmployee(String firstName, String lastName);
    public Employee findEmployee(String firstName, String lastName);

    List<Employee> getAllEmployees();
}
