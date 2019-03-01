package PROJECT_FINISH;

import java.applet.AudioClip;

public class Sound {

    AudioClip player;

    public Sound() {
    }

    public void AbrirFichero(String cad) {
        player = java.applet.Applet.newAudioClip(getClass().getResource(cad));
        player.play();
        
    }

}
