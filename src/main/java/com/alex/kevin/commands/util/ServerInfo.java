package com.alex.kevin.commands.util;

import com.alex.kevin.commands.CommandManager;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;

public class ServerInfo extends CommandManager {
    public static void serverInfo(SlashCommandInteractionEvent event){
        Guild guild = event.getGuild();

        String content = "name: " + guild.getName() + "\nid: " + guild.getId() + "\nowner id: " + guild.getOwnerId() + "\nbanner id: " + guild.getBannerId()
                + "\nicon id: " + guild.getIconId() + "\nsplash id: " + guild.getSplashId() + "\nowner: " + guild.getOwner().getAsMention() + "\nicon url: "
                + guild.getIconUrl() + "\n banner url: " + guild.getBannerUrl() + "\nsplash url: " + guild.getSplashUrl()
        + "\nvanity url: " + guild.getVanityUrl() + "\ndescription: " + guild.getDescription() + "\ndefault channel: "
                + guild.getDefaultChannel() + "\nboost count: " + guild.getBoostCount() + "\nnsfw level: " + guild.getNSFWLevel() + "\nroles: " + guild.getRoles().size()
                + "\nemojis: " + guild.getEmojis().size() + "\nstickers: " + guild.getStickers().size() + "\nchannels: " + guild.getChannels().size()
                + "\nmembers: " + guild.getMemberCount();

        event.reply(content).queue();
    }
}
