import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.URL;
import java.util.Timer;
import java.util.TimerTask;

public class StartingPoint extends Applet implements Runnable, KeyListener {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    Paddle p;
    Ball b;
    Item[] item = new Item[5];
    private int score;
    private int isCollision;
    private int lives = 4;
    int backX = 0;
    URL url;
    Image backGscore, backGdefault;

    Platform brick1[] = new Platform[9];
    Platform brick2[] = new Platform[9];
    Platform brick3[] = new Platform[9];
    Platform brick4[] = new Platform[9];
    Platform brick5[] = new Platform[9];
    Platform brick6[] = new Platform[9];
    Platform brick7[] = new Platform[9];
    Platform brick8[] = new Platform[9];
    Platform brick9[] = new Platform[9];
    Platform brick10[] = new Platform[9];
    Platform brick11[] = new Platform[9];
    Platform brick12[] = new Platform[9];

    private int MAX_WIDTH = 740;
    private int MAX_HEIGHT = 720;

    public static void main(String[] args) {
	new StartingPoint().start();
    }

    public void createPlatform() {
	for (int i = 0; i < 9; i++) {
	    brick1[i] = new Platform(i * 80 + 10, 40);
	    brick2[i] = new Platform(i * 80 + 10, 55);
	    brick3[i] = new Platform(i * 80 + 10, 70);
	    brick4[i] = new Platform(i * 80 + 10, 85);
	    brick5[i] = new Platform(i * 80 + 10, 100);
	    brick6[i] = new Platform(i * 80 + 10, 115);
	    brick7[i] = new Platform(i * 80 + 10, 130);
	    brick8[i] = new Platform(i * 80 + 10, 145);
	    brick9[i] = new Platform(i * 80 + 10, 160);
	    brick10[i] = new Platform(i * 80 + 10, 175);
	    brick11[i] = new Platform(i * 80 + 10, 190);
	    brick12[i] = new Platform(i * 80 + 10, 205);

	}
    }

    private void displayScore(Graphics g) {
	if (score < 100) {
	    g.drawImage(Pictures.numbers[score / 10], this.getWidth() - 100, 1, this);
	    g.drawImage(Pictures.numbers[0], this.getWidth() - 80, 1, this);
	} else if (score >= 100 && score < 1000) {
	    g.drawImage(Pictures.numbers[score / 100], this.getWidth() - 120, 1, this);
	    g.drawImage(Pictures.numbers[(score % 100) / 10], this.getWidth() - 100, 1, this);
	    g.drawImage(Pictures.numbers[0], this.getWidth() - 80, 1, this);
	} else if (score >= 1000 && score < 10000) {
	    g.drawImage(Pictures.numbers[score / 1000], this.getWidth() - 140, 1, this);
	    g.drawImage(Pictures.numbers[(score % 1000) / 100], this.getWidth() - 120, 1, this);
	    g.drawImage(Pictures.numbers[((score % 1000) % 100) / 10], this.getWidth() - 100, 1,
		    this);
	    g.drawImage(Pictures.numbers[0], this.getWidth() - 80, 1, this);
	}
    }

    public void setLives(int lives) {
	this.lives = lives;
    }

    public int getLives() {
	return lives;
    }

    public int getIsCollision() {
	return isCollision;
    }

    public void setIsCollision(int isCollision) {
	this.isCollision = isCollision;
    }

    public int getScore() {
	return score;
    }

    public void setScore(int score) {
	this.score = score;
    }

    public int getMAX_WIDTH() {
	return MAX_WIDTH;
    }

    public int getMAX_HEIGHT() {
	return MAX_HEIGHT;
    }

    public void init() {
	this.setSize(MAX_WIDTH, MAX_HEIGHT);
	addKeyListener(this);
	try {
	    url = getDocumentBase();
	} catch (Exception e) {
	    // TODO: handle exception
	}

    }

    public void start() {
	new Pictures(this);
	Pictures.mainTheme.loop();
	item[0] = new speedUp(900);
	item[1] = new speedDown(900);
	item[2] = new paddleSpread(900);
	item[3] = new paddleShrink(900);
	item[4] = new extraLive(900);

	p = new Paddle();
	b = new Ball(this, p);

	createPlatform();

	Thread thread = new Thread(this);
	thread.start();

    }

    public void stop() {
	this.removeAll();
    }

    @Override
    public void run() {
	while (true) {

	    p.update(this, b);
	    b.update(this, p);
	    for (int i = 0; i < item.length; i++) {
		item[i].update(this, p, b);
	    }

	    for (int i = 0; i < 9; i++) {
		brick1[i].update(this, b, item, p);
		brick2[i].update(this, b, item, p);
		brick3[i].update(this, b, item, p);
		brick4[i].update(this, b, item, p);
		brick5[i].update(this, b, item, p);
		brick6[i].update(this, b, item, p);
		brick7[i].update(this, b, item, p);
		brick8[i].update(this, b, item, p);
		brick9[i].update(this, b, item, p);
		brick10[i].update(this, b, item, p);
		brick11[i].update(this, b, item, p);
		brick12[i].update(this, b, item, p);

	    }
	    if (b.getDx() == 0 && b.getY() != p.getY() - 15) {
		b.setDx(1);
	    }

	    repaint();
	    try {
		Thread.sleep(20);
	    } catch (InterruptedException e) {
		e.printStackTrace();
	    }
	    if (lives == 0) {
		score = 0;
		lives = 3;
		createPlatform();
	    }

	}
    }

    @Override
    public void keyPressed(KeyEvent e) {
	// TODO Auto-generated method stub
	switch (e.getKeyCode()) {
	case KeyEvent.VK_A:
	    p.moveLeft(b);
	    break;
	case KeyEvent.VK_D:
	    p.moveRight(this, b);
	    break;
	case KeyEvent.VK_SPACE:
	    b.shootTheBall(p, this);
	    break;
	}
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent arg0) {
	// TODO Auto-generated method stub

    }

    private Image i;
    private Graphics doubleG;

    public void update(Graphics g) {
	if (i == null) {
	    i = createImage(this.getSize().width, this.getSize().height);
	    doubleG = i.getGraphics();
	}
	getBackground();
	doubleG.setColor(Color.BLACK);
	doubleG.fillRect(0, 0, this.getSize().width, this.getSize().height);
	doubleG.setColor(getForeground());
	paint(doubleG);
	g.drawImage(i, 0, 0, this);

    }

    public void paint(Graphics g) {
	g.drawImage(Pictures.backGdefault, backX, 0, this);

	for (int i = 0; i < lives; i++) {
	    g.drawImage(Pictures.heart, this.getWidth() - 50 - 40 * i, 655, this);
	}
	if (isCollision == 1) {
	    Timer t = new Timer();
	    g.drawImage(Pictures.backGscore, backX, 0, this);

	    TimerTask task = new TimerTask() {
		public void run() {
		    isCollision = 0;
		}
	    };

	    t.schedule(task, 450);
	}

	p.paint(g);
	b.paint(g);
	for (int i = 0; i < item.length; i++) {
	    item[i].paint(g);
	}

	for (int i = 0; i < 9; i++) {
	    brick1[i].paintR(g);
	    brick2[i].paintR(g);
	    brick3[i].paintO(g);
	    brick4[i].paintO(g);
	    brick5[i].paintY(g);
	    brick6[i].paintY(g);
	    brick7[i].paintLG(g);
	    brick8[i].paintLG(g);
	    brick9[i].paintC(g);
	    brick10[i].paintC(g);
	    brick11[i].paintB(g);
	    brick12[i].paintB(g);
	}
	displayScore(g);

    }

}
