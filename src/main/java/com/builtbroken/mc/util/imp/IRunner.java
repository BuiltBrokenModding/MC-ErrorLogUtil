package com.builtbroken.mc.util.imp;

import com.builtbroken.mc.util.data.Settings;

/**
 * Applied to objects that handle the runtime processing of data
 *
 * @see <a href="https://github.com/BuiltBrokenModding/VoltzEngine/blob/development/license.md">License</a> for what you can and can't do with the code.
 * Created by Dark(DarkGuardsman, Robert) on 10/9/2016.
 */
public interface IRunner
{
    /** Called to run the process */
    void run(Settings settings);
}
