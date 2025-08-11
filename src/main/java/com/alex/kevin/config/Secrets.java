package com.alex.kevin.config;

import io.github.cdimascio.dotenv.Dotenv;

public class Secrets {
    private final Dotenv dotenv = Dotenv.configure()
            .directory("./src/main/resources")
            .filename(".env")
            .load();

    private final String token = dotenv.get("DISCORD_TOKEN");
    private final String prefix = dotenv.get("PREFIX");

    public String getToken() {
        return this.token;
    }

    public String getPrefix() {
        return this.prefix;
    }

}
