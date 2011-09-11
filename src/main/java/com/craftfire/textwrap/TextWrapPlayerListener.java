/**
(C) Copyright 2011 CraftFire <dev@craftfire.com>
Contex <contex@craftfire.com>, Wulfspider <wulfspider@craftfire.com>

This work is licensed under the Creative Commons Attribution-NonCommercial-NoDerivs 3.0 Unported License.
To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/3.0/
or send a letter to Creative Commons, 171 Second Street, Suite 300, San Francisco, California, 94105, USA.
**/

package com.craftfire.textwrap;

import java.util.ArrayList;
import java.util.logging.Level;

import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.CraftServer;
import org.bukkit.craftbukkit.command.ColouredConsoleSender;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerListener;

public class TextWrapPlayerListener extends PlayerListener {
    private final TextWrap plugin;

    public TextWrapPlayerListener(TextWrap instance) {
        this.plugin = instance;
    }

    public void onPlayerChat(PlayerChatEvent event) {
        Player player = event.getPlayer();
        String PlayerName = player.getName();
        String Message = event.getMessage();
        event.setFormat(event.getFormat().replace("%1$s", PlayerName));
        String Spaces = "";
        int x = event.getFormat().indexOf(Message) + countColors(event.getFormat().replace(" " + Message, ""));
        this.plugin.getServer().getLogger().info("LOCATION: " + x + "- LENGTH:" + event.getFormat().length());
        int tempcounter = event.getFormat().length() - 2;
        for (int i = 0; i < tempcounter; i++) {
            Spaces += " ";
        }
        int counter = 50;
        event.setFormat(event.getFormat().replace("%2$s", Message));
        this.plugin.getServer().getLogger().info("FORMAT: " + event.getFormat());
        if (event.getFormat().length() > counter) {
            this.plugin.getServer().getLogger().info(event.getFormat().length() + event.getMessage().length() + " > " + counter);
            ArrayList<String> Messages = new ArrayList<String>();
            String[] Words = Message.split(" ");
            String TempMessage = "";
            int TempMessageLength = x;
            for (String Word : Words) {
                TempMessageLength = (TempMessage.length() + x + Word.length()) + 1;
                if (TempMessageLength > counter) {
                    TempMessageLength = x;
                    Messages.add(TempMessage);
                    TempMessage = "";
                }
                this.plugin.getServer().getLogger().info(TempMessage + "-" + (TempMessage.length() + x) + "-" + Word.length() + "-" + TempMessageLength + ":" + counter);
                TempMessage += Word + " ";
            }
            Messages.add(TempMessage);
            int thecounter = 0;
            String TempPrefix = "";
            while (thecounter < Messages.size()) {
                if (thecounter == 0) {
                    TempPrefix = event.getFormat().replace(" " + Message, "");
                } else {
                    if (Config.message_indent) {
                        TempPrefix = Spaces;
                    } else {
                        TempPrefix = "";
                    }
                }
//              for (Player p : event.getRecipients()) {
//                  p.sendMessage(TempPrefix + Messages.get(thecounter));
//              }
//              ColouredConsoleSender console = new ColouredConsoleSender((CraftServer)Bukkit.getServer());
//              console.sendMessage(TempPrefix + Messages.get(thecounter));
                event.getPlayer().chat(Messages.get(thecounter));
                thecounter++;
            }
            event.setCancelled(true);
        }
    }

    public int countColors(String string) {
        int counter = 0;
        if (string.contains("§0") || string.contains("§1") || string.contains("§2") || string.contains("§3") || string.contains("§4") || string.contains("§5") || string.contains("§6") || string.contains("§7") || string.contains("§8") || string.contains("§9") || string.contains("§a") || string.contains("§b") || string.contains("§c") || string.contains("§d") || string.contains("§e") || string.contains("§f")) {
            counter += 2;
        }
        return counter;
    }
}
