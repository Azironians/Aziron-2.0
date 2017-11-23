package Interface;

import javafx.fxml.FXMLLoader;
import javafx.scene.ImageCursor;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

import static Main.BuildStage.azironStage;

public class SceneMover {
    public void moveToScene(String pathOfScene){
        try {
            azironStage.setScene(new Scene(FXMLLoader.load(getClass().getResource(pathOfScene)), 1280, 720));
            Image cursor = new Image("file:src\\Picture\\Mouse\\Mouse.png");
            ImageCursor imageCursor = new ImageCursor(cursor);
            azironStage.getScene().setCursor(imageCursor);
        } catch (IOException e) {
            e.printStackTrace();
        }
        azironStage.show();
    }
}
