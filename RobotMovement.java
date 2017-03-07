/**
* Created by Andrew Kerton 5/3/17.
*/
import java.util.Scanner;
import java.util.Arrays; //for debugging

public class RobotMovement {

	public static void main(String[] args) {
		System.out.println("Robot Movement");

		Robot robot = new Robot(5);
		String basicInvalidString = "Invalid input! Try PLACE <int>,<int>,<north|east|south|west> | MOVE | LEFT | RIGHT | REPORT.";
		boolean generalError;
		boolean placeError;
		Scanner in = new Scanner(System.in);
		
		System.out.print("Please enter a command: ");
		String command = in.nextLine();
		String[] commandArgs;

		while(!command.equalsIgnoreCase("q") && !command.equalsIgnoreCase("quit")) {
			generalError = false;
			placeError = false;

			commandArgs = command.trim().toUpperCase().split(" |,");

			System.out.println(Arrays.toString(commandArgs));

			if(commandArgs.length > 0) {
				switch(commandArgs[0].toUpperCase()) {
					case "PLACE":
						int f = -1;
						if(commandArgs.length == 4) {
							switch(commandArgs[3]) {
								case "NORTH": f = 0;
									break;
								case "EAST": f = 1;
									break;
								case "SOUTH": f = 2;
									break;
								case "WEST": f = 3;
									break;
								default: placeError = true; 
									break;
							}
							try {
								robot.place(Integer.parseInt(commandArgs[1]), Integer.parseInt(commandArgs[2]), f);
							} catch (Exception e) {
								placeError = true;
							}
						} else {
							placeError = true;
						}
						break;

					case "MOVE":
						if(!robot.move()) {
							System.out.println("Invalid move!");
						};
						break;

					case "LEFT": 
						robot.left();
						break;

					case "RIGHT": 
						robot.right();		
						break;

					case "REPORT": 
						String output = robot.report();
						if(!output.equals(""))
							System.out.println("OUTPUT: " + robot.report());
						break;

					default: 
						generalError = true;
						break;
				}
			}

			if(placeError) 
				System.out.println("Invalid place! Try PLACE <int>,<int>,<north|east|south|west>");
			else if (generalError)
				System.out.println(basicInvalidString);

			System.out.print("Please enter a command: ");
			command = in.nextLine();

		}
		in.close();
	}
}
