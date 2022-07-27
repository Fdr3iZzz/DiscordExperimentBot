package com.Franz3.bot.events;

import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class PingEvents extends ListenerAdapter {
    @Override
        public void onMessageReceived(MessageReceivedEvent event) {
        if (event.getAuthor().isBot()) return;

        Message message = event.getMessage();
        String content = message.getContentRaw();
        if (content.equalsIgnoreCase("/ping")){
            MessageChannel channel = event.getChannel();
            System.out.println("Event ist" + event.getChannel());
            channel.sendMessage("Pong! " + event.getAuthor().getAsMention()).queue();
        }
    }

}
