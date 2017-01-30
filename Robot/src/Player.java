import java.util.Scanner;
import java.util.Map;

public class Player implements Robot{

//	ArrayList<Integer> currentLocation = new ArrayList<Integer>();
	int []currentLocation = {0,0,0};
	char [] dir = {'N', 'S', 'E', 'W'};
	char [] rotation = {'N','E','S','W'};
	String [] orientation = {"NORTH", "SOUTH", "EAST", "WEST"};
	String [] input = {"MOVE", "LEFT", "RIGHT", "REPORT"};
	String move;
	boolean iterate;
	@Override
	public void play(){
		System.out.println("Lets play with the Robot\n");
		System.out.println("Please enter the following :\n");
		setBoardLayout();
		placePlayer();
			 do{
				Scanner playerInput = new Scanner(System.in);
			 	System.out.println("Would you like to try another move (MOVE) or turn left (LEFT) or turn right (RIGHT) or Report the location (REPORT) or place the player somewhere (PLACE) or print Board (PRINT) :\n");
			 	String choice = playerInput.nextLine().toUpperCase();;
			 	iterate = true;
			 	if (choice.equals("MOVE")){
			 		System.out.println("The current location is: " +currentLocation[0]+ ":" +currentLocation[1]+ ":"+currentLocation[2]+ "\n");
			 		int direction = currentLocation[2];
			 		currentLocation = setNewLocation(currentLocation[0], currentLocation[1], dir[direction]);
					move(currentLocation);
			 		iterate = true;
			 		
			 	} else if (choice.equals("LEFT")){
				 	for (int loop = 0, i = rotation.length; loop < i ; loop++) {
				 		char c = rotation[loop];
				 		char direction;
//				 		System.out.println("For LEFT: now c is: " +c+ " and direction is: " + dir[currentLocation[2]] );
				 		if (c == dir[currentLocation[2]]){
				 			if (loop == 0){
				 				direction = rotation[(rotation.length)-1];
				 			} else if (loop == ((rotation.length)-1)){
				 				direction = rotation[0];
				 			} else {
				 				direction = rotation[loop-1];			 		
				 			}
//				 			System.out.println("The new direction key is: " + direction);
				 			currentLocation = setNewLocation(currentLocation[0], currentLocation[1], direction);
			        	}
			    	}		 	
				 	iterate = true;
			 	} else if (choice.equals("RIGHT")){
				 	for (int loop = 0, i = rotation.length; loop< i ; loop++) {
				 		char c = rotation[loop];
				 		char direction;
//				 		System.out.println("For RIGHT: now c is: " +c+ " and direction is: " + dir[currentLocation[2]] );
				 		if (c == dir[currentLocation[2]]){
				 			if (loop == ((rotation.length)-1)){
				 				direction = rotation[0];
				 			} else if (loop == 0){
				 				direction = rotation[(rotation.length+1)];
				 			} else {
				 				direction = rotation[loop+1];
//				 				System.out.println("The new direction key is: " + direction);
				 				currentLocation = setNewLocation(currentLocation[0], currentLocation[1], direction);
				 			}
				 		}
			    	}
				 	iterate = true;
			 	} else if (choice.equals("REPORT")){
			 		int direction = currentLocation[2];
			 		System.out.println("Your player is located at: " +currentLocation[0]+ ":" +currentLocation[1]+ ":" +orientation[direction]);
			 		iterate = true;
			 	} else if (choice.equals("PLACE")){
			 		placePlayer();
			 		iterate = true;
			 	}
			 	else {
			 		iterate = false;
			 	}
			 } while (iterate != false);
	}
	
	@Override
	public void setBoardLayout(){
		char [][] board = new char [5][5];
		for (int row = 0; row <5; row++){
			for (int col = 0; col <5; col++){
				board[row][col] = 'O';
//				System.out.println(":"+board[row][col]+":");
			}
//			System.out.println("\n");
		}
		System.out.println("The Board Layout is: 5x5: ");
	}

	public void printBoardLayout(){
		char [][] board = new char [5][5];
		for (int row = 0; row <5; row++){
			for (int col = 0; col <5; col++){
				if (row == currentLocation[0] && col == currentLocation[1]){
					board[row][col] = dir[currentLocation[2]];
				}
//				System.out.println(":"+board[row][col]+":");
			}
//			System.out.println("\n");
		}
		System.out.println("The Board Layout is: 5x5: ");
	}
	
	public void placePlayer(){
		Scanner place = new Scanner(System.in);
		System.out.println("Select X position where you wish to place you player");
		String x = place.nextLine();
		int initial_x = Integer.parseInt(x);
		System.out.println("Select Y position where you wish to place you player");
		String y = place.nextLine();
		int initial_y = Integer.parseInt(y);
		System.out.println("Select direction you wish for your player: Type (N) for North, (S) for South, (E) for East, (W) for West");
		String dir = place.nextLine();
		char initial_dir = dir.charAt(0); 
		System.out.println("Your player is located at: " +initial_x+ ":" +initial_y+ ":" +initial_dir);
		setNewLocation(initial_x, initial_y, initial_dir);
	}
	public int [] setNewLocation(int new_x, int new_y, char new_dir){
		for (int spot = 0; spot <=2; spot++){
//			System.out.println("Spot = " + spot);
//			System.out.println("Co-ordinates are: "+ new_x +":" + new_y + ":" + new_dir);
			if (spot == 0){
//				System.out.println("Current X location is ...!!!!!");
				currentLocation[spot] = new_x;
//				System.out.println(currentLocation[spot]);
			} 
			if (spot == 1){
//				System.out.println("Current Y location is ...!!!!!");
				currentLocation[spot] = new_y;
//				System.out.println(currentLocation[spot]);
			}
			if (spot == 2){
				if (new_dir == 'N' || new_dir == 'n'){
					currentLocation[spot] = 0;
				} else if (new_dir == 'S' || new_dir == 's'){
					currentLocation[spot] = 1;
				} else if (new_dir == 'E' || new_dir == 'e'){
					currentLocation[spot] = 2;
				} else if (new_dir == 'W' || new_dir == 'w'){
					currentLocation[spot] = 3;
				}
//				System.out.println(currentLocation[spot]);
			}
		}
		return currentLocation;
	}
	
	public int[] getCurrentLocation(int [] currentLocation){
		return currentLocation;
	}
	
	public int [] move(int [] currentLocation){
		System.out.println("Please select a move player");
		System.out.println("LOCATION: " +currentLocation);
		int [] LOCATION = getCurrentLocation(currentLocation);
//		System.out.println("Your current location is: " + LOCATION);
		if (currentLocation[2] == 0){
			if(currentLocation[1]<5){
				currentLocation[1] += 1;
			} else {
				System.out.println("The robot is now at the edge of the board - no movement is allowed");
			}
		} if (currentLocation[2] == 1){
			if(currentLocation[1]>1){
				currentLocation[1] -= 1;
			} else {
				System.out.println("The robot is now at the edge of the board - no movement is allowed");
			}
		} if (currentLocation[2] == 2){
			if(currentLocation[0]<5){
				currentLocation[0] += 1;
			} else {
				System.out.println("The robot is now at the edge of the board - no movement is allowed");
			}
		} if (currentLocation[2] == 3){
			if(currentLocation[0]>1){
				currentLocation[0] -= 1;
			} else {
				System.out.println("The robot is now at the edge of the board - no movement is allowed");
			}
		}
		return currentLocation;
	}
	
	public boolean finish(){
		return true;
	}
	
	public void reset(){
		 Scanner gameOption = new Scanner(System.in);
		 System.out.println("Please select 0 to reset the game or any other key to finish");
		 Integer option = gameOption.nextInt();
		 System.out.println("You chose" + option);
		 if (option == 0){
			gameOption.close();
			play();
		 } else {
			gameOption.close();
			finish();
		 }
	}
}
