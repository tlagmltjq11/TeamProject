package prj;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

import javazoom.jl.player.Player;

public class Music extends Thread{
	
	private Player player;	
	private boolean isLoop; // �뷡�� ���ѹݺ������� ���� ����
	private File file;
	private FileInputStream fis;
	private BufferedInputStream bis;
	
	public Music(String name, boolean isLoop)
	{
		try {
			this.isLoop = isLoop;
			// music�̶�� �����ȿ� �ִ� �ش��̸��� ������ �����Ű�� ���� toURI�� ��ġ�� ������.
			file = new File(start.class.getResource("../music/" + name).toURI());
			fis = new FileInputStream(file);
			//�ش� ������ ���ۿ� ��Ƽ� �о�� �� �ֵ��� �Ѵ�.
			bis = new BufferedInputStream(fis);
			//player�� �ش� ������ ��´�.
			player = new Player(bis);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	// ���� �����ϴ� �޼ҵ�
	public void close()
	{
		isLoop = false;  // false ���� �־��ָ鼭 run�޼ҵ忡�� �� ����� �����Ŵ.
		player.close();
		this.interrupt(); //���� ����ϴ� �����带 ������.
	}
	
	
	// �����带 ����ϱ����� �� �ʿ��� run�޼ҵ�
	@Override
	public void run()
	{
		try {
			//isLoop���� true��� ���� ���ѹݺ���Ŵ.
			do {
				player.play();
			}while(isLoop);
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
}
