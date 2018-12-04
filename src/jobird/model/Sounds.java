package jobird.model;

import javafx.scene.media.AudioClip;

public class Sounds {

    AudioClip flügelschlag = new AudioClip("file:src/Sounds/sfx_wing.wav");
    AudioClip fallen = new AudioClip("file:src/Sounds/sfx_swooshing.wav");
    AudioClip punkt = new AudioClip("file:src/Sounds/sfx_point.wav");
    AudioClip getroffen = new AudioClip("file:src/Sounds/sfx_hit.wav");

    public void flügelSound() {
        flügelschlag.play();
    }

    public void fallSound() {
        fallen.play();
    }

    public void punktSound() {
        punkt.play();
    }

    public void getroffenSound() {
        getroffen.play();
    }

}
