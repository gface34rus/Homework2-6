package pro.sky.Homework2_6.service;

import org.springframework.stereotype.Service;
import pro.sky.Homework2_6.exceptions.EmployeeAlreadyAddedException;
import pro.sky.Homework2_6.exceptions.EmployeeNotFoundException;
import pro.sky.Homework2_6.exceptions.EmployeeStorageIsFullException;
import pro.sky.Homework2_6.model.Employee;
import pro.sky.Homework2_6.service.EmployeeService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private static final int MAX_EMPLOYEES = 5;
    List<Employee> employees = new ArrayList<>(Arrays.asList(new Employee("Павел", "Никитин"), new Employee("Евгений", "Романов"),
            new Employee("Кирилл", "Донцов"), new Employee("Николай", "Нелюбов")));

    @Override
    public Employee addEmployee(String firstName, String lastName) {
        if (employees.size() >= MAX_EMPLOYEES) {
            throw new EmployeeStorageIsFullException("Хранилище заполнено! Невозможно добавить работника.");
        }
        Employee newEmployee = new Employee(firstName, lastName);
        if (employees.contains(newEmployee)) {
            throw new EmployeeAlreadyAddedException("Такой работник уже добавлен в список");
        }
        employees.add(newEmployee);
        return newEmployee;
    }

    @Override
    public Employee removeEmployee(String firstName, String lastName) {
        Employee employeeToRemove = new Employee(firstName, lastName);
        if (!employees.remove(employeeToRemove)) {
            throw new EmployeeNotFoundException("Работник с таким именем - не найден!");
        }employees.remove(employeeToRemove);
        return employeeToRemove;
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        return employees.stream()
                .filter(e -> e.getFirstName().equals(firstName) && e.getLastName().equals(lastName))
                .findFirst()
                .orElseThrow(() -> new EmployeeNotFoundException("Работник не найден."));
    }

    @Override
    public List<Employee> getAllEmployees() {
        return new ArrayList<>(employees);
    }
}
