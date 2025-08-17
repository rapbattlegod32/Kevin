package com.alex.kevin.listeners;

import com.alex.kevin.config.Secrets;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.io.File;

public class EventListener extends ListenerAdapter {
    Secrets config = new Secrets();
    final File folder = new File("C:\\Users\\Alexu\\Desktop\\kevin\\src\\main\\resources\\media\\schieste");

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        String content = event.getMessage().getContentRaw().toLowerCase();
        char prefix = config.getPrefix();

        if (content.contains("kevin")){
            kevin(event);
        }
    }

    public void kevin(MessageReceivedEvent event){
        String message = "Hey " + event.getAuthor().getAsMention();
        event.getMessage().reply(message).queue();
    }

}
