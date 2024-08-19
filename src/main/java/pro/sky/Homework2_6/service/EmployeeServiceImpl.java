package pro.sky.Homework2_6.service;

import org.springframework.stereotype.Service;
import pro.sky.Homework2_6.exceptions.EmployeeAlreadyAddedException;
import pro.sky.Homework2_6.exceptions.EmployeeNotFoundException;
import pro.sky.Homework2_6.exceptions.EmployeeStorageIsFullException;
import pro.sky.Homework2_6.model.Employee;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private static final int MAX_EMPLOYEES = 5;
    Map<String, Employee> employees = new HashMap<>();

    @Override
    public Employee addEmployee(String firstName, String lastName) {
        if (employees.size() >= MAX_EMPLOYEES) {
            throw new EmployeeStorageIsFullException("Хранилище заполнено! Невозможно добавить работника.");
        }
        Employee newEmployee = new Employee(firstName, lastName);
        if (employees.containsKey(newEmployee.getFullName())) {
            throw new EmployeeAlreadyAddedException("Такой работник уже добавлен в список");
        }
        employees.put(newEmployee.getFullName(), newEmployee);
        return newEmployee;
    }

    @Override
    public Employee removeEmployee(String firstName, String lastName) {
        Employee employeeToRemove = new Employee(firstName, lastName);
        if (employees.containsKey(employeeToRemove.getFullName())) {
            return employees.remove(employeeToRemove.getFullName());
        }
        throw new EmployeeNotFoundException("Работник не найден.");
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        Employee employeeToFind = new Employee(firstName, lastName);
        if (employees.containsKey(employeeToFind.getFullName())) {
            return employees.get(employeeToFind.getFullName());
        }
        throw new EmployeeNotFoundException("Работник не найден.");
    }

    @Override
    public Map<String, Employee> getAllEmployees() {
        return new HashMap<>(employees);
    }
}
