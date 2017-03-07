/**
* Created by Andrew Kerton 5/3/17.
*/
import java.util.Scanner;
import java.util.Arrays; //for debugging
import java.io.FileReader;
import java.io.FileNotFoundException;

public class RobotMovement {

	public static void main(String[] args) {
		System.out.println("Robot Movement");

		Robot robot = new Robot(5);

		String basicInvalidString = "Invalid input! Try PLACE <int>,<int>,<north|east|south|west> | MOVE | LEFT | RIGHT | REPORT.";
		String placeInvalidString = "Invalid place! Try PLACE <int>,<int>,<north|east|south|west>";
		String moveInvalidString = "Invalid move! The robot must stay on the table";
		boolean generalError;
		boolean placeError;
		boolean moveError;
		boolean readingFile = false;

		String command;
		Scanner in;

		try {

			if(args.length == 1) {
				in = new Scanner(new FileReader(args[0]));
				readingFile	= true;
			} else
				in = new Scanner(System.in);
			
			System.out.print("Please enter a command: ");
			command = in.nextLine();
			String[] commandArgs;

			while(!command.equalsIgnoreCase("q") && !command.equalsIgnoreCase("quit")) {
				generalError = false;
				placeError = false;
				moveError = false;

				commandArgs = command.trim().toUpperCase().split(" |,");
				if(readingFile) System.out.println(Arrays.toString(commandArgs));

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
								moveError = true;
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
					System.out.println(placeInvalidString);
				if(moveError) 
					System.out.println(moveInvalidString);
				else if (generalError)
					System.out.println(basicInvalidString);

				System.out.print("Please enter a command: ");
				command = in.nextLine();
			}
			in.close();
		}
		catch (FileNotFoundException e) {
			System.out.print("File not found");
			command = "q";
		}	
		catch(Exception e){
			System.out.print("Something went wrong. Quiting");
			command = "q";
		}
	}
}
