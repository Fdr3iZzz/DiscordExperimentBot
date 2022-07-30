package com.Franz3.bot.events;

import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.events.guild.GuildReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class OnReadyMessage extends ListenerAdapter {
    @Override
    public void onReady(@NotNull ReadyEvent event) {
        event.getJDA().getTextChannelById(999840182452891799L).sendMessage(  "<@269486856469479424> Bot is Running").queue();


    }
}