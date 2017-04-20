package Match;

import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.File;

import static InitializationGame.WindowMatchMaking1.launch;
import static javafx.application.Platform.exit;

public class MatchMaking {
    private static int turn;

    private static void damageVisual(Pane pane, Player player1, Player player2) {
        ImageView imageView;
        if (turn == 1) imageView = player1.getHero().getImage();
        else imageView = player2.getHero().getImage();
        AnimationTimer gameLoop = new AnimationTimer() {
            int k = 1;

            @Override
            public void handle(long now) {
                if (turn == -1) {
                    imageView.setLayoutX(imageView.getLayoutX() + 30 * k);
                    if (imageView.getLayoutX() > 640) {
                        pane.getChildren().get(pane.getChildren().size() - 2).setLayoutY(200);
                        pane.getChildren().get(pane.getChildren().size() - 2).setLayoutX(940);
                        k *= -1;
                        imageView.setLayoutX(imageView.getLayoutX() - 40);
                    }
                    if (imageView.getLayoutX() < 50) {
                        imageView.setLayoutX(50);
                        pane.getChildren().get(pane.getChildren().size() - 2).setLayoutY(-1000);
                        stop();
                    }
                } else {
                    imageView.setLayoutX(imageView.getLayoutX() - 30 * k);
                    if (imageView.getLayoutX() < 350) {
                        pane.getChildren().get(pane.getChildren().size() - 2).setLayoutY(200);
                        pane.getChildren().get(pane.getChildren().size() - 2).setLayoutX(50);
                        k *= -1;
                        imageView.setLayoutX(imageView.getLayoutX() + 40);
                    }
                    if (imageView.getLayoutX() > 960) {
                        imageView.setLayoutX(940);
                        pane.getChildren().get(pane.getChildren().size() - 2).setLayoutY(-1000);
                        stop();
                    }
                }
            }
        };
        gameLoop.start();
    }


    private static void treatmentVisual(Pane pane) throws InterruptedException {
        AnimationTimer gameLoop = new AnimationTimer() {
            @Override
            public void handle(long now) {

                if (turn == 1) {
                    pane.getChildren().get(pane.getChildren().size() - 1).setLayoutX(50);
                    pane.getChildren().get(pane.getChildren().size() - 1).setLayoutY(200);

                } else {
                    pane.getChildren().get(pane.getChildren().size() - 1).setLayoutX(940);
                    pane.getChildren().get(pane.getChildren().size() - 1).setLayoutY(200);
                }
            }
        }; gameLoop.start();

//        AnimationTimer gameLoop2 = new AnimationTimer() {
//            @Override
//            public void handle(long now) {
//                pane.getChildren().get(pane.getChildren().size() - 1).setLayoutY(-1000);
//
//            }
//        }; gameLoop2.start();
//



    }
    public static void damage(Player thisPlayer, Player otherPlayer, Pane pane) {
        otherPlayer.getHero().setHitPoints(otherPlayer.getHero().getHitPoints() - thisPlayer.getHero().getAttack());
        damageVisual(pane, thisPlayer, otherPlayer);
        turn *= -1;
        if ((thisPlayer.getHero().getHitPoints() < 0) || (otherPlayer.getHero().getHitPoints() < 0))
            exit();
    }


    public static void treatment(Player player1,Player player2, Pane pane) throws InterruptedException {
        if (turn==1)player1.getHero().setHitPoints(player1.getHero().getHitPoints() + player1.getHero().getTreatment());
        else player2.getHero().setHitPoints(player2.getHero().getHitPoints() + player2.getHero().getTreatment());
        treatmentVisual(pane);
        turn *= -1;
    }

    public static void battleProcess(Pane pane, Player player1, Player player2) {
        launch(pane, player1, player2);
        ImageView imageView1 = new ImageView(new Image(new File("src\\Picture\\Heroes\\GeneralSkills\\dpsHero.png").toURI().toString()));
        imageView1.setLayoutX(950);
        imageView1.setLayoutY(-1000);
        imageView1.setFitWidth(300);
        imageView1.setFitHeight(300);
        ImageView imageView2 = new ImageView(new Image(new File("src\\Picture\\Heroes\\GeneralSkills\\health.png").toURI().toString()));
        imageView2.setLayoutX(950);
        imageView2.setLayoutY(-1000);
        imageView2.setFitWidth(300);
        imageView2.setFitHeight(300);

        pane.getChildren().addAll(imageView1, imageView2);

        turn = 1;

    }
}
