package com.builtbroken.mc.util;

import com.builtbroken.mc.util.data.Settings;
import com.builtbroken.mc.util.imp.IRunner;
import com.builtbroken.mc.util.runner.AutoRunner;
import com.builtbroken.mc.util.runner.CommandLineRunner;

import java.util.HashMap;

/**
 * Main class for the program
 *
 * @see <a href="https://github.com/BuiltBrokenModding/VoltzEngine/blob/development/license.md">License</a> for what you can and can't do with the code.
 * Created by Dark(DarkGuardsman, Robert) on 10/9/2016.
 */
public final class MCErrorLogUtil
{
    /**
     * Main class
     *
     * @param args - arguments for the program @see {@link Settings}
     *             for more information
     */
    public static void main(String... args)
    {
        try
        {
            System.out.println("Loading settings from args...");
            final Settings settings = new Settings();

            //If arguments exist load them into the settings object
            if (args != null)
            {
                final HashMap<String, String> map = parseArgs(args);
                settings.read(map);
                settings.validateMCPConfigFile();
            }

            System.out.println("Picking runner...");
            IRunner runner = null;

            if (settings.shouldAutoParse())
            {
                runner = new AutoRunner();
            }
            else
            {
                //TODO open GUI if possible
                runner = new CommandLineRunner();
            }

            if(runner != null)
            {
                runner.run(settings);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            //TODO save error to log
        }
        System.out.println("Exiting...");
    }

    /**
     * Parse the arguments into an easy to check map
     *
     * @param args - array of arguments
     * @return map
     */
    private static HashMap<String, String> parseArgs(String... args)
    {
        final HashMap<String, String> map = new HashMap();
        //TODO convert args to map
        String lastArg = null;
        for (String string : args)
        {
            //Store new arg
            if (string.startsWith("-"))
            {
                lastArg = string.trim().replaceFirst("-", "");
                if (lastArg.contains("="))
                {
                    String[] split = lastArg.split("=");
                    lastArg = split[0];
                    map.put(lastArg, split[1].replace("\\\"", ""));
                    continue;
                }
                map.put(lastArg, null);
            }
            else
            {
                //Store arg value, or append value
                String v = map.get(lastArg);
                if (v == null)
                {
                    v = string;
                }
                else
                {
                    v += "," + string;
                }
                map.put(lastArg, v);
            }
        }
        return map;
    }
}
