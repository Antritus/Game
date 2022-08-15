package com.gmail.antcoreservices.games.laura.main;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.net.URL;

public class Sound {
	Clip clip;
	URL soundURL[] = new URL[30];

	public Sound() {
		String folder = "/sound/";
		soundURL[0] = getClass().getResource(folder+"BlueBoyAdventure.wav");
		soundURL[1] = getClass().getResource(folder+"coin.wav");
		soundURL[2] = getClass().getResource(folder+"powerup.wav");
		soundURL[3] = getClass().getResource(folder+"unlock.wav");
		soundURL[4] = getClass().getResource(folder+"fanfare.wav");
	}

	public void setFile(int index) {
		try {
			AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL[index]);
			clip = AudioSystem.getClip();
			clip.open(ais);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void play(){
		clip.start();
	}
	public void loop(){
		clip.loop(clip.LOOP_CONTINUOUSLY);

	}
	public void stop() {
		clip.stop();
	}
}
