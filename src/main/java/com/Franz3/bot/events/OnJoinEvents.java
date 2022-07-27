package com.Franz3.bot.events;

import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class OnJoinEvents extends ListenerAdapter {
    @Override
    public void onGuildMemberJoin(@NotNull GuildMemberJoinEvent event) {

        if (event.getUser().isBot()) return;

        String channel = "999840182452891799";
        event.getGuild().getTextChannelById("channel").sendMessage("Hey, " +  event.getUser().getAsMention() + " and well cum to: " + event.getGuild().getName()).queue();

    }
}
