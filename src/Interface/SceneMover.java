package Interface;

import Main.AGame;
import javafx.fxml.FXMLLoader;
import javafx.scene.ImageCursor;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

import static Main.BuildStage.azironStage;

public class SceneMover {

    public static void moveToScene(String nameOfWindow) {
        Scene scene = AGame.getAGame().getMapOfWindows().get(nameOfWindow).getScene();
        AGame.getAGame().getStage().setScene(scene);
    }
}
