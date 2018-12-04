package jobird;

import jobird.model.Model;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class InputHandler {
    private Model model;

    public InputHandler(Model model) {
        this.model = model;
    }

    public void onKeyReleased(KeyEvent event) {
        if (event.getCode() == KeyCode.SPACE) {
            if (this.model.getGameStatus() == 0) {
                this.model.setGameStatus(1);
            } else if (this.model.getGameStatus() == 1){
                this.model.getFlappy().setPosY(model.getFlappy().getPosY()-50);
                this.model.getSounds().flügelSound();
            }
        }
        if (event.getCode() == KeyCode.ENTER) {
            this.model.setGameStatus(1);
            this.model.resetCounter();
            this.model.resetGame();
        }
    }

}
