package InitializationGame;

import Match.Player;
import javafx.animation.FadeTransition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import java.io.File;

import static Match.Battle.*;

public class WindowMatchMaking1 {
    private static ImageView Dam = new ImageView(new Image("file:src\\Picture\\Triggers\\Arrowleftred_clip_art_hight.png"));
   // private static ImageView Hil = new ImageView(new Image("file:src\\Picture\\Triggers\\Arrowleftred_clip_art_hight.png"));

    private static void openDam() {
        FadeTransition fadeTransition = new FadeTransition(Duration.millis(3000), Dam);
        fadeTransition.setToValue(1);
        fadeTransition.setCycleCount(1);
        fadeTransition.play();
    }

    private static void closeDam() {
        FadeTransition fadeTransition = new FadeTransition(Duration.millis(1000), Dam);
        fadeTransition.setToValue(0);
        fadeTransition.setCycleCount(1);
        fadeTransition.play();
    }

    public static void launch(Pane root, Player player1, Player player2) {
        Dam.setFitHeight(300);
        Dam.setFitWidth(600);
        Dam.setLayoutX(1280 / 2 - 300);
        Dam.setLayoutY(720 / 2 - 150);
Dam.setOpacity(0);

        ImageView heroOne;
        ImageView heroTwo;

        ImageView imageBattleGround = new ImageView(new Image(new File("src\\Picture\\Windows\\battleProcess.jpg").toURI().toString(), 1280.0, 720.0, true, true));
        imageBattleGround.setFitHeight(720.0);
        imageBattleGround.setFitWidth(1280.0);
        if (!player1.getHero().getLocation()) {
            Player player = player1;
            player1 = player2;
            player2 = player;
        }
        heroOne = player1.getHero().getImage();
        heroOne.setFitHeight(300.0);
        heroOne.setFitWidth(300.0);
        heroOne.setLayoutX(50);
        heroOne.setLayoutY(140);
        heroTwo = player2.getHero().getImage();
        heroTwo.setFitHeight(300.0);
        heroTwo.setFitWidth(300.0);
        heroTwo.setLayoutX(930);
        heroTwo.setLayoutY(140);

        Player finalPlayer1 = player1;
        Player finalPlayer2 = player2;
        heroTwo.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            turns++;
            if (turn == 1) damage(finalPlayer1, finalPlayer2, root);
            else try {
                treatment(finalPlayer1, finalPlayer2, root);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        heroOne.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            turns++;
            if (turn == -1) damage(finalPlayer1, finalPlayer2, root);
            else try {
                treatment(finalPlayer1, finalPlayer2, root);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        heroTwo.addEventHandler(MouseEvent.MOUSE_ENTERED, mouseEvent -> {
            if (turn == 1) openDam();
            else {};
        });

        heroTwo.addEventHandler(MouseEvent.MOUSE_EXITED, mouseEvent -> {if (turn == 1) closeDam();
        else {};
        });

        heroOne.addEventHandler(MouseEvent.MOUSE_ENTERED, mouseEvent -> {
        });

        heroOne.addEventHandler(MouseEvent.MOUSE_EXITED, mouseEvent -> {
        });
        root.getChildren().addAll(imageBattleGround, heroOne, heroTwo,Dam,
                player1.getHero().getSkills().getImageViewList()[0],
                player1.getHero().getSkills().getImageViewList()[1],
                player1.getHero().getSkills().getImageViewList()[2],
                player2.getHero().getSkills().getImageViewList()[0],
                player2.getHero().getSkills().getImageViewList()[1],
                player2.getHero().getSkills().getImageViewList()[2]);

    }
}
