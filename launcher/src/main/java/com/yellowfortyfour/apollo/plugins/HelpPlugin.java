package com.yellowfortyfour.apollo.plugins;

import com.yellowfortyfour.apollo.api.plugin.Plugin;

public class HelpPlugin extends Plugin
{
    private final String PLUGIN_NAME = "Help Plugin";

    public HelpPlugin()
    {
        super();
        setPluginName(PLUGIN_NAME);
    }

    public void onEnable()
    {
        getPluginHandler().registerCommand("help", new HelpCommand(this), this);
    }
}