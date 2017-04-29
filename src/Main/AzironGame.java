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

    @Override
    public void start(Stage virtualStage) throws Exception {
        //1. Создание окна загрузки:
        Parent rootInit = FXMLLoader.load(getClass().getResource("../fxmlFiles/WindowInitialization.fxml"));
        Scene sceneInit = new Scene(rootInit, 1280, 720);
        azironStage.getIcons().add(new Image("file:src\\Picture\\Triggers\\Icon.png"));
        azironStage.setResizable(false);
        azironStage.setTitle("Build 1.0.0.0.0.0.0");
        azironStage.setScene(sceneInit);
        azironStage.show();

        //Прогрузка:
        Parent rootMenu = FXMLLoader.load(getClass().getResource("../fxmlFiles/WindowMenu.fxml"));
        Scene sceneMenu = new Scene(rootMenu, 1280, 720);
        //2. Окно меню:
        azironStage.setScene(sceneMenu);
}

    public static void main(String[] args) {
        launch(args);
    }
}