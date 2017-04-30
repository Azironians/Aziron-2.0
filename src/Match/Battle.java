package Match;

import javafx.animation.AnimationTimer;
import javafx.animation.FadeTransition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import javafx.scene.text.*;

import java.io.File;

import static InitializationGame.WindowMatchMaking1.launch;
import static javafx.application.Platform.exit;

public class Battle {
    public static int turn = 0;
    public static int turns = 0;

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
                        pane.getChildren().get(pane.getChildren().size() - 2).setLayoutY(140);
                        pane.getChildren().get(pane.getChildren().size() - 2).setLayoutX(940);
                        k *= -1;
                        imageView.setLayoutX(imageView.getLayoutX() - 40);
                    }
                    if (imageView.getLayoutX() < 50) {
                        imageView.setLayoutX(50);
                        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(1), pane.getChildren().get(pane.getChildren().size() - 2));
                        fadeTransition.setFromValue(1);
                        fadeTransition.setToValue(0);
                        fadeTransition.setCycleCount(1);
                        fadeTransition.play();
                        stop();
                    }
                } else {
                    imageView.setLayoutX(imageView.getLayoutX() - 30 * k);
                    if (imageView.getLayoutX() < 330) {
                        pane.getChildren().get(pane.getChildren().size() - 2).setLayoutY(140);
                        pane.getChildren().get(pane.getChildren().size() - 2).setLayoutX(50);
                        k *= -1;
                        imageView.setLayoutX(imageView.getLayoutX() + 40);
                    }
                    if (imageView.getLayoutX() > 960) {
                        imageView.setLayoutX(940);
                        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(1), pane.getChildren().get(pane.getChildren().size() - 2));
                        fadeTransition.setFromValue(1);
                        fadeTransition.setToValue(0);
                        fadeTransition.setCycleCount(1);
                        fadeTransition.play();
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

                if (turn == -1) {
                    pane.getChildren().get(pane.getChildren().size() - 1).setLayoutX(50);
                    pane.getChildren().get(pane.getChildren().size() - 1).setLayoutY(140);

                } else {
                    pane.getChildren().get(pane.getChildren().size() - 1).setLayoutX(940);
                    pane.getChildren().get(pane.getChildren().size() - 1).setLayoutY(140);
                }
                FadeTransition fadeTransition = new FadeTransition(Duration.seconds(1), pane.getChildren().get(pane.getChildren().size() - 1));
                fadeTransition.setFromValue(1);
                fadeTransition.setToValue(0);
                fadeTransition.setCycleCount(1);
                fadeTransition.play();
                stop();
            }
        };
        gameLoop.start();
    }

    public static void damage(Player player1, Player player2, Pane pane) {
        damageVisual(pane, player1, player2);
        if ((player1.getHero().getHitPoints() < 0) || (player2.getHero().getHitPoints() < 0))
            exit();//другое окно
        if (turn == 1) {
            player2.getHero().setHitPoints(player2.getHero().getHitPoints() - player1.getHero().getAttack());
            player1.getHero().setExperience(player1.getHero().getExperience() + player1.getHero().getAttack());
        } else {
            player1.getHero().setHitPoints(player1.getHero().getHitPoints() - player2.getHero().getAttack());
            player2.getHero().setExperience(player2.getHero().getExperience() + player2.getHero().getAttack());
        }
        turn *= -1;
    }


    public static void treatment(Player player1, Player player2, Pane pane) throws InterruptedException {
        if (turn == 1)
            player1.getHero().setHitPoints(player1.getHero().getHitPoints() + player1.getHero().getTreatment());
        else player2.getHero().setHitPoints(player2.getHero().getHitPoints() + player2.getHero().getTreatment());
        treatmentVisual(pane);
        turn *= -1;
    }

    public static void battleProcess(Pane pane, Player player1, Player player2, Boolean first) {
        Text name1 = new Text(486, 44, player1.getProfileName());
        name1.setFont(new Font("Times New Roman",30));
        name1.setFill(Color.LIGHTBLUE);
        Text name2 = new Text(666, 44, player2.getProfileName());
        name2.setFont(new Font("Times New Roman",30));
        name2.setFill(Color.RED);

        Text hitPoints1 = new Text(8, 104, player1.getHero().getHitPoints().intValue() + "/" + player1.getHero().getSupplyHealth().intValue());
        hitPoints1.setFont(new Font(30));
        hitPoints1.setFill(Color.LIGHTGREY);
        Text hitPoints2 = new Text(1070, 104, player2.getHero().getHitPoints().intValue() + "/" + player2.getHero().getSupplyHealth().intValue());
        hitPoints2.setFont(new Font(30));
        hitPoints2.setFill(Color.LIGHTGREY);
        Text attack1 = new Text(242, 494, player1.getHero().getAttack().intValue() + "");
        attack1.setFont(new Font(45));
        attack1.setFill(Color.LIGHTGREY);
        Text attack2 = new Text(943, 494, player2.getHero().getAttack().intValue() + "");
        attack2.setFont(new Font(45));
        attack2.setFill(Color.LIGHTGREY);
        Text level1 = new Text(315, 57, player1.getHero().getLevelHero() + "");
        level1.setFont(new Font(50));
        level1.setFill(Color.LIGHTGREY);
        Text level2 = new Text(936, 57, player2.getHero().getLevelHero() + "");
        level2.setFont(new Font(50));
        level2.setFill(Color.LIGHTGREY);
        Text treatment1 = new Text(75, 494, player1.getHero().getTreatment().intValue() + "");
        treatment1.setFont(new Font(45));
        treatment1.setFill(Color.LIGHTGREY);
        Text treatment2 = new Text(1111, 494, player2.getHero().getTreatment().intValue() + "");
        treatment2.setFont(new Font(45));
        treatment2.setFill(Color.LIGHTGREY);
        Text experience1 = new Text(77, 57, player1.getHero().getExperience().intValue() + "");
        experience1.setFont(new Font(50));
        experience1.setFill(Color.LIGHTGREY);
        Text experience2 = new Text(1030, 57, player2.getHero().getExperience().intValue() + "");
        experience2.setFont(new Font(50));
        experience2.setFill(Color.LIGHTGREY);

        if (first) turn = 1;
        else turn = -1;
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

        pane.getChildren().addAll(name1, name2, hitPoints1, hitPoints2, attack1, attack2, level1, level2, treatment1, treatment2, experience1, experience2, imageView1, imageView2);

        AnimationTimer data = new AnimationTimer() {
            @Override
            public void handle(long now) {
                hitPoints1.setText(player1.getHero().getHitPoints().intValue() + "/" + player1.getHero().getSupplyHealth().intValue());
                hitPoints2.setText(player2.getHero().getHitPoints().intValue() + "/" + player2.getHero().getSupplyHealth().intValue());
                attack1.setText(player1.getHero().getAttack().intValue() + "");
                attack2.setText(player2.getHero().getAttack().intValue() + "");
                level1.setText(player1.getHero().getLevelHero() + "");
                level2.setText(player2.getHero().getLevelHero() + "");
                treatment1.setText(player1.getHero().getTreatment().intValue() + "");
                treatment2.setText(player2.getHero().getTreatment().intValue() + "");
                experience1.setText(player1.getHero().getExperience().intValue() + "");
                experience2.setText(player2.getHero().getExperience().intValue() + "");
                player1.getHero().levelUp();
                player2.getHero().levelUp();
                player1.getHero().getSkills().updateSkills(player1.getHero());
                player2.getHero().getSkills().updateSkills(player2.getHero());
            }
        };
        data.start();

    }
}
