package github.io.toandv.algs4.week01;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;


/**
 * Created by dovan on 4/2/2017.
 */
public class JavafxSample extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
      /*
      Code for JavaFX application.
      (Stage, scene, scene graph)
      */
        Group root = new Group();

        Line line = new Line(100.0, 150.0, 500.0, 150.0);
        Text text = new Text(50, 100, "Welcome to javafx");
        text.setFont(new Font(50));

        Circle circle = new Circle(100, 150, 40, Color.BISQUE);
        //Creating the mouse event handler
        EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                System.out.println("Hello World");
                circle.setCenterX((circle.getCenterX() + 50 ) % 1024);
            }
        };
        circle.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);


        root.getChildren().addAll(line, text, circle);

        Scene scene = new Scene(root, 1024, 768);
        scene.setFill(Color.GREY);
        primaryStage.setTitle("Sample application");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String args[]){
        launch(args);
    }
}
