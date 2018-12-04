package jobird.model;

import jobird.Main;

public class Roehre {

    private int breiteRoehre = 80;
    private int durchFlugHoehe = 150;
    private int hoeheObereRoehre;
    private double posX;
    private double startPositionX = Main.WIDTH;

    public Roehre(int hoeheObereRoehre) {
        this.hoeheObereRoehre = hoeheObereRoehre;
        this.posX = startPositionX;
    }

    public int getBreiteRoehre() {
        return breiteRoehre;
    }

    public void setBreiteRoehre(int breiteRoehre) {
        this.breiteRoehre = breiteRoehre;
    }

    public int getDurchFlugHoehe() {
        return durchFlugHoehe;
    }

    public void setDurchFlugHoehe(int durchFlugHoehe) {
        this.durchFlugHoehe = durchFlugHoehe;
    }

    public int getHoeheObereRoehre() {
        return hoeheObereRoehre;
    }

    public void setHoeheObereRoehre(int hoeheObereRoehre) {
        this.hoeheObereRoehre = hoeheObereRoehre;
    }

    public double getStartPositionX() {
        return startPositionX;
    }

    public void setStartPositionX(double startPositionX) {
        this.startPositionX = startPositionX;
    }

    public double getPosX() {
        return posX;
    }

    public void setPosX(double posX) {
        this.posX = posX;
    }

    public void bewegeRoehre(Model model) {
        posX -= model.getGeschwindigkeit();
    }
}
