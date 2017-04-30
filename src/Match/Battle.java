package Match;

import javafx.animation.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import javafx.scene.text.*;

import java.util.TimerTask;

import static InitializationGame.WindowMatchMaking1.launch;

import static controller.ControllerChoiceHero.player1;
import static controller.ControllerChoiceHero.player2;
import static javafx.application.Platform.exit;

public class Battle {
    public static int turn = 0;
    public static int turns = 0;
    private static ImageView dpsHero = new ImageView(new Image("file:src\\Picture\\Heroes\\GeneralSkills\\dpsHero.png"));
    private static ImageView health = new ImageView(new Image("file:src\\Picture\\Heroes\\GeneralSkills\\health.png"));
    private static Text anyText = new Text(0, 0, "");
    private static ImageView imageView1 = new ImageView(new Image("file:src\\Picture\\Heroes\\GeneralSkills\\dpsHero.png"));//damage
    private static ImageView imageView2 = new ImageView(new Image("file:src\\Picture\\Heroes\\GeneralSkills\\health.png"));//hill

    public static void damageOrHilForSkills(Double damage, Double hil, int indexUlt) {

        if (indexUlt == 11) {
            imageView1.setImage(new Image("file:src\\Picture\\Heroes\\Devourer\\Ults\\DmgSkillDev.png"));
        }
        if (indexUlt == 12) {
            imageView1.setImage(new Image("file:src\\Picture\\Heroes\\Devourer\\Ults\\DmgSkillDev.png"));
            imageView2.setImage(new Image("file:src\\Picture\\Heroes\\Devourer\\Ults\\HealthDevSkill.png"));
        }
        if (indexUlt == 13) {
            imageView1.setImage(new Image("file:src\\Picture\\Heroes\\Devourer\\Ults\\DmgSkillDev.png"));
            imageView2.setImage(new Image("file:src\\Picture\\Heroes\\Devourer\\Ults\\HealthDevSkill.png"));
        }
        if (indexUlt == 21) {
            imageView1.setImage(new Image("file:src\\Picture\\Heroes\\LordWamp\\Ults\\DmgSkillLV.png"));
            imageView2.setImage(new Image("file:src\\Picture\\Heroes\\LordWamp\\Ults\\HealthLVSkill.png"));
        }
        if (indexUlt == 22) {
            imageView1.setImage(new Image("file:src\\Picture\\Heroes\\LordWamp\\Ults\\DmgSkillLV.png"));
        }
        if (indexUlt == 23) {
            imageView2.setImage(new Image("file:src\\Picture\\Heroes\\LordWamp\\Ults\\HealthLVSkill.png"));
        }
        if (indexUlt == 31) {
            imageView1.setImage(new Image("file:src\\Picture\\Heroes\\Basher\\Ults\\DmgSkillBHR.png"));
        }
        if (indexUlt == 32) {
            imageView1.setImage(new Image("file:src\\Picture\\Heroes\\Basher\\Ults\\DmgSkillBHR.png"));
        }
        if (indexUlt == 33) {
            imageView1.setImage(new Image("file:src\\Picture\\Heroes\\Basher\\Ults\\DmgSkillBHR.png"));
        }
        if (damage != null) {
            imageView1.toFront();
            imageView1.setOpacity(1);
            ImageView imageView;
            if (turn == -1) imageView = player1.getHero().getImage();
            else imageView = player2.getHero().getImage();
            ImageView finalImageView1 = imageView1;
            AnimationTimer gameLoop = new AnimationTimer() {
                int k = 1;

                @Override
                public void handle(long now) {
                    if (turn == -1) {
                        imageView.setLayoutX(imageView.getLayoutX() + 30 * k);
                        if (imageView.getLayoutX() > 640) {
                            finalImageView1.setFitWidth(300);
                            finalImageView1.setFitHeight(300);
                            finalImageView1.setLayoutY(140);
                            finalImageView1.setLayoutX(930);


                            anyText.setText(damage.intValue() + "");
                            anyText.setLayoutY(350);
                            anyText.setLayoutX(1000);
                            anyText.toFront();
                            k *= -1;
                            imageView.setLayoutX(imageView.getLayoutX() - 40);
                        }
                        if (imageView.getLayoutX() < 50) {
                            imageView.setLayoutX(50);

                            FadeTransition fadeTransition = new FadeTransition(Duration.seconds(1), finalImageView1);
                            fadeTransition.setFromValue(1);
                            fadeTransition.setToValue(0);
                            fadeTransition.setCycleCount(1);
                            fadeTransition.setOnFinished(event -> imageView1.setLayoutY(-10000));

                            ScaleTransition scaleTransition = new ScaleTransition(Duration.seconds(0.5), anyText);
                            scaleTransition.setFromX(1);
                            scaleTransition.setFromY(1);
                            scaleTransition.setToX(1.2);
                            scaleTransition.setToY(1.2);

                            scaleTransition.setCycleCount(1);
                            scaleTransition.setOnFinished(event -> anyText.toBack());

                            scaleTransition.play();
                            fadeTransition.play();

                            stop();
                        }
                    } else {
                        imageView.setLayoutX(imageView.getLayoutX() - 30 * k);
                        if (imageView.getLayoutX() < 330) {
                            finalImageView1.toFront();
                            finalImageView1.setFitWidth(300);
                            finalImageView1.setFitHeight(300);
                            finalImageView1.setLayoutY(140);
                            finalImageView1.setLayoutX(50);

                            anyText.setText(damage.intValue() + "");
                            anyText.setLayoutY(350);
                            anyText.setLayoutX(100);
                            anyText.toFront();
                            k *= -1;
                            imageView.setLayoutX(imageView.getLayoutX() + 40);
                        }
                        if (imageView.getLayoutX() > 960) {
                            imageView.setLayoutX(940);
                            FadeTransition fadeTransition = new FadeTransition(Duration.seconds(1), finalImageView1);
                            fadeTransition.setFromValue(1);
                            fadeTransition.setToValue(0);
                            fadeTransition.setCycleCount(1);
                            fadeTransition.setOnFinished(event -> imageView1.setLayoutY(-10000));
                            ScaleTransition scaleTransition = new ScaleTransition(Duration.seconds(0.5), anyText);
                            scaleTransition.setFromX(1);
                            scaleTransition.setFromY(1);
                            scaleTransition.setToX(1.2);
                            scaleTransition.setToY(1.2);

                            scaleTransition.setCycleCount(1);
                            scaleTransition.setOnFinished(event -> anyText.toBack());

                            scaleTransition.play();
                            fadeTransition.play();

                            stop();
                        }
                    }
                }
            };
            gameLoop.start();
        }
        if (hil != null) {
            imageView2.toFront();
            imageView2.setOpacity(1);
            ImageView finalImageView = imageView2;
            AnimationTimer gameLoop = new AnimationTimer() {
                @Override
                public void handle(long now) {

                    if (turn == -1) {
                        finalImageView.setFitWidth(300);
                        finalImageView.setFitHeight(300);
                        finalImageView.setLayoutX(50);
                        finalImageView.setLayoutY(140);

                        anyText.setText(hil.intValue() + "");
                        anyText.setLayoutY(350);
                        anyText.setLayoutX(100);
                        anyText.toFront();

                    } else {
                        finalImageView.setLayoutX(940);
                        finalImageView.setLayoutY(140);
                        finalImageView.setFitWidth(300);
                        finalImageView.setFitHeight(300);

                        anyText.setText(hil.intValue() + "");
                        anyText.setLayoutY(350);
                        anyText.setLayoutX(1000);
                        anyText.toFront();
                    }
                    FadeTransition fadeTransition = new FadeTransition(Duration.seconds(1), finalImageView);
                    fadeTransition.setFromValue(1);
                    fadeTransition.setToValue(0);
                    fadeTransition.setCycleCount(1);
                    fadeTransition.setOnFinished(event -> imageView2.setLayoutY(-10000));
                    ScaleTransition scaleTransition = new ScaleTransition(Duration.seconds(0.5), anyText);
                    scaleTransition.setFromX(1);
                    scaleTransition.setFromY(1);
                    scaleTransition.setToX(1.2);
                    scaleTransition.setToY(1.2);

                    scaleTransition.setCycleCount(1);
                    scaleTransition.setOnFinished(event -> anyText.toBack());
                    scaleTransition.play();
                    fadeTransition.play();

                    stop();
                }
            };
            gameLoop.start();
        }
    }

    private static void damageVisual(Player player1, Player player2) {
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
                        dpsHero.setLayoutY(140);
                        dpsHero.setLayoutX(940);
                        dpsHero.toFront();

                        anyText.setText(player1.getHero().getAttack().intValue() + "");
                        anyText.setLayoutY(350);
                        anyText.setLayoutX(1000);
                        anyText.toFront();
                        k *= -1;
                        imageView.setLayoutX(imageView.getLayoutX() - 40);
                    }
                    if (imageView.getLayoutX() < 50) {
                        imageView.setLayoutX(50);

                        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(1), dpsHero);
                        fadeTransition.setFromValue(1);
                        fadeTransition.setToValue(0);
                        fadeTransition.setCycleCount(1);
                        fadeTransition.setOnFinished(event -> dpsHero.toBack());

                        ScaleTransition scaleTransition = new ScaleTransition(Duration.seconds(0.5), anyText);
                        scaleTransition.setFromX(1);
                        scaleTransition.setFromY(1);
                        scaleTransition.setToX(1.2);
                        scaleTransition.setToY(1.2);

                        scaleTransition.setCycleCount(1);
                        scaleTransition.setOnFinished(event -> anyText.toBack());

                        scaleTransition.play();
                        fadeTransition.play();
                        stop();
                    }
                } else {
                    imageView.setLayoutX(imageView.getLayoutX() - 30 * k);
                    if (imageView.getLayoutX() < 330) {
                        dpsHero.toFront();
                        dpsHero.setLayoutY(140);
                        dpsHero.setLayoutX(50);
                        anyText.setText(player2.getHero().getAttack().intValue() + "");
                        anyText.setLayoutY(350);
                        anyText.setLayoutX(100);
                        anyText.toFront();
                        k *= -1;
                        imageView.setLayoutX(imageView.getLayoutX() + 40);
                    }
                    if (imageView.getLayoutX() > 960) {
                        imageView.setLayoutX(940);
                        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(1), dpsHero);
                        fadeTransition.setFromValue(1);
                        fadeTransition.setToValue(0);
                        fadeTransition.setCycleCount(1);
                        fadeTransition.setOnFinished(event -> dpsHero.toBack());
                        ScaleTransition scaleTransition = new ScaleTransition(Duration.seconds(0.5), anyText);
                        scaleTransition.setFromX(1);
                        scaleTransition.setFromY(1);
                        scaleTransition.setToX(1.2);
                        scaleTransition.setToY(1.2);

                        scaleTransition.setCycleCount(1);
                        scaleTransition.setOnFinished(event -> anyText.toBack());

                        scaleTransition.play();
                        fadeTransition.play();
                        stop();
                    }
                }
            }
        };
        gameLoop.start();
    }

    private static void treatmentVisual() throws InterruptedException {

        AnimationTimer gameLoop = new AnimationTimer() {
            @Override
            public void handle(long now) {

                if (turn == -1) {

                    health.setLayoutX(50);
                    health.setLayoutY(140);
                    anyText.setText(player1.getHero().getTreatment().intValue() + "");
                    anyText.setLayoutY(350);
                    anyText.setLayoutX(100);
                    anyText.toFront();

                } else {
                    health.setLayoutX(940);
                    health.setLayoutY(140);
                    anyText.setText(player2.getHero().getTreatment().intValue() + "");
                    anyText.setLayoutY(350);
                    anyText.setLayoutX(1000);
                    anyText.toFront();
                }
                FadeTransition fadeTransition = new FadeTransition(Duration.seconds(1), health);
                fadeTransition.setFromValue(1);
                fadeTransition.setToValue(0);
                fadeTransition.setCycleCount(1);
                ScaleTransition scaleTransition = new ScaleTransition(Duration.seconds(0.5), anyText);
                scaleTransition.setFromX(1);
                scaleTransition.setFromY(1);
                scaleTransition.setToX(1.2);
                scaleTransition.setToY(1.2);

                scaleTransition.setCycleCount(1);
                scaleTransition.setOnFinished(event -> anyText.toBack());
                scaleTransition.play();
                fadeTransition.play();
                stop();
            }
        };
        gameLoop.start();
    }

    public static void damage(Player player1, Player player2) {
        damageVisual(player1, player2);
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


    public static void treatment(Player player1, Player player2) throws InterruptedException {
        if (turn == 1)
            player1.getHero().setHitPoints(player1.getHero().getHitPoints() + player1.getHero().getTreatment());
        else player2.getHero().setHitPoints(player2.getHero().getHitPoints() + player2.getHero().getTreatment());
        treatmentVisual();
        turn *= -1;
    }


    public static void battleProcess(Pane pane, Player player1, Player player2, Boolean first) {
        imageView1.setLayoutY(-10000);
        imageView2.setLayoutY(-10000);

        anyText.setFill(Color.LIGHTGREY);
        anyText.setFont(new Font("Times New Roman", 150));
        Text label1 = new Text(536, 80, "480");
        label1.setFont(new Font("Times New Roman", 30));
        label1.setFill(Color.LIGHTBLUE);
        int[] time = {480}; //Чтобы внутри события был доступен, делаем в виде массива.
        Timeline timeline = new Timeline(
                new KeyFrame(
                        Duration.seconds(1), //1000 мс * 60 сек = 1 мин
                        ae -> {
                            time[0]--;
                            label1.setText("" + time[0]);
                        }
                )
        );
        timeline.setCycleCount(480);
        Text label2 = new Text(716, 80, "480");
        label2.setFont(new Font("Times New Roman", 30));
        label2.setFill(Color.RED);
        int[] time2 = {480}; //Чтобы внутри события был доступен, делаем в виде массива.
        Timeline timeline2 = new Timeline(
                new KeyFrame(
                        Duration.seconds(1), //1000 мс * 60 сек = 1 мин
                        ae -> {
                            time2[0]--;
                            label2.setText("" + time2[0]);
                        }
                )
        );
        timeline2.setCycleCount(480);
        timeline.setOnFinished(event -> exit());
        timeline2.setOnFinished(event -> exit());

        //Ограничим число повторений
        if (turn == 1) timeline.play();
        else timeline2.play();

        Text name1 = new Text(486, 44, player1.getProfileName());
        name1.setFont(new Font("Times New Roman", 30));
        name1.setFill(Color.LIGHTBLUE);
        Text name2 = new Text(666, 44, player2.getProfileName());
        name2.setFont(new Font("Times New Roman", 30));
        name2.setFill(Color.RED);
        Text hitPoints1 = new Text(8, 104, player1.getHero().getHitPoints().intValue() + "/"
                + player1.getHero().getSupplyHealth().intValue());
        hitPoints1.setFont(new Font(30));
        hitPoints1.setFill(Color.LIGHTGREY);
        Text hitPoints2 = new Text(1070, 104, player2.getHero().getHitPoints().intValue() + "/"
                + player2.getHero().getSupplyHealth().intValue());
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
        dpsHero.setLayoutX(950);
        dpsHero.setLayoutY(-1000);
        dpsHero.setFitWidth(300);
        dpsHero.setFitHeight(300);

        health.setLayoutX(950);
        health.setLayoutY(-1000);
        health.setFitWidth(300);
        health.setFitHeight(300);

        pane.getChildren().addAll(label1, label2, name1, name2, hitPoints1, hitPoints2, attack1, attack2,
                level1, level2, treatment1, treatment2, experience1, experience2, dpsHero, health, imageView1, imageView2, anyText);
        java.util.Timer timer = new java.util.Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                if (turn == 1) {
                    timeline2.pause();
                    timeline.play();
                } else {
                    timeline.pause();
                    timeline2.play();
                }
                hitPoints1.setText(player1.getHero().getHitPoints().intValue() + "/"
                        + player1.getHero().getSupplyHealth().intValue());
                hitPoints2.setText(player2.getHero().getHitPoints().intValue() + "/"
                        + player2.getHero().getSupplyHealth().intValue());
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
        timer.schedule(timerTask, 0, 1000);
    }
}
