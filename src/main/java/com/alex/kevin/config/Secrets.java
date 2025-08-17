package com.alex.kevin.config;

import io.github.cdimascio.dotenv.Dotenv;

public class Secrets {
    private final Dotenv dotenv = Dotenv.configure()
            .directory("./src/main/resources")
            .filename(".env")
            .load();

    private final String token = dotenv.get("DISCORD_TOKEN");
    private final char prefix = dotenv.get("PREFIX").charAt(0);
    private final String inviteGuild = dotenv.get("INVITE_GUILD");
    private final String inviteUser = dotenv.get("INVITE_USER");

    public String getToken() {
        return this.token;
    }

    public char getPrefix() {
        return this.prefix;
    }

    public String getInviteGuild() { return this.inviteGuild; }
    public String getInviteUser() { return this.inviteUser; }


}
