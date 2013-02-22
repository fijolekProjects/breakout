import java.awt.Graphics;

public abstract class Item {

    private int x, y, radius;
    private double dy;

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

    public double getDy() {
	return dy;
    }

    public void setDy(int dy) {
	this.dy = dy;
    }

    public int getRadius() {
	return radius;
    }

    public void setRadius(int radius) {
	this.radius = radius;
    }

    public Item(int y) {
	// TODO Auto-generated constructor stub
	this.y = y;
	dy = -2.0;
	radius = 20;
    }

    public void update(StartingPoint sp, Paddle p, Ball b) {
	y -= dy;
	checkForCollision(b, p, sp);
    }

    private void checkForCollision(Ball b, Paddle p, StartingPoint sp) {
	// TODO Auto-generated method stub
	if (y + radius > p.getY() && y < p.getY() + p.getHeight()) {
	    if (x + radius > p.getX() && x < p.getX() + p.getWidth()) {
		performAction(b);
		performAction(p);
		performAction(sp);
	    }
	}

    }

    private void restartItem() {
	x = 1000;
	y = 1000;
    }

    public void performAction(Ball b) {
	restartItem();
    }

    public void performAction(Paddle p) {
	restartItem();
    }

    public void performAction(StartingPoint sp) {
	restartItem();
    }

    public void paint(Graphics g) {
	// g.setColor(Color.RED);
	g.fillOval(x - radius, y - radius, 2 * radius, 2 * radius);
    }

}
