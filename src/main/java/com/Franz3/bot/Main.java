package com.Franz3.bot;

import com.Franz3.bot.commands.DeleteMessages;
import com.Franz3.bot.events.OnJoinEvents;
import com.Franz3.bot.events.OnReadyMessage;
import com.Franz3.bot.events.PingEvents;
import io.github.cdimascio.dotenv.Dotenv;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.requests.GatewayIntent;

public class Main {

    public static void main(String[] args) throws Exception{

        final Dotenv config;
        config = Dotenv.configure().load();
        String token = config.get("TOKEN");

        JDA jda = JDABuilder.createDefault(token)
                .setActivity(Activity.watching("Time passing by"))
                .setStatus(OnlineStatus.DO_NOT_DISTURB)
                .enableIntents(GatewayIntent.MESSAGE_CONTENT)
                .enableIntents(GatewayIntent.GUILD_MEMBERS)
                //listener
                .addEventListeners(new PingEvents())
                .addEventListeners(new OnJoinEvents())
                .addEventListeners(new DeleteMessages())
                .addEventListeners(new OnReadyMessage())
                .build().awaitReady();

        // adds slash commands
        Guild guild = jda.getGuildById("592382416069459968");
        if (guild != null){
            guild.upsertCommand("delete", "will delete the inputed amount of messages in the channel it is used in")
                    .addOption(OptionType.INTEGER, "amount", "number of messages deleted",true)
                    .queue();
        }else {
            System.out.println("ERROR, Guild ID for registering the delete command is wrong");
        }


    }
}
