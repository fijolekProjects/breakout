import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;
import java.util.Random;

public class Platform {

    private int height = 10;
    private int width = 80;
    private int x;
    private int y;

    Image platR, platB, platC, platO, platY, platLG;
    URL url;

    public Platform(int x, int y) {
	this.x = x;
	this.y = y;
	platR = Pictures.brickR;
	platB = Pictures.brickB;
	platC = Pictures.brickC;
	platO = Pictures.brickO;
	platY = Pictures.brickY;
	platLG = Pictures.brickLG;
    }

    private void checkForCollision(Ball b, StartingPoint sp, Item[] item, Paddle p) {
	int ballX = b.getX();
	int ballY = b.getY();
	int radius = b.getRadius();
	if (ballY + radius - 2 > y && ballY + radius < y + height + 2) {
	    if (ballX + radius > x && ballX + radius < x + width) {

		b.setY(y);
		b.setDy(b.getDy() * (-1));
		x = 1000;
		y = 1000;
		int dispScore = sp.getScore();
		dispScore += 10;
		sp.setScore(dispScore);
		sp.setIsCollision(1);
		Pictures.coin.play();

		Random r = new Random();

		int itemVisibilty = r.nextInt(15);
		if (itemVisibilty % 2 == 0) {
		    int whichItem = r.nextInt(item.length);
		    if (item[whichItem].getY() > p.getY()) {
			item[whichItem].setX(ballX + 2);
			item[whichItem].setY(ballY);
		    }
		}
	    }
	}

    }

    public void update(StartingPoint sp, Ball b, Item[] item, Paddle p) {
	checkForCollision(b, sp, item, p);

    }

    public void paintO(Graphics g) {
	g.drawImage(platO, x, y, width, height, Pictures.sp);
    }

    public void paintR(Graphics g) {
	g.drawImage(platR, x, y, width, height, Pictures.sp);
    }

    public void paintY(Graphics g) {
	g.drawImage(platY, x, y, width, height, Pictures.sp);
    }

    public void paintC(Graphics g) {
	g.drawImage(platC, x, y, width, height, Pictures.sp);
    }

    public void paintLG(Graphics g) {
	g.drawImage(platLG, x, y, width, height, Pictures.sp);
    }

    public void paintB(Graphics g) {
	g.drawImage(platB, x, y, width, height, Pictures.sp);
    }
}
