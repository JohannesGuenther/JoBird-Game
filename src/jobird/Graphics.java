package jobird;

import jobird.model.Model;
import jobird.model.Roehre;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

public class Graphics {

    private Model model;
    private GraphicsContext gc;

    public Graphics(Model model, GraphicsContext gc) {
        this.model = model;
        this.gc = gc;
    }

    public void draw() {

        if (model.getGameStatus() == 0) {
            gc.setFill(Color.LIGHTSKYBLUE);
            gc.fillRect(0,0, Main.WIDTH, Main.HEIGHT);
            gc.setFill(Color.GREEN);
            gc.setFont(Font.font("comic sans ms", FontWeight.EXTRA_BOLD, FontPosture.REGULAR, 60));
            gc.fillText("Jo Bird", Main.WIDTH/3, Main.HEIGHT/2, Main.WIDTH/3);
            gc.setFont(Font.font("comic sans ms", FontWeight.NORMAL, FontPosture.ITALIC, 40));
            gc.fillText("Press 'Space' to start!", Main.WIDTH/3 - 40, Main.HEIGHT/2 + 70, Main.WIDTH/3);
        } else if (model.getGameStatus() == 1){

            gc.drawImage(model.getPictures().getHintergrund(), 0, 0, Main.WIDTH, Main.HEIGHT);

            if ((model.getCounter() / 50) % 3 == 1) {
                gc.drawImage(model.getFlappy().getImagef1(), model.getFlappy().getPosX(), model.getFlappy().getPosY());
            } else if ((model.getCounter() / 50) % 3 == 2) {
                gc.drawImage(model.getFlappy().getImagef2(), model.getFlappy().getPosX(), model.getFlappy().getPosY());
            } else if ((model.getCounter() / 50) % 3 == 0) {
                gc.drawImage(model.getFlappy().getImagef3(), model.getFlappy().getPosX(), model.getFlappy().getPosY());
            }
            zeichneRoehre();

            gc.setFill(Color.WHITE);
            gc.setFont(Font.font("comic sans ms", FontWeight.BOLD, FontPosture.REGULAR, 30));
            gc.fillText("High Score: " + model.getHighScore().getHighScore(), 30, 40);
            gc.fillText("Punkte: " + model.getHighScore().getScore(), 30, 80);
        } else if (model.getGameStatus() == 2) {
            gc.setFill(Color.MIDNIGHTBLUE);
            gc.fillRect(0,0, Main.WIDTH, Main.HEIGHT);

            if (model.getHighScore().getScore() > model.getHighScore().getHighScore()) {
                gc.setFill(Color.ORANGERED);
                gc.setFont(Font.font("comic sans ms", FontWeight.EXTRA_BOLD, FontPosture.REGULAR, 60));
                gc.fillText("New High Score!", Main.WIDTH/3 - 30, 200, Main.WIDTH/3);
            }

            gc.setFill(Color.ORANGERED);
            gc.setFont(Font.font("comic sans ms", FontWeight.EXTRA_BOLD, FontPosture.REGULAR, 60));
            gc.fillText("Game Over", Main.WIDTH/3, Main.HEIGHT/2, Main.WIDTH/3);
            gc.setFont(Font.font("comic sans ms", FontWeight.NORMAL, FontPosture.ITALIC, 40));
            gc.fillText("Press 'Enter' to restart!", Main.WIDTH/3 - 40, Main.HEIGHT/2 + 70, Main.WIDTH/3);
        }

    }

    public void zeichneRoehre() {
        for (Roehre roehre : model.getRoehreList()) {
            gc.setFill(Color.GREEN);
            gc.fillRect(roehre.getPosX(), 0, roehre.getBreiteRoehre(), roehre.getHoeheObereRoehre());
            gc.fillRect(roehre.getPosX(), roehre.getHoeheObereRoehre() + model.getDurchFlugHoehe(), roehre.getBreiteRoehre(), Main.HEIGHT - roehre.getHoeheObereRoehre() + model.getDurchFlugHoehe());
        }
    }
}
