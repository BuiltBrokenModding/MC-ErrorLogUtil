package com.builtbroken.mc.util.data;

import java.io.File;
import java.util.HashMap;

/**
 * Object that contains all settings for the current run
 *
 * @see <a href="https://github.com/BuiltBrokenModding/VoltzEngine/blob/development/license.md">License</a> for what you can and can't do with the code.
 * Created by Dark(DarkGuardsman, Robert) on 10/9/2016.
 */
public final class Settings
{
    /** Folder to do all actions inside, root folder */
    public File runPath = new File("");
    /** File to read from */
    public File readFile = null;
    /** File to save to */
    public File saveFile = null;
    /** File containing SRG to read-able names */
    public File mcpConfigFile = null;

    /** Do we auto run after getting all needed data? */
    public boolean autoRun = false;

    /**
     * Reads the passed in argument map and applies all valid args
     *
     * @param map - argument map
     */
    public void read(HashMap<String, String> map)
    {
        if (map.containsKey("runPath"))
        {
            runPath = getFile(runPath, map.get("runPath"));
            if (!runPath.isDirectory())
            {
                throw new IllegalArgumentException("Invalid run direction: " + runPath);
            }
        }

        if (map.containsKey("loadPath"))
        {
            readFile = getFile(runPath, map.get("readPath"));
            if (!runPath.exists())
            {
                throw new IllegalArgumentException("Invalid read path: " + runPath);
            }
        }

        if (map.containsKey("savePath"))
        {
            saveFile = getFile(runPath, map.get("savePath"));
        }

        if (map.containsKey("mcpConfigFolder"))
        {
            mcpConfigFile = getFile(runPath, map.get("mcpConfigFolder"));
            if (!mcpConfigFile.isDirectory() || !runPath.exists())
            {
                throw new IllegalArgumentException("Invalid mcp config folder: " + runPath);
            }
            //TODO validate the folder contains the needed files
        }

        if (map.containsKey("overrideSave"))
        {
            autoRun = isTrue(map.get("overrideSave"));
        }

        if (map.containsKey("autoRun"))
        {
            autoRun = isTrue(map.get("autoRun"));
        }
    }

    /**
     * Used to parse a string as a file path
     *
     * @param root  - root folder of the program
     * @param value - string passed into the program
     * @return new file path
     */
    private static File getFile(File root, String value)
    {
        if (value.startsWith(File.pathSeparator))
        {
            return new File(root, value);
        }
        else
        {
            return new File(value);
        }
    }

    /**
     * Checks if the value is true
     *
     * @param value
     * @return
     */
    private static boolean isTrue(String value)
    {
        if (value != null)
        {
            return value.toLowerCase().equals("true");
        }
        return true;
    }

    public boolean hasRequiredFiles()
    {
        return hasReadFile() && hasValidSaveFile() && hasValidMCPConfigs();
    }

    public boolean shouldAutoParse()
    {
        return hasRequiredFiles();
    }

    public boolean hasReadFile()
    {
        return readFile != null && readFile.exists();
    }

    public boolean hasValidMCPConfigs()
    {
        return mcpConfigFile != null && mcpConfigFile.exists();
    }

    public boolean hasValidSaveFile()
    {
        return saveFile != null && !saveFile.exists();
    }
}
