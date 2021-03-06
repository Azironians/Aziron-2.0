package Interface;

import Controllers.Controller;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import java.io.IOException;

public class AWindow {
    private Scene scene;
    private Controller controller;

    public AWindow(FXMLLoader fxmlLoader) {
        try {
            scene = new Scene(fxmlLoader.load(), 1280, 720);
            controller = fxmlLoader.getController();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Scene getScene() {
        return scene;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public Controller getController() {
        return controller;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }
}
