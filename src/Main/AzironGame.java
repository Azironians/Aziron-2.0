package Main;

import Heroes.HeroDevourer;
import Heroes.HeroLordVamp;
import Match.Player;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.File;

import static Match.MatchMaking.battleProcess;

public class AzironGame extends Application {

    @Override
    public void start(Stage AzironStage) throws Exception {
        AzironStage.setTitle("Heroes of Azironian");
        AzironStage.show();
        AzironStage.setResizable(false);
        Pane pane = new Pane();
        ImageView imageBattleGround = new ImageView(new Image(new File("src\\Picture\\Windows\\WindowInitialization.jpg").toURI().toString(), 1280.0, 720.0, true, true));
        imageBattleGround.setFitHeight(720.0);
        imageBattleGround.setFitWidth(1280.0);
        pane.getChildren().addAll(imageBattleGround);
        Scene scene = new Scene(pane, 1280, 720);
        AzironStage.setScene(scene);
        AzironStage.show();
        battleProcess(pane, new Player("I am Groot", new HeroLordVamp(), null), new Player("I am not Groot", new HeroDevourer(), null));
    }

    public static void main(String[] args) {
        launch(args);
    }
}