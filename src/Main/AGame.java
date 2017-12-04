package Main;

import Interface.AWindow;
import Interface.SceneMover;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.util.Map;


public class AGame extends Application {
    private static Stage stage = new Stage();
    private static AGame aGame = null;

    public static synchronized AGame getAGame() {
        if (aGame == null) {
            aGame = new AGame();
        }
        return aGame;
    }

    private Map<String, AWindow> mapOfWindows = Map.of(
            "windowInitialization", new AWindow(new FXMLLoader(AGame.class.getResource("../fxmlFiles/WindowInitialization.fxml"))),
            "windowMainMenu", new AWindow(new FXMLLoader(AGame.class.getResource("../fxmlFiles/WindowMenu.fxml"))),
            "windowAuthorization", new AWindow(new FXMLLoader(AGame.class.getResource("../fxmlFiles/WindowAuthorization.fxml"))),
            "windowChoiceHero", new AWindow(new FXMLLoader(AGame.class.getResource("../fxmlFiles/WindowChoiceHero.fxml"))),
            "windowChoiceBonus", new AWindow(new FXMLLoader(AGame.class.getResource("../fxmlFiles/WindowChoiceBonus.fxml")))
    );

    private void stageInitialization() {
        stage.getIcons().add(new Image("file:src\\Picture\\Triggers\\Icon.png"));
        stage.setResizable(false);
        stage.setTitle("Build 1.0.0.0.0.0.3");
    }

    @Override
    public void start(Stage virtualStage) throws Exception {
        stageInitialization();
        SceneMover.moveToScene("windowInitialization");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public Stage getStage() {
        return stage;
    }

    public Map<String, AWindow> getMapOfWindows() {
        return mapOfWindows;
    }
}
