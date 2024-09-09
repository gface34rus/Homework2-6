package pro.sky.Homework2_6.controller;

import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.Homework2_6.model.Employee;
import pro.sky.Homework2_6.service.DepartmentService;
import pro.sky.Homework2_6.service.EmployeeService;
import pro.sky.Homework2_6.service.EmployeeServiceImpl;
@RestController
@RequestMapping("/departments")
public class DepartmentsController {
    private final DepartmentService departmentService;

    public DepartmentsController( DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/max-salary")
    public Employee findEmployeeWithMaxSalaryInDepartment(@RequestParam Integer departmentId) {
        return departmentService.findEmployeeWithMaxSalaryInDepartment(departmentId);
    }
    @GetMapping(path = "/min-salary")
    public Employee findEmployeeWithMinSalaryInDepartment(@RequestParam Integer departmentId){
        return findEmployeeWithMinSalaryInDepartment(departmentId);
    }
    @GetMapping(path = "/departments/all-by-department")
    public Employee employeesDepartment(@RequestParam Integer departmentId){
        return employeesDepartment(departmentId);
    }
    @GetMapping(path = "/departments/all")
    public Employee allEmployeesDepartments(@RequestParam Integer departmentId){
        return allEmployeesDepartments(departmentId);
    }
}
