import java.io.BufferedInputStream;
import java.net.URL;
import java.util.ArrayList;

import javazoom.jl.player.Player;

public class Players2 {

	ArrayList<String> l = new ArrayList<String>();
	BufferedInputStream b;
	InYourFace iy;

	public Players2(InYourFace iy){
		this.iy=iy;
	}
	
	SThread g;
	public class SThread extends Thread{
	public void run() {
		g=this;
			for (int i=iy.pos; iy.pos < l.size(); iy.pos++) {
				iy.jLabel1.setText("  "+((l.size()>0)?iy.pos+1:0)+" von "+l.size());
				long tm = System.currentTimeMillis();
				do {
					try {
						//System.out.println("try" + iy.pos);
						new Player(b= new BufferedInputStream(new URL(l.get(iy.pos)).openStream())).play();
						Thread.sleep(1000);
					} catch (Exception e) {
						//System.out.print(" nah");
					}
				} while (System.currentTimeMillis() < tm + 10000);
			}
		}
	}
	

	public void add(String URLtoMP3) {
		if (URLtoMP3.indexOf("mp3", URLtoMP3.length() - 4) == -1) {
			URLtoMP3 = "http://www.youtubeinmp3.com/fetch/?video=" + URLtoMP3;
		}
		l.add(URLtoMP3);
	}
	
}
