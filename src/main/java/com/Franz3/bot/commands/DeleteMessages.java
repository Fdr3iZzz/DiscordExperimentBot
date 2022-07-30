package com.Franz3.bot.commands;

import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import net.dv8tion.jda.internal.requests.Route;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class DeleteMessages extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {

            event.reply("Messages got removed").setEphemeral(true).queue();
            // /delete <amount>
            OptionMapping amount = event.getOption("amount");

            if (amount == null){
                event.reply("ERROR").queue();
                return;
            } else {
                event.getMessageChannel().getIterableHistory().takeAsync(amount.getAsInt()).thenApply(messages -> event.getChannel().purgeMessages(messages));
            }

    }
}
