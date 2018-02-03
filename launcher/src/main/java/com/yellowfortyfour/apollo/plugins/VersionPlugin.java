package com.yellowfortyfour.apollo.plugins;

import com.yellowfortyfour.apollo.api.plugin.Plugin;

public class VersionPlugin extends Plugin
{
    private final String PLUGIN_NAME = "Version Plugin";

    public VersionPlugin()
    {
        super();
        setPluginName(PLUGIN_NAME);
    }

    public void onEnable()
    {
        getPluginHandler().registerCommand("version", new VersionCommand(this), this);
    }
}