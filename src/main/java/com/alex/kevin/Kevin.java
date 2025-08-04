package com.alex.kevin;

import com.alex.kevin.config.Secrets;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.sharding.DefaultShardManagerBuilder;
import net.dv8tion.jda.api.sharding.ShardManager;

public class Kevin {
    static Secrets config = new Secrets();

    protected final ShardManager shardManager;

    public Kevin(){
        DefaultShardManagerBuilder builder = DefaultShardManagerBuilder.createDefault(config.getToken());
        builder.setStatus(OnlineStatus.ONLINE);
        builder.setActivity(Activity.listening("something"));
        shardManager = builder.build();
    }

    public ShardManager getShardManager() {
        return shardManager;
    }

    public static void main(String[] args){
        Kevin bot = new Kevin();
    }
}
