/* creates ship class, initializes basic variables of ship class */
public class Ship {
	private int size;
	private int x;
	private int y;
	private int x1;
	private int y1;
	public Ship (int x, int y, int x1, int y2) {
		this.x = x;
		this.y = y;
		this.x1 = x1;
		this.y1 = y1;
	}

  /* returns the size of the ship */
	public int getSize() {
		return size;
	}

  /* returns the x location of the ship */
	public int getX() {
		return x;
	}

  /* returns the y location of the ship */
	public int getY() {
		return y;
	}

  /* returns the x direction of the ship */
	public int getX1() {
		return x1;
	}

  /* returns the y direction the ship */
	public int getY1() {
		return y1; 
	}
}
