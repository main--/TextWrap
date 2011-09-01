/**
(C) Copyright 2011 CraftFire <dev@craftfire.com>
Contex <contex@craftfire.com>, Wulfspider <wulfspider@craftfire.com>

This work is licensed under the Creative Commons Attribution-NonCommercial-NoDerivs 3.0 Unported License.
To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/3.0/
or send a letter to Creative Commons, 171 Second Street, Suite 300, San Francisco, California, 94105, USA.
**/

package com.craftfire.textwrap;

import java.io.IOException;

import org.bukkit.Server;
import org.bukkit.event.Event;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class TextWrap extends JavaPlugin {
    private final TextWrapPlayerListener playerListener = new TextWrapPlayerListener(this);
    private final Util Util = new Util();
    private final Config Config = new Config();
    PluginDescriptionFile pluginFile = getDescription();

    public void onLoad() {
    }

    public void onDisable() {
        getServer().getLogger().info(Config.pluginname + " plugin " + Config.pluginversion + " has been disabled");
    }

    public void onEnable() {
        new Config("config", "plugins/" + Config.pluginname + "/", "config.yml");
        if (null == getConfiguration().getKeys("plugin")) {
            Util.Log("info", "config.yml could not be found in plugins/" + Config.pluginname + "/ -- disabling!");
            getServer().getPluginManager().disablePlugin(((Plugin) (this)));
            return;
        }

        if (Config.plugin_usagestats) {
            Server TheServer = getServer();
            Plugin[] plugins = TheServer.getPluginManager().getPlugins();
            int counter = 0;
            String Plugins = "";
            while (plugins.length > counter) {
                Plugins = Plugins + plugins[counter].getDescription().getName() + "&_&" + plugins[counter].getDescription().getVersion();
                if (plugins.length != counter + 1) {
                    Plugins = Plugins + "*_*";
                }
                counter++;
            }

            int online = getServer().getOnlinePlayers().length;
            int max = getServer().getMaxPlayers();
            try {
                this.Util.PostInfo(getServer().getName(), getServer().getVersion(), "1.1.0", System.getProperty("os.name"), System.getProperty("os.version"), System.getProperty("os.arch"), System.getProperty("java.version"), "", "", Plugins, "" + online, "" + max, TheServer.getPort());
            } catch (IOException e1) {
                getServer().getLogger().info("Could not send data to main server.");
            }
        }
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvent(Event.Type.PLAYER_CHAT, this.playerListener, Event.Priority.Highest, this);
        getServer().getLogger().info(Config.pluginname + " plugin " + Config.pluginversion + " is enabled");
        getServer().getLogger().info(Config.pluginname + " is developed by CraftFire <dev@craftfire.com>");
    }
}
