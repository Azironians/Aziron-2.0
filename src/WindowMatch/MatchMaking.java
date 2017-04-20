package WindowMatch;


import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.File;

public class MatchMaking {
    public static Stage launch(Stage AzironStage) {
        Pane root = new Pane();

        ImageView imageBattleGround = new ImageView(new Image(new File("src\\Picture\\Windows\\WindowBattleField.bmp").toURI().toString(),1280.0,720.0,true,true));
        imageBattleGround.setFitHeight(720.0);
        imageBattleGround.setFitWidth(1280.0);

        ImageView imageDevourer = new ImageView(new Image(new File("src\\Picture\\Heroes\\Devourer\\Devourer.png").toURI().toString(),1280.0,720.0,true,true));
        imageDevourer.setFitHeight(300.0);
        imageDevourer.setFitWidth(300.0);
        imageDevourer.setTranslateX(50);
        imageDevourer.setTranslateY(200);

        ImageView imageLordVampire = new ImageView(new Image(new File("src\\Picture\\Heroes\\LordWamp\\LV.png").toURI().toString(),1280.0,720.0,true,true));
        imageLordVampire.setFitHeight(300.0);
        imageLordVampire.setFitWidth(300.0);
        imageLordVampire.setTranslateX(930);
        imageLordVampire.setTranslateY(200);

        ImageView buttonTreatment = new ImageView(new Image(new File("src\\Picture\\Buttons\\Health_Moused.png").toURI().toString(),1280.0,720.0,true,true));
        buttonTreatment.setFitHeight(50.0);
        buttonTreatment.setFitWidth(50.0);
        buttonTreatment.setTranslateY(670);
        buttonTreatment.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> System.out.println("sdfsdf"));

        ImageView levelBlue = new ImageView(new Image(new File("src\\Picture\\Triggers\\Level_Blue.png").toURI().toString(),1280.0,720.0,true,true));
        levelBlue.setFitHeight(100.0);
        levelBlue.setFitWidth(300.0);
        levelBlue.setTranslateX(10);
        levelBlue.setTranslateY(10);







        root.getChildren().addAll( imageBattleGround, imageDevourer,imageLordVampire, buttonTreatment, levelBlue);
        Scene scene = new Scene(root, 1280, 720);
        AzironStage.setScene(scene);



        return AzironStage;
    }
}
