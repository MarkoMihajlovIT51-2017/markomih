package shapes;

import java.awt.Color;
import java.awt.Graphics;

public class Rectangle extends Shape{
	private Point upperLeftPoint;
	private int width;
	private int height;
	private Color fill;
	private boolean potvrda;
	private Color border;
	public Color getBorder() {
		return border;
	}

	public void setBorder(Color border) {
		this.border = border;
	}

	public Color getFill() {
		return fill;
	}

	public void setFill(Color fill) {
		this.fill = fill;
	}

	public boolean isPotvrda() {
		return potvrda;
	}

	public void setPotvrda(boolean potvrda) {
		this.potvrda = potvrda;
	}

	//-----------------------------------------------------KONSTRUKTORI-----------------------------------------------------
	public Rectangle() {

	}

	public Rectangle(Point upperLeftPoint, int width, int height) {
		this.upperLeftPoint = upperLeftPoint;
		this.width = width;
		this.height = height;
	}

	public Rectangle(Point upperLeftPoint,int width, int height, boolean selected) {
		this(upperLeftPoint,width,height);
		this.selected = selected;
	}
	public Rectangle(int x, int y, int width, int height)
	{
		upperLeftPoint.setX(x);
		upperLeftPoint.setY(y);
		this.width = width;
		this.height = height;
	}
	
	
	//-----------------------------------------------------KONSTRUKTORI-----------------------------------------------------

	//-----------------------------------------------------GET SET METODE-----------------------------------------------------
	public Point getUpperLeftPoint() {
		return upperLeftPoint;
	}

	public void setUpperLeftPoint(Point upperLeftPoint) {
		this.upperLeftPoint = upperLeftPoint;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	//-----------------------------------------------------GET SET METODE-----------------------------------------------------

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		if(o instanceof Rectangle)
			return this.area() - ((Rectangle)o).area();
		return 0;
	}

	public boolean contains(int x, int y) {
		return (x >= upperLeftPoint.getX() &&
				x <= upperLeftPoint.getX() + width &&
				y >= upperLeftPoint.getY() &&
				y <= upperLeftPoint.getY() + height);
	}

	public boolean contains(Point p) {
		return this.contains(p.getX(), p.getY());
	}

	public void draw(Graphics g) {
		g.setColor(border);
		g.drawRect(upperLeftPoint.getX(), upperLeftPoint.getY(), width, height);
		g.setColor(Color.WHITE);
		g.setColor(fill);
		g.fillRect(upperLeftPoint.getX()+1, upperLeftPoint.getY()+1, width-1, height-1);
		g.setColor(Color.BLACK);
		if (isSelected()) {
			g.setColor(Color.BLUE);
			g.drawRect(upperLeftPoint.getX() - 3, upperLeftPoint.getY() - 3, 6, 6);
			g.drawRect(upperLeftPoint.getX() + width - 3, upperLeftPoint.getY() - 3, 6, 6);
			g.drawRect(upperLeftPoint.getX() - 3, upperLeftPoint.getY() + height - 3, 6, 6);
			g.drawRect(upperLeftPoint.getX() + width  - 3, upperLeftPoint.getY() + height - 3, 6, 6);
		}
	}
	public int area() {
		return width*height;
	}
	@Override
	public String toString() {
		return "Pravougaonik : "+"Upper Left Point : " + "(" + upperLeftPoint.getX() + "," + upperLeftPoint.getY() + ")" +", Width: " + width + ", Height: " + height;
	}
}
