package com.builtbroken.mc.util.runner;

import com.builtbroken.mc.util.data.Settings;
import com.builtbroken.mc.util.parser.LogParser;

import java.io.IOException;

/**
 * Strait forward runner with minimal user input
 *
 * @see <a href="https://github.com/BuiltBrokenModding/VoltzEngine/blob/development/license.md">License</a> for what you can and can't do with the code.
 * Created by Dark(DarkGuardsman, Robert) on 10/9/2016.
 */
public class AutoRunner extends Runner
{
    @Override
    public void run(Settings settings)
    {
        System.out.println("Starting auto runner");
        super.run(settings);

        settings.validateMCPConfigFile();
        if (settings.hasValidMCPConfigs())
        {
            System.out.println("Loading MCP data");
            loadMCPData();
            if (settings.hasReadFile())
            {
                if (settings.hasValidSaveFile())
                {
                    //Generate save file folders if missing
                    if (!settings.saveFile.getParentFile().exists())
                    {
                        settings.saveFile.getParentFile().mkdirs();
                    }
                    //Parse file
                    final LogParser parser = new LogParser(settings.readFile);

                    System.out.println("Reading file from " + settings.readFile);
                    parser.readFile();

                    System.out.println("Editing file");
                    parser.replaceSRG(mcpData);

                    System.out.println("\tEdited " + parser.linesEdited + " lines");
                    System.out.println("\tReplaced " + parser.stringsReplaced + " entries");
                    try
                    {
                        System.out.println("Saving edited file to " + settings.saveFile);
                        parser.save(settings.saveFile);
                        System.out.println("Done...");
                    }
                    catch (IOException e)
                    {
                        throw new RuntimeException("Failed to save file correctly!", e);
                    }
                }
                else
                {
                    throw new RuntimeException("Save path is invalid!");
                }
            }
            else
            {
                throw new RuntimeException("Read file not specified!");
            }
        }
        else
        {
            throw new RuntimeException("MCP config file is invalid check path and try again!");
        }
    }
}
