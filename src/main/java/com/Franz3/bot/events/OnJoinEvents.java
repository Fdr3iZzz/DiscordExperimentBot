package com.Franz3.bot.events;

import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.guild.GuildJoinEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class OnJoinEvents extends ListenerAdapter {
    @Override
    public void onGuildJoin(@NotNull GuildJoinEvent event) {


        channell.sendMessage("Hey " + event.getRawData()+ "and well cum to " + event.getGuild());

    }
}
