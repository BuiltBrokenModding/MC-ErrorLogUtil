package com.builtbroken.mc.util.runner;

import com.builtbroken.mc.util.data.Settings;
import com.builtbroken.mc.util.imp.IRunner;

/**
 * Base class for all runners
 *
 * @see <a href="https://github.com/BuiltBrokenModding/VoltzEngine/blob/development/license.md">License</a> for what you can and can't do with the code.
 * Created by Dark(DarkGuardsman, Robert) on 10/9/2016.
 */
public class Runner implements IRunner
{
    protected Settings settings;

    @Override
    public void run(Settings settings)
    {
        this.settings = settings;
    }
}
