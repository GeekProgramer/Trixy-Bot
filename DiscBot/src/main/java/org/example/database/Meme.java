package org.example.database;

import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.util.Random;

public class Meme extends ListenerAdapter {
    public static final String[] MEME_LINKS = {
            "https://cdn.discordapp.com/attachments/1068844142865678346/1097797190677712946/Meme5.webp",
            "https://cdn.discordapp.com/attachments/1068844142865678346/1097797191722090567/Meme3.webp",
            "https://cdn.discordapp.com/attachments/1068844142865678346/1097797191428472832/Meme2.jpg",
            "https://cdn.discordapp.com/attachments/1068844142865678346/1097797191143280650/Meme1.png",
            "https://cdn.discordapp.com/attachments/1068844142865678346/1097797192154107964/Meme4.webp",
            "https://cdn.discordapp.com/attachments/1068844142865678346/1097806522429493310/Meme6.jpg",
            "https://cdn.discordapp.com/attachments/1068844142865678346/1097806522685333525/Meme7.jpg",
            "https://cdn.discordapp.com/attachments/1068844142865678346/1097806522966347847/Meme8.png",
            "https://cdn.discordapp.com/attachments/1068844142865678346/1097806523364823060/Meme9.jpg",
            "https://cdn.discordapp.com/attachments/1068844142865678346/1097806586866581544/Meme10.jpg",
            "https://cdn.discordapp.com/attachments/1068844142865678346/1097806587114041344/Meme11.webp",
            "https://cdn.discordapp.com/attachments/1068844142865678346/1097806587491520512/Meme12.jpg",
            "https://cdn.discordapp.com/attachments/1068844142865678346/1097806587772551270/Meme13.webp",
            "https://cdn.discordapp.com/attachments/1068844142865678346/1097806587772551270/Meme13.webp",
            "https://cdn.discordapp.com/attachments/1068844142865678346/1097806588129063032/Meme14.jpg",
            "https://cdn.discordapp.com/attachments/1068844142865678346/1097806588401684580/Meme15.jpg",
            "https://cdn.discordapp.com/attachments/1068844142865678346/1097812101709451324/Meme16.png",
            "https://cdn.discordapp.com/attachments/1068844142865678346/1097812101961105458/Meme17.png",
            "https://cdn.discordapp.com/attachments/1068844142865678346/1097812102237925386/Meme18.jpg",
            "https://cdn.discordapp.com/attachments/1068844142865678346/1097812102502174811/Meme19.png",
            "https://cdn.discordapp.com/attachments/1068844142865678346/1097812102787383316/Meme20.jpg",
            "https://cdn.discordapp.com/attachments/1068844142865678346/1097797190677712946/Meme5.webp",
            "https://cdn.discordapp.com/attachments/1068844142865678346/1097797191143280650/Meme1.png",
            "https://cdn.discordapp.com/attachments/1068844142865678346/1097797191428472832/Meme2.jpg",
            "https://cdn.discordapp.com/attachments/1068844142865678346/1097797191722090567/Meme3.webp",
            "https://cdn.discordapp.com/attachments/1068844142865678346/1097797192154107964/Meme4.webp",
            "https://cdn.discordapp.com/attachments/1068844142865678346/1097806522429493310/Meme6.jpg",
            "https://cdn.discordapp.com/attachments/1068844142865678346/1097806522685333525/Meme7.jpg",
            "https://cdn.discordapp.com/attachments/1068844142865678346/1097806522966347847/Meme8.png",
            "https://cdn.discordapp.com/attachments/1068844142865678346/1097806523364823060/Meme9.jpg",
            "https://cdn.discordapp.com/attachments/1068844142865678346/1097806586866581544/Meme10.jpg",
            "https://cdn.discordapp.com/attachments/1068844142865678346/1097806587114041344/Meme11.webp",
            "https://cdn.discordapp.com/attachments/1068844142865678346/1097806587491520512/Meme12.jpg",
            "https://cdn.discordapp.com/attachments/1068844142865678346/1097806587772551270/Meme13.webp",
            "https://cdn.discordapp.com/attachments/1068844142865678346/1097806588129063032/Meme14.jpg",
            "https://cdn.discordapp.com/attachments/1068844142865678346/1097812101709451324/Meme16.png",
            "https://cdn.discordapp.com/attachments/1068844142865678346/1097812102237925386/Meme18.jpg",
    };


    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        if (event.getAuthor().isBot()) {
            return; // Ignore messages from bots
        }

        String message = event.getMessage().getContentRaw();
        if (message.equalsIgnoreCase("!meme")) {
            Random random = new Random();
            String memeLink = MEME_LINKS[random.nextInt(MEME_LINKS.length)];
            event.getChannel().sendMessage(event.getAuthor().getAsMention() + " Here's your meme from Trixy : " + memeLink).queue();
        }
    }
}