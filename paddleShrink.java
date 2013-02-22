import java.awt.Graphics;

public class paddleShrink extends Item {
    public paddleShrink(int y) {
	super(y);
	// TODO Auto-generated constructor stub
    }

    public void performAction(Paddle p) {
	// TODO Auto-generated method stub
	p.setX(p.getX() + 10);
	p.setWidth(p.getWidth() - 20);
	Pictures.paddleShrink.play();
    }

    public void paint(Graphics g) {
	// TODO Auto-generated method stub
	g.drawImage(Pictures.shrink, getX(), getY(), 2 * getRadius(), 2 * getRadius(), Pictures.sp);
    }
}
