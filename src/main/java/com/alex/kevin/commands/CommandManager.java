package com.alex.kevin.commands;

import com.alex.kevin.commands.util.Invite;
import com.alex.kevin.commands.util.ServerInfo;
import com.alex.kevin.commands.util.UserInfo;
import com.alex.kevin.commands.util.YTDLP;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.session.ReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.IntegrationType;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.interactions.commands.build.Commands;

import java.util.ArrayList;
import java.util.List;

public class CommandManager extends ListenerAdapter {

    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        String command = event.getName();
        switch (command){
            case "invite": {
                Invite.invite(event);
                break;
            }
            case "user-info": {
                UserInfo.userInfo(event);
                break;
            }
            case "server-info": {
                ServerInfo.serverInfo(event);
                break;
            }
            case "yt-dlp": {
                YTDLP.YTDLPEXE(event);
                break;
            }
        }
    }

    @Override
    public void onReady(ReadyEvent event) {
        List<CommandData> commandData = new ArrayList<>();
        commandData.add(Commands.slash("invite", "Get the invite link for kevin")
                .setIntegrationTypes(IntegrationType.GUILD_INSTALL, IntegrationType.USER_INSTALL));
        commandData.add(Commands.slash("server-info", "Get the current server info")
                .setIntegrationTypes(IntegrationType.GUILD_INSTALL));
        commandData.add(Commands.slash("user-info", "Display info about a user")
                .addOption(OptionType.MENTIONABLE,
                "user", "Get info of mentioned user", false)
                .setIntegrationTypes(IntegrationType.GUILD_INSTALL, IntegrationType.USER_INSTALL));
        commandData.add(Commands.slash("yt-dlp", "yt-dlp.exe")
                .addOption(OptionType.STRING,
                        "url", "URL of media", true)
                .setIntegrationTypes(IntegrationType.GUILD_INSTALL, IntegrationType.USER_INSTALL)
        );
        event.getJDA().updateCommands().addCommands(commandData).queue();
    }
}
