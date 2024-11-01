# Pilz Server Tools

![PilzServerTools Banner](/docs/banner.jpg)

## About
Pilz Server Tools is a collection of advanced server administration tools that will better allow you to assist your players and protect your server.

## Key Features

- Plugin stealing protection - block players from using plugin stealing commands
- Player Information - gives every piece of minecraft data on a particular user
- Help Me - feature that allows users to be placed into a queue. When an admin is ready to assist a user, it teleports them to the players location.
- Maintenance Mode - like whitelist, but allows anyone with PST admin permission to login, while providing others with maintenance message
- Silence Mode - disable chat for any player without admin permissions, while they can still see messages from admins
- Memory Management

### Help Me
- Help me creates a queue for players in need of assistance. When a player needs help, they issue the command "/helpme" and they will automatically be placed into the queue & admins will be notified. The queue supports unlimited users, and helps them on a first come first served basis. When an admin is ready to assist, they simply issue the command "/helpme" and they will be automatically teleported to the user in need. That user is then removed from the queue, and the next user in need of assistance is in the front of the line.
- Displays a scoreboard for all users with admin or helper permissions, with number of users in the help queue

### Maintenance Mode
When enabled, only users with admin or helper permissions are permitted to join the server. All others are automatically kicked, and are displayed with a message letting them know maintenance is underway.
Maintenance mode was designed to provide you with an alternative to whitelisting. When enabled, only users with admin or helper permissions will be able to join the server.
This is especially useful for building or configuring new plugins so you're not disturbed .

### Player Information
Provides every bukkit information about a user (ex. is flying, health, food, level, etc.)

### Supervise
Supervise mode allows you to watch over players to see if they're up to no good. When you enter supervisor mode, you are automatically vanished and teleported to the users location

### Silence Mode
Mode that when enabled, disables chat for any players without PST admin permissions. This is very useful if players are all fighting, or updates are in progress

### Lockdown Mode
In the event you need to freeze, mute and or disable all player commands, lockdown made makes it easy. You can change what is enabled/disabled during lockdown mode in the global.yml file. You can disable any movement, chat or commands from users that do not have PST admin permissions

### Security Protection
A common way for users to "steal" a servers plugins is by typing unprotected plugin commands, which are usually never blocked by servers. PST disables anybody without PST admin permissions from accessing these command in order to protect your server

### Memory Protection
There's no need to install another plugin that consumes more resources just to view your servers memory information! PST now monitors your servers memory usage which you can view at any time
- PST monitors your servers RAM usage in order to protect you from unexpected crashes and data loss.
- You can view your servers memory usage and information by executing /pst memory
- In the event your memory usage spikes into an unsafe or unexpected range, anyone with PST.admin permissions will be notified. It won't annoy the hell out of you, don't worry. If your memory spikes to 90%, you won't get another message until it hits 91%
- You can disable memory protection in global.yml

### Convenience
Option to broadcast message to all users on server reload, letting them know a reload is underway and that commands will be temporarily unavailable.

### User Information
You can look up all the information on a user that Minecraft manages. This includes, but is not limited to, health, hunger, fly status...etc.

### Plugin Stealing Protection
Most servers forget that players can easily access a list of their plugins by using commonly unprotected commands. PST automatically prevents users from accessing these commands unless they have PST admin permissions.

## Help Me Usage
### Admin
- When the user issues the help command, they are placed into a wait queue. A scoreboard will appear on anyone with admin or helper permissions, telling them how many users are waiting to be helped
- When the admin issues the command /helpme and someone is in the wait queue, they will be automatically teleported to their location and a message telling them who they're helping. When they're done, they can simply go on their way or if there are more users in the queue, they can issue /helpme again to continue to the next user 

### User
- If a user ever needs help, they can request help from admins (or users with pst.helper permission: Permissions). Admins can then issue a command to be teleported to the next user in the queue who needs assistance

## Commands
- `/pst` - plugin information
- `/pst check` - checks to see if plugin is running
- `/pst info` - detailed plugin information
- `/pst player [PLAYER NAME]` - returns detailed player information
- `/pst player [PLAYER NAME]` - returns detailed player information`
- `/pst player [PLAYER NAME]` - returns detailed player information
- `/pst player [PLAYER NAME]` - returns detailed player information
- `/pst maintenance [enable/disable]` - enables or disables maintenance mode
- `/pst maintenance info` - returns information on wether maintenance mode is enable or disabled
- `/silence` - Enables / Disables silence mode
- `/lockdown` - Enables / Disables lockdown mode
- `/pst memory` - Displays servers memory usage information

## Permissions
- `PST.admin` - automatically assigned to OP's. Gives access to all administrative commands
- `PST.helper` - gives access to admin side of /helpme (Can assist users in need) 
- `PST.user` - default permission level. Gives access to basic user commands such as "/helpme" 