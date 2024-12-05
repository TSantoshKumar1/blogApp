package com.blogapp12.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;


public class MainClass {



    public static void main(String[] args) {


 //  Consumer:- it takes single input but does not return o/p.

//        Consumer<Integer> val = n-> System.out.println(n);
//        val.accept(500);

// Supplier:- it is a type of Functional interface in java 8 feature where it takes no argument or input but return o/p.


//        Supplier<Double> val = ()->Math.random();
//        Double result = val.get();
//        System.out.println(result);

        Employee santosh = new Employee(1213, "santosh", 35000);
        Employee praveen = new Employee(1111, "praveen", 39000);
        Employee xyz = new Employee(3333, "xyz", 40000);
        Employee elvin= new Employee(2222, "elvin", 39000);
        Employee samuel = new Employee(1413, "samuel", 35000);

        List<Employee> data = Arrays.asList(santosh, praveen, xyz,elvin,samuel);

 // q1. if i want to get the employe whose salary is greater thean 39000 rs...?

//        List<Employee> val = data.stream().filter(e -> e.getSalary() > 39000).collect(Collectors.toList());
//
//        for(Employee emp : val){
//
//            System.out.println(emp.getName()+" "+emp.getSalary()+" "+emp.getId());
//        }


// q2. if i want to reduce the employee salary by 500 Rs.....?

//        List<Integer> value = data.stream().map(e -> e.getSalary() - 500).collect(Collectors.toList());
//
//        System.out.println(value);

// q3. if i want to change the all Employee names in upercase letter...?

//        List<String> result = data.stream().map(e -> e.getName().toUpperCase()).collect(Collectors.toList());
//        System.out.println(result);

// Method Reference :- there is a another feature called method Reference which is another way to call a method
//                      instead  using lambda expression.

//--------------------------------------------------------------------------------------------------------------------

// grouping the objects value...?

        Map<Integer, List<Employee>> result = data.stream().collect(Collectors.groupingBy(e -> e.getSalary()));

        for( Map.Entry<Integer , List<Employee>> entry :result.entrySet()) {

            System.out.println(entry);
        }


    }
}
