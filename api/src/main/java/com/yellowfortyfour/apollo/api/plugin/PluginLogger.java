package com.yellowfortyfour.apollo.api.plugin;

import java.util.logging.LogRecord;
import java.util.logging.Logger;

public class PluginLogger extends Logger
{

    private final String pluginName;

    public PluginLogger(Plugin plugin)
    {
        super(plugin.getClass().getCanonicalName(), null);
        pluginName = "[" + plugin.getPluginName() + "] ";
        setParent(plugin.getPluginHandler().getLogger());
    }

    @Override
    public final void log(LogRecord logRecord)
    {
        logRecord.setMessage(pluginName + logRecord.getMessage());
        super.log(logRecord);
    }
    
}
