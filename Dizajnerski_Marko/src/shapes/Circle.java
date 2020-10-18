package shapes;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JOptionPane;



public class Circle extends Shape{
	protected Point center;
	protected int r;
	protected boolean selected;
	private Color Color;
	private Color border;
	private boolean potvrda;
	private boolean borderPotvrda;
	public boolean isBorderPotvrda() {
		return borderPotvrda;
	}

	public void setBorderPotvrda(boolean borderPotvrda) {
		this.borderPotvrda = borderPotvrda;
	}

	public Color getBorder() {
		return border;
	}

	public void setBorder(Color border) {
		this.border = border;
	}
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
	public Circle() {

	}

	public Circle(Point center, int r) {
		
				this.center = center;
				this.r = r;
	}

	public Circle(Point center, int r, boolean selected) {
		this(center, r);
		this.selected = selected;
	}


	//-----------------------------------------------------KONSTRUKTORI-----------------------------------------------------

	//-----------------------------------------------------TOSTRING,CONTAINS,DRAW,COMPARETO,AREA,MOVEBY-----------------------------------------------------
	public String toString() {
		return "Krug : " + "Center: " + "(" + center.getX() + "," + center.getY() + ") " + "Radius: "+ r;
	}

	public boolean contains(int x, int y) {
		double temp = center.distance(x, y);
		return temp <= r;
	}

	public void draw(Graphics g) {
		g.setColor(border);
		g.drawOval(center.getX()-r, center.getY()-r, 2*r, r+r);
		g.setColor(Color.BLACK);
		g.setColor(Color.WHITE);
		g.setColor(Color);
		g.fillOval(center.getX() - r, center.getY()-r, 2*r, 2*r);
		g.setColor(Color.BLACK);
		if (isSelected()) {
			g.setColor(Color.BLUE);
			g.drawRect(center.getX() - r - 3, center.getY() - 3, 6, 6);
			g.drawRect(center.getX() + r - 3, center.getY() - 3, 6, 6);
			g.drawRect(center.getX() - 3, center.getY() - r - 3, 6, 6);
			g.drawRect(center.getX() - 3, center.getY() + r - 3, 6, 6);
			g.drawRect(center.getX() - 3, center.getY() - 3, 6, 6);
		}
	}


	public int compareTo(Object o) {
		if(o instanceof Circle)
			return (int) ((this.area())-((Circle)o).area());
		return 0;
	}

	public double area() {
		return r*r*Math.PI;
	}

	public void moveBy(int x, int y) {
		center.moveBy(x, y);
	}
	//-----------------------------------------------------TOSTRING,CONTAINS,DRAW,COMPARETO,AREA,MOVEBY-----------------------------------------------------

	//-----------------------------------------------------GET SET METODE-----------------------------------------------------
	public Point getCenter() {
		return center;
	}

	public void setCenter(Point center) {
		this.center = center;
	}

	public int getR() {
		return r;
	}

	public void setR(int r) throws Exception{
		if(r>0)
			this.r = r;
		else
		{
			JOptionPane.showMessageDialog(null, "R mora biti veci od 0!");
		}
	}
	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}


	//-----------------------------------------------------GET SET METODE-----------------------------------------------------

}
