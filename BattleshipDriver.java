import java.util.Scanner;

public class BattleshipDriver {

	public static void main(String[] args) {		
	   Scanner keyboard = new Scanner(System.in);
       Battleship grid = new Battleship();     
       System.out.println("--------- Welcome To The Battleship Game ---------");
       System.out.println();
       System.out.println("The objective of the game is to sink all enemy ships!");
       System.out.println("The grid size goes from A-H horizontally and 1-8 vertically. Each ship takes one coordinate. An example of a valid coordinate is B2"); 
       System.out.println("Grenades can be placed on the board. If you or your opponent hit a grenade, they will lose a turn.");
       System.out.println("Your ships and grenades are marked with lowercase \"s\" and \"g\" while they are uppercase for your opponent. Note that you can hit your own ships and grenades ");
       System.out.println();
       int value = 1;
       int i = 0;
       int j = 0;
       while (i < 6) 
    	   // Prompt user to input ship coordinates. Letter of coordinate system is uppercased 
           {     	  
    	   System.out.print("Enter the coordinates of your ship.  #" + value + ": ");    	     	   
    	   String input = keyboard.next();
           char let = input.charAt(0); 
           let=Character.toUpperCase(let);
           char num = input.charAt(1);                  
                                                         
           // Method to check if user gives input that is not in the A-H & 1-8 Coordinate system
           grid.outOfBounds(let, num);    
           
           // Method takes input and assigns Letter coordinate to the specific row and Number coordinate to specific colunm in the Grid
           // that is displayed
           grid.isRow(input);
           grid.isCol(input);
           
           // Method assigns Ship to the Grid unless it is out of bounds 
           boolean gridChecker = grid.gridScan();              
           if (gridChecker == true) 	
           		{ 
           			System.out.println("Coordinates are out of bounds. Input valid coordinates.");
           			continue;
           		} else {
           			grid.setShip();
           			i++; 
           			value++;
           				}
           		}
       
	   System.out.println();
	   value = 1;
       while (j < 4) 
    	   // 	Same methods as before but with Grenades
       		{    	   
           System.out.print("Enter the coordinates of your grenade #" + value + ": ");
           String input = keyboard.next();
           char let = input.charAt(0); 
           let=Character.toUpperCase(let);
           char num = input.charAt(1); 	
           
           grid.outOfBounds(let, num);
           grid.isRow(input);
           grid.isCol(input);
           boolean inspectGrid = grid.gridScan();               
           if (inspectGrid == true)	
           		{
           		System.out.println("Coordinates are out of bounds. Input valid coordinates.");
           		continue;
           		} else {
           		  grid.setGrenade();
           		   j++; 
           		  value++;
           				 }
           			
       		 }       
       System.out.println();      
       int a = 0;
       int b = 0;
       while (a < 6) 
    	   
    	   // Method randomly assigns a Ship coordinate as user is playing with a CPU (computer)
       	   { 
    	   grid.cpuRow();
           grid.cpuCol();
           boolean validation = grid.gridScan();
           if (validation == true)
           	   {
               continue;
           	   } else {
           	     grid.setCShip();
           	     a++;
           				 }
            }

       while (b < 4)	
    	// Same Methods above but for grenades
       	   {
           grid.cpuRow();
           grid.cpuCol();
           boolean check = grid.gridScan();
           if (check == true) 
           		{
        	    continue;
           		} else {
           	      grid.setCGrenade();
           		  b++;
           				}
       	   	}
       //While playing, the grid mustn't show the location of the Ships and Grenades unless a rocket shoots at it
       Battleship activeGrid = new Battleship(grid); 
       grid.emptyGrid(); 
       System.out.println();
       System.out.println("The opposing player (computer) has placed it's ships and grenades. The game has begun!.");
       System.out.println();
       
       int turns = 0;
       while (turns <= 64) 
    	   // Limit is set to above 64 as there are 64 spots on the grid. Impossible to have 65 or more turns
       	   { 
           System.out.print("Position of your rocket: "); 
           String input = keyboard.next();
           char let = input.charAt(0); 
           let=Character.toUpperCase(let);
           char num = input.charAt(1);            
                                                                                   
           grid.outOfBounds(let, num);           
           grid.isRow(input);
           grid.isCol(input);
           
           // The following methods checks if a specific coordinate was already shot at with a rocket. 
           // If coordinate is exposed (duplicate check), prompt user to choose a hidden coordinate
           // If coordinate is hidden (active grid), allow the rocket to be shot
           
           boolean inspectGrid = grid.duplicateCheck(); 
           if (inspectGrid == true) 
           		{
        	   	System.out.println("Coordinate already exposed. Please choose a hidden coordinate.");
            	grid.display();
            	continue;
            	} else { 
            	   	grid.Rocket(activeGrid);
            	   	boolean hitGrenade = grid.Grenade(activeGrid);
            	   	if(hitGrenade == true) 
            	   		{
            	   		grid.cpuTurn(activeGrid);
            	   		grid.Rocket(activeGrid);
            	   		}

            	   	}
           		// The following methods are repeated, but they are for the computer instead of the user/Human
           	   grid.cpuTurn(activeGrid); 
               grid.Rocket(activeGrid);
               boolean location = grid.Grenade(activeGrid);
               if (location == true)
               		{ 
                    while (turns <= 64 )
                       {
                    	System.out.print("Position of your rocket: "); 
                    	String input2 = keyboard.next();
                        char let2 = input.charAt(0); 
                        let2=Character.toUpperCase(let2);
                        char num2 = input.charAt(1);            
                        
                       grid.outOfBounds2(let, num);
                       grid.isRow(input2);
                       grid.isCol(input2);
                       boolean duplicateGrid = grid.duplicateCheck();
                       if (duplicateGrid == true) 
                        {
                        	System.out.println("Coordinate has already been used");
                            grid.display();
                            continue;
                            } else {
                                 grid.Rocket(activeGrid);
                                 boolean activeGrenade = grid.Grenade(activeGrid);
                                 if(activeGrenade == true) 
                                 	{
                                    grid.cpuTurn(activeGrid);
                                    grid.Rocket(activeGrid);
                                   }
                               	}

                           }
                   break;
                }                        
         turns++;
      }
   }
}