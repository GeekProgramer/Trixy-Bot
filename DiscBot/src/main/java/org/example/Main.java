package org.example;

import io.github.cdimascio.dotenv.Dotenv;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.requests.GatewayIntent;
import org.example.commands.CommandManager;
import org.example.commands.CustomCommands;
import org.example.database.Tips;


public class Main extends ListenerAdapter {
    public static void main(String[] args) {
        Dotenv config = Dotenv.configure().load();
        String token = config.get("TOKEN");
        JDABuilder builder = JDABuilder.createDefault(token);

        builder.setStatus(OnlineStatus.ONLINE);
        builder.setActivity(Activity.competing("LeetCode"));
        builder.enableIntents(GatewayIntent.GUILD_MESSAGES, GatewayIntent.GUILD_MESSAGE_REACTIONS,GatewayIntent.MESSAGE_CONTENT);

        builder.addEventListeners(new CommandManager());
        builder.addEventListeners(new CustomCommands());
        builder.addEventListeners(new Main());
        builder.addEventListeners(new Tips());

        builder.build();
    }
}
