import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;

public class Paddle {
    private int dx = 15;
    private int width = 100;
    private int height = 10;
    private int x = 370 - width / 2;
    private int y = 640;
    Image paddleGr;
    URL url;

    public Paddle() {
	// TODO Auto-generated constructor stub
	paddleGr = Pictures.paddleG;
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

    public int getDx() {
	return dx;
    }

    public void setDx(int dx) {
	this.dx = dx;
    }

    public void moveRight(StartingPoint sp, Ball b) {
	int max_w = sp.getMAX_WIDTH();
	if (x < max_w - width) {
	    x += dx;
	} else {
	    x = max_w - width;
	}
	if (b.getDx() == 0 && b.getY() == y - 15) {
	    int x_temp = b.getX();
	    b.setX(x_temp + dx);
	    if (x == sp.getMAX_WIDTH() - width) {
		b.setX(sp.getMAX_WIDTH() - width / 2 - b.getRadius());
	    }
	}
    }

    public void moveLeft(Ball b) {
	if (x > 0) {
	    x -= dx;
	} else {
	    x = 0;
	}
	if (b.getDx() == 0 && b.getY() == y - 15) {
	    int x_temp = b.getX();
	    b.setX(x_temp - dx);
	    if (x == 0) {
		b.setX(width / 2 - b.getRadius());
	    }
	}
    }

    public void update(StartingPoint sp, Ball b) {
	checkForCollision(b, sp);
    }

    private void checkForCollision(Ball b, StartingPoint sp) {
	int ballX = b.getX();
	int ballY = b.getY();
	int radius = b.getRadius();

	if (ballY + 2 * radius > y && ballY - radius < y + height) {
	    if (ballX + radius > x && ballX + radius < x + width) {
		double newDy = b.getDy() * -1;
		b.setY(y - radius);
		b.setDy(newDy);
		if (b.getDy() != 0) {
		    b.setDx(b.getDx());
		}
	    }
	}
    }

    public void paint(Graphics g) {
	g.drawImage(paddleGr, x, y, width, height, Pictures.sp);
    }
}