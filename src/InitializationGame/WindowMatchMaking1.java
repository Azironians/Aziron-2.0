package InitializationGame;

import Heroes.HeroDevourer;
import Heroes.HeroLordVamp;
import Match.Player;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.File;

import static Match.MatchMaking.damage;
import static Match.MatchMaking.treatment;

public class WindowMatchMaking1 {
    public static void launch(Pane root, Player player1, Player player2) {
        ImageView heroOne;
        ImageView heroTwo;

        ImageView imageBattleGround = new ImageView(new Image(new File("src\\Picture\\Windows\\WindowBattleField.bmp").toURI().toString(), 1280.0, 720.0, true, true));
        imageBattleGround.setFitHeight(720.0);
        imageBattleGround.setFitWidth(1280.0);

        heroOne = player1.getHero().getImage();

        heroOne.setFitHeight(300.0);
        heroOne.setFitWidth(300.0);
        heroOne.setLayoutX(50);
        heroOne.setLayoutY(200);

        heroTwo = player2.getHero().getImage();
        heroTwo.setFitHeight(300.0);
        heroTwo.setFitWidth(300.0);
        heroTwo.setLayoutX(930);
        heroTwo.setLayoutY(200);

        ImageView buttonTreatment = new ImageView(new Image(new File("src\\Picture\\Buttons\\Health_Moused.png").toURI().toString(), 1280.0, 720.0, true, true));


        buttonTreatment.setFitHeight(50.0);
        buttonTreatment.setFitWidth(50.0);
        buttonTreatment.setLayoutY(670);
        buttonTreatment.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> damage(player1, player2, root));
        ImageView buttonTreatment2 = new ImageView(new Image(new File("src\\Picture\\Buttons\\Health_Moused.png").toURI().toString(), 1280.0, 720.0, true, true));


        buttonTreatment2.setFitHeight(50.0);
        buttonTreatment2.setFitWidth(50.0);
        buttonTreatment2.setLayoutY(600);
        buttonTreatment2.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            try {
                treatment(player1, player2, root);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        ImageView levelBlue = new ImageView(new Image(new File("src\\Picture\\Triggers\\Level_Blue.png").toURI().toString(), 1280.0, 720.0, true, true));
        levelBlue.setFitHeight(100.0);
        levelBlue.setFitWidth(300.0);
        levelBlue.setLayoutX(10);
        levelBlue.setLayoutY(10);


        root.getChildren().addAll(imageBattleGround, heroOne, heroTwo, buttonTreatment, levelBlue,buttonTreatment2);
    }
}
