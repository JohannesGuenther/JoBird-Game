package jobird.model;


import javafx.scene.image.Image;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Flappy {

    private double posX = 500;
    private double posY = 500;
    private double flappySize = 60;


    Image imagef1;

    {
        try {
            imagef1 = new Image(new FileInputStream("C:/Users/johan/GitHub/jobird/src/jobird/P05_flappyImages/flappy1.png"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    Image imagef2;

    {
        try {
            imagef2 = new Image(new FileInputStream("C:/Users/johan/GitHub/jobird/src/jobird/P05_flappyImages/flappy2.png"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    Image imagef3;

    {
        try {
            imagef3 = new Image(new FileInputStream("C:/Users/johan/GitHub/jobird/src/jobird/P05_flappyImages/flappy3.png"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Flappy() {
    }

    public double getPosX() {
        return posX;
    }

    public double getPosY() {
        return posY;
    }

    public double getFlappySize() {
        return flappySize;
    }

    public void setPosY(double posY) {
        this.posY = posY;
    }

    public Image getImagef1() {
        return imagef1;
    }

    public Image getImagef2() {
        return imagef2;
    }

    public Image getImagef3() {
        return imagef3;
    }

    public void flappyDown(double posY) {
        this.posY = posY + 2;
    }

    public boolean flappyPassedRoehre(Roehre roehre, Flappy flappy) {

        if (flappy.getPosX() == roehre.getPosX() + roehre.getBreiteRoehre()) {
            return true;
        } else {
            return false;
        }
    }
}
