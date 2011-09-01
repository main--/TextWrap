/**
(C) Copyright 2011 CraftFire <dev@craftfire.com>
Contex <contex@craftfire.com>, Wulfspider <wulfspider@craftfire.com>

This work is licensed under the Creative Commons Attribution-NonCommercial-NoDerivs 3.0 Unported License.
To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/3.0/
or send a letter to Creative Commons, 171 Second Street, Suite 300, San Francisco, California, 94105, USA.
**/

package com.craftfire.textwrap;

import java.io.File;
import java.util.logging.Logger;

import org.bukkit.util.config.Configuration;

public class Config {
    ///////////////////////////////////////////
    //               GLOBAL
    ///////////////////////////////////////////
    //
    public Config Config;
    public org.bukkit.Server Server;
    public String pluginname = "TextWrap";
    public String pluginversion = "1.1.0";
    //
    public Logger log = Logger.getLogger("Minecraft");
    ///////////////////////////////////////////
    //               plugin
    ///////////////////////////////////////////
    public static boolean plugin_debugmode;
    public static boolean plugin_usagestats;

        ///////////////////////////////////////////
        //               message
        ///////////////////////////////////////////
        public static boolean message_indent;

    public Configuration template = null;
    public Config() { }
    public Config(String config, String directory, String filename) {
        template = new Configuration(new File(directory, filename));
        template.load();
        if(config.equals("config")) {
            ///////////////////////////////////////////
            //               plugin
            ///////////////////////////////////////////
            plugin_debugmode = GetConfigBoolean("plugin.debugmode", false);
            plugin_usagestats = GetConfigBoolean("plugin.usagestats", true);

            ///////////////////////////////////////////
            //               message
            ///////////////////////////////////////////
            message_indent = GetConfigBoolean("message.indent", true);
        }
    }

    public String GetConfigString(String key, String defaultvalue) {
        return template.getString(key, defaultvalue);
    }

    public boolean GetConfigBoolean(String key, boolean defaultvalue) {
        return template.getBoolean(key, defaultvalue);
    }

    public void DeleteConfigValue(String key) {
        template.removeProperty(key);
    }

    public String raw(String key, String line) {
        return template.getString(key, line);
    }

    public void save(String key, String line) {
        template.setProperty(key, line);
    }
}
