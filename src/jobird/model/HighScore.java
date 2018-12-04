package jobird.model;

public class HighScore {

    private int score = 0;

    private int highScore = 0;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getHighScore() {
        return highScore;
    }

    public void setHighScore(int highScore) {
        this.highScore = highScore;
    }

    public void erhöheScore() {
        score += 1;
    }
}
