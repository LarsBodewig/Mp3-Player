import java.io.BufferedInputStream;
import java.net.URL;
import java.util.ArrayList;

import javazoom.jl.player.Player;

public class Players {

	ArrayList<Player> l=new ArrayList<Player>();
	
	public static void main(String[] args) {
		Players p =new Players();
		p.add("https://www.youtube.com/watch?v=gL9wRsLHd98");
		p.add("https://www.youtube.com/watch?v=Tr32f6F23vY");
		p.play();
	}

	public void play() {
		for(int i=0; i<l.size(); i++){
				//long tm=System.currentTimeMillis();
				//do{
					try{
					System.out.println("try"+i);
					l.get(i).play();
				}catch(Exception e){
					System.out.println("nah");
				}
				//}while(System.currentTimeMillis()<tm+5000);
		}
	}
	
	public void add(String URLtoMP3){
		try{
			if(URLtoMP3.indexOf("mp3", URLtoMP3.length()-4)==-1){
				URLtoMP3="http://www.youtubeinmp3.com/fetch/?video="+URLtoMP3;
			}
			l.add(new Player(new BufferedInputStream(new URL(URLtoMP3).openStream())));
		}catch(Exception e){
			System.out.println("noope "+URLtoMP3);
		}
	}
    
}
