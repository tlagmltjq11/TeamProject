package Model;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import Starter.Application;
import javazoom.jl.player.Player; //http://www.javazoom.net/javalayer/sources.html donwload!!!

public class Music extends Thread{
	private Player player;	
	private boolean isLoop; 
	private File file;
	private FileInputStream fis;
	private BufferedInputStream bis;
	
	public Music(String name, boolean isLoop)
	{
		try {
			this.isLoop = isLoop;
			String path = "src/music/" + name;
			player = new Player(new FileInputStream(path));
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void close()
	{
		isLoop = false;  
		player.close();
		this.interrupt(); 
	}
	
	@Override
	public void run()
	{
		try {
			do {
				player.play();
			}while(isLoop);
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}