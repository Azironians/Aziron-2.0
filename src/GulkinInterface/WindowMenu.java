package GulkinInterface;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.File;

public class WindowMenu {
    public static Stage launch(Stage AzironStage) {
        Pane root = new Pane();

        ImageView imageInit = new ImageView(new Image(new File("src\\Picture\\Windows\\WindowMenu.jpg").toURI().toString(), 1280.0, 720.0, true, true));

        root.getChildren().addAll(imageInit);
        Scene scene = new Scene(root, 1280, 720);
        AzironStage.setScene(scene);

        return AzironStage;
    }


}
