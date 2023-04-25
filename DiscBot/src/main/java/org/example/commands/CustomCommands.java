package org.example.commands;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.EventListener;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.bson.Document;
import org.example.database.*;

import java.util.Date;
import java.util.Random;

import static com.mongodb.client.model.Filters.eq;
import static org.example.database.Meme.MEME_LINKS;

public class CustomCommands extends ListenerAdapter implements EventListener {
    MongoClient mongoClient = new MongoClient("localhost", 27017);
    MongoDatabase database = mongoClient.getDatabase("trixy");
    private String user;
    private String userResponse;
    PickUpLines db = new PickUpLines();                                      //here we are making objects of imported classes
    Jokes jokeObj = new Jokes();
    Questions questionObj = new Questions();
    Answers answerObj = new Answers();
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {

        if (event.getAuthor().isBot()) {
            return;                                                         // Ignore messages from bots
        }

        String messageContent = event.getMessage().getContentDisplay();
        String user = event.getAuthor().getName();
        this.userResponse = messageContent;
        this.user = user;

        if (messageContent.startsWith("//")) {                             // Checking if the message starts with the custom prefix
            String commandName = messageContent.substring(2);    // Removing the prefix and get the command name

            switch (commandName) {
                case ("joke") -> {
                    EmbedBuilder builder = new EmbedBuilder();
                    String JOKE = jokeObj.Joke();
                    builder.setTitle(JOKE);
                    builder.setColor(0x42f5e0);
                    MessageEmbed embed = builder.build();
                    event.getChannel().sendMessageEmbeds(embed).queue();
                }
                case ("pl") -> {
                    EmbedBuilder builder1 = new EmbedBuilder();
                    String pl = (db.pickUpLines());
                    if (pl != null && !pl.isEmpty()) {
                        builder1.setTitle(pl);
                        builder1.setColor(0x42f5e0);
                        MessageEmbed embed1 = builder1.build();
                        event.getChannel().sendMessageEmbeds(embed1).queue();
                    }
                }
                case ("game") -> new Thread(
                    () -> {
                        try {
                            game(event);
                        }
                        catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                ).start();

                case("meme") ->{
                    Random random = new Random();
                    String memeLink = MEME_LINKS[random.nextInt(MEME_LINKS.length)];
                    EmbedBuilder builderM = new EmbedBuilder();
                    builderM.setTitle("Here's a meme for you from Trixy");
                    builderM.setImage(memeLink);
                    builderM.setColor(0x42f5e0);
                    MessageEmbed embedM = builderM.build();
                    event.getChannel().sendMessageEmbeds(embedM).queue();
                }
                case("tip")->{
                    Tips getTips = new Tips();
                    String tips = getTips.sendRandomTip();
                    EmbedBuilder builderM = new EmbedBuilder();
                    builderM.setTitle("Here's a Tip for you from Trixy");
                    builderM.setDescription(tips);
                    builderM.setColor(0x42f5e0);
                    MessageEmbed embedM = builderM.build();
                    event.getChannel().sendMessageEmbeds(embedM).queue();
                }
                case "score"->{
                    MongoCollection<Document> collection=database.getCollection("scores");
                    String userId = event.getAuthor().getId();
                    Document result = collection.find(eq("userId",userId)).first();
                    int points = 0;
                    if (result != null) {
                        points = result.getInteger("score");
                    }
                    EmbedBuilder builderM = new EmbedBuilder();
                    builderM.setTitle("Your current score: "+points);
                    builderM.setDescription("You have answered "+points+" questions correctly.\nKeep it up!!");
                    builderM.setColor(0x42f5e0);
                    MessageEmbed embedM = builderM.build();
                    event.getChannel().sendMessageEmbeds(embedM).queue();
                }

            }
        }
        synchronized (this) {
            notify();
        }
    }
    private void game(MessageReceivedEvent event) throws InterruptedException {
        EmbedBuilder builder = new EmbedBuilder();
        builder.setTitle("Make Sure to Read the rules before playing the game");
        builder.addField("**Here's your quiz question:**\n\n", questionObj.questions(), false);
        builder.setColor(0x42f5e0);
        MessageEmbed embed = builder.build();
        event.getChannel().sendMessageEmbeds(embed).queue();

        synchronized (this) {
            try {
                wait(20000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        String userN = event.getAuthor().getName();
        if (user.equals(userN) && !userResponse.equals("//game")) {
            if (answerObj.answers(questionObj.randomIndex).equals(this.userResponse) && userN.equals(user)) {
                EmbedBuilder builder1 = new EmbedBuilder();
                builder1.addField("CORRECT", "Congratulations, your answer is correct!", false);
                builder.setColor(0x42F586);
                MessageEmbed embed1 = builder1.build();
                event.getChannel().sendMessageEmbeds(embed1).queue();

                String userDiscordId = event.getAuthor().getId();
                MongoCollection<Document> scoresCollection = database.getCollection("scores");
                Document query = new Document("userId", userDiscordId);
                Document scoreDocument = scoresCollection.find(query).first();
                if (scoreDocument == null) {
                    // If the user doesn't have a score, create a new document for them
                    scoreDocument = new Document("userId", userDiscordId)
                            .append("score", 0)
                            .append("updatedAt", new Date());
                    scoresCollection.insertOne(scoreDocument);
                }
                int newScore = scoreDocument.getInteger("score") + 1;
                scoreDocument.put("score", newScore);
                scoreDocument.put("updatedAt", new Date());
                scoresCollection.updateOne(query, new Document("$set", scoreDocument));

            } else {
                EmbedBuilder builder3 = new EmbedBuilder();
                builder3.addField("INCORRECT", "Sorry, your answer is incorrect. The correct answer is " + answerObj.answers(questionObj.randomIndex), false);
                builder3.setColor(0xF54258);
                MessageEmbed embed3 = builder3.build();
                event.getChannel().sendMessageEmbeds(embed3).queue();
            }
        }
        else if(user.equals(userN) && userResponse.equals("//game")){
            EmbedBuilder builder2 = new EmbedBuilder();
            builder2.setTitle("OOPS!! TIME IS UP");
            builder2.setDescription("The correct answer is " + answerObj.answers(questionObj.randomIndex));
            builder2.setColor(0x42f5e0);
            MessageEmbed embed2 = builder2.build();
            event.getChannel().sendMessageEmbeds(embed2).queue();

        } else if (!user.equals(userN) && !userResponse.equals("//game")) {
            if (answerObj.answers(questionObj.randomIndex).equals(this.userResponse)) {
                EmbedBuilder builderN = new EmbedBuilder();
                builderN.addField("Be Fast Next Time", "Someone else answered it first!! ", false);
                builderN.setColor(0x42F586);
                MessageEmbed embedN = builderN.build();
                event.getChannel().sendMessageEmbeds(embedN).queue();
            }

        }
    }
}






