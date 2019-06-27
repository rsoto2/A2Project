package com.mycompany.a2;
import java.io.IOException;
import java.io.InputStream;
import com.codename1.media.MediaManager;
import com.codename1.ui.Display;
import com.codename1.media.Media;

public class PlaySound {

	public void PlaySound(String fileName)
	{
		try {
			InputStream is = Display.getInstance().getResourceAsStream(getClass(), "/" + fileName);
			Media m = MediaManager.createMedia(is, "audio/wav");
			m.play();
		}
		
		catch (IOException e) {
			e.printStackTrace();
			
		}
	}
	
	
	public void sound()
	{
		PlaySound("frogs.wav");
	}
	
	
	


}
