 # HarearsWarriorsApi
 
 ## who use this
 This module is import inside:
 * ```DesktopLauncher```
 * ```HarearsPluginLoader```
 * ```HarearsWarriors```
 * ```Server```
 ## plugins
 ### Main Class
 The main class of your plugin will not need to have a method main. 
 Simply because the game or server that will host the plugin without will charge for you.
 The main class of the plugin will be a class that will inherit the class ```HWPlugin```,
 this will add two methods to your class:
 * ```public void onStart()``` Call when the plugin is loaded.
 * ```public void onStop()``` Call when the plugin is unloaded.
 ### hwpl file
 In the source of the code create a new file: ```hwpl.xml``` and edit the file like this example.
 
 ```XML
<?xml version="1.0" encoding="utf-8" ?>
<plugin>
    <name>MyPluginName</name>
    <version>MyPluginVersion</version>
    <main>package.path.to.the.main.class.MyMainClass</main>
    <authors>
        <author>one contributor to the plugin</author>
        <author>a second contributor to the plugin</author>
    </authors>
</plugin>
``` 
#### Details for all nodes
##### name
* give the name of your plugins
##### version
* give the build version of the plugin
##### main
* give the main class to the plugin
##### authors
* a list of all contributor of the plugin
##### author 
* give an author name *(this node should be inside the **authors** node)*