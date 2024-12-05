package com.blogapp12.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MainClass2 {

    public static EmployeeDto mapToDta(Employee e1){

        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setId(e1.getId());
       employeeDto.setName(e1.getName());
       employeeDto.setSalary(e1.getSalary());


        return employeeDto;

    }

    public static void main(String[] args) {


        Employee emp1 = new Employee(12,"syam",12000);
        Employee emp2 = new Employee(13, "ram", 13000);
        Employee emp3 = new Employee(14, "krishna", 14000);

        List<Employee> emp = Arrays.asList(emp1, emp2, emp3);
        List<EmployeeDto> empdto = emp.stream().map(p -> mapToDta(p)).collect(Collectors.toList());
        System.out.println(empdto);


    }
}
