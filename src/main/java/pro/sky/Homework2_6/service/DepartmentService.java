package pro.sky.Homework2_6.service;

import pro.sky.Homework2_6.model.Employee;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface DepartmentService {
    Employee findEmployeeWithMaxSalaryInDepartment(int department);

    Employee findEmployeeWithMinSalaryInDepartment(int department);

    Collection<Employee> employeesDepartment(int department);

    Map<Integer, List<Employee>> allEmployeesDepartments();

    Collection<Employee> findAll();
}
