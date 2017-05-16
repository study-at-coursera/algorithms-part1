package github.io.toandv.algs4.week01.tree;

/**
 * Created by toan on 5/16/17.
 */

import java.io.File;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

/**
 * @web http://java-buddy.blogspot.com/
 */
public class JavaFX_DirectoryChooser extends Application {

    String deletingDir;

    @Override
    public void start(final Stage primaryStage) {

        final Label labelSelectedDirectory = new Label();
        final Label deletingStatus = new Label();

        Button btnOpenDirectoryChooser = new Button();
        btnOpenDirectoryChooser.setText("Directory to delete");
        btnOpenDirectoryChooser.setOnAction(event -> {
            DirectoryChooser directoryChooser = new DirectoryChooser();
            File selectedDirectory =
                    directoryChooser.showDialog(primaryStage);

            if (selectedDirectory == null) {
                labelSelectedDirectory.setText("No Directory selected");
            } else {
                deletingDir = selectedDirectory.getAbsolutePath();
                labelSelectedDirectory.setText(selectedDirectory.getAbsolutePath());
            }
        });

        Button btnStartDeleting = new Button();
        btnStartDeleting.setText("Delete");
        btnStartDeleting.setOnAction(event -> {
            if (deletingDir != null) {
                DirectoryTraversal.delete(deletingDir);
                labelSelectedDirectory.setText(deletingDir + " deleted");
            }
        });

        VBox vBox = new VBox();
        vBox.getChildren().addAll(
                labelSelectedDirectory,
                btnOpenDirectoryChooser,
                btnStartDeleting,
                deletingStatus);

        StackPane root = new StackPane();
        root.getChildren().add(vBox);

        Scene scene = new Scene(root, 300, 250);

        primaryStage.setTitle("Fast directory delete");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
