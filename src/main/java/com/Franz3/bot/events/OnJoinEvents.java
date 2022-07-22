package com.Franz3.bot.events;

import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.guild.GuildJoinEvent;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class OnJoinEvents extends ListenerAdapter {
    @Override
    public void onGuildMemberJoin(@NotNull GuildMemberJoinEvent event) {

        event.getGuild().getTextChannelById("999840182452891799").sendMessage("Hey, " + event.getMember() +" and well cum to " + event.getGuild()).queue();
    }
}
