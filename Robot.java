
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
		if(x <= tableWidth && x >= 0 && y <= tableWidth && y >= 0 && f <= 3 && f >= 0) {
			this.x = x;
			this.y = y;
			this.f = f;
			return true;
		}
		return false;
	}

	public boolean move(){
		switch(f) {
			case 0: 
			if(x<5)
				++x;
			else
				return false;
			break;

			case 1: 
			if(y<5)
				++y;
			else
				return false;
			break;

			case 2: 
			if(x>0)
				--x;
			else
				return false;
			break;
			case 3: 

			if(y>0)
				--y;
			else
				return false;
			break;
		}
		return true;
	}

	public void left() {
		if(this.f != -1) {
			this.f = (this.f-1)%4;
		}
	}

	public void right() {
		if(this.f != -1) {
			this.f = (this.f+1)%4;
		}
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