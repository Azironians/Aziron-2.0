package Main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;


import java.io.File;

import static Main.BuildStage.azironStage;


public class AzironGame extends Application {
    public static Sound soundFon = new Sound(new File("src\\Sounds\\menu.wav"));

    @Override
    public void start(Stage virtualStage) throws Exception {
        //1. Создание окна загрузки:
        azironStage.getIcons().add(new Image("file:src\\Picture\\Triggers\\Icon.png"));
        azironStage.setResizable(false);
        azironStage.setTitle("Build 1.0.0.0.0.0.1");
        //Прогрузка:
        Parent rootInit = FXMLLoader.load(getClass().getResource("../fxmlFiles/WindowInitialization.fxml"));
        Scene sceneInit = new Scene(rootInit, 1280, 720);
        //2. Окно меню:
        azironStage.setScene(sceneInit);
        azironStage.show();
        soundFon.play();
        soundFon.setRepeat(true);
    }

    public static void main(String[] args) {
        launch(args);
    }
}