
class RobotGame {
	public static void main(String[] args) {
	   
		   Player Game = new Player();
		   Game.play();
		   
		   if (Game.finish() == true){
			   System.out.println("Thanks for playing Robot ... please play again soon");
			   System.exit(0);
		  } 
	}
}