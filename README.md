# RecordKeeper

This program was an assignment for a Data Structures course. I was required to read a data file, keep track of the number of wins and losses as well as the years the teams played in increasing order. 

The program was built to support data with the following format, YearPlayed:WinningTeamName:LosingTeamName(i.e, 1994:FIU:FSU) with each input on a line of its own(i.e, 1994:FIU:FSU {NEXT LINE} 2000:FSU:FIU). The data structure used is a Red_Black tree from the Java API TreeMap class, where the keys of the map are the team names and the values are objects of the TeamInfo class. All methods are documented.

The simple UI has 4 functions that are called when the appropriate numbers are inputted.
1 - Choose a file with the appropriately formatted data ;; 
2 - Create and populate the tree ;; 
3 - Traverse the tree and displays data both in a seperate window and within the IDE ;; 
4 - Exit the program ;; 
