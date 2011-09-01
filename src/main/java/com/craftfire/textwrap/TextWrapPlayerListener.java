package com.craftfire.textwrap;

import java.util.ArrayList;

import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerListener;

public class TextWrapPlayerListener extends PlayerListener
{
    private final TextWrap plugin;

    public TextWrapPlayerListener(TextWrap instance)
    {
        this.plugin = instance;
    }

    public void onPlayerChat(PlayerChatEvent event)
    {
        Player player = event.getPlayer();
        String PlayerName = player.getName();
        String Message = event.getMessage();
        event.setFormat(event.getFormat().replace("%1$s", PlayerName));
        String Spaces = "";
        int x = event.getFormat().indexOf(Message) + countColors(event.getFormat().replace(" "+Message, ""));
        this.plugin.getServer().getLogger().info("LOCATION: "+ x +"- LENGTH:"+event.getFormat().length());
        int tempcounter = event.getFormat().length() - 2;
        for (int i = 0; i < tempcounter; i++)
            Spaces += " ";
        int counter = 50;
        event.setFormat(event.getFormat().replace("%2$s", Message));
        this.plugin.getServer().getLogger().info("FORMAT: "+event.getFormat());
        if (event.getFormat().length() > counter)
        {
            this.plugin.getServer().getLogger().info(event.getFormat().length() + event.getMessage().length() +" > "+ counter);
            ArrayList<String> Messages = new ArrayList<String>();
            String[] Words = Message.split(" ");
            String TempMessage = "";
            int TempMessageLength = x;
            for (String Word : Words)
            {
                TempMessageLength = (TempMessage.length()+x+Word.length()) + 1;
                if (TempMessageLength > counter)
                {
                    TempMessageLength = x;
                    Messages.add(TempMessage);
                    TempMessage = "";
                }
                this.plugin.getServer().getLogger().info(TempMessage+"-"+(TempMessage.length()+x)+"-"+Word.length()+"-"+TempMessageLength+":"+counter);
                TempMessage += Word + " ";
            }
            Messages.add(TempMessage);
            int thecounter = 0;
            String TempPrefix = "";
            while(thecounter < Messages.size())
            {
                if(thecounter==0) { TempPrefix = event.getFormat().replace(" "+Message, ""); }
                else 
                { 
                    if(Config.message_indent) { TempPrefix = Spaces; } 
                    else { TempPrefix = ""; } 
                }
                this.plugin.getServer().broadcastMessage(TempPrefix+Messages.get(thecounter));
                thecounter++;
            }
        } else {
            for(Player p : this.plugin.getServer().getOnlinePlayers())
            {
                //p.sendMessage(arg0)
            }
            event.setFormat(event.getFormat().replace("%1$s", PlayerName));
            event.setFormat(event.getFormat().replace("%2$s", Message));
            this.plugin.getServer().broadcastMessage(event.getFormat());
        }
        event.setCancelled(true);
    }

    public int countColors(String string)
    {
        int counter = 0;
        if(string.contains("§0") || string.contains("§1") || string.contains("§2") || string.contains("§3") || string.contains("§4") || string.contains("§5") || string.contains("§6") || string.contains("§7") || string.contains("§8") || string.contains("§9") || string.contains("§a") || string.contains("§b") || string.contains("§c") || string.contains("§d") || string.contains("§e") || string.contains("§f"))
            counter += 2;
        return counter;
    }
}