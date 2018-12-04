package jobird.model;

import javafx.scene.image.Image;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Pictures {

    Image hintergrund;
    {
        try {
            hintergrund = new Image(new FileInputStream("C:/Users/johan/GitHub/jobird/src/jobird/P05_flappyImages/blue-clouds-blue-sky-blue-hills-1399883.jpg"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    public Image getHintergrund() {
        return hintergrund;
    }
}
