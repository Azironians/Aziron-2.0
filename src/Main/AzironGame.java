package Main;

import Heroes.HeroDevourer;
import Heroes.HeroLordVamp;
import Heroes.HeroOrcBasher;
import Match.Player;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import static Main.BuildStage.azironStage;
import static Match.Battle.battleProcess;


public class AzironGame extends Application {
    public static Player player1;
    public static Player player2;

    @Override
    public void start(Stage virtualStage) throws Exception {
        //1. Создание окна загрузки:

        Pane rootInit = new Pane();
        Scene sceneInit = new Scene(rootInit, 1280, 720);
        azironStage.setScene(sceneInit);
        azironStage.show();
        Boolean turn = Math.random() < 0.5;
        player1 = new Player("StarKRE", new HeroLordVamp(true));
        player2 = new Player("StarKRE2", new HeroLordVamp(false));
        battleProcess(rootInit, player1, player2, turn);
//
//        Parent rootInit = FXMLLoader.load(getClass().getResource("../fxmlFiles/WindowInitialization.fxml"));
//        Scene sceneInit = new Scene(rootInit, 1280, 720);
//        azironStage.getIcons().add(new Image("file:src\\Picture\\Triggers\\Icon.png"));
//        azironStage.setResizable(false);
//        azironStage.setTitle("Build 1.0.0.0.0.0.0");
//        azironStage.setScene(sceneInit);
//        azironStage.show();
//        //Прогрузка:
//        Parent rootMenu = FXMLLoader.load(getClass().getResource("../fxmlFiles/WindowMenu.fxml"));
//        Scene sceneMenu = new Scene(rootMenu, 1280, 720);
//        //2. Окно меню:
//        azironStage.setScene(sceneMenu);
    }

    public static void main(String[] args) {
        launch(args);
    }
}