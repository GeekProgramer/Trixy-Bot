package org.example.database;


import net.dv8tion.jda.api.events.StatusChangeEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.util.Random;

public class Tips extends ListenerAdapter {
    private static final String[] TIPS = {
            "Always test your code before pushing it to production.",
            "Don't repeat yourself (DRY) - avoid duplicating code.",
            "Use version control (e.g. Git) to manage your codebase.",
            "Use meaningful variable and function names to make your code more readable.",
            "Document your code with comments to explain its purpose and how it works.",
            "Learn to use debugging tools to help you identify and fix issues in your code.",
            "Avoid using global variables - they can cause unexpected side effects.",
            "Follow coding conventions and style guides to maintain consistency in your code.",
            "Don't optimize prematurely - focus on writing clear and maintainable code first.",
            "Use libraries and frameworks to save time and improve the quality of your code.",
            "Avoid using magic numbers and hard-coded values - define constants instead.",
            "Use try-catch blocks to handle exceptions and prevent your program from crashing.",
            "Use test-driven development (TDD) to ensure that your code works as expected.",
            "Refactor your code regularly to improve its design and maintainability.",
            "Use tools like linters and code analyzers to catch errors and improve code quality."
    };


    public String sendRandomTip() {
        // Choose a random tip from the array
        String tip = TIPS[new Random().nextInt(TIPS.length)];
        return tip;
    }
}