package com.yellowfortyfour.apollo.plugins;

import com.yellowfortyfour.apollo.api.plugin.Plugin;
import com.yellowfortyfour.apollo.api.command.Command;

public class VersionCommand extends Command
{

    VersionCommand(Plugin plugin)
    {
        super(plugin);
    }
    
    public Boolean executeCommand(String command, String args[])
    {
        plugin.getLogger().info("");
        
        plugin.getLogger().info("Running Java " + System.getProperty("java.java.version"));
        plugin.getLogger().info(" from " + System.getProperty("java.java.vendor" ));
        
        plugin.getLogger().info("Java home is: " + System.getProperty("java.home" ));
        plugin.getLogger().info(System.getProperty("os.name" ));
        plugin.getLogger().info(" on " + System.getProperty("java.os.arch" ));
        plugin.getLogger().info(" version " + System.getProperty("os.version" ));
        plugin.getLogger().info("Logged in as " + System.getProperty("user.name" ));
        
        plugin.getLogger().info("App version is " + this.getClass().getPackage().getImplementationVersion());

        return true;
    }

  
}

