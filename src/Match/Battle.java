package Match;

import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.ImageCursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;
import static InitializationGame.WindowMatchMaking1.launch;
import static Main.BuildStage.*;
import static Match.winnerScene.winInfoUpdate;


public class Battle {
    public Battle() {}

    public static int turn = 0;
    public static int turns = 0;
    private static ImageView dpsHero = new ImageView(new Image("file:src\\Picture\\Heroes\\GeneralSkills\\dpsHero.png"));
    private static ImageView health = new ImageView(new Image("file:src\\Picture\\Heroes\\GeneralSkills\\health.png"));
    private static Text anyText = new Text(0, 0, "");
    private static ImageView imageView1 = new ImageView(new Image("file:src\\Picture\\Heroes\\GeneralSkills\\dpsHero.png"));//damage
    private static ImageView imageView2 = new ImageView(new Image("file:src\\Picture\\Heroes\\GeneralSkills\\health.png"));//hill
    private int[] time = {480};
    private int[] time2 = {480};
    private static ImageView fire = new ImageView(new Image("file:src\\Picture\\Triggers\\fire.gif"));
    private static ImageView icon = new ImageView(new Image("file:src\\Picture\\Triggers\\Icon.png"));
    private TimerTask timerTask;

    private void winAnim() {
        timerTask.cancel();
        ImageView imageView;
        Path path1;
        ImageView imageView2;
        Path path2;
        if (turn == -1 && player2.getHero().getHitPoints()<0) {
            imageView = player1.getHero().getImage();
            path1 = new Path(new MoveTo(150, 140), new LineTo(730, 140));
            imageView2 = player2.getHero().getImage();
            path2 = new Path(new MoveTo(150, 140), new LineTo(500, -500));
        } else {
            imageView = player2.getHero().getImage();
            path1 = new Path(new MoveTo(150, 140), new LineTo(-480, 140));
            imageView2 = player1.getHero().getImage();
            path2 = new Path(new MoveTo(150, 140), new LineTo(-500, -500));
        }

        RotateTransition rotateTransition = new RotateTransition(Duration.millis(500), imageView2);
        rotateTransition.setByAngle(360 * 5);
        rotateTransition.setCycleCount(1);
        rotateTransition.setOnFinished((ActionEvent event) -> {
            player1.setReachedLevel((byte) player1.getHero().getLevelHero());
            player2.setReachedLevel((byte) player2.getHero().getLevelHero());
            player1.setRemainingTime(time[0]);


            player2.setRemainingTime(time2[0]);
            if (player1.getHero().getHitPoints() < 0 && turn == -1)
                try {
                    winInfoUpdate(profile1, profile2, false);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            else try {
                winInfoUpdate(profile1, profile2, true);
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {

                Parent rootInit = FXMLLoader.load(getClass().getResource("../fxmlFiles/WindowTotalMatch.fxml"));
                Scene sceneInit = new Scene(rootInit, 1280, 720);
                azironStage.setScene(sceneInit);
                Image cursor = new Image("file:src\\Picture\\Mouse\\Mouse.png");
                ImageCursor imageCursor = new ImageCursor(cursor);
                azironStage.getScene().setCursor(imageCursor);

            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        PathTransition pathTransition2 = new PathTransition(Duration.millis(1000), path2, imageView2);
        pathTransition2.setCycleCount(1);


        PathTransition pathTransition = new PathTransition(Duration.millis(1000), path1, imageView);
        pathTransition.setCycleCount(1);
        pathTransition.setOnFinished(event -> {
            pathTransition2.play();
            rotateTransition.play();
        });
        pathTransition.play();

    }


    public void damageOrHilForSkills(Double damage, Double hil, int indexUlt) {

        //благодаря разному исполнению визуализации
        // есть разница в скорости и качестве анимации!!!
        // именно по этому не стал делать это как общую функцию
        if (turn == -1) {
            if (damage != null) player1.setDealDamage((int) (player1.getDealDamage() + damage));
            if (hil != null) player1.setRestoredHitPoints((int) (player1.getRestoredHitPoints() + hil));
            player1.setUsedSkills((byte) (player1.getUsedSkills() + 1));
        } else {
            if (damage != null) player2.setDealDamage((int) (player2.getDealDamage() + damage));
            if (hil != null) player2.setRestoredHitPoints((int) (player2.getRestoredHitPoints() + hil));
            player2.setUsedSkills((byte) (player2.getUsedSkills() + 1));
        }
        if (indexUlt == 11) {
            imageView1.setImage(new Image("file:src\\Picture\\Heroes\\Devourer\\Ults\\DmgSkillDev.png"));
        }
        if (indexUlt == 12) {
            imageView1.setImage(new Image("file:src\\Picture\\Heroes\\Devourer\\Ults\\DmgSkillDev.png"));
            imageView2.setImage(new Image("file:src\\Picture\\Heroes\\Devourer\\Ults\\HealthDevSkill.png"));
        }
        if (indexUlt == 13) {
            imageView1.setImage(new Image("file:src\\Picture\\Heroes\\Devourer\\Ults\\DmgSkillDev.png"));
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
            ImageView imageView;
            Path path;
            imageView1.setFitWidth(300);
            imageView1.setFitHeight(300);
            if (turn == -1) {
                imageView = player1.getHero().getImage();
                path = new Path(new MoveTo(150, 140), new LineTo(730, 140), new LineTo(150, 140));
                imageView1.setLayoutX(940);
                anyText.setText(damage.intValue() + "");
                anyText.setLayoutX(1000);
            } else {
                imageView = player2.getHero().getImage();
                path = new Path(new MoveTo(150, 140), new LineTo(-480, 140), new LineTo(150, 140));
                imageView1.setLayoutX(50);
                anyText.setText(damage.intValue() + "");
                anyText.setLayoutX(100);
            }

            PathTransition pathTransition = new PathTransition(Duration.millis(1000), path, imageView);
            pathTransition.setCycleCount(1);
            pathTransition.play();
            TranslateTransition transition = new TranslateTransition(Duration.millis(500), new Rectangle(-10, -10, 1, 1));
            transition.setByX(2);
            transition.setCycleCount(1);
            transition.setOnFinished(event -> {
                imageView1.setLayoutY(140);
                anyText.setLayoutY(350);
                imageView1.toFront();
                anyText.toFront();
                FadeTransition fadeTransition = new FadeTransition(Duration.seconds(1), imageView1);
                fadeTransition.setFromValue(1);
                fadeTransition.setToValue(0);
                fadeTransition.setCycleCount(1);
                fadeTransition.setOnFinished(event2 -> imageView1.setLayoutY(-10000));
                ScaleTransition scaleTransition = new ScaleTransition(Duration.seconds(1), anyText);
                scaleTransition.setFromX(1);
                scaleTransition.setFromY(1);
                scaleTransition.setToX(1.2);
                scaleTransition.setToY(1.2);
                scaleTransition.setCycleCount(1);
                scaleTransition.setOnFinished(event2 -> {
                    anyText.toBack();
                    if (indexUlt == 31) {
                        turn *= -1;
                    }
                });
                scaleTransition.play();
                fadeTransition.play();
            });
            transition.play();
            if ((player1.getHero().getHitPoints() < 0 && (turn == -1)) || ((turn == 1) && player2.getHero().getHitPoints() < 0))
                winAnim();
        }
        if (hil != null) {
            imageView2.setFitWidth(300);
            imageView2.setFitHeight(300);
            imageView2.toFront();
            imageView2.setOpacity(1);
            anyText.setText(hil.intValue() + "");

            if (turn == -1) {
                imageView2.setLayoutX(50);
                imageView2.setLayoutY(140);
                anyText.setLayoutX(100);
            } else {
                imageView2.setLayoutX(940);
                imageView2.setLayoutY(140);
                anyText.setLayoutX(1000);
            }

            anyText.setLayoutY(350);
            anyText.toFront();
            FadeTransition fadeTransition = new FadeTransition(Duration.seconds(1), imageView2);
            fadeTransition.setFromValue(1);
            fadeTransition.setToValue(0);
            fadeTransition.setCycleCount(1);
            fadeTransition.setOnFinished(event -> imageView2.setLayoutY(-10000));
            ScaleTransition scaleTransition = new ScaleTransition(Duration.seconds(1), anyText);
            scaleTransition.setFromX(1);
            scaleTransition.setFromY(1);
            scaleTransition.setToX(1.2);
            scaleTransition.setToY(1.2);
            scaleTransition.setCycleCount(1);
            scaleTransition.setOnFinished(event -> anyText.setLayoutY(-10000));
            scaleTransition.play();
            fadeTransition.play();
        }

    }

    private static void damageVisual(Player player1, Player player2) {
        ImageView imageView;
        Path path;

        if (turn == 1) {
            imageView = player1.getHero().getImage();
            path = new Path(new MoveTo(150, 140), new LineTo(730, 140), new LineTo(150, 140));
            dpsHero.setLayoutX(940);
            anyText.setText(player1.getHero().getAttack().intValue() + "");
            anyText.setLayoutX(1000);
            player1.getHero().soundAttack();
        } else {
            imageView = player2.getHero().getImage();
            path = new Path(new MoveTo(150, 140), new LineTo(-480, 140), new LineTo(150, 140));
            dpsHero.setLayoutX(50);
            anyText.setText(player2.getHero().getAttack().intValue() + "");
            anyText.setLayoutX(100);
            player2.getHero().soundAttack();
        }

        PathTransition pathTransition = new PathTransition(Duration.millis(1000), path, imageView);
        pathTransition.setCycleCount(1);
        pathTransition.play();

        TranslateTransition transition = new TranslateTransition(Duration.millis(500), new Rectangle(-10, -10, 1, 1));
        transition.setByX(2);
        transition.setCycleCount(1);
        transition.setOnFinished(event -> {
            dpsHero.setLayoutY(140);
            anyText.setLayoutY(350);
            dpsHero.toFront();
            anyText.toFront();
            FadeTransition fadeTransition = new FadeTransition(Duration.seconds(1), dpsHero);
            fadeTransition.setFromValue(1);
            fadeTransition.setToValue(0);
            fadeTransition.setCycleCount(1);
            fadeTransition.setOnFinished(event2 -> dpsHero.setLayoutY(-10000));
            ScaleTransition scaleTransition = new ScaleTransition(Duration.seconds(1), anyText);
            scaleTransition.setFromX(1);
            scaleTransition.setFromY(1);
            scaleTransition.setToX(1.2);
            scaleTransition.setToY(1.2);
            scaleTransition.setCycleCount(1);
            scaleTransition.setOnFinished(event2 -> anyText.setLayoutY(-10000));
            scaleTransition.play();
            fadeTransition.play();
        });
        transition.play();
    }


    private static void treatmentVisual() throws InterruptedException {

        if (turn == 1) {
            health.setLayoutX(50);
            anyText.setText(player1.getHero().getTreatment().intValue() + "");
            anyText.setLayoutX(100);
            player1.getHero().soundTreatment();
        } else {
            health.setLayoutX(940);
            anyText.setText(player2.getHero().getTreatment().intValue() + "");
            anyText.setLayoutX(1000);
            player2.getHero().soundTreatment();
        }
        health.setLayoutY(140);
        health.toFront();
        anyText.setLayoutY(350);
        anyText.toFront();
        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(1), health);
        fadeTransition.setFromValue(1);
        fadeTransition.setToValue(0);
        fadeTransition.setCycleCount(1);
        fadeTransition.setOnFinished(event2 -> health.setLayoutY(-10000));
        ScaleTransition scaleTransition = new ScaleTransition(Duration.seconds(1), anyText);
        scaleTransition.setFromX(1);
        scaleTransition.setFromY(1);
        scaleTransition.setToX(1.2);
        scaleTransition.setToY(1.2);
        scaleTransition.setCycleCount(1);
        scaleTransition.setOnFinished(event -> anyText.setLayoutY(-10000));
        scaleTransition.play();
        fadeTransition.play();
    }

    public void damage(Player player1, Player player2) {
        damageVisual(player1, player2);
        if ((player1.getHero().getHitPoints() < 0) || (player2.getHero().getHitPoints() < 0))
            winAnim();//другое окно
        if (turn == 1) {
            player1.setDealDamage((int) (player1.getDealDamage() + player1.getHero().getAttack()));
        } else {
            player2.setDealDamage((int) (player2.getDealDamage() + player2.getHero().getAttack()));
        }
        if (turn == 1) {
            player2.getHero().setHitPoints(player2.getHero().getHitPoints() - player1.getHero().getAttack());
            player1.getHero().setExperience(player1.getHero().getExperience() + player1.getHero().getAttack());
        } else {
            player1.getHero().setHitPoints(player1.getHero().getHitPoints() - player2.getHero().getAttack());
            player2.getHero().setExperience(player2.getHero().getExperience() + player2.getHero().getAttack());
        }
        turn *= -1;

    }


    public void treatment(Player player1, Player player2) throws InterruptedException {
        if (turn == 1) {
            player1.setRestoredHitPoints((int) (player1.getRestoredHitPoints() + player1.getHero().getTreatment()));
        } else {
            player2.setRestoredHitPoints((int) (player2.getRestoredHitPoints() + player2.getHero().getTreatment()));
        }

        if (turn == 1)
            player1.getHero().setHitPoints(player1.getHero().getHitPoints() + player1.getHero().getTreatment());
        else player2.getHero().setHitPoints(player2.getHero().getHitPoints() + player2.getHero().getTreatment());
        treatmentVisual();
        if ((player1.getHero().getHitPoints() < 0) || (player2.getHero().getHitPoints() < 0))
            winAnim();
        turn *= -1;
    }

    public void battleProcess(Player player1, Player player2) {

        fire.setFitHeight(52);
        fire.setFitWidth(1280);
        fire.setLayoutY(665);
        fire.setLayoutX(0);
        icon.setFitHeight(100);
        icon.setFitWidth(100);
        icon.setLayoutY(635);
        icon.setLayoutX(640 - 50);

        imageView1.setLayoutY(-10000);
        imageView2.setLayoutY(-10000);

        anyText.setFill(Color.LIGHTGREY);
        anyText.setFont(new Font("Times New Roman", 150));
        Text label1 = new Text(536, 80, "480");
        label1.setFont(new Font("Times New Roman", 30));
        label1.setFill(Color.LIGHTBLUE);
        //Чтобы внутри события был доступен, делаем в виде массива.
        Timeline timeline = new Timeline(
                new KeyFrame(
                        Duration.seconds(1),
                        ae -> {
                            time[0]--;
                            label1.setText("" + time[0]);
                            fire.setScaleX(1);
                        }
                )
        );
        timeline.setCycleCount(480);
        Text label2 = new Text(716, 80, "480");
        label2.setFont(new Font("Times New Roman", 30));
        label2.setFill(Color.RED);

        Timeline timeline2 = new Timeline(
                new KeyFrame(
                        Duration.seconds(1),
                        ae -> {
                            time2[0]--;
                            label2.setText("" + time2[0]);
                            fire.setScaleX(-1);
                        }
                )
        );
        timeline2.setCycleCount(480);
        timeline.setOnFinished(event -> winAnim());
        timeline2.setOnFinished(event -> winAnim());

        if (turn == 1) timeline.play();
        else timeline2.play();

        Text name1 = new Text(547, 44, player1.getProfileName());
        name1.setFont(new Font("Times New Roman", 30));
        name1.setTranslateX(-name1.getLayoutBounds().getWidth() / 2);
        name1.setFill(Color.LIGHTBLUE);

        Text name2 = new Text(721, 44, player2.getProfileName());
        name2.setFont(new Font("Times New Roman", 30));
        name2.setTranslateX(-name2.getLayoutBounds().getWidth() / 2);
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
        level1.setFill(Color.DARKBLUE);
        Text level2 = new Text(936, 57, player2.getHero().getLevelHero() + "");
        level2.setFont(new Font(50));
        level2.setFill(Color.DARKBLUE);
        Text treatment1 = new Text(75, 494, player1.getHero().getTreatment().intValue() + "");
        treatment1.setFont(new Font(45));
        treatment1.setFill(Color.LIGHTGREY);
        Text treatment2 = new Text(1111, 494, player2.getHero().getTreatment().intValue() + "");
        treatment2.setFont(new Font(45));
        treatment2.setFill(Color.LIGHTGREY);
        Text experience1 = new Text(77, 47, player1.getHero().getExperience().intValue() + "/" + player1.getHero().getExperienceList()[player1.getHero().getLevelHero()].intValue());
        experience1.setFont(new Font(30));
        experience1.setFill(Color.DARKBLUE);
        Text experience2 = new Text(1030, 47, player2.getHero().getExperience().intValue() + "/" + player2.getHero().getExperienceList()[player2.getHero().getLevelHero()].intValue());
        experience2.setFont(new Font(30));
        experience2.setFill(Color.DARKBLUE);


        dpsHero.setLayoutY(-1000);
        dpsHero.setFitWidth(300);
        dpsHero.setFitHeight(300);
        health.setLayoutY(-1000);
        health.setFitWidth(300);
        health.setFitHeight(300);

        if (Math.random() < 0.5) {
            turn = 1;
            player2.getHero().setExperience(player2.getHero().getAttack());
        } else {
            turn = -1;
            player1.getHero().setExperience(player1.getHero().getAttack());
        }


        Pane pane = new Pane();

        launch(pane, player1, player2);
        pane.getChildren().addAll(label1, label2, name1, name2, hitPoints1, hitPoints2, attack1, attack2,
                treatment1, treatment2, experience1, experience2, level1, level2, dpsHero, health, imageView1, imageView2, anyText, fire, icon);
        Scene scene = new Scene(pane, 1280, 720);
        azironStage.setScene(scene);
        Image cursor = new Image("file:src\\Picture\\Mouse\\Mouse.png");
        ImageCursor imageCursor = new ImageCursor(cursor);
        azironStage.getScene().setCursor(imageCursor);


        timerTask = new TimerTask() {
            @Override
            public void run() {

                if (turn == 1) {
                    timeline2.pause();
                    timeline.play();
                } else {
                    timeline.pause();
                    timeline2.play();
                }
                if (turn == 1 && AzironGame.getControllerBot().getGameWithPC()) {
                    TranslateTransition transition2 = new TranslateTransition(Duration.millis(2000), new Rectangle(-10, -10, 1, 1));
                    transition2.setByX(1);
                    transition2.setCycleCount(1);
                    transition2.setOnFinished(event1 -> {
                        if (turn == 1 && AzironGame.getControllerBot().getGameWithPC()) {
                            Battle.turns++;
                            //Запуск бота первого уровня
                            AzironGame.getControllerBot().playingEasyBot();
                        }
                    });
                    transition2.play();
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
                experience1.setText(player1.getHero().getExperience().intValue() + "/" +
                        player1.getHero().getExperienceList()[player1.getHero().getLevelHero()].intValue());
                experience2.setText(player2.getHero().getExperience().intValue() + "/" +
                        player2.getHero().getExperienceList()[player2.getHero().getLevelHero()].intValue());
                player1.getHero().levelUp();
                player2.getHero().levelUp();
                player1.getHero().getSkills().updateSkills(player1.getHero());
                player2.getHero().getSkills().updateSkills(player2.getHero());
            }
        };
        new Timer().schedule(timerTask, 0, 1000);
    }
}
