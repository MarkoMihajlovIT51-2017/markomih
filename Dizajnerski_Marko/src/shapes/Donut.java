package shapes;

import java.awt.Color;
import java.awt.Graphics;

public class Donut extends Circle{

	private int innerRadius;
	private Color fill = new Color(255,255,255,0);
	private boolean potvrda;
	private Color border;
	private boolean fillPotvrda;
	
	public boolean isFillPotvrda() {
		return fillPotvrda;
	}

	public void setFillPotvrda(boolean fillPotvrda) {
		this.fillPotvrda = fillPotvrda;
	}

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
	public Donut() {
		
	}
	
	public Donut(Point center, int outerRadius, int innerRadius) {
		super(center,outerRadius);
		this.innerRadius = innerRadius;
	}
	
	public Donut(Point center, int outerRadius, int innerRadius, boolean selected) {
		this(center, outerRadius, innerRadius);
		this.selected = selected;
	}
	//-----------------------------------------------------KONSTRUKTORI-----------------------------------------------------
	//-----------------------------------------------------TOSTRING, AREA, CONTAINS, DRAW-----------------------------------------------------
	public String toString() {
		return "Donut : " + "Center : " + "(" + center.getX() + "," + center.getY() + ")" + ", Outer Radius : " + r + ", Inner Radius : " + innerRadius;
	}
	
	public double area() {
		return super.area() - (innerRadius * innerRadius * Math.PI);
	}
	
	public boolean contains(int x, int y) {
		return super.contains(x, y) && center.distance(x, y) > innerRadius;
	}
	
	public void draw(Graphics g) {
		g.setColor(border);
		g.drawOval(center.getX() - innerRadius, center.getY() - innerRadius, 2 * innerRadius, 2 * innerRadius);
		g.drawOval(center.getX()-r, center.getY()-r, 2*r, 2*r);
			g.setColor(fill);
			g.fillOval(center.getX()-super.r, center.getY()-super.r, super.r*2, super.r*2);
			g.setColor(Color.white);
			g.fillOval(center.getX() - innerRadius, center.getY() - innerRadius, 2 * innerRadius, 2 * innerRadius);
			g.setColor(Color.BLACK);
		
		
		if (isSelected()) {
			g.setColor(Color.BLUE);
			g.drawRect(this.getCenter().getX() - innerRadius - 3, this.getCenter().getY() - 3, 6, 6);
			g.drawRect(this.getCenter().getX() + innerRadius - 3, this.getCenter().getY() - 3, 6, 6);
			g.drawRect(this.getCenter().getX() - 3, this.getCenter().getY() - innerRadius - 3, 6, 6);
			g.drawRect(this.getCenter().getX() - 3, this.getCenter().getY() + innerRadius - 3, 6, 6);
		}
	}
	//-----------------------------------------------------TOSTRING, AREA, CONTAINS, DRAW-----------------------------------------------------
	
	//-----------------------------------------------------GET SET METODE-----------------------------------------------------
	public int getInnerRadius() {
		return innerRadius;
	}

	public void setInnerRadius(int innerRadius) {
		this.innerRadius = innerRadius;
	}
	//-----------------------------------------------------GET SET METODE-----------------------------------------------------
}
