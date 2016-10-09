package com.builtbroken.mc.util.data;

/**
 * Data object for storing parsed information from MCP's SRG configs
 *
 * @see <a href="https://github.com/BuiltBrokenModding/VoltzEngine/blob/development/license.md">License</a> for what you can and can't do with the code.
 * Created by Dark(DarkGuardsman, Robert) on 10/9/2016.
 */
public class SrgData
{
    /** Name of the object */
    public String name;
    /** Searge version of the object */
    public String srg;
    /** Description of the object */
    public String desc;

    public SrgData()
    {
    }

    public SrgData(String line)
    {
        parse(line);
    }

    public void parse(String line)
    {
        String[] split = line.split(",");
        srg = split[0];
        name = split[1];
        //side = Integer.parseInt(split[2]); not used
        desc = split[3];
    }
}
