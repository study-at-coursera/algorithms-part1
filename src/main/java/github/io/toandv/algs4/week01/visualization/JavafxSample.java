package github.io.toandv.algs4.week01.visualization;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;


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
        TreeNode rootNode1 = new TreeNode("1", 1000 / 2, 40);
        rootNode1.setGroup(root);
        TreeNode child1 = new TreeNode("2", 400, 400);
        TreeNode child2 = new TreeNode("3", 800, 400);
        rootNode1.addChild(child1);
        rootNode1.addChild(child2);
        rootNode1.show();

        Scene scene = new Scene(root, 1000, 800);

        List<Line> verticalLines = new ArrayList<>();
        for (int i = 0; i <= 1000; ) {
            Line line = new Line(i, i + 800, i, 0);
            i = i + 40;
            verticalLines.add(line);
        }
        List<Line> horizontalLines = new ArrayList<>();
//        for (int i = 0; i <= 800; ) {
//            Line line = new Line();
//        }

        root.getChildren().addAll(verticalLines);
        primaryStage.setTitle("Sample application");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String args[]) {
        launch(args);
    }
}
