package com.blogapp12.Test;

import java.util.*;
import java.util.stream.Collectors;

public class StreamApiPractise {

    public static void main(String[] args) {

// filtering the data....

//1. find the even numbers in given list.....?

//       List<Integer> numbers =  Arrays.asList(1,4,3,8,6,7);
//        List<Integer> result = numbers.stream().filter(e -> e % 2 == 0).collect(Collectors.toList());
//
//        System.out.println(result);

//2. count the elements that match a specific condition.....?

//        List<String> list = Arrays.asList("apple", "banana", "cherry", "apple");
//        long count = list.stream().filter(e -> e.equals("apple")).count();
//        System.out.println("apple is "+ count);


// Mapping the data........

//1. transform the all elements into uppercase letter....?

//        List<String> data = Arrays.asList("sam", "livy", "jerry");
//        List<String> result = data.stream().map(e -> e.toUpperCase()).collect(Collectors.toList());
//        System.out.println(result);


//2. multiply all elements with 2 in given list....?

//        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
//        List<Integer> num = numbers.stream().map(e -> e * 2).collect(Collectors.toList());
//        System.out.println(num);


// Sorting the data.........

// 1. sorting the given strings

 //      List<String> list = Arrays.asList("john", "anna", "mark");
//        List<String> sortedList = list.stream().sorted().collect(Collectors.toList());
//        System.out.println(sortedList);


// Reducing the data.....

//1. combine elements and produce a single result such as concatenation or sum etc......?
//
//        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
//        Integer sum = list.stream().reduce(0, (a, b) -> a + b);
//        System.out.println(sum);


// collecting the result....

//1. collect the elements into different types of collection.....?

//        List<String> list = Arrays.asList("john", "anna", "mark");
//        Set<String> setcollect = list.stream().collect(Collectors.toSet());
//        System.out.println(setcollect);

// portioning the data.......

// portioning the even and odd numbers in the given list.....?

//        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6,8,9);
//
//        Map<Boolean, List<Integer>> partitioned = list.stream().collect(Collectors.partitioningBy(e -> e % 2 == 0));
//        System.out.println(partitioned);


// Flat Mapping.........

// . flatten nested List or Arrays into single list.....?

//        List<List<String>> nestedList = Arrays.asList(Arrays.asList("john", "jane"),
//                Arrays.asList("alice", "bob"),
//                Arrays.asList("charlie"));
//
//        List<String> singleList = nestedList.stream().flatMap(List::stream).collect(Collectors.toList());
//        System.out.println(singleList);


//  Finding Max and Min ..........

        List<Integer> list = Arrays.asList(24, 50, 97, 66, 32);
        Optional<Integer> min = list.stream().min(Integer::compare);
        Optional<Integer> max = list.stream().max(Integer::compare);

        System.out.println(min);
        System.out.println(max);

    }
}
