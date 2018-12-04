package jobird.model;

import jobird.Main;

public class Kollission {

    private boolean kollission;
    private boolean outOfBounce;

    public boolean checkForCollission(Flappy flappy, Roehre roehre, Model model) {
        double durchFlugHoehe = model.getDurchFlugHoehe();
        double breiteRoehre = roehre.getBreiteRoehre();
        double posXRoehre = roehre.getPosX();
        double obereRoehre = roehre.getHoeheObereRoehre();

        double posYFlappy = flappy.getPosY();
        double posXFlappy = flappy.getPosX();
        double flappySize = flappy.getFlappySize();

        if ((((posYFlappy < obereRoehre) || (posYFlappy > obereRoehre + durchFlugHoehe)) && (posXFlappy + flappySize == posXRoehre)) || (((posXFlappy + flappySize) > (posXRoehre) && (posXFlappy) < (posXRoehre + breiteRoehre)) && (posYFlappy <= obereRoehre || posYFlappy >= (obereRoehre + durchFlugHoehe - flappySize))))  {
            kollission = true;
        } else {
            kollission = false;
        }

        return kollission;
    }

    public boolean isFlappyOutOfBounds(Flappy flappy) {
        double posYFlappy = flappy.getPosY();
        double flappySize = flappy.getFlappySize();
        if (posYFlappy < 0 || posYFlappy + flappySize > Main.HEIGHT) {
            outOfBounce = true;
        } else {
            outOfBounce = false;
        }
        return outOfBounce;
    }

}
