package jobird.model;

import jobird.Main;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Model {

    private int counter = 0;
    private int counter2 = 0;
    private int gameStatus = 0;
    private int durchFlugHoehe = 175;
    private double geschwindigkeit = 1;
    private Flappy flappy = new Flappy();
    private Sounds sounds = new Sounds();
    private Pictures pictures = new Pictures();
    private List<Roehre> roehreList = new ArrayList<>();
    private Kollission kollission = new Kollission();
    private HighScore highScore = new HighScore();

    public int getCounter() {
        return counter;
    }

    public int getGameStatus() {
        return gameStatus;
    }

    public int getDurchFlugHoehe() {
        return durchFlugHoehe;
    }

    public double getGeschwindigkeit() {
        return geschwindigkeit;
    }

    private int getZufallszahl() {
        return  (int) (Math.random() * (Main.HEIGHT - durchFlugHoehe - 99)) + 50;
    }

    public void setGameStatus(int gameStatus) {
        this.gameStatus = gameStatus;
    }

    public Flappy getFlappy() {
        return flappy;
    }

    public Sounds getSounds() {
        return sounds;
    }

    public Pictures getPictures() {
        return pictures;
    }

    public List<Roehre> getRoehreList() {
        return roehreList;
    }

    public HighScore getHighScore() {
        return highScore;
    }


    public void update(long deltaMillis) {
        counter += deltaMillis;

        if (gameStatus == 1) {
            counter2 += 1;
            getFlappy().flappyDown(getFlappy().getPosY());
            this.getSounds().fallSound();

            if (counter2 == 10) {
                roehreList.add(new Roehre(getZufallszahl()));
            } else if (counter2 % 500 == 0) {
                roehreList.add(new Roehre(getZufallszahl()));
            }

            for (Roehre roehre : roehreList) {
                roehre.bewegeRoehre(this);

                if (flappy.flappyPassedRoehre(roehre, getFlappy())) {
                    getHighScore().erhöheScore();
                    this.getSounds().punktSound();
                }
                if (kollission.isFlappyOutOfBounds(getFlappy()) || kollission.checkForCollission(getFlappy(), roehre, this)) {
                    this.getSounds().getroffenSound();
                    gameStatus = 2;
                }
            }

            roehreList.removeIf(new Predicate<Roehre>() {
                @Override
                public boolean test(Roehre roehre) {
                    return roehre.getPosX() < 0;
                }
            });
        }
    }

    public void resetCounter() {
        counter = 0;
        counter2 = 0;
    }

    public void resetGame() {
        flappy.setPosY(500);
        roehreList.removeIf(new Predicate<Roehre>() {
            @Override
            public boolean test(Roehre roehre) {
                return roehre.getPosX() < Main.WIDTH;
            }
        });
        if (highScore.getHighScore() < highScore.getScore()) {
            highScore.setHighScore(highScore.getScore());
        }
        highScore.setScore(0);
    }
}
