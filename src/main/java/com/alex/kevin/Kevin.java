package com.alex.kevin;

import com.alex.kevin.commands.CommandManager;
import com.alex.kevin.config.Secrets;
import com.alex.kevin.listeners.EventListener;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.sharding.DefaultShardManagerBuilder;
import net.dv8tion.jda.api.sharding.ShardManager;
import net.dv8tion.jda.api.utils.ChunkingFilter;
import net.dv8tion.jda.api.utils.MemberCachePolicy;

public class Kevin {
    static Secrets config = new Secrets();

    protected final ShardManager shardManager;

    public Kevin(){
        DefaultShardManagerBuilder builder = DefaultShardManagerBuilder.createDefault(config.getToken());
        builder.setStatus(OnlineStatus.ONLINE);
        builder.setActivity(Activity.listening("something"));
        builder.enableIntents(GatewayIntent.MESSAGE_CONTENT, GatewayIntent.GUILD_MEMBERS);
        builder.setMemberCachePolicy(MemberCachePolicy.ALL);
        builder.setChunkingFilter(ChunkingFilter.ALL);
        shardManager = builder.build();
        
        // register listeners
        shardManager.addEventListener(new EventListener(), new CommandManager());
    }

    public ShardManager getShardManager() {
        return shardManager;
    }

    public static void main(String[] args){
        Kevin bot = new Kevin();
    }
}
