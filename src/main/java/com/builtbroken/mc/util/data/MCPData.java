package com.builtbroken.mc.util.data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

/**
 * @see <a href="https://github.com/BuiltBrokenModding/VoltzEngine/blob/development/license.md">License</a> for what you can and can't do with the code.
 * Created by Dark(DarkGuardsman, Robert) on 10/9/2016.
 */
public class MCPData
{
    private HashMap<String, SrgData> fieldData = new HashMap();
    private HashMap<String, SrgData> methodData = new HashMap();

    public void loadMethods(File file) throws IOException
    {
        methodData.clear();
        BufferedReader br = new BufferedReader(new FileReader(file));

        String line;
        while ((line = br.readLine()) != null)
        {
            SrgData data = new SrgData(line);
            if (!methodData.containsKey(data.srg))
            {
                methodData.put(data.srg, data);
            }
        }
        br.close();
    }

    public void loadFields(File file) throws IOException
    {
        methodData.clear();
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        while ((line = br.readLine()) != null)
        {
            SrgData data = new SrgData(line);
            if (!methodData.containsKey(data.srg))
            {
                methodData.put(data.srg, data);
            }
        }
        br.close();
    }

    public SrgData getMethodData(String srg)
    {
        return methodData.get(srg);
    }

    public SrgData getFieldData(String srg)
    {
        return fieldData.get(srg);
    }

    public String convertSrgMethod(String srg)
    {
        SrgData data = getMethodData(srg);
        if (data != null)
        {
            return data.name != null ? data.name : srg;
        }
        return srg;
    }

    public String ConvertSrgField(String srg)
    {
        SrgData data = getFieldData(srg);
        if (data != null)
        {
            return data.name != null ? data.name : srg;
        }
        return srg;
    }
}
