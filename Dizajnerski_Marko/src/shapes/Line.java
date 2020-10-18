package shapes;

import java.awt.Color;
import java.awt.Graphics;

public class Line extends Shape{

	private Point startPoint;
	private Point endPoint;
	private boolean selected;
	private Color fill;
	private boolean potvrda;
	
	//-----------------------------------------------------KONSTRUKTORI-----------------------------------------------------
	
	public boolean isPotvrda() {
		return potvrda;
	}

	public void setPotvrda(boolean potvrda) {
		this.potvrda = potvrda;
	}

	public Color getFill() {
		return fill;
	}

	public void setFill(Color fill) {
		this.fill = fill;
	}

	public Line() {
		
	}
	
	public Line(Point startPoint, Point endPoint) {
		this.startPoint = startPoint;
		this.endPoint = endPoint;
	}
	
	public Line(Point startPoint, Point endPoint, boolean selected) {
		this(startPoint,endPoint);
		this.selected = selected;
	}
	//-----------------------------------------------------KONSTRUKTORI-----------------------------------------------------
	
	//-----------------------------------------------------TOSTRING,LENGTH,COMPARETO,CONTAINS,DRAW,MOVEBY-----------------------------------------------------
	public String toString() {
		return "Linija: "+ "(" + startPoint.getX() + "," + startPoint.getY()+")" + ">>>" + "(" + endPoint.getX() + "," + endPoint.getY()+")";
	}
	
	public double length() {
		double length = startPoint.distance(endPoint.getX(), endPoint.getY());
		return length;
	}
	
	public int compareTo(Object o) {
		if(o instanceof Line)
			return (int) (this.length() - ((Line)o).length());
		return 0;
	}
	
	public boolean contains(int x, int y) {
		double temp = startPoint.distance(x, y) + endPoint.distance(x, y);
		return temp - this.length() <=3;
	}
	
	public void draw(Graphics g) {
		g.setColor(fill);
		g.drawLine(startPoint.getX(), startPoint.getY(), endPoint.getX(), endPoint.getY());
		g.setColor(Color.BLACK);
		
		if(isSelected()) {
			g.setColor(Color.BLUE);
			g.drawRect(startPoint.getX()-3, startPoint.getY()-3, 6, 6);
			g.drawRect(endPoint.getX()-3, endPoint.getY()-3, 6, 6);
		}
	}
	
	public void moveBy(int x, int y) {
		startPoint.moveBy(x, y);
		endPoint.moveBy(x, y);
	}
	//-----------------------------------------------------TOSTRING,LENGTH,COMPARETO,CONTAINS,DRAW-----------------------------------------------------
	
	//-----------------------------------------------------GET SET METODE-----------------------------------------------------
	public Point getStartPoint() {
		return startPoint;
	}

	public void setStartPoint(Point startPoint) {
		this.startPoint = startPoint;
	}

	public Point getEndPoint() {
		return endPoint;
	}

	public void setEndPoint(Point endPoint) {
		this.endPoint = endPoint;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	//-----------------------------------------------------GET SET METODE-----------------------------------------------------
	
	
}
