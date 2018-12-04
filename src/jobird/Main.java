package jobird;

import jobird.model.Model;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class Main extends Application {

    public static final double WIDTH = 1200;
    public static final double HEIGHT = 750;

    private Timer timer;

    @Override
    public void start(Stage primaryStage) throws Exception {

        Canvas canvas = new Canvas(WIDTH, HEIGHT);
        Group group = new Group();
        group.getChildren().addAll(canvas);

        Scene scene = new Scene(group);
        primaryStage.setScene(scene);
        primaryStage.show();

        Model model = new Model();
        Graphics graphics = new Graphics(model, canvas.getGraphicsContext2D());
        timer = new Timer(model, graphics);

        InputHandler inputHandler = new InputHandler(model);


        scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                inputHandler.onKeyReleased(event);
            }
        });

        timer.start();
    }


    @Override
    public void stop() throws Exception {
        timer.stop();
        super.stop();
    }
}
