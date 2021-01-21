# RPG Battle Simulator

RPG Battle Simulator is a RPG game where you can select or create a party formed by Warriors and Wizards and battle against another party.

## Installation

1. Download the proyect from the repository.

2. Open the directory as a project on a IDE as IntelliJ.

3. Run the Main.java file on the path:

```bash
 ./src/com/ironhack/rpg_simulator/main
```

## Games Modes

1. Play With Random Teams

   1.1. Normal Mode (choosing fighters)
  
   1.2. Random Mode

2. Play with Custom Teams

   2.1. Normal Mode (choosing fighters)
  
   2.2. Random Mode
  
## Usage

Starting the Main.java file will display a menu with 4 options:

   1. Play With Random Teams - Lets you battle with a random generated team against another random generated team.
   
   2. Play with Custom Teams - Lets you select a team and battles with another selected team.
   
   3. Create New Team - Lets you create a custom team, choosing the diferents stats for each figther.
   
   4. Exit the game
 
To choose an option you have to introduce the corresponding number and click 'Enter'. Other numbers and other characters won't be accepted and displays
an error message and it will appear the same options again.
 
Before the game starts, it loads the teams that are on a CSV file inside of the following path:

```bash
 ./src/com/ironhack/rpg_simulator/csv_files
```

So, if you want to import a team from a CSV file, you only need to put the file on this directory.

If you select the options 1 or 2, the following new options will be displayed:

1. Normal Mode (Choose your fighters) - Lets you battle, choosing your figthers for each round. For each round, it will appear the fighters that are alive
   and you have to select one of them. Then, it will display a log of every action of the battle and, finally, the winner of the battle. Then, a new menu will
   appear:
      
   1. Select next fighter - Returns to the previous menu.
      
   2. Check the graveyard - Shows the graveyard for each team (the fighters who have died). The, you have to press 'Enter' and it returns to this same menu.
      
   3. Return to Main Menu - Ends the battle and return to the Main Menu.
   
2. Random Mode (The fighters will be chosen randomly) - The battle will take place randomly and immediately. It prints the first round and you have to press
'Enter' to move along the next round. When the battle finishes, it prints the winner team and returns to the Main Menu.
   
3. Return to Main Menu
   
If you select the option 3 on the Main Menu (Create New Team), it will display the instructions step by step to create a new party with the desired name and size.
Then, it will be the same for each fighter (name, HP, stamina/mana, strength/intelligence). When you finish to create a party, the game will create a CSV file on the
next path:

```bash
 ./src/com/ironhack/rpg_simulator/csv_files
```

And then, it will display the Main Menu.
   
## Screenshots


## Authors
**The Excepcionalist Team**: Adrià López, Jaume Sánchez, Salvatore Corsaro, Antonio Navarro, Iván Trujillo.
