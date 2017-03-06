/**
* Created by Andrew Kerton 5/3/17.
*/
import java.util.Scanner;

public class RobotMovement {

	public static void main(String[] args) {
		System.out.println("Robot Movement");

		Robot robot = new Robot(5);
		Scanner in = new Scanner(System.in);
		String command = "";
		String[] commandArgs;

		while(!command.equalsIgnoreCase("q") || !command.equalsIgnoreCase("quit")) {
			System.out.print("Please enter a command: ");
			command = in.nextLine();
			commandArgs = command.split("\\s+");

			switch(commandArgs[0].toUpperCase()){
				case "PLACE": 
				break;
				case "MOVE": 	
				break;
				case "LEFT": 
				break;
				case "RIGHT":
				break;
				case "REPORT": 
				break;
				default : System.out.println("Invalid input! Try PLACE X,Y,F | MOVE | LEFT | RIGHT | REPORT."); break;
			}

			System.out.println("You entered: " + commandArgs[0]);
		}
		in.close();
	}
}
