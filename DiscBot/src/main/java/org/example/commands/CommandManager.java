package org.example.commands;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.events.guild.GuildReadyEvent;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import org.example.Main;
import org.example.database.Jokes;
import org.example.database.PickUpLines;
import org.example.database.Tips;
import org.jetbrains.annotations.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CommandManager extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        String command = event.getName();
        switch (command) {
            case "propose":
                Member member = Objects.requireNonNull(event.getOption("member")).getAsMember();
                PickUpLines PL = new PickUpLines();
                event.reply(member.getAsMention() + " " + PL.pickUpLines()).queue();
                break;

            case "help":
                EmbedBuilder builder = new EmbedBuilder();
                builder.setThumbnail("https://cdn.discordapp.com/attachments/1068100266492166264/1068855513518985216/Screenshot_2023-01-28_164630.png");
                builder.setTitle("[//] Trixy Bot Commands");
                builder.addBlankField(true);
                builder.setDescription("Here are the available commands for Trixy: <:5508imdone:1024357822730870825>");
                builder.addField("//game <:RetroGameOverLaptop:1099951288747302943> ", "A quick one word answer game to check your basic knowledge about programming.", false);
                builder.addField("//score :100:  ", "Check your progress.", false);
                builder.addField("//pl <:rilakkuma_kitty:1099952952518647899>", "A programming related pickup line to change your relationship status from single to mingle", false);
                builder.addField("//joke :grin:", "A programming related joke to brighten up your mood and give you a little laugh.", false);
                builder.addField("//meme <:hihihihehe:1024360482448084992>", "A programming related meme to make you go LOL", false);
                builder.addField("//tip " +"<:8989tip:1099947773912158208>", "A programming related tip to help you focus an level up your coding skills .", false);
                builder.addBlankField(true);
                builder.addField(":white_check_mark: CURRENT STATUS : ", "All The Above Specified Commands Are Working For Trixy . ", false);
                builder.setColor(0x42f5e0);
                MessageEmbed embed = builder.build();
                event.getChannel().sendMessageEmbeds(embed).queue();
                event.reply("Here's help command    ").queue();
                break;
            case "rules":
                EmbedBuilder builderR = new EmbedBuilder();
                builderR.setTitle(":red_circle:  Rules");
               // builderR.addBlankField(true);
                builderR.setDescription("• Answer only in one word . \n" +
                        "• If the code has some error , Type \"error\".\n" +
                        "• Answer in Lower Case only . \n" +
                        "• Do not send multiple commands simultaneously . \n" +
                        "• Only send answer after the question is given to you .\n"+
                        "• Each question consist of 1 mark .\n"+
                        "• Use //score to view your score");
                builderR.setColor(0x42f5e0);
                MessageEmbed embedR = builderR.build();
                event.getChannel().sendMessageEmbeds(embedR).queue();
                event.reply("Here are the rules for the quiz    ").queue();
                break;
        }
    }
    @Override
    public void onGuildReady(@NotNull GuildReadyEvent event) {
        List<CommandData> commandData = new ArrayList<>();
        commandData.add(Commands.slash("propose", "The worst she can say is no").addOption(OptionType.USER, "member", "The member you want to propose", true));
        //commandData.add(Commands.slash("leaderboard", "See who is leading the server"));
        commandData.add(Commands.slash("help","Shows info about bot and commands"));
        commandData.add(Commands.slash("rules","Shows rules for quiz"));
        event.getGuild().updateCommands().addCommands(commandData).queue();
    }
}