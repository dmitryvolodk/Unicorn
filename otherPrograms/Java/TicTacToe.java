import java.util.Scanner;
public class TicTacToe {
    
    static enum Value {X, O, EMPTY};
    static Value[][] grid = new Value[3][3];
    public static int x,y,count;
    static Scanner input;
    static String message; // to display the message
    static Boolean isFinished; // true/false if result is found
    public static int choice; // to decide if the human's move first or second
    
    public static void main(String[] args){
        
        input = new Scanner(System.in);
        
        // to assigne enum EMPTY for every space in the grid
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                grid[i][j] = Value.EMPTY;
            }
        }
        count = 1;
        isFinished = false;
        choice = 1;
        
        // ask the user if the human's move is 1st or 2nd
        System.out.print("Please choose the move (1 or 2) if human moves 1st or 2nd: ");
        choice = Integer.parseInt(input.next());
        
        //displays the original grid with values
        TicTacToe.displayGrid();
        
        // play the game until finished
        while(!isFinished){
            // ask the next player for move
            TicTacToe.askForMove();
            //checks if the game is finished
            TicTacToe.checkIfFinished();
            // display the grid
            TicTacToe.displayGrid();
        }
    }
    // ask the next player for move
    public static void askForMove(){
        Boolean rightPosition = false;
        while(!rightPosition){
            // to identify which player is moving next
            if(count % 2 != 0){ 
                // to input the right row and column for the right grid position - player X
                System.out.print("\nPlease enter a row number (1,2, or 3) for the player X: ");
                
                if(choice == 1)
                    x = Integer.parseInt(input.next());
                else{
                    x = (int)(Math.random() * 3) + 1;
                    System.out.println(x);
                }
                            
                System.out.print("Please enter a column number (1,2, or 3) for the player X: ");
                
                if(choice == 1)
                    y = Integer.parseInt(input.next());
                else{
                    y = (int)(Math.random() * 3) + 1;
                    System.out.println(y);
                }
                
                if(grid[x - 1][y - 1] == Value.EMPTY  ){
                grid[x - 1][y - 1] = Value.X; 
                rightPosition = true;
            }
                else{
		    // if the space is taken - prompt the user to choose another one
                    System.out.println("The space has been taken. Please choose another one.");
                    rightPosition = false;
                }
            }
            else{
		// to input the right row and column for the right grid position - player O
                System.out.print("\nPlease enter a row number (1,2, or 3) for the player O: ");
                
                if(choice == 2)
                    x = Integer.parseInt(input.next());
                else{
                    x = (int)(Math.random() * 3) + 1;
                    System.out.println(x);
                }
                
                System.out.print("Please enter a column number (1,2, or 3) for the player O: ");
                
                if(choice == 2)
                    y = Integer.parseInt(input.next());
                else{
                    y = (int)(Math.random() * 3) + 1;
                    System.out.println(y);
                }
                
                if(grid[x - 1][y - 1] == Value.EMPTY   ){
                    grid[x - 1][y - 1] = Value.O;  
                    rightPosition = true;
                }
                else{
		    // if the space is taken - prompt the user to choose another one
                    System.out.println("The space has been taken. Please choose another one.");
                    rightPosition = false;
                }
                
            }
        }
        count++;
    }
    
    // to check if the game is finished
    public static void checkIfFinished(){
        int i;
        Value checkPoint = Value.EMPTY;
        
        // check the rows
        for(i = 0; i < 3; i++)
            if(grid[i][0] == grid[i][1] && grid[i][0] == grid[i][2] && grid[i][0] != Value.EMPTY  ) 
                checkPoint = grid[i][0];  
        
        // check the columns
        for(i = 0; i < 3; i++)
            if(grid[0][i] == grid[1][i] && grid[0][i] == grid[2][i] && grid[0][i] != Value.EMPTY) 
                checkPoint = grid[0][i]; 
        
        // check the diagonals
        if(grid[0][0] == grid[1][1] && grid[1][1] == grid[2][2] && grid[1][1] != Value.EMPTY) 
            checkPoint = grid[1][1]; 
        if(grid[0][2] == grid[1][1] && grid[1][1] == grid[2][0] && grid[1][1] != Value.EMPTY) 
            checkPoint = grid[1][1]; 
        
        // check if nobody won
        if(count == 10){
            isFinished = true;
            message = "Match drawn";
        }
        
        // check if player X won
        if(checkPoint == Value.X){
            isFinished = true;
            message = "Player X won";
        }
        
        // check if player O won
        else if(checkPoint == Value.O){
            isFinished = true;
            message = "Player O won";
        }
        
    }
    
    // to display the grid
    public static void displayGrid(){
        for(int i = 0; i < 3; i++){
	    // Display horizontal lines
            System.out.println("\n----------------------");
	    // Display virtical lines and the values in the cells
            for(int j = 0; j < 3; j++){
                if(grid[i][j] != Value.EMPTY || grid[i][j] != null  ){
		    // to keep the columns width always the same
		    if(grid[i][j] == Value.EMPTY)
		    System.out.print("| " + grid[i][j] + " "   );
		    else
                    System.out.print("|   " + grid[i][j] + "   "   );
                }else
                    System.out.print("|" + " ");
                if(j == 2)
                    System.out.println("|");
            }
            if(i == 2)
		// Display horizontal lines
                System.out.println("\n----------------------");
        }
        
        // to show the message when the game is finished
        if(isFinished)
            System.out.println(message);
    }
}
