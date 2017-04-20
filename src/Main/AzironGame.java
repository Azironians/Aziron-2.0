package Main;

import Heroes.HeroDevourer;
import Heroes.HeroLordVamp;
import Match.Player;
import javafx.application.Application;
import javafx.stage.Stage;

import static Match.MatchMaking.battleProcess;

public class AzironGame extends Application {

    @Override
    public void start(Stage AzironStage) throws Exception {
        AzironStage.setTitle("Heroes of Azironian");
        AzironStage.show();
        AzironStage.setResizable(false);
        battleProcess(AzironStage, new Player("I am Groot", new HeroLordVamp(), null), new Player("I am not Groot", new HeroDevourer(), null));
    }

    public static void main(String[] args) {
        launch(args);
    }
}