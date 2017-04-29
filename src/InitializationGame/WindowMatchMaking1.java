package InitializationGame;

import Match.Player;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

import java.io.File;

import static Match.Battle.damage;
import static Match.Battle.treatment;
import static Match.Battle.turn;

public class WindowMatchMaking1 {
    public static void launch(Pane root, Player player1, Player player2) {
        ImageView heroOne;
        ImageView heroTwo;

        ImageView imageBattleGround = new ImageView(new Image(new File("src\\Picture\\Windows\\battleProcess.jpg").toURI().toString(), 1280.0, 720.0, true, true));
        imageBattleGround.setFitHeight(720.0);
        imageBattleGround.setFitWidth(1280.0);

        heroOne = player1.getHero().getImage();
        player1.setLocation(true);
        heroOne.setFitHeight(300.0);
        heroOne.setFitWidth(300.0);
        heroOne.setLayoutX(50);
        heroOne.setLayoutY(140);
        player2.setLocation(false);
        heroTwo = player2.getHero().getImage();
        heroTwo.setFitHeight(300.0);
        heroTwo.setFitWidth(300.0);
        heroTwo.setLayoutX(930);
        heroTwo.setLayoutY(140);

        heroTwo.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            if (turn == 1) damage(player1, player2, root);
            else try {
                treatment(player1, player2, root);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        heroOne.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            if (turn == -1) damage(player1, player2, root);
            else try {
                treatment(player1, player2, root);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        root.getChildren().addAll(imageBattleGround, heroOne, heroTwo);
    }
}
