package com.yellowfortyfour.apollo.api.command;

import com.yellowfortyfour.apollo.api.plugin.*;

import java.util.LinkedList;;

abstract public class Command 
{
    protected Plugin plugin = null;
    protected LinkedList<String> commandStrings = new LinkedList<String>();
    
    public Command(Plugin plugin)
    {
        this.plugin = plugin;
    }
    public Boolean onRegsiter(String command)
    {
        if(commandStrings.contains(command))
        {
            plugin.getLogger().severe("Command '" + command + "' already registerd with this handler!");
            return false;
        }
        this.commandStrings.add(command);
        return true;
    }

    public Boolean onUnRegsiter(String command)
    {
        if(commandStrings.contains(command))
        {
            commandStrings.remove(command);
            plugin.getLogger().info("Command '" + command + "' removed from '" + this.getClass().getName());
            return true;
        }
        return false;
    }
    
    abstract public Boolean executeCommand(String command, String args[]);
}
