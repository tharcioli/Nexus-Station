package controller;

import javax.sound.sampled.*;
import java.io.File;

public class TapSong {
    public static void getSong() {
        new Thread(() -> {
            try {
                AudioInputStream audioStream = AudioSystem.getAudioInputStream(new File("MenuSongs/tapSong.wav"));
                Clip clip = AudioSystem.getClip();

                clip.addLineListener(event -> {
                    if (event.getType() == LineEvent.Type.STOP)
                        clip.close();
                });

                clip.open(audioStream);
                clip.start();

            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }).start();
    }
}
