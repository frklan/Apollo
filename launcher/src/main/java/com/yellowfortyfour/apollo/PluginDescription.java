package com.yellowfortyfour.apollo;

import java.io.File;

public class PluginDescription
{
    public String name;
    public void setName(String name)
    {
        this.name = name;
    }
    public String getName()
    {
        return name;
    }

    public String mainclass;
    public void setMainclass(String mainclass)
    {
        this.mainclass = mainclass;
    }
    public String getMainclass()
    {
        return mainclass;
    }

    public String toString()
    {
        return "Name: " + name + ", Main-class: " + mainclass;
    }

    File jarFile;
    public File getJarFile()
    {
        return jarFile;
    }
    public void setJarFile(File jarFile)
    {
        this.jarFile = jarFile;
    }
}