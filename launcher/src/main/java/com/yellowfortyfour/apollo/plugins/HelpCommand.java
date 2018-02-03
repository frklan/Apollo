package com.yellowfortyfour.apollo.plugins;

import com.yellowfortyfour.apollo.api.plugin.Plugin;
import com.yellowfortyfour.apollo.api.ansi.AnsiCodes;
import com.yellowfortyfour.apollo.api.command.Command;

public class HelpCommand extends Command
{

    HelpCommand(Plugin plugin)
    {
        super(plugin);
    }
    public Boolean executeCommand(String command, String args[])
    {
        plugin.getLogger().info(AnsiCodes.TextFgColor.BRIGHT_RED + "TODO:" + AnsiCodes.TextDecoration.RESET + " loop thru all plugins print the help text...");
        return true;
    }
}
