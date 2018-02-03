package com.yellowfortyfour.apollo.api.plugin;

import com.yellowfortyfour.apollo.api.command.Command;
import java.util.logging.Logger;

import jline.console.ConsoleReader;

public interface PluginHandler 
{
    public void registerCommand(String command, Command commandHandler, Plugin plugin);
    public void unRegisterCommand(String command, Command commandHandler, Plugin plugin);
    public void shutDown();
    public Logger getLogger();  
    public ConsoleReader getConsoleReader();
}
