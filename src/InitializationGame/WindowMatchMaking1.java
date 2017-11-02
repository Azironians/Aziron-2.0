package InitializationGame;

import Match.Battle;
import Match.Player;
import javafx.animation.FadeTransition;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import java.io.File;

import static Match.Battle.turn;
import static controller.ControllerChoiceHero.battle;


public class WindowMatchMaking1 {
    private static ImageView Dam1 = new ImageView(new Image("file:src\\Picture\\Triggers\\Arrowleftred_clip_art_hight.png"));
    private static ImageView Hil1 = new ImageView(new Image("file:src\\Picture\\Heroes\\GeneralSkills\\health.png"));
    private static ImageView Dam2 = new ImageView(new Image("file:src\\Picture\\Triggers\\Arrowleftred_clip_art_hight.png"));
    private static ImageView Hil2 = new ImageView(new Image("file:src\\Picture\\Heroes\\GeneralSkills\\health.png"));

    private static void openDam1() {
        FadeTransition fadeTransition = new FadeTransition(Duration.millis(1000), Dam1);
        fadeTransition.setToValue(1);
        fadeTransition.setCycleCount(1);
        fadeTransition.play();
    }

    private static void closeDam1() {
        FadeTransition fadeTransition = new FadeTransition(Duration.millis(1000), Dam1);
        fadeTransition.setToValue(0);
        fadeTransition.setCycleCount(1);
        fadeTransition.play();
    }

    private static void openDam2() {
        FadeTransition fadeTransition = new FadeTransition(Duration.millis(1000), Dam2);
        fadeTransition.setToValue(1);
        fadeTransition.setCycleCount(1);
        fadeTransition.play();
    }

    private static void closeDam2() {
        FadeTransition fadeTransition = new FadeTransition(Duration.millis(1000), Dam2);
        fadeTransition.setToValue(0);
        fadeTransition.setCycleCount(1);
        fadeTransition.play();
    }

    private static void openHil1() {
        FadeTransition fadeTransition = new FadeTransition(Duration.millis(1000), Hil1);
        fadeTransition.setToValue(1);
        fadeTransition.setCycleCount(1);
        fadeTransition.play();
    }

    private static void closeHil1() {
        FadeTransition fadeTransition = new FadeTransition(Duration.millis(1000), Hil1);
        fadeTransition.setToValue(0);
        fadeTransition.setCycleCount(1);
        fadeTransition.play();
    }

    private static void openHil2() {
        FadeTransition fadeTransition = new FadeTransition(Duration.millis(1000), Hil2);
        fadeTransition.setToValue(1);
        fadeTransition.setCycleCount(1);
        fadeTransition.play();
    }

    private static void closeHil2() {
        FadeTransition fadeTransition = new FadeTransition(Duration.millis(1000), Hil2);
        fadeTransition.setToValue(0);
        fadeTransition.setCycleCount(1);
        fadeTransition.play();
    }

    public static void launch(Pane root, Player player1, Player player2) {
        Button button = new Button();
        button.setLayoutX(-1000);
        button.setOnKeyPressed(event -> {
            if (turn == 1) {
                if (event.getCode() == KeyCode.DIGIT1) {
                    Battle.turns++;
                    battle.damage(player1, player2);
                }
                if (event.getCode() == KeyCode.DIGIT2) {
                    Battle.turns++;
                    try {
                        battle.treatment(player1, player2);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (event.getCode() == KeyCode.Q && player1.getHero().getSkills().isFirstOpen()) {
                    Battle.turns++;
                    turn *= -1;
                    player1.getHero().getSkills().firstUlt();
                }
                if (event.getCode() == KeyCode.W && player1.getHero().getSkills().isTwoOpen()) {
                    Battle.turns++;
                    turn *= -1;
                    player1.getHero().getSkills().twoUlt();
                }
                if (event.getCode() == KeyCode.E && player1.getHero().getSkills().isThreeOpen()) {
                    Battle.turns++;
                    turn *= -1;
                    player1.getHero().getSkills().threeUlt();
                }
            }
            if (turn == -1) {
                if (event.getCode() == KeyCode.NUMPAD1) {
                    Battle.turns++;
                    battle.damage(player1, player2);
                }
                if (event.getCode() == KeyCode.NUMPAD2) {
                    try {
                        Battle.turns++;
                        battle.treatment(player1, player2);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (event.getCode() == KeyCode.NUMPAD4 && player2.getHero().getSkills().isFirstOpen()) {
                    Battle.turns++;
                    turn *= -1;
                    player2.getHero().getSkills().firstUlt();
                }
                if (event.getCode() == KeyCode.NUMPAD5 && player2.getHero().getSkills().isTwoOpen()) {
                    Battle.turns++;
                    turn *= -1;
                    player2.getHero().getSkills().twoUlt();
                }
                if (event.getCode() == KeyCode.NUMPAD6 && player2.getHero().getSkills().isThreeOpen()) {
                    Battle.turns++;
                    turn *= -1;
                    player2.getHero().getSkills().threeUlt();
                }
            }
        });

        Dam1.setFitHeight(300);
        Dam1.setFitWidth(600);
        Dam1.setLayoutX(1280 / 2 - 300);
        Dam1.setLayoutY(720 / 2 - 200);
        Dam1.setOpacity(0);
        Hil1.setFitHeight(300);
        Hil1.setFitWidth(300);
        Hil1.setLayoutX(50);
        Hil1.setLayoutY(140);
        Hil1.setOpacity(0);
        Dam2.setFitHeight(300);
        Dam2.setFitWidth(600);
        Dam2.setLayoutX(1280 / 2 - 300);
        Dam2.setLayoutY(720 / 2 - 200);
        Dam2.setOpacity(0);
        Hil2.setFitHeight(300);
        Hil2.setFitWidth(300);
        Hil2.setLayoutX(930);
        Hil2.setLayoutY(140);
        Hil2.setOpacity(0);
        Dam1.setScaleX(-1);
        Hil2.setScaleX(-1);
        ImageView heroOne;
        ImageView heroTwo;

        ImageView imageBattleGround = new ImageView(new Image(new File("src\\Picture\\Windows\\battleProcess.jpg").toURI().toString(), 1280.0, 720.0, true, true));
        imageBattleGround.setFitHeight(720.0);
        imageBattleGround.setFitWidth(1280.0);
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
        heroTwo.setScaleX(-1);
        heroTwo.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            Battle.turns++;
            if (turn == 1) battle.damage(player1, player2);
            else try {
                battle.treatment(player1, player2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        heroOne.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            Battle.turns++;
            if (turn == -1) battle.damage(player1, player2);
            else try {
                battle.treatment(player1, player2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        heroTwo.addEventHandler(MouseEvent.MOUSE_ENTERED, mouseEvent -> {
            if (turn == 1) {
                openDam1();
            } else {
                openHil2();
            }
        });

        heroTwo.addEventHandler(MouseEvent.MOUSE_EXITED, mouseEvent -> {
            closeDam1();
            closeDam2();
            closeHil1();
            closeHil2();
        });

        heroOne.addEventHandler(MouseEvent.MOUSE_ENTERED, mouseEvent -> {
            if (turn == -1) {
                openDam2();
            } else {
                openHil1();
            }
        });


        heroOne.addEventHandler(MouseEvent.MOUSE_EXITED, mouseEvent -> {
            closeDam1();
            closeDam2();
            closeHil1();
            closeHil2();
        });

        root.getChildren().addAll(button, imageBattleGround, heroOne, Dam1, Hil1,
                player1.getHero().getSkills().getImageViewList()[0],
                player1.getHero().getSkills().getImageViewList()[1],
                player1.getHero().getSkills().getImageViewList()[2],
                player1.getHero().getSkills().getImageViewsText()[0],
                player1.getHero().getSkills().getImageViewsText()[1],
                player1.getHero().getSkills().getImageViewsText()[2],


                heroTwo, Dam2, Hil2,
                player2.getHero().getSkills().getImageViewsText()[0],
                player2.getHero().getSkills().getImageViewsText()[1],
                player2.getHero().getSkills().getImageViewsText()[2],
                player2.getHero().getSkills().getImageViewList()[0],
                player2.getHero().getSkills().getImageViewList()[1],
                player2.getHero().getSkills().getImageViewList()[2]);
    }
}
