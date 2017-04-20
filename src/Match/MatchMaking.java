package Match;

import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import static InitializationGame.WindowMatchMaking1.launch;

public class MatchMaking {

    public static void damageVisual(Pane pane) {
       ImageView imageView = (ImageView) pane.getChildren().get(0);
       imageView.setLayoutX(imageView.getX()+1);

System.out.print(pane);
    }

    public static void treatmentVisual(Pane pane) {
    }


    public static void damage(Player thisPlayer, Player otherPlayer, Pane pane) {
        otherPlayer.getHero().setHitPoints(otherPlayer.getHero().getHitPoints() - thisPlayer.getHero().getAttack());
        damageVisual(pane);
    }


    public static void treatment(Player thisPlayer, Pane pane) {
        thisPlayer.getHero().setHitPoints(thisPlayer.getHero().getHitPoints() + thisPlayer.getHero().getTreatment());
        treatmentVisual(pane);
    }

    public static void battleProcess(Pane pane, Player player1, Player player2) {
        launch(pane, player1, player2);

        boolean inBattle = true;
        while (inBattle) {
            Player thisPlayer = player1;
            Player otherPlayer = player2;

            inBattle = false;

        }
    }
}
