package Match;

import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.File;

import static InitializationGame.WindowMatchMaking1.launch;

public class MatchMaking {

    public static void damageVisual(Pane pane) {
        ImageView imageView = (ImageView) pane.getChildren().get(2);

        AnimationTimer gameLoop = new AnimationTimer() {
            int k = 1;

            @Override
            public void handle(long now) {

                if (imageView.getLayoutX() < 640) imageView.setLayoutX(imageView.getLayoutX() + 30 * k);
                else {
                    pane.getChildren().get(pane.getChildren().size() - 1).setLayoutY(200);
                    k *= -1;
                      imageView.setLayoutX(imageView.getLayoutX() - 40);
                }
                if (imageView.getLayoutX() < 50) {
                    imageView.setLayoutX(50);
                    pane.getChildren().get(pane.getChildren().size() - 1).setLayoutY(-1000);
                    stop();
                }
            }
        };

        gameLoop.start();


    }

    public static void treatmentVisual(Pane pane) {

        pane.getChildren().addAll();
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
        ImageView imageView1 = new ImageView(new Image(new File("src\\Picture\\Heroes\\GeneralSkills\\dpsHero.png").toURI().toString()));
        imageView1.setLayoutX(950);
        imageView1.setLayoutY(-1000);
        imageView1.setFitWidth(300);
        imageView1.setFitHeight(300);

        pane.getChildren().addAll(imageView1);

        boolean inBattle = true;
        while (inBattle) {
            Player thisPlayer = player1;
            Player otherPlayer = player2;

            inBattle = false;

        }
    }
}
