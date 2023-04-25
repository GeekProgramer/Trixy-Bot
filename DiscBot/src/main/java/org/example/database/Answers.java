package org.example.database;

import java.util.HashMap;

public class Answers {
    private final HashMap<Integer, String> myDictionary;
    public void setRandomIndex(int randomIndex) {
    }

    public Answers() {
        myDictionary = new HashMap<>();
        // Add some key-value pairs to the dictionary
        myDictionary.put(1, "1");
        myDictionary.put(2, "bc");
        myDictionary.put(3, "error");
        myDictionary.put(4, "onetwo");
        myDictionary.put(5, "3");
        myDictionary.put(6, "error");
        myDictionary.put(7, "true");
        myDictionary.put(8, "50");
        myDictionary.put(9, "3.0");
        myDictionary.put(10, "3");
        myDictionary.put(11, "10");
        myDictionary.put(12, "6");
        myDictionary.put(13, "true");
        myDictionary.put(14, "5");
        myDictionary.put(15, "2.5");
        myDictionary.put(16, "program");
        myDictionary.put(17, "hezzo");
        myDictionary.put(18, "positive");
        myDictionary.put(19, "other");
        myDictionary.put(20, "4");





//        myDictionary.put(12, "Where’s the ‘like’ button for that smile?");
//        myDictionary.put(13, "You are so hot girl that when I first laid eyes on you, I reached a runtime error.");
//        myDictionary.put(14, "Are you tired? Because you have been running through my mind all day.");
//        myDictionary.put(15, "I must be an exception because you have sure caught me.");
    }

    public String answers(int index) {
        try{
            return myDictionary.get(index);
        }
        catch (Exception e){
            return "Error";
        }
    }

}