package com.alex.kevin.commands.util;

import com.alex.kevin.commands.CommandManager;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;

public class UserInfo extends CommandManager {
    public static void userInfo(SlashCommandInteractionEvent event){
        if (event.getInteraction().getOptionsByName("user").isEmpty()){
            User user = event.getUser();
            String content = "username: " + user.getName() + "\ndisplay name: " + user.getEffectiveName() + "\nid: " + user.getId()
                    + "\navatar url: " + user.getAvatarUrl()  + "\navatar id: " + user.getAvatarId() + "\ndate created: " + user.getTimeCreated()
            + "\nbot: " + user.isBot();
            event.reply(content).queue();
            return;
        }
        User user = event.getInteraction().getOption("user").getAsUser();
        String content = "username: " + user.getName() + "\ndisplay name: " + user.getEffectiveName() + "\nid: " + user.getId()
                + "\navatar url: " + user.getAvatarUrl()  + "\navatar id: " + user.getAvatarId() + "\ndate created: " + user.getTimeCreated()
                + "\nbot: " + user.isBot();
        event.reply(content).queue();
    }
}
