import java.applet.AudioClip;
import java.awt.Image;
import java.net.URL;

public class Pictures {

    static Image brickO, brickB, brickC, brickR, brickY, brickLG, ballG, ballGcopy, paddleG,
	    backGscore, backGdefault;
    static Image zero, one, two, three, four, five, six, seven, eight, nine;
    static Image heart, speedDown, speedUp, shrink, spread;
    static Image[] numbers = new Image[10];
    static AudioClip mainTheme, coin, paddleSpread, paddleShrink, heartbeat, fallingDown;
    URL url;
    static StartingPoint sp;

    public Pictures(StartingPoint sp) {
	// TODO Auto-generated constructor stub
	try {
	    url = sp.getDocumentBase();
	} catch (Exception e) {
	    // TODO: handle exception
	}
	brickR = sp.getImage(url, "images/brickR.png");
	brickB = sp.getImage(url, "images/brickB.png");
	brickC = sp.getImage(url, "images/brickC.png");
	brickO = sp.getImage(url, "images/brickO.png");
	brickY = sp.getImage(url, "images/brickY.png");
	brickLG = sp.getImage(url, "images/brickLG.png");
	ballG = sp.getImage(url, "images/ballG.png");
	ballGcopy = sp.getImage(url, "images/ballGcopy.png");
	paddleG = sp.getImage(url, "images/paddleG.png");
	backGscore = sp.getImage(url, "images/backGscore.gif");
	backGdefault = sp.getImage(url, "images/backGdefault.png");
	heart = sp.getImage(url, "images/heart.png");
	speedDown = sp.getImage(url, "images/speedDown.png");
	speedUp = sp.getImage(url, "images/speedUp.png");
	shrink = sp.getImage(url, "images/shrink.png");
	spread = sp.getImage(url, "images/spread.png");

	numbers[0] = sp.getImage(url, "images/0.png");
	numbers[1] = sp.getImage(url, "images/1.png");
	numbers[2] = sp.getImage(url, "images/2.png");
	numbers[3] = sp.getImage(url, "images/3.png");
	numbers[4] = sp.getImage(url, "images/4.png");
	numbers[5] = sp.getImage(url, "images/5.png");
	numbers[6] = sp.getImage(url, "images/6.png");
	numbers[7] = sp.getImage(url, "images/7.png");
	numbers[8] = sp.getImage(url, "images/8.png");
	numbers[9] = sp.getImage(url, "images/9.png");

	mainTheme = sp.getAudioClip(url, "sounds/mainTheme.au");
	coin = sp.getAudioClip(url, "sounds/coin.au");
	paddleSpread = sp.getAudioClip(url, "sounds/paddleSpread.au");
	paddleShrink = sp.getAudioClip(url, "sounds/paddleShrink.au");
	heartbeat = sp.getAudioClip(url, "sounds/heartbeat.au");
	fallingDown = sp.getAudioClip(url, "sounds/fallingDown.au");
    }
}
