package InitializationGame;


import Heroes.HeroDevourer;
import Heroes.HeroLordVamp;
import Match.Player;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.File;

public class WindowMatchMaking1 {
    public static Stage launch(Stage AzironStage, Player player1, Player player2) {
        Pane root = new Pane();
        ImageView heroOne;
        ImageView heroTwo;

        ImageView imageBattleGround = new ImageView(new Image(new File("src\\Picture\\Windows\\WindowBattleField.bmp").toURI().toString(),1280.0,720.0,true,true));
        imageBattleGround.setFitHeight(720.0);
        imageBattleGround.setFitWidth(1280.0);

        if (player1.getHero().getClass() == HeroDevourer.class) {
            heroOne = new ImageView(new Image(new File("src\\Picture\\Heroes\\Devourer\\ger1.png").toURI().toString()));
        } else if (player1.getHero().getClass() == HeroLordVamp.class) {
            heroOne = new ImageView(new Image(new File("src\\Picture\\Heroes\\LordWamp\\ger2.png").toURI().toString()));
        } else {
            heroOne = new ImageView(new Image(new File("src\\Picture\\Heroes\\Basher\\ger3.png").toURI().toString()));
        }

        heroOne.setFitHeight(400.0);
        heroOne.setFitWidth(300.0);
        heroOne.setTranslateX(50);
        heroOne.setTranslateY(100);

        if (player2.getHero().getClass() == HeroDevourer.class) {
            heroTwo = new ImageView(new Image(new File("src\\Picture\\Heroes\\Devourer\\ger1.png").toURI().toString()));
        } else if (player2.getHero().getClass() == HeroLordVamp.class) {
            heroTwo = new ImageView(new Image(new File("src\\Picture\\Heroes\\LordWamp\\ger2.png").toURI().toString()));
        } else {
            heroTwo = new ImageView(new Image(new File("src\\Picture\\Heroes\\Basher\\ger3.png").toURI().toString()));
        }
        heroTwo.setFitHeight(400.0);
        heroTwo.setFitWidth(300.0);
        heroTwo.setTranslateX(930);
        heroTwo.setTranslateY(100);

        ImageView buttonTreatment = new ImageView(new Image(new File("src\\Picture\\Buttons\\Health_Moused.png").toURI().toString(), 1280.0, 720.0, true, true));


        buttonTreatment.setFitHeight(50.0);
        buttonTreatment.setFitWidth(50.0);
        buttonTreatment.setTranslateY(670);
        buttonTreatment.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> System.out.println("sdfsdf"));

        ImageView levelBlue = new ImageView(new Image(new File("src\\Picture\\Triggers\\Level_Blue.png").toURI().toString(),1280.0,720.0,true,true));
        levelBlue.setFitHeight(100.0);
        levelBlue.setFitWidth(300.0);
        levelBlue.setTranslateX(10);
        levelBlue.setTranslateY(10);


        root.getChildren().addAll( imageBattleGround, heroOne,heroTwo, buttonTreatment, levelBlue);
        Scene scene = new Scene(root, 1280, 720);
        AzironStage.setScene(scene);

        return AzironStage;
    }
}
