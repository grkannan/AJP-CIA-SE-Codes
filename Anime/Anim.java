import java.applet.*;
import java.awt.*;
import java.awt.event.*;
/* <applet code="Anim.class" width="800" height="600"></applet> */
public class Anim extends Applet{
	int i = 10, j = 20, x = 500, y = 500;
	Image img, img1;
	public void init(){
		img = getImage(getCodeBase(), "Boy.png");
		img1 =getImage(getCodeBase(), "Tiger.png");
		System.out.println(img + "\n"+img1);
	}
	public void paint(Graphics g){
		g.drawImage(img, i, j, this);
		g.drawImage(img1, x, y, this);
		i += 20; j += 20;
		x-=10; y-=10;
		repaint(1000);
	}
}