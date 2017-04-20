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

public class WindowMatchMaking1 {
    public static void launch(Pane root, Player player1, Player player2) {
        ImageView heroOne;
        ImageView heroTwo;

        ImageView imageBattleGround = new ImageView(new Image(new File("src\\Picture\\Windows\\WindowBattleField.bmp").toURI().toString(), 1280.0, 720.0, true, true));
        imageBattleGround.setFitHeight(720.0);
        imageBattleGround.setFitWidth(1280.0);

        if (player1.getHero().getClass() == HeroDevourer.class) {
            heroOne = new ImageView(new Image(new File("src\\Picture\\Heroes\\Devourer\\Devourer.png").toURI().toString()));
        } else if (player1.getHero().getClass() == HeroLordVamp.class) {
            heroOne = new ImageView(new Image(new File("src\\Picture\\Heroes\\LordWamp\\LV.png").toURI().toString()));
        } else {
            heroOne = new ImageView(new Image(new File("src\\Picture\\Heroes\\Basher\\Basher.png").toURI().toString()));
        }

        heroOne.setFitHeight(300.0);
        heroOne.setFitWidth(300.0);
        heroOne.setLayoutX(50);
        heroOne.setLayoutY(200);

        if (player2.getHero().getClass() == HeroDevourer.class) {
            heroTwo = new ImageView(new Image(new File("src\\Picture\\Heroes\\Devourer\\Devourer.png").toURI().toString()));
        } else if (player2.getHero().getClass() == HeroLordVamp.class) {
            heroTwo = new ImageView(new Image(new File("src\\Picture\\Heroes\\LordWamp\\LV.png").toURI().toString()));
        } else {
            heroTwo = new ImageView(new Image(new File("src\\Picture\\Heroes\\Basher\\Basher.png").toURI().toString()));
        }
        heroTwo.setFitHeight(300.0);
        heroTwo.setFitWidth(300.0);
        heroTwo.setLayoutX(930);
        heroTwo.setLayoutY(200);

        ImageView buttonTreatment = new ImageView(new Image(new File("src\\Picture\\Buttons\\Health_Moused.png").toURI().toString(), 1280.0, 720.0, true, true));


        buttonTreatment.setFitHeight(50.0);
        buttonTreatment.setFitWidth(50.0);
        buttonTreatment.setLayoutY(670);
        buttonTreatment.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> damage(player1,player2,root));

        ImageView levelBlue = new ImageView(new Image(new File("src\\Picture\\Triggers\\Level_Blue.png").toURI().toString(),1280.0,720.0,true,true));
        levelBlue.setFitHeight(100.0);
        levelBlue.setFitWidth(300.0);
        levelBlue.setLayoutX(10);
        levelBlue.setLayoutY(10);


        root.getChildren().addAll( imageBattleGround, heroOne,heroTwo, buttonTreatment, levelBlue);
    }
}
