package com.alex.kevin.listeners;

import com.alex.kevin.config.Secrets;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.events.message.react.MessageReactionAddEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class EventListener extends ListenerAdapter {
    Secrets config = new Secrets();

    @Override
    public void onMessageReactionAdd(MessageReactionAddEvent event) {
        User user = event.getUser();
        String emoji = event.getReaction().getEmoji().getAsReactionCode();
        String channelMention = event.getChannel().getAsMention();
        String jumpLink = event.getJumpUrl();

        String message = user.getAsTag() + " | " + user.getId() + " reacted to a message with:\nemoji: " + emoji + "\nchannel: " + channelMention
                + "\njump: " + jumpLink;
        event.getGuild().getDefaultChannel().asTextChannel().sendMessage(message).queue();

    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        String content = event.getMessage().getContentRaw().toLowerCase();
        String prefix = config.getPrefix();

        if (content.equals(prefix + "ping")){
            String message = "Pong!";
            event.getMessage().reply(message).queue();
        }
    }
}
