import java.awt.Graphics;

public class speedDown extends Item {

    public speedDown(int y) {
	super(y);
	// TODO Auto-generated constructor stub
    }

    @Override
    public void performAction(Ball b) {
	if (b.getDx() <= 0) {
	    b.setDx(b.getDx() + 2);
	} else {
	    b.setDx(b.getDx() - 2);
	}
    }

    public void paint(Graphics g) {
	// TODO Auto-generated method stub
	g.drawImage(Pictures.speedDown, getX(), getY(), 2 * getRadius(), 2 * getRadius(),
		Pictures.sp);

    }

}
