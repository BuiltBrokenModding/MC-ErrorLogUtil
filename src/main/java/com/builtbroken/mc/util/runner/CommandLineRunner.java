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
                boolean tryAgain = true;
                while(tryAgain)
                {
                    //Get file
                    System.out.println("Enter mcp configs:");
                    settings.setMcpConfigDirectory(settings.parseFile(scan.next()));
                    settings.validateMCPConfigFile();

                    //Validate
                    if(settings.hasValidMCPConfigs())
                    {
                        break;
                    }
                    else if(!settings.getMcpConfigDirectory().exists())
                    {
                        System.out.println("\tFile: " + settings.getMcpConfigDirectory() + " does not exist");
                    }
                    else
                    {
                        if(settings.mcpFieldsFile == null || !settings.mcpFieldsFile.exists())
                        {
                            System.out.println("\tMissing 'fields.csv' file");
                        }
                        if(settings.mcpMethodsFile == null || !settings.mcpMethodsFile.exists())
                        {
                            System.out.println("\tMissing 'methods.csv' file");
                        }
                    }

                    //Tell user it was wrong and ask if the user wants to try again
                    System.out.println("\tInvalid config file try again? [Y/N]");
                    String answer = scan.next().toLowerCase();
                    tryAgain = answer.equals("y") || answer.equals("n");
                }
            }

            if(!settings.hasReadFile())
            {
                //Get read file
                System.out.println("Enter read path:");
                settings.readFile = settings.parseFile(scan.next());
            }

            if(!settings.hasValidSaveFile())
            {
                //Get read file
                System.out.println("Enter save path:");
                settings.saveFile = settings.parseFile(scan.next());
            }
        }
        System.out.println("Processing needed data....");
        loadMCPData();
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
