package com.builtbroken.mc.util.runner;

import com.builtbroken.mc.util.data.MCPData;
import com.builtbroken.mc.util.data.Settings;
import com.builtbroken.mc.util.imp.IRunner;

import java.io.IOException;

/**
 * Base class for all runners
 *
 * @see <a href="https://github.com/BuiltBrokenModding/VoltzEngine/blob/development/license.md">License</a> for what you can and can't do with the code.
 * Created by Dark(DarkGuardsman, Robert) on 10/9/2016.
 */
public class Runner implements IRunner
{
    protected Settings settings;
    protected MCPData mcpData;
    protected boolean hasProcessedMCPConfig = false;

    @Override
    public void run(Settings settings)
    {
        this.settings = settings;
        mcpData = new MCPData();
    }

    protected void loadMCPData()
    {
        if(!hasProcessedMCPConfig)
        {
            try
            {
                mcpData.loadFields(settings.mcpFieldsFile);
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }

            try
            {
                mcpData.loadMethods(settings.mcpMethodsFile);
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            hasProcessedMCPConfig = true;
        }
    }
}
