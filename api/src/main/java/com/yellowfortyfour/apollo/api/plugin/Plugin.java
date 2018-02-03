package com.yellowfortyfour.apollo.api.plugin;

import java.util.logging.Logger;

import java.io.File;
import java.io.InputStream;

/**
 * This represents an Apollo plugin object.
 * A plugin should have one of these objects defined.
 * mainclass in plugin.yml points to this class
 */
public abstract class Plugin 
{

    private String pluginName = "";
    private PluginLogger pluginLogger;
    private PluginHandler pluginHandler = null;
    private File pluginsDir;

    /**
     * Called by the plugin handler to setup internal
     * variables
     * 
     * @param pluginHandler Represents the Apollo PluginHandler
     */
    public final void init(PluginHandler pluginHandler, String pluginsDir)
    {
        this.pluginHandler = pluginHandler;
        this.pluginLogger = new PluginLogger(this); 
        this.pluginsDir = new File(pluginsDir);
    }

    /**
     * This is called just when the plugin has been loaded. 
     * Most of the Apollo systems are not fully initialized
     * at this point, hence the plugin should only do internal
     * setup work. 
     * 
     * getlogger can be used from this point.
     * 
     * N.B plugin must call setPluginName here
     * setPluginName here.
     * 
     * @param pluginHandler Represents the Apollo PluginHandler
     * @return returns true of onLoad was successfull
     * 
     */
    public Boolean onLoad()
    {
        return true;
    }

    /**
     * Called when the plugin are enabled and can start
     * performing it's intended work. All of the interal
     * Apollo systems are up and running at this time.
     * Note that the list of plugins might be incomplete
     * 
     */
    public void onEnable()
    {

    }

    /**
     * Called when the plugin is deactivated and should start
     * brining itself down. Note that all Apollo systems are
     * still active.
     * 
     */
    public void onDisable()
    {

    }

    public final String getPluginName()
    {
        return pluginName;
    }

    protected final void setPluginName(String pluginName)
    {
        this.pluginName = pluginName;
    }

    public final PluginHandler getPluginHandler()
    {
        return pluginHandler;
    }

    public final Logger getLogger()
	{
		return pluginLogger;	
    }

    public final File getDataFolder()
    {
        return new File(pluginsDir,  getPluginName()); /*, getDescription().getName()*/
    }

    public final InputStream getResourceAsStream(String name)
    {
        return getClass().getClassLoader().getResourceAsStream( name );
    }
}
