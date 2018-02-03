package com.yellowfortyfour.apollo;

import com.yellowfortyfour.apollo.plugins.*;
import com.yellowfortyfour.apollo.logger.LogHandler;
import com.yellowfortyfour.apollo.logger.LogFormatter;

import com.yellowfortyfour.apollo.api.plugin.Plugin;
import com.yellowfortyfour.apollo.api.plugin.PluginHandler;
import com.yellowfortyfour.apollo.api.command.Command;

import java.io.IOException;
import java.util.logging.Handler;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import java.util.HashMap;
import java.util.Set;
import java.io.File;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.jar.*;
import java.net.URL;
import java.net.URLClassLoader;

import org.yaml.snakeyaml.*;
import org.yaml.snakeyaml.constructor.Constructor; 

import jline.console.ConsoleReader;


public class PluginManager implements PluginHandler 
{
    private Boolean isRunning = true;
    private LinkedList<Plugin> plugins = new LinkedList<Plugin>();
    private HashMap<String, Command> commands = new HashMap<String, Command>();
    private ConsoleReader consoleReader = null;
    private final String LOGGER_NAME = "com.yellowfortyfour.apollo";
    private final Logger logger = Logger.getLogger(LOGGER_NAME);
    private HashMap<String, PluginDescription> pluginsToLoad = new HashMap<>();
    
    public PluginManager() throws IOException
    {
        consoleReader = new ConsoleReader();
        consoleReader.setExpandEvents(false);
        setupLogger();

        System.setSecurityManager( new ApolloSecurityManager() );

        getLogger().info("Loading plugins..");
        try
        {   
            loadInternalPlugin(new VersionPlugin());
            loadInternalPlugin(new HelpPlugin());
            
            detectExternalPlugins(getPluginsDir());
            loadExternalPlugins();
            enablePlugins();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        getLogger().info("All plugins loaded.");
    }

    private void loadInternalPlugin(Plugin plugin)
    {
        logger.info("Loading " + plugin.getPluginName() + " (internal plugin)");

        plugin.init(this, getPluginsDir().getAbsolutePath());
        if(plugin.onLoad())
            plugins.add(plugin);
    }

    private void loadExternalPlugins()
    {
        try
        {
            Set<String> s = pluginsToLoad.keySet();

            for(String pluginName : s)
            {
                getLogger().info("Loading " + pluginName + " (external plugin)");

                URLClassLoader pluginClassLoader = new PluginClassLoader(new URL[] {
                    pluginsToLoad.get(pluginName).getJarFile().toURI().toURL()
                });
                
                String mainClassName = pluginsToLoad.get(pluginName).getMainclass();
                Class<?> mainClass = pluginClassLoader.loadClass(mainClassName);

                Plugin p = (Plugin) mainClass.getDeclaredConstructor().newInstance();
                p.init(this, getPluginsDir().getAbsolutePath());

                if(p.onLoad())
                {
                    plugins.add(p);
                }
                else
                {
                    getLogger().severe(pluginName + " Plugin could not be strarted");
                }
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public void enablePlugins()
    {
        for(Plugin p : plugins)
            p.onEnable();
    }

    private void detectExternalPlugins(File folder) throws Exception
    {
        for(File f : folder.listFiles())
        {
            if(!f.exists() || !f.getName().endsWith(".jar"))
                continue; // no action on non .jar files

            JarFile jar = new JarFile(f);
            JarEntry pluginYml = jar.getJarEntry("plugin.yml");

            if(pluginYml == null)
            {
                getLogger().severe(jar.getName() + " missing 'plugin.yml'");
                jar.close();
                continue;
            }

            InputStream ymlStream = jar.getInputStream(pluginYml);
            if(ymlStream == null)
            {
                getLogger().severe("Can't read plugin.yml of " + jar.getName());
                jar.close();
                continue;
            }

            PluginDescription pd =  loadPluginProps(ymlStream);
            pd.setJarFile(f);
            pluginsToLoad.put(pd.name, pd);

            ymlStream.close();
            jar.close();
        }
    }
   
    private File getPluginsDir()
    {
        // This will spam the disk with folders, depending
        // if we run it from the IDE or command prompt
        // since the user.dir differs..
        File pluginsFolder;
        try
        {
            String path = System.getProperty("user.dir");
            pluginsFolder = new File(path, "plugins");
            
            if(!pluginsFolder.exists())
                pluginsFolder.mkdir();
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return null;
        }
        return pluginsFolder;
    }

    public void registerCommand(String command, Command commandHandler, Plugin plugin)
    {
        if(commandHandler.onRegsiter(command))
            commands.put(command, commandHandler);
    }

    public void unRegisterCommand(String command, Command commandHandler, Plugin plugin)
    {
        if(commandHandler.onUnRegsiter(command))
        {
            commands.remove(command);
        }
    }

    public Boolean dispatchCommand(String commandLine)
    {
        Pattern argsSplit = Pattern.compile(" ");
        String[] args = argsSplit.split(commandLine, -1);
		
		// Ignore empty (i.e. "") commands
		if (args[0].length() == 0)
		    return true;

        String command = args[0].toLowerCase();
        Set<String> availableCommands = commands.keySet();

        for(String c : availableCommands)
        {
            if(c.equalsIgnoreCase(command))
                return commands.get(c).executeCommand(command, args);
        }
        getLogger().warning(args[0] + " not found. Try 'help'.");
        return true;
    }

    public void shutDown()
    {
        logger.info("Shutting down..");
        for(Plugin p : plugins)
        {
            logger.info("Disabling plugin " + p.getPluginName());
            p.onDisable();
        }
        logger.info("Godbye");
               
        // Clear remaining prompt.
        try
        {
            consoleReader.resetPromptLine("", "", 1);    
        }
        catch(Exception e)
        {
        }
        finally
        {
            consoleReader.close();  
        }
        isRunning = false;
    }

    
    private void setupLogger()
	{
		logger.setUseParentHandlers(false);
		Handler cnslHdlr = new LogHandler(getConsoleReader());
		cnslHdlr.setFormatter(new LogFormatter());
		logger.addHandler(cnslHdlr);
	}
    
	public Logger getLogger()
	{
		return logger;
    }
    
    public ConsoleReader getConsoleReader()
    {
        return consoleReader;
    }

    public Boolean isRunning()
    {
        return this.isRunning;
    }

    private PluginDescription loadPluginProps(InputStream input)
    {        
        Yaml yaml = new Yaml(new Constructor(PluginDescription.class));
       
        PluginDescription config = (PluginDescription) yaml.load(input);
        return config;
    }
}
