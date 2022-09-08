public class Battleship {
   private char grid[][] = new char[8][8];
   private int row;
   private int col;
   private int human;
   private int cpu;
   private boolean winner;

   public Battleship() {
       row = 0;
       col = 0;
       for (int i = 0; i < grid.length; i++) {
           for (int j = 0; j < grid[i].length; j++) {
               grid[i][j] = '_';
           }
       }
   }
   
   public Battleship(Battleship tempGrid) {
       for (int i = 0; i < grid.length; i++) {
           for (int j = 0; j < grid[i].length; j++) {
               this.grid[i][j] = tempGrid.grid[i][j];
           }
       }
   }

   public int isRow(String coordinate) {
       switch (coordinate.charAt(0)) {
       case 'A':
       case 'a':
           row = 0;
           break;
       case 'B':
       case 'b':
           row = 1;
           break;
       case 'C':
       case 'c':
           row = 2;
           break;
       case 'D':
       case 'd':
           row = 3;
           break;
       case 'E':
       case 'e':
           row = 4;
           break;
       case 'F':
       case 'f':
           row = 5;
           break;
       case 'G':
       case 'g':
           row = 6;
           break;
       case 'H':
       case 'h':
           row = 7;
           break;
       }
       return (row);
   }

   public int isCol(String coordinate) {
       switch (coordinate.charAt(1)) {
       case '1':
           col = 0;
           break;
       case '2':
           col = 1;
           break;
       case '3':
           col = 2;
           break;
       case '4':
           col = 3;
           break;
       case '5':
           col = 4;
           break;
       case '6':
           col = 5;
           break;
       case '7':
           col = 6;
           break;
       case '8':
           col = 7;
           break;
       }
       return (col);
   }
   
   public void outOfBounds(char let, char num) {
       if (let < 65 && let > 72) {
           System.out.println("Coordinates are out of bounds. Input valid coordinates.");
       }
       if (num < 49 && let > 56) {
           System.out.println("Coordinates are out of bounds. Input valid coordinates.");
       }
   }
   
   public void outOfBounds2(char let2, char num2) {
       if (let2 < 65 && let2 > 72) {
           System.out.println("Coordinates are out of bounds. Input valid coordinates.");
       }
       if (num2 < 49 && let2 > 56) {
           System.out.println("Coordinates are out of bounds. Input valid coordinates.");
       }
   }

   public void setShip() {
       grid[this.col][this.row] = 's';
   }

   public void setCShip() {
       grid[this.col][this.row] = 'S';
   }

   public void setGrenade() {
       grid[this.col][this.row] = 'g';
   }

   public void setCGrenade() {
       grid[this.col][this.row] = 'G';
   }

   public boolean gridScan() {
       return (grid[this.col][this.row] == 'S' || grid[this.col][this.row] == 'G' || grid[this.col][this.row] == 's'
               || grid[this.col][this.row] == 'g');
   } 

   public int cpuRow() {
       this.row = (int) (Math.random() * ((8 - 1) + 1) - 1);
       return row;
   }

   public int cpuCol() {
       this.col = (int) (Math.random() * ((8 - 1) + 1) - 1);
       return col;
   }

   public void cpuTurn(Battleship activeGrid) {
       cpuRow();
       cpuCol();
       boolean valid =duplicateCheck();
       if (valid == true) {
    	   cpuTurn(activeGrid); 
                                  
           return;
       }
       if (activeGrid.grid[this.col][this.row] == 'S' ||activeGrid.grid[this.col][this.row] == 'G') {
           cpuRow();
           cpuCol();
       }
       switch (this.row) {
       case 0: {
           System.out.print("position of my rocket: A");
           break;
       }
       case 1: {
           System.out.print("position of my rocket: B");
           break;
       }
       case 2: {
           System.out.print("position of my rocket: C");
           break;
       }

       case 3: {
           System.out.print("position of my rocket: D");
           break;
       }
       case 4: {
           System.out.print("position of my rocket: E");
           break;
       }
       case 5: {
           System.out.print("position of my rocket: F");
           break;
       }
       case 6: {
           System.out.print("position of my rocket: G");
           break;
       }
       case 7: {
           System.out.print("position of my rocket: H");
           break;
       }
       }

       switch (this.col) {
       case 0: {
           System.out.println("1");
           break;
       }
       case 1: {
           System.out.println("2");
           break;
       }
       case 2: {
           System.out.println("3");
           break;
       }

       case 3: {
           System.out.println("4");
           break;
       }
       case 4: {
           System.out.println("5");
           break;
       }
       case 5: {
           System.out.println("6");
           break;
       }
       case 6: {
           System.out.println("7");
           break;
       }
       case 7: {
           System.out.println("8");
           break;
       }
       }

   }

   public void display() {
       for (int i = 0; i < grid.length; i++) {
           for (int j = 0; j < grid[i].length; j++) {
               System.out.print(grid[i][j] + " ");
           }
           System.out.println();
       }
   }

   public void display(Battleship playGrid) {
       for (int i = 0; i < grid.length; i++) {
           for (int j = 0; j < playGrid.grid[i].length; j++) {
               System.out.print(playGrid.grid[i][j] + " ");
           }
           System.out.println();
       }
   }

   public boolean duplicateCheck()  {
       return (grid[this.col][this.row] == '*' || grid[this.col][this.row] == 'G' || grid[this.col][this.row] == 'S'
               || grid[this.col][this.row] == 's' || grid[this.col][this.row] == 'g');
   }

   public void Rocket(Battleship playGrid) {
       if (playGrid.grid[this.col][this.row] == '_') {
           System.out.println("nothing.");
           grid[this.col][this.row] = '*';
           display();
       } else if (playGrid.grid[this.col][this.row] == 's' || playGrid.grid[this.col][this.row] == 'S') {
           System.out.println("ship hit.");
           this.grid[this.col][this.row] = playGrid.grid[this.col][this.row];
           if (playGrid.grid[this.col][this.row] == 'S') 
           		{
               this.human++;
               if (this.human == 6) {
                   System.out.println("You won against CPU");
                   display(playGrid);
                   System.exit(0);
               }

           } else if (playGrid.grid[this.col][this.row] == 's') {
               this.cpu++;
               if (this.cpu == 6) {
                   System.out.println("You lost against CPU");
                   display(playGrid);
                   System.exit(0);
               }
           }
           display();
       }

       else if (playGrid.grid[this.col][this.row] == 'g' || playGrid.grid[this.col][this.row] == 'G') {
           System.out.println("boom! grenade.");
           this.grid[this.col][this.row] = playGrid.grid[this.col][this.row];
           display();
       }
   }
       
   public void emptyGrid() {
       for (int i = 0; i < grid.length; i++) {
           for (int j = 0; j < grid[i].length; j++) {
               grid[i][j] = '_';
           }
       }
   }

   public boolean Grenade(Battleship activeGrid) {
       return activeGrid.grid[this.col][this.row] == 'G' ||activeGrid.grid[this.col][this.row] == 'g';

   }

   public boolean equals(Battleship activeGrid) {
       return (this.grid ==activeGrid.grid);
   }
}