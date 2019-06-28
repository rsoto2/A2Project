package com.mycompany.a2;
import java.io.IOException;
import java.io.InputStream;
import com.codename1.media.MediaManager;
import com.codename1.ui.Display;
import com.codename1.media.Media;

public class PlaySound implements Runnable {
	Media m;
	public PlaySound(String fileName)
	{
		try {
			InputStream in = Display.getInstance().getResourceAsStream(getClass(), "/" + fileName);
			m = MediaManager.createMedia(in, "audio/wav", this);
			//m.play();
		}
		
		catch (IOException e) {
			e.printStackTrace();
			
		}
	}
	
	
	public void play()
	{
		//PlaySound("frogs.wav");
		m.play();
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		m.setTime(0);
		m.play();
		
	}
	
	
	
	


}
