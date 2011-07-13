package com.craftfire.textwrap;

import java.io.IOException;
import org.bukkit.Server;
import org.bukkit.event.Event;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class TextWrap extends JavaPlugin
{
  private final TextWrapPlayerListener playerListener = new TextWrapPlayerListener(this);
  private final Util Util = new Util();
  private final Config TheConfig = new Config();
  PluginDescriptionFile pluginFile = getDescription();

  public void onLoad()
  {
  }

  public void onDisable()
  {
	  getServer().getLogger().info(TheConfig.pluginname+" plugin "+TheConfig.pluginversion+" has been disabled");
  }

  public void onEnable()
  {
	new Config("config","plugins/"+TheConfig.pluginname+"/", "config.yml");
	if (null == getConfiguration().getKeys("Core")) 
	{
	    Util.Log("info", "config.yml could not be found in plugins/"+TheConfig.pluginname+"/ -- disabling!");
	    getServer().getPluginManager().disablePlugin(((Plugin) (this)));
	    return;
	}
		
	if(TheConfig.plugin_usagestats)
	{
	    Server TheServer = getServer();
	    Plugin[] plugins = TheServer.getPluginManager().getPlugins();
	    int counter = 0;
	    String Plugins = "";
	    while (plugins.length > counter)
	    {
	      Plugins = Plugins + plugins[counter].getDescription().getName() + "&_&" + plugins[counter].getDescription().getVersion();
	      if (plugins.length != counter + 1)
	        Plugins = Plugins + "*_*";
	      counter++;
	    }
	
	    int online = getServer().getOnlinePlayers().length;
	    int max = getServer().getMaxPlayers();
	    try 
	    {
	      this.Util.PostInfo(getServer().getName(), getServer().getVersion(), "1.0.0", System.getProperty("os.name"), System.getProperty("os.version"), System.getProperty("os.arch"), System.getProperty("java.version"), "", "", Plugins, ""+online, ""+max, TheServer.getPort()); } catch (IOException e1) {
	      getServer().getLogger().info("Could not send data to main server.");
	    }
	}
    PluginManager pm = getServer().getPluginManager();
    pm.registerEvent(Event.Type.PLAYER_CHAT, this.playerListener, Event.Priority.Highest, this);
    getServer().getLogger().info(TheConfig.pluginname+" plugin "+TheConfig.pluginversion+" is enabled");
    getServer().getLogger().info(TheConfig.pluginname+" is developed by CraftFire <dev@craftfire.com>");
  }
}