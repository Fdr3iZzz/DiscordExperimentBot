package com.Franz3.bot;

import com.Franz3.bot.events.DeleteMessages;
import com.Franz3.bot.events.OnJoinEvents;
import com.Franz3.bot.events.PingEvents;
import io.github.cdimascio.dotenv.Dotenv;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;

import javax.security.auth.login.LoginException;

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
                .build();

        //#getTextChannelById(999840182452891799).sendMessage("@Franz3 Server Running");
    }
}
