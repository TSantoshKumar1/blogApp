package com.blogapp12.Test;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TestClass {

    public void checkEvennum(){

        List<Integer> data =  Arrays.asList(10,5,12,18,17,21);
       List<Integer> value = data.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());
        System.out.println(value);
    }


    public void findString(){

      List<String> data = Arrays.asList("mike", "santosh", "lucky" , "adam", "sam");
        List<String> value = data.stream().filter(str -> str.startsWith("s")).collect(Collectors.toList());
        System.out.println(value);

    }


    public void findStringWithignoreCase(){

        List<String> data = Arrays.asList("mike", "santosh", "lucky" , "adam", "sam");
        List<String> value = data.stream().filter(str -> str.equalsIgnoreCase("Mike")).collect(Collectors.toList());
        System.out.println(value);
    }

public void stringsFilterBylength(){

    List<String> data = Arrays.asList("mike", "santosh", "lucky", "adam", "sam");
    List<String> value = data.stream().filter(str -> str.length() == 4).collect(Collectors.toList());
    System.out.println("4 charactres words is "+value);
}

public  void multileCondition(){

    List<Integer> data = Arrays.asList(12, 1, 15, 20, 3, 9, 18 ,30, 25);
    List<Integer> value = data.stream().filter(n -> n % 5 == 0 && n > 5).collect(Collectors.toList());
    System.out.println("numbers that is eligible to divid by 5 and greater than 10 "+value);

}


public void uniqueValue(){

    List<String> data = Arrays.asList("mike", "santosh", "lucky", "adam", "sam" , "santosh");
    List<String> value = data.stream().distinct().collect(Collectors.toList());
    System.out.println(value);
}

public void findSizeOfCharacters(){
    List<String> data = Arrays.asList("mike", "santosh", "lucky", "adam", "sam" , "santosh");
    List<Integer> value = data.stream().map(str -> str.length()).collect(Collectors.toList());

    System.out.println(value);

}

public void Multiply(){
    List<Integer> data = Arrays.asList(2,4,6,8);
    List<Integer> value = data.stream().map(n -> n * 5).collect(Collectors.toList());
    System.out.println(value);
}

    public static void main(String[] args) {

      TestClass test = new TestClass();
      test.checkEvennum();
      test.findString();
      test.findStringWithignoreCase();
      test.stringsFilterBylength();
      test.multileCondition();
      test.uniqueValue();
      test.findSizeOfCharacters();
      test.Multiply();
    }
}
