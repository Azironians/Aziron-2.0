package Menu;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class Menu {
    Scene scene;
    public Menu(Scene scene) throws IOException {
        Parent rootAutorize = FXMLLoader.load(getClass().getResource("../fxmlFiles/WindowAutorization.fxml"));
        this.scene = new Scene(rootAutorize, 1280, 720);
    }
}
