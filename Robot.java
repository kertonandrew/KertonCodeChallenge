
/**
* Created by Andrew Kerton 5/3/17.
*/	

public class Robot {
	private int x;
	private int y;
	private int f;
	private int tableWidth;	

	public Robot(int tableWidth) {
		this.x = -1;
		this.y = -1;
		this.f = -1;

		this.tableWidth = tableWidth;
	}

	public boolean place(int x, int y, int f) {
		return true;
	}

	public boolean move(){
		return true;
	}

	public void left() {
		
	}

	public void right() {

	}

	public String report() {
		return x + "," + y + "," + this.direction();
	}

	private String direction() {
		String dir = "";
		switch(f) {
			case 0: dir = "NORTH"; 
			break;
			case 1: dir = "EAST"; 
			break;
			case 2: dir = "SOUTH"; 
			break;
			default: dir = "WEST"; 
			break;
		}
		return dir;
	}

}