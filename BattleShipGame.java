
import java.util.Scanner;

/* class for battleship game initializes basic variables to start game */
public class BattleShipGame {
    
	  private int width = 21;
	  private int height = 22;
	  private int shipType = 0;
	  private int shipType1 = 0;
	  private int size; 
	  private String grid = "+--";
	  private String[][] gameSize = new String[width][height];
	  private String[][] gameSize1 = new String[width][height];
	  private String[][] actualGame = new String[width][height];
	  private String[][] actualGame1 = new String[width][height];
	  private int scorePlayer1 = 0;
	  private int scorePlayer2 = 0;
	  private String shipStr1; 
	  private String shipStr2;
	  Scanner myObjInt = new Scanner(System.in);
	  Scanner myObjStr = new Scanner(System.in);
	  
	  /* creates the actual game, also starts placement of ships using placeShip(), also tutorial*/
	  public BattleShipGame() {
		System.out.println("Read before starting a New Game\r\n"
				+ "Each player places the 5 ships somewhere on their board.  The ships can only be placed vertically or horizontally. Diagonal placement is not allowed. No part of a ship may hang off the edge of the board.  Ships may not overlap each other.  No ships may be placed on another ship. \r\n"
				+ "\r\n"
				+ "Once the guessing begins, the players may not move the ships.\r\n"
				+ "\r\n"
				+ "The 5 ships are:  Carrier (occupies 5 spaces), Battleship (4), Cruiser (3), Submarine (3), and Destroyer (2).  \r\n"
				+ "Player's take turns guessing by calling out the coordinates. The opponent responds with \"hit\" or \"miss\" as appropriate.  Both players should mark their board with pegs:  HIT for hit, NOT for miss. For example, if you call out (5,10) and your opponent does not have any ship located at (5,10), your opponent would respond with \"miss\".  You record the miss F6 by placing NOT on the part of your board at (5,10).  Your opponent records the miss by placing NOT.\r\n"
				+ "\r\n"
				+ "As soon as all of one player's ships have been sunk, the game ends."
				+ "\r\n"
				+ "Rules from: https://www.cs.nmsu.edu/~bdu/TA/487/brules.htm");
		System.out.println();
	    createGame();
	    shipType++;
	    shipType1++;
	    placeShip1();
	    placeShip1();
	    placeShip1();
	    placeShip1();
	    placeShip1();
	    placeShip(); 
	    placeShip();
	    placeShip();
	    placeShip(); 
	    placeShip();
	    System.out.println();
	    System.out.println();
	    System.out.println();
	    System.out.println();
	    System.out.println();
	    System.out.println();
	    System.out.println();
	    System.out.println();
	    System.out.println();
	    System.out.println();
	    System.out.println();
	    System.out.println();
	    System.out.println();
	    System.out.println();
	    System.out.println();
	    System.out.println();
	    System.out.println();
	    System.out.println();
	    player2();
	  }

    
	  public void createGame() {
	    for(int row = 0; row < gameSize.length; row++) {
	      for(int col = 0; col < gameSize[0].length; col++) {
	    	  if (col != 0) {
	    		  gameSize[row][col] = "+--";
	        	  actualGame[row][col] = "+--";
	    	  }
	    	  else {
	    		  gameSize[row][col] = "   ";
	        	  actualGame[row][col] = "   ";
	    	  }
	        
	      }
	    }
	    for(int row = 0; row < gameSize1.length; row++) {
		      for(int col = 0; col < gameSize1[0].length; col++) {
		    	  if (col != 0) {
		    		  gameSize1[row][col] = "+--";
		        	  actualGame1[row][col] = "+--";
		    	  }
		    	  else {
		    		  gameSize1[row][col] = "   ";
		        	  actualGame1[row][col] = "   ";
		    	  }
		        
		      }
		    }
	  }
	  
	  /* checks score to see if either player has won */ 
	  public void winner() {
		  if (scorePlayer1 >= 17) {
			  System.out.println("PLAYER 1 WINS!");
        return;
		  }
		  else if (scorePlayer2 >= 17) {
			  System.out.println("PLAYER 2 WINS!");
        return;
		  }
	  }
  
    /* asks the player2 the location of enemy ships and checks if player is correct giving score */
	  public void player2() {
      /* inputs for x and y axis of the enemy ships*/
		  int inputX1;
		  int inputY1;
      /* asks for the x and y axis of enemy ships*/
		  System.out.println("PLAYER 2'S TURN AND SCORE IS CURRENTLY: " + scorePlayer2);
		  System.out.println("Enter x position of enemy ship");
  		inputY1 =  myObjInt.nextInt();
  
  		System.out.println("Enter y position of enemy ship");
  		inputX1 =  myObjInt.nextInt();

  		while (inputY1 > 20 || inputY1 < 0) {
  			System.out.println("Enter x position of enemy ship again, it's out of map");
  	  		inputY1 =  myObjInt.nextInt();
  			
  		}
  		while (inputX1 > 20 || inputX1 < 0) {
  			System.out.println("Enter y position of enemy ship again, it's out of map");
  	  		inputX1 =  myObjInt.nextInt();
  		}
      /* checks to see if the player's inputs are where the location of the ship are. If they are replaces grid with "HIT" and if not replaces with "HIT"*/
  		if (actualGame1[inputX1][inputY1 + 1].equals("NOT")) {
  			  actualGame1[inputX1][inputY1 + 1] = "NOT";
  			  System.out.println("You have guessed there once, try again");
  			  player2();
  			  return;
  		  }
  		else if (actualGame1[inputX1][inputY1 + 1].equals("HIT")) {
  			System.out.println("You have guessed there once, try again");
  			player2();
  			return;
  		}
  		else if (gameSize[inputX1][inputY1 + 1].equals("+--") && !(gameSize[inputX1][inputY1 + 1].equals("NOT"))) {
  			actualGame1[inputX1][inputY1 + 1] = "NOT";
  		}
  		  else {
  			  System.out.println(gameSize[inputX1][inputY1 + 1]);
  			  scorePlayer2++;
  			  actualGame1[inputX1][inputY1 + 1] = "HIT";
  		  	  winner();
              
  		  } 

      /* prints out the actual grid of player 2's POV including the score using for loop*/ 
  		System.out.println("   PLAYER 2'S TURN SCORE P1: " + scorePlayer2);
		  System.out.println("   0  1  2  3  4  5  6  7  8  9 10 11 12 13 14 15 16 17 18 19 20");
		  for(int row = 0; row < actualGame1.length; row++) {
		    	
		      for(int col = 0; col < actualGame1[0].length; col++) {
		        System.out.print(actualGame1[row][col]);
		        if (col == actualGame1[0].length - 1) {
		        	System.out.print(row);
		        }
		      }
		      System.out.println();
		  }
      if (scorePlayer1 >= 17) {
			  System.out.println("PLAYER 1 WINS!");
        return;
		  }
		  else if (scorePlayer2 >= 17) {
			  System.out.println("PLAYER 2 WINS!");
        return;
		  }
      /* changes turn to player 1 */
  		  player1();
  		  return;
  		  
	  }

    /* asks the player2 the location of enemy ships and checks if player is correct giving score */
	  public void player1() {
      /* inputs for x and y axis of the enemy ships*/
		  int inputX;
		  int inputY;
      
      /* asks for the x and y axis of enemy ships*/
		  System.out.println("PLAYER 1'S TURN AND SCORE IS CURRENTLY: " + scorePlayer1);
		  System.out.println("Enter x position of enemy ship");
  		inputY =  myObjInt.nextInt();
  
  		System.out.println("Enter y position of enemy ship");
  		inputX =  myObjInt.nextInt();

  		while (inputY > 20 || inputY < 0) {
  			System.out.println("Enter x position of enemy ship again, it's out of map");
  	  		inputY =  myObjInt.nextInt();
  		}
  		while (inputX > 20 || inputX < 0) {
  			System.out.println("Enter y position of enemy ship again, it's out of map");
  	  		inputX =  myObjInt.nextInt();
  		}
      /* checks to see if the player's inputs are where the location of the ship are. If they are replaces grid with "HIT" and if not replaces with "HIT"*/
  		if (actualGame[inputX][inputY + 1].equals("NOT")) {
			  actualGame[inputX][inputY + 1] = "NOT";
			  System.out.println("You have guessed there once, try again");
			  player2();
			  return;
		  }
		else if (actualGame[inputX][inputY + 1].equals("HIT")) {
			System.out.println("You have guessed there once, try again");
			player2();
			return;
		}
		else if (gameSize1[inputX][inputY + 1].equals("+--") && !(gameSize1[inputX][inputY + 1].equals("NOT"))) {
			actualGame[inputX][inputY + 1] = "NOT";
		}
		  else {
			  System.out.println(gameSize1[inputX][inputY + 1]);
			  scorePlayer1++;
			  actualGame[inputX][inputY + 1] = "HIT";
		  	  winner();
            
		  } 
  		/* prints out the actual grid of player 1's POV including the score using for loop*/ 
  		System.out.println("   PLAYER 1'S TURN SCORE P1: " + scorePlayer1);
		  System.out.println("   0  1  2  3  4  5  6  7  8  9 10 11 12 13 14 15 16 17 18 19 20");
		  for(int row = 0; row < actualGame.length; row++) {
		    	
		      for(int col = 0; col < actualGame[0].length; col++) {
		        System.out.print(actualGame[row][col]);
		        if (col == actualGame[0].length - 1) {
		        	System.out.print(row);
		        }
		      }
		      System.out.println();
		  }
      if (scorePlayer1 >= 17) {
			  System.out.println("PLAYER 1 WINS!");
        return;
		  }
		  else if (scorePlayer2 >= 17) {
			  System.out.println("PLAYER 2 WINS!");
        return;
		  }
      /* changes turn to player 2 */
  		  player2();
  		  return;
  		  
	  }

    /* method for placing the ships for player 1, also including checking collision, out of map. uses shiptype to change the type of the ship, and replaces the grid with the ship "CAR" "SUB" "DES" */
	  public void placeShip() {
      
      /* variables for placing ship for player 1 */
		  boolean cBoolean = false;
		  int xCDirection = 0;
		  int yCDirection = 0;
		  int xC;
		  int yC;
      /* checks the type of the ship and asks for input of x/y based off of shiptype */
      	  if (shipType == 1) {
      
      		  System.out.println("Enter x position of the player 1 carrier: ");
      		  yC =  myObjInt.nextInt();
      		  yC++;
      		  
      		  System.out.println("Enter y position of the player 1 carrier: ");
    		    xC =  myObjInt.nextInt();
      		  size = 4;
      		  shipStr1 = "CAR";
	      		  
      	  }
      	  
      	  else if (shipType == 2) {
      		  System.out.println("Enter x position of the player 1 battleship: ");
    		  yC =  myObjInt.nextInt();
    		  yC++;
    		  
    		  System.out.println("Enter y position of the player 1 battleship: ");
    		  xC =  myObjInt.nextInt();
    		  
    		  size = 3;
    		  shipStr1 = "BAT";
      	  }
      	  
      	  else if (shipType == 3) {
      		  System.out.println("Enter x position of the player 1 cruiser: ");
      		  yC =  myObjInt.nextInt();
      		  yC++;
  		  
      		  System.out.println("Enter y position of the player 1 cruiser: ");
      		  xC =  myObjInt.nextInt();
    		  size = 2;
    		  shipStr1 = "CRU";
    		  
      	  }
      	  
      	  else if (shipType == 4) {
      		  System.out.println("Enter x position of the player 1 submarine: ");
      		  yC =  myObjInt.nextInt();
      		  yC++;
  		  
      		  System.out.println("Enter y position of the player 1 submarine: ");
      		  xC =  myObjInt.nextInt();
    		  size = 2;
    		  shipStr1 = "SUB";
    		  
      	  }
      	  
      	  else {
      		  System.out.println("Enter x position of the player 1 destroyer: ");
      		  yC =  myObjInt.nextInt();
      		  yC++;
  		  
      		  System.out.println("Enter y position of the player 1 destroyer: ");
      		  xC =  myObjInt.nextInt();
    		  size = 1;
    		  shipStr1 = "DES";
      	  }

      /* asks the player for the way the ships will face */
      
      	  System.out.print("Do you want the ship to face up, down, right or left? ");
      	  String cFace = myObjStr.nextLine(); 

      /* checks to see if the ships are in the map or even colliding with other ships via for loop */
		  while (cBoolean == false) {
        /* for ships facing up */ 
			  if (cFace.equals("up") == true) {
				  if (xC - size > height || xC - size < 1) {
					  System.out.println("Try again.... The ship is not in map");
					  placeShip(); 
					  return;
				  }
				  else {
					  for (int i = 0; i < size; i++) {
						  if(gameSize[xC - i][yC + 1] != "+--") {
							  System.out.println("Try again.... The ship is colliding with another ship");
							  placeShip();
							  return;
					    }
						  else { cBoolean = true; xCDirection = size; }
					  }
				  }
			  }
        /* for ships facing down */ 
			  else if (cFace.equals("down") == true) {
				  if (xC + size > height || xC + size < 1) {
					  
					  System.out.println("Try again.... The ship is not in map");
					  placeShip(); 
					  return;
				  }
				  else {
					  for (int i = 0; i < size; i++) {
						  if(gameSize[xC + i][yC + 1] != "+--") {
							  System.out.println("Try again.... The ship is colliding with another ship");
							  placeShip();
							  return;
					  }
						  else { cBoolean = true; xCDirection = size; }
					  }
				  }
			  }
        /* for ships facing right */ 
			  else if (cFace.equals("right") == true) {
				  if (yC + size > width || yC + size < 1) {
					  
					  System.out.println("Try again.... The ship is not in map");
					  placeShip(); 
					  return;
				  }
				  else {
					  for (int i = 0; i < size; i++) {
						  if(gameSize[xC][yC + i + 1] != "+--") {
							  System.out.println("Try again.... The ship is colliding with another ship");
							  placeShip(); 
							  return;
					    }
						  else { cBoolean = true; yCDirection = size; }
					  }
				  }
			  }
			  /* for ships facing left */ 
			  else if (cFace.equals("left") == true) {
				  if (yC - size > width || yC - size < 1) {
					  
					  System.out.println("Try again.... The ship is not in map");
					  placeShip(); 
					  return;
				  }
				  else {
					  for (int i = 0; i < size; i++) {
						  if(gameSize[xC][yC - i] != "+--") {
							  System.out.println("Try again.... The ship is colliding with another ship");
							  placeShip(); 
							  return;
						  }
						  else { cBoolean = true; yCDirection = size; }
					  }
				  }
			  }
        /* checks if facing is not left, right, down, or left */
			  else {
				  System.out.println("Try again.... You didn't choose up, down, right, or left");
				  placeShip(); 
				  return;
			  }
		  }

      /* travels across the grid and replacing the location with the type of ship, "CRU" "DES" */
      
		  if (cFace.equals("up")) {
			  for(int row = 0; row <= xCDirection; row++) {
				  for(int col = 0; col <= yCDirection; col++) {
					  gameSize[xC - row][yC - col] = shipStr1;
				  }
			  }
		  }
		  else if (cFace.equals("right")) {
			  for(int row = 0; row <= xCDirection; row++) {
				  for(int col = 0; col <= yCDirection; col++) {
					  gameSize[xC + row][yC + col] = shipStr1;
				  }
			  }
		  }
		  else {
			  if (cFace.equals("left") || cFace.equals("down")) {
				  for(int row = 0; row <= xCDirection; row++) {
					  for(int col = 0; col <= yCDirection; col++) {
						  if (xC == 1 || yC == 1) {
							  gameSize[xC + row][xC - col + 1] = shipStr1;
						  }
						  else { gameSize[xC + row][yC - col] = shipStr1; }
					  }
				  }
			  }
		  }

      /* prints the grid of player's ship placement, includes x/y axis. traverse through grid using for loop */
		  System.out.println("   SHIP PLACEMENT PLAYER 1");
		  System.out.println("   0  1  2  3  4  5  6  7  8  9 10 11 12 13 14 15 16 17 18 19 20");
		  for(int row = 0; row < gameSize.length; row++) {
		      for(int col = 0; col < gameSize[0].length; col++) {
		        System.out.print(gameSize[row][col]);
		        if (col == gameSize[0].length - 1) {
		        	System.out.print(row);
		        }
		      }
		      System.out.println();
		  }
      /* changes the ship type to the next, carrier, battleship, cruiser, submarine, and then destroyer */
		  shipType++;
      /* closes loop */
		  return;
	  }


    /* method for placing the ships for player 2, also including checking collision, out of map. uses shiptype to change the type of the ship, and replaces the grid with the ship "CAR" "SUB" "DES" */
	  public void placeShip1() {

      /* variables for placing ship for player 1 */
		  boolean cBoolean = false;
		  int xCDirection = 0;
		  int yCDirection = 0;
		  int xC;
		  int yC;
      /* checks the type of the ship and asks for input of x/y based off of shiptype */
      	  if (shipType1 == 1) {
      
      		  System.out.println("Enter x position of the player 2 carrier:");
      		  yC =  myObjInt.nextInt();
      		  yC++;
      		  
      		  System.out.println("Enter y position of the player 2 carrier:");
    		  xC =  myObjInt.nextInt();
      		  size = 4;
      		  shipStr2 = "CAR";
	      		  
      	  }
      	  
      	  else if (shipType1 == 2) {
      		  System.out.println("Enter x position of the player 2 battleship:");
    		  yC =  myObjInt.nextInt();
    		  yC++;
    		  
    		  System.out.println("Enter y position of the player 2 battleship:");
    		  xC =  myObjInt.nextInt();
    		  
    		  size = 3;
    		  shipStr2 = "BAT";
      	  }
      	  
      	  else if (shipType1 == 3) {
      		  System.out.println("Enter x position of the player 2 cruiser:");
      		  yC =  myObjInt.nextInt();
      		  yC++;
  		  
      		  System.out.println("Enter y position of the player 2 cruiser:");
      		  xC =  myObjInt.nextInt();
    		  size = 2;
    		  shipStr2 = "CRU";
    		  
      	  }
      	  
      	  else if (shipType1 == 4) {
      		  System.out.println("Enter x position of the player 2 submarine:");
      		  yC =  myObjInt.nextInt();
      		  yC++;
  		  
      		  System.out.println("Enter y position of the player 2 submarine:");
      		  xC =  myObjInt.nextInt();
    		  size = 2;
    		  shipStr2 = "SUB";
    		  
      	  }
      	  
      	  else {
      		  System.out.println("Enter x position of the player 2 destroyer:");
      		  yC =  myObjInt.nextInt();
      		  yC++;
  		  
      		  System.out.println("Enter y position of the player 2 destroyer:");
      		  xC =  myObjInt.nextInt();
    		  size = 1;
    		  shipStr2 = "DES";
      	  }
       /* asks the player for the way the ships will face */
      	  System.out.print("Do you want the ship to face up, down, right or left? ");
      	  String cFace = myObjStr.nextLine(); 

      /* checks for ship's location, collision and outside of map */
		  while (cBoolean == false) {
        /* for ships facing up */ 
			  if (cFace.equals("up") == true) {
				  if (xC - size > height || xC - size < 1) {
					  System.out.println("Try again.... The ship is not in map");
					  placeShip1(); 
					  return;
				  }
				  else {
					  for (int i = 0; i < size; i++) {
						  if(gameSize1[xC - i][yC] != "+--") {
							  System.out.println("Try again.... The ship is colliding with another ship");
							  placeShip1();
							  return;
					    }
						  else { cBoolean = true; xCDirection = size; }
					  }
				  }
			  }

        /* for ships facing down */ 
			  else if (cFace.equals("down") == true) {
				  if (xC + size > height || xC + size < 1) {
					  
					  System.out.println("Try again.... The ship is not in map");
					  placeShip1(); 
					  return;
				  }
				  else {
					  for (int i = 0; i < size; i++) {
						  if(gameSize1[xC + i][yC] != "+--") {
							  System.out.println("Try again.... The ship is colliding with another ship");
							  placeShip1();
							  return;
					  }
						  else { cBoolean = true; xCDirection = size; }
					  }
				  }
			  }

        /* for ships facing right */ 
			  else if (cFace.equals("right") == true) {
				  if (yC + size > width || yC + size < 1) {
					  
					  System.out.println("Try again.... The ship is not in map");
					  placeShip1(); 
					  return;
				  }
				  else {
					  for (int i = 0; i < size; i++) {
						  if(gameSize1[xC][yC + i] != "+--") {
							  System.out.println("Try again.... The ship is colliding with another ship");
							  placeShip1(); 
							  return;
					    }
						  else { cBoolean = true; yCDirection = size; }
					  }
				  }
			  }

          /* for ships facing left */ 
			  else if (cFace.equals("left") == true) {
				  if (yC - size > width || yC - size < 1) {
					  
					  System.out.println("Try again.... The ship is not in map");
					  placeShip1(); 
					  return;
				  }
				  else {
					  for (int i = 0; i < size; i++) {
						  if(gameSize1[xC][yC - i] != "+--") {
							  System.out.println("Try again.... The ship is colliding with another ship");
							  placeShip1(); 
							  return;
						  }
						  else { cBoolean = true; yCDirection = size; }
					  }
				  }
			  }
        /* checks if facing is not left, right, down, or left */
			  else {
				  System.out.println("Try again.... You didn't choose up, down, right, or left");
				  placeShip1(); 
				  return;
			  }
		  }

      /* travels across the grid and replacing the location with the type of ship, "CRU" "DES" */
		  if (cFace.equals("up")) {
			  for(int row = 0; row <= xCDirection; row++) {
				  for(int col = 0; col <= yCDirection; col++) {
					  gameSize1[xC - row][yC - col] = shipStr2;
				  }
			  }
		  }
		  else if (cFace.equals("right")) {
			  for(int row = 0; row <= xCDirection; row++) {
				  for(int col = 0; col <= yCDirection; col++) {
					  gameSize1[xC + row][yC + col] = shipStr2;
				  }
			  }
		  }
		  else {
			  if (cFace.equals("left") || cFace.equals("down")) {
				  for(int row = 0; row <= xCDirection; row++) {
					  for(int col = 0; col <= yCDirection; col++) {
						  if (xC == 1 || yC == 1) {
							  gameSize1[xC + row][xC - col + 1] = shipStr2;
						  }
						  else { gameSize1[xC + row][yC - col] = shipStr2; }
					  }
				  }
			  }

		  }
      
      /* prints the grid of player's ship placement, includes x/y axis. traverse through grid using for loop */
		  System.out.println("   SHIP PLACEMENT PLAYER 2");
		  System.out.println("   0  1  2  3  4  5  6  7  8  9 10 11 12 13 14 15 16 17 18 19 20");
		  for(int row = 0; row < gameSize1.length; row++) {
		      for(int col = 0; col < gameSize1[0].length; col++) {
		        System.out.print(gameSize1[row][col]);
		        if (col == gameSize1[0].length - 1) {
		        	System.out.print(row);
		        }
		      }
		      System.out.println();
		  }
      /* changes the ship type to the next, carrier, battleship, cruiser, submarine, and then destroyer */
		  shipType1++;
      /* closes loop */
		  return;
	  }
	  
	}
	  
