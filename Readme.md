PacketWrapper 
===========

When reading and writing packets in ProtocolLib, it is necessary to know the order at which the fields are stored in memory. 
This requires you do decompile the Minecraft source code with [JD Gui](http://java.decompiler.free.fr/?q=jdgui), and correspond 
it an online [Wiki](http://www.wiki.vg/Protocol) resource 
([tutorial](http://forums.bukkit.org/threads/lib-1-4-6-protocollib-2-0-0-safely-and-easily-modify-sent-and-recieved-packets.101035/page-2#post-1366140)). 
It would be much easier if these packets could be accessed as any other normal Java bean. 

Enter PacketWrapper. It contains wrapper classes for all the known packets in 1.4.6, providing you access to the fields by name, along
with automatic conversion to existing Bukkit enumerations and classes. It also includes a number of custom enumerations when appropriate.

You can include PacketWrapper as a JAR if you wish, though the intent is for plugin authors to simply copy-and-paste the classes into their 
project.

Building
--------
You can compile this project yourself by using the latest version of Maven.