import java.awt.Graphics;

public class extraLive extends Item {

    public extraLive(int y) {
	super(y);
	// TODO Auto-generated constructor stub
    }

    @Override
    public void performAction(StartingPoint sp) {
	sp.setLives(sp.getLives() + 1);
	Pictures.heartbeat.play();
    }

    public void paint(Graphics g) {
	g.drawImage(Pictures.heart, getX(), getY(), 2 * getRadius(), 2 * getRadius(), Pictures.sp);
    }
}
