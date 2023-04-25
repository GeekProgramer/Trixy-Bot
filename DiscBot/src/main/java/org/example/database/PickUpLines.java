package org.example.database;

import java.util.HashMap;
import java.util.Random;

public class PickUpLines {
    private final HashMap<Integer, String> myDictionary;

    public PickUpLines() {
        myDictionary = new HashMap<>();
        // Add some key-value pairs to the dictionary
        myDictionary.put(1, "I must be an exception because you have sure caught me.");
        myDictionary.put(2, "A life without you, would be like a computer without an OS.");
        myDictionary.put(3, "Anonymity makes me even more handsome.");
        myDictionary.put(4, "Are you a computer keyboard? Because you’re my type.");
        myDictionary.put(5, "Are you a computer whiz… it seems you know how to turn my software to hardware");
        myDictionary.put(6, "Are you a double? The thought of you always floats inside my head.");
        myDictionary.put(7, "Are you an angel, because your texture mapping is divine!");
        myDictionary.put(8, "You are my initializer: without you, my life would point to nothing (null)");
        myDictionary.put(9, "I’ll have to try again tomorrow, because you’ve already exceeded my bandwidth.");
        myDictionary.put(10, "You are my semicolon; always present in everything I do.");
        myDictionary.put(11, "Are you https?? Bcz without you I'm just ://");
        myDictionary.put(12, "Where’s the ‘like’ button for that smile?");
        myDictionary.put(13, "You are so hot girl that when I first laid eyes on you, I reached a runtime error.");
        myDictionary.put(14, "Are you tired? Because you have been running through my mind all day.");
        myDictionary.put(15, "I must be an exception because you have sure caught me.");
    }

    public String pickUpLines() {
        Random random = new Random();
        int randomIndex = (random.nextInt(15));
        try{
            return myDictionary.get(randomIndex);
        }
        catch (Exception e){
            return "Error";
        }
    }
}
