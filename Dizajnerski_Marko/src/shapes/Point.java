package shapes;

import java.awt.Color;
import java.awt.Graphics;

public class Point extends Shape{
	private int x;
	private int y;
	private boolean selected;
	private Color Color;
	private boolean potvrda;
	
	public boolean isPotvrda() {
		return potvrda;
	}

	public void setPotvrda(boolean potvrda) {
		this.potvrda = potvrda;
	}

	public Color getColor() {
		return Color;
	}

	public void setColor(Color color) {
		Color = color;
	}

	//-----------------------------------------------------KONSTRUKTORI-----------------------------------------------------
	public Point() {
		
	}
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public Point(int x, int y, boolean selected) {
		this(x,y);
		this.selected = selected;
	}
	public Point(int x, int y, Color Color)
	{
		this(x,y);
		this.Color = Color;
	}
	//-----------------------------------------------------KONSTRUKTORI-----------------------------------------------------
	
	
	//-----------------------------------------------------TOSTRING,EQUALS,DISTANCE,COMPARETO,CONTAINS,MOVEBY,DRAW-----------------------------------------------------

	@Override
	public String toString() {
		return "Tacka: "+"("+x+","+y+")";
	}
	
	@Override 
	public boolean equals(Object obj) {
		Point temp;
		if(obj instanceof Point) {
			temp = (Point) obj;
					return (this.x == temp.x && this.y == temp.y);
		}
		return false;
	}
	
	public double distance(int x, int y) {
		int dx = this.x-x;
		int dy = this.y-y;
		double d = Math.sqrt(dx*dx+dy*dy);
		return d;
	}
	
	public int compareTo(Object o) {
		if(o instanceof Point)
			return (int) (this.distance(0,0)-((Point) o).distance(0,0));
		return 0;
	}
	
	public boolean contains(int x, int y) {
		return this.distance(x, y)<=3;
	}
	
	public void moveBy(int x, int y) {
		this.x += x;
		this.y += y;
	}
	
	public void draw(Graphics g) {
			g.setColor(Color);
			g.drawLine(x-2, y, x+2, y);
			g.drawLine(x, y-2, x, y+2);
			g.setColor(Color.BLACK);
		if(isSelected()) {
			g.setColor(Color.BLUE);
			g.drawRect(x-3, y-3, 6, 6);
		}
	}

	//-----------------------------------------------------TOSTRING,EQUALS,DISTANCE,COMPARETO,CONTAINS,MOVEBY,DRAW-----------------------------------------------------
	
	
	//-----------------------------------------------------GET SET METODE-----------------------------------------------------
	public boolean isSelected() {
		return selected;
	}
	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	//-----------------------------------------------------GET SET METODE-----------------------------------------------------
}
