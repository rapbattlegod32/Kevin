package com.alex.kevin.commands.util;

import com.alex.kevin.commands.CommandManager;
import com.alex.kevin.config.Secrets;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;

public class Invite extends CommandManager {
    public static void invite(SlashCommandInteractionEvent event){
        Secrets config = new Secrets();
        String content = "guild install: " + config.getInviteGuild() + "\nuser install: " + config.getInviteUser();
        event.reply(content).queue();
    }
}
