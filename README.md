# Battleship_BoardGame
This is a Battleship boardgame Emulator against a CPU. A player can place their battleships on a grid as well as grenades. Hitting a grenade causes a player to lose their turn. Once all ships and grenades are placed, the user and CPU take turns hitting rockets on the board until one of the players is able to hit all og their opponent's hidden ships. Multiple methods were used to do the following;
- Creating a grid that stores the locations of ships, grenades and previous rockets, and only reveals these locations after they have been hit. 
- Out of bounds detection when placing ships and grenades on the board. Same applies to placing items on a already existing ship / grenade. 
- Randomizing the CPU ship / grenade / rocket placement

