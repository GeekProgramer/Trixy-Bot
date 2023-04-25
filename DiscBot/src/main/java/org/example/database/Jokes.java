package org.example.database;

import java.util.HashMap;
import java.util.Random;

public class Jokes {
    private final HashMap<Integer, String> myDictionary;

    public Jokes() {
        myDictionary = new HashMap<>();
        // Add some key-value pairs to the dictionary
        myDictionary.put(1, "Why do programmers prefer dark mode? Because light attracts bugs.");
        myDictionary.put(2, "There are 10 types of people in this world: those who understand binary, and those who don't.");
        myDictionary.put(3, "Why do Java developers wear glasses? Because they can't C#");
        myDictionary.put(4, "Why did the Java developer refuse to become a teacher? He didn't want to inherit all of the errors from his students");
        myDictionary.put(5, "Why did the programmer go broke? He used up all his cache.");
        myDictionary.put(6, "Why did the Java developer get arrested? For illegal byte-code trafficking");
        myDictionary.put(7, "Why did the programmer go to the bar? He wanted to catch up on his networking.");
        myDictionary.put(8, "Why do programmers like to play football? Because they like to use their headers and footers.");
        myDictionary.put(9, "Why did the PHP developer go to jail? Because he didn't sanitize his inputs.");
        myDictionary.put(10, "Why did the Swift developer cross the road? To get to the Apple store.");
        myDictionary.put(11, "Why did the Rust developer refuse to write unsafe code? Because he didn't want to get into a data race.");
        myDictionary.put(12, "Why did the Go developer take up gardening? Because he loves to Gopher things.");
        myDictionary.put(13, "Why did the Python developer love mathematics? He loved the power of numpy.");
        myDictionary.put(14, "Two Python developers walk into a bar. The bartender asks, \"What do you guys want to drink?\" The first developer says, \"I'll have a Flask.\" The second developer says, \"I'll have a Django.\"");
        myDictionary.put(15, "(To Replace programmers with Robots, Clients will have to accurately describe what they want.\n We’re Safe)");
        myDictionary.put(16, "If you are not happy single, you won't be happy in a relationship.\nTrue happiness comes from closing 100 browser tabs after solving an obscure programming bug, not from someone else.");
    }

    public String Joke() {
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
