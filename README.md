Anti-Cheat plugin for detecting KillAura in PvP.

Preferred Version: 1.21.0+ (older versions untested)

If someone is detected using KillAura, you will get a message saying "PlateouKillAura: <user> might be using KillAura" to staff members (all staff members must have the correct LuckPerms permission)

The LuckPerms permission required to see the message is:
'plateoukillaura.notify'

To assign this permission to a player/group do the following:

  For a player:
    /lp user <username> permission set plateoukillaura.notify true

  For a group:
    /lp group <groupname> permission set plateoukillaura.notify true

The permission is set to default to 'op' (only server operators have it by default).
