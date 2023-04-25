package org.example.database;

import java.util.HashMap;
import java.util.Random;

public class Questions {
    private final HashMap<Integer, String> myDictionary;
    public int randomIndex;

    public Questions() {
        myDictionary = new HashMap<>();
        // Add some key-value pairs to the dictionary
        myDictionary.put(1, """
                ✨Find the value of A[1] after execution of the following program.

                int[] A = {0,2,4,1,3};
                for(int i = 0; i < a.length; i++){
                    a[i] = a[(a[i] + 3) % a.length];
                }""");
        myDictionary.put(2, """
                ✨Identify the output of the following program.

                String str = “abcde”;
                System.out.println(str.substring(1, 3));""");
        myDictionary.put(3, """
                ✨ Identify the output of the following program.

                String str = “Hellow”;
                System.out.println(str.indexOf(‘t));""");
        myDictionary.put(4, """
                ✨ Public class Test{
                          Public static void main(String argos[]){
                                   String str1 = “one”;
                                   String str2 = “two”;
                                   System.out.println(str1.concat(str2));
                          }
                }""");
        myDictionary.put(5, """
                ✨How many objects will be created in the following?

                String a = new String(“interviewbit”);
                String b = new String(“Interviewbit”);
                Strinc c = “interviewbit”;
                String d = “interviewbit”;""");
        myDictionary.put(6, """
                ✨ Find the output of the following code.

                int ++a = 100;
                System.out.println(++a);""");
        myDictionary.put(7, """
                ✨if(1 + 1 + 1 + 1 + 1 == 5){
                  System.out.print(“true”);
                }
                else{
                  System.out.print(“false”);
                }""");
        myDictionary.put(8, """
                ✨Find the output of the following code.

                Public class Solution{
                      Public static void main(String… argos){
                             Int x = 5;
                             x * = (3 + 7);
                             System.out.println(x);""");
        myDictionary.put(9, "Output of Math.floor(3.6)?");
        myDictionary.put(10, """
                ✨What will be the output of the following code
                lst=[1,2,3]
                new_lst = lst*2
                new_lst[3] = 8
                print(len(lst))""");
        myDictionary.put(11, """
                ✨ How many times will “Interviewbit” be printed.

                Int count = 0;
                do{
                  System.out.println(“Interviewbit”);
                  count++;
                } while(count < 10);""");
        myDictionary.put(12, """
                ✨What is the output of the following code?
                 
                 int[] arr = {1, 2, 3};
                 int sum = 0;
                 for (int i = 0; i < arr.length; i++) {
                     sum += arr[i];
                 }
                 System.out.println(sum);
                """);
        myDictionary.put(13, """
                ✨What is the output of the following code?
                 
                 
                 String name = "Alice";
                 System.out.println(name.contains("li"));
                """);
        myDictionary.put(14, """
                ✨What is the output of the following code?
                 
                 
                 int[] arr = {1, 2, 3};
                 arr[1] = 5;
                 System.out.println(arr[1]);
                """);
        myDictionary.put(15, """
                ✨What is the output of the following code?
                 
                 double x = 2.5;
                 double y = 1.5;
                 System.out.println(Math.max(x, y));
                """);
        myDictionary.put(16, """
                ✨What is the output of the following code?
                 
                 String str = "Java Programming";
                 System.out.println(str.substring(5, 12));
                """);
        myDictionary.put(17, """
                ✨What is the output of the following Java code?
                 
                 String str = "hello";
                 System.out.println(str.replaceAll("l", "z"));
                """);
        myDictionary.put(18, """
                ✨What is the output of the following Java code?
                 
                 int num = 5;
                 String result = (num > 0) ? "positive" : "negative";
                 System.out.println(result);
                """);
        myDictionary.put(19, """
                ✨What is the output of the following Java code?
                 
                 int num = 5;
                 switch(num) {
                     case 1:
                         System.out.println("one");
                         break;
                     case 2:
                         System.out.println("two");
                         break;
                     default:
                         System.out.println("other");
                         break;
                 }
                """);
        myDictionary.put(20, """
                ✨What is the output of the following Java code?
                 
                 String str = "Hello User , Trixy is here to give you questions ! ";
                 System.out.println(str.indexOf("o"));
                """);
    }

    public String questions() {
        Random random = new Random();
        this.randomIndex = (random.nextInt(20));
        try{
            return myDictionary.get(randomIndex);
        }
        catch (Exception e){
            return "Error";
        }
    }
}
