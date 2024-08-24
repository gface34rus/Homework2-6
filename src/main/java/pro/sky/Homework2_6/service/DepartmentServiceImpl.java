package pro.sky.Homework2_6.service;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import pro.sky.Homework2_6.model.Employee;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.groupingBy;

@Service
public class DepartmentServiceImpl implements DepartmentService{
    private final DepartmentServiceImpl employeeServiceImpl;
    Map<String, Employee> employees = new HashMap<>();

    public DepartmentServiceImpl(@Lazy DepartmentServiceImpl employeeServiceImpl) {
        this.employeeServiceImpl = employeeServiceImpl;
    }

    @Override
    public Employee findEmployeeWithMaxSalaryInDepartment(int department) {
        return employeeServiceImpl.findAll().stream()
                .filter(e -> e.getDepartment() == department)
                .max(comparing(Employee::getSalary))
                .orElseThrow();
    }
    @Override
    public Employee findEmployeeWithMinSalaryInDepartment(int department) {
        return employeeServiceImpl.findAll().stream()
                .filter(e -> e.getDepartment() == department)
                .min(comparing(Employee::getSalary))
                .orElseThrow();
    }

    @Override
    public Collection<Employee> employeesDepartment(int department) {
        return employeeServiceImpl.findAll().stream()
                .filter(e -> e.getDepartment() == department)
                .collect(Collectors.toList());
    }

    @Override
    public Map<Integer, List<Employee>> allEmployeesDepartments() {
        return employeeServiceImpl.findAll().stream()
                .collect(groupingBy(Employee::getDepartment));
    }
    @Override
    public Collection<Employee> findAll() {
        return Collections.unmodifiableCollection(employees.values());
    }
}
