How to Play:

You're an adventurer stuck in a dungeon full of trolls.  Collect the key, sneak past the trolls, and make it to 
the exit!  You start with five health points.  If your health is low, collect a health potion for 3 more 
health points. You can't have more than 7 health points.  You don't have any weapons, so you'll have to survive!

Controls:
'w'- Move up
'a'- Move left
's'- Move down
'd'- Move right

Custome Features:

I added a two enemies modeled off my HW3 code.  They follow collision detection with the walls and move randomly
using Math.random and a switch statement.  I also implemented a health counter as well as health potions in each 
level.  There is also an additional level at the end of the game. The error messages are printed from an array.

There is a key algorithm that works on a collision detection system modeled after the target clicker
and the boolean value keyValue.  When the player collides with the position of the key, it changes the 
value of keyValue to true and stops printing the keyTile.  The health potion is modeled the same way.  Both of these
values trigger false again when the new level loads to ensure they print.