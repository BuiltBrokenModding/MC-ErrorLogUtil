package com.builtbroken.mc.util.runner;

import com.builtbroken.mc.util.data.Settings;

import java.util.Scanner;

/**
 * Runs the program from the command line
 *
 * @see <a href="https://github.com/BuiltBrokenModding/VoltzEngine/blob/development/license.md">License</a> for what you can and can't do with the code.
 * Created by Dark(DarkGuardsman, Robert) on 10/9/2016.
 */
public class CommandLineRunner extends Runner
{
    @Override
    public void run(Settings settings)
    {
        super.run(settings);
        System.out.println("=============================================");
        System.out.println("=== Thank you for using MC Error Log Util ===");
        System.out.println("=============================================");

        final Scanner scan = new Scanner(System.in);

        if(!settings.hasRequiredFiles())
        {
            System.out.println("In order to function I will need some data");

            if(!settings.hasValidMCPConfigs())
            {
                //Get read file
                System.out.println("Enter mcp configs:");
                String s = scan.next();
            }

            if(!settings.hasReadFile())
            {
                //Get read file
                System.out.println("Enter read path:");
                String s = scan.next();
            }

            if(!settings.hasValidSaveFile())
            {
                //Get read file
                System.out.println("Enter save path:");
                String s = scan.next();
            }
        }
        System.out.println("Processing needed data....");
        //TODO process file
        System.out.println("Processing file....");
        //TODO save file
        System.out.println("Saving file....");
        //TODO Finalize all
        System.out.println("Done....");

        System.out.println("=============================================");
        System.out.println("Press <any> key to exit....");

        scan.next();
        scan.close();
    }
}
