/**
* Created by Andrew Kerton 5/3/17.
*/
import java.util.Scanner;

public class RobotMovement {

	public static void main(String[] args) {
		System.out.println("Robot Movement");

		Robot robot = new Robot(5);
		Scanner in = new Scanner(System.in);
		
		System.out.print("Please enter a command: ");
		String command = in.nextLine();
		String[] commandArgs;

		while(!command.equalsIgnoreCase("q") && !command.equalsIgnoreCase("quit")) {
			commandArgs = command.toUpperCase().split(" |,");

			switch(commandArgs[0].toUpperCase()){
				case "PLACE":
					int f = -1;
					switch(commandArgs[3]) {
						case "NORTH": f = 0;
						break;
						case "EAST": f = 1;
						break;
						case "SOUTH": f = 2;
						break;
						case "WEST": f = 3;
						break;
						default: System.out.println("Invalid input! Try PLACE X,Y,F"); break;
					}
					robot.place(Integer.parseInt(commandArgs[1]), Integer.parseInt(commandArgs[2]), f);
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
					System.out.println("Invalid input! Try PLACE <int>,<int>,<north|east|south|west> | MOVE | LEFT | RIGHT | REPORT."); break;
			}

			System.out.print("Please enter a command: ");
			command = in.nextLine();

		}
		in.close();
	}
}
