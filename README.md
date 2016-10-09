# Minecraft Error Log Utility

##About
This app is designed to parse crash logs to conver srg to readable, help reduce junk, and simplify data. This way it is easier to understand what is going on inside of a Minecraft crash message. Without spending hours of comparing different sections and manually looking up method names.

##AutoRunner[Function 1 only]
The auto runner it the quickest way to use the app. All you need to do is provide all the required information.

###Pass in args
-runPath=Folder to work in  - optional, defaults to user.dir

-loadPath=ReadFileName   - start with ./ for relitave path, file that will be processed

-savePath=SaveFileName   - start with ./ for relitave path, save location

-mcpConfigFolder=FolderName - start with ./ for relitave path, MCP confi containing methods.csv & fields.csv

-overrideSave

-autoRun

##CMD Runner[WIP]

##GUI Runner [Not implemented]

##Function 1        - Parse [Methods only]
Parse crash logs to replace srg names with read-able names using a MCP config file

##Function 2        - Reduce [WIP]
Look for duplicate entries to help understand the source of infinite loops

##Function 3        - Predict [WIP]
Pick out mods that could be the source of the problem

##Function 4        - Simplify [WIP]
Group stack calls to simple method entries sets to help understand the source of the problem
