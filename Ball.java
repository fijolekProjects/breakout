import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;
import java.util.Random;

public class Ball {
    private int x;
    private int y;
    private double dx;
    private double dy;
    private int radius;
    Image ballGr, ballGrCopy;
    URL url;

    public Ball(StartingPoint sp, Paddle p) {
	getStarted(sp, p, this);
	radius = 7;
	ballGr = Pictures.ballG;
    }

    public void speedUp() {
	if (dx > 0) {
	    dx += 2;
	} else {
	    dx -= 2;
	}
    }

    public void slowDown() {
	if (dx <= 0) {
	    dx += 2;
	} else {
	    dx -= 2;
	}
    }

    public double getDx() {
	return dx;
    }

    public void setDx(double dx) {
	this.dx = dx;
    }

    public double getDy() {
	return dy;
    }

    public void setDy(double dy) {
	this.dy = dy;
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

    public int getRadius() {
	return radius;
    }

    public void setRadius(int radius) {
	this.radius = radius;
    }

    public void shootTheBall(Paddle p, StartingPoint sp) {
	if (dx == 0) {
	    Random r = new Random();
	    dy = 7;
	    Random rand = new Random();
	    boolean plusOrMinus = rand.nextBoolean();
	    if (plusOrMinus) {
		dx = 1 * ((r.nextInt(1000) % 6) + 1);
	    } else {
		dx = -1 * ((r.nextInt(1000) % 6) + 1);
	    }
	    y = p.getY() + 2;
	}
    }

    public void update(StartingPoint sp, Paddle p) {
	if (x + dx > sp.getWidth() - radius - 1) {
	    x = sp.getWidth() - radius - 1;
	    dx = -dx;
	} else if (x + dx < radius) {
	    x = radius;
	    dx = -dx;
	} else {
	    x += dx;
	}
	if (y + dy > sp.getHeight() - radius - 1) {
	    getStarted(sp, p, this);
	    Pictures.fallingDown.play();
	} else if (y + dy < radius) {
	    y = radius;
	    dy = -dy;
	} else {
	    y += dy;
	}
    }

    private void getStarted(StartingPoint sp, Paddle p, Ball b) {
	sp.setLives(sp.getLives() - 1);
	p.setWidth(100);
	y = p.getY() - 15;
	dy = 0;
	dx = 0;
	int x_start = p.getX();
	x_start = sp.getWidth() / 2 - p.getWidth() / 2;
	p.setX(x_start);
	x = x_start + p.getWidth() / 2 - 5;

	for (int i = 0; i < sp.item.length; i++) {
	    sp.item[i].setX(1000);
	    sp.item[i].setY(1000);
	}

    }

    public void paint(Graphics g) {
	g.drawImage(ballGr, x, y, 2 * radius, 2 * radius, Pictures.sp);
	g.drawImage(ballGrCopy, x, y, 2 * radius, 2 * radius, Pictures.sp);
    }
}
