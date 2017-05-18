package Skills;

import Heroes.Hero;
import Main.Sound;
import javafx.animation.FadeTransition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;

import java.io.File;

import static Match.Battle.turn;
import static Match.Battle.turns;
import static controller.ControllerChoiceHero.battle;
import static controller.ControllerChoiceHero.player1;
import static controller.ControllerChoiceHero.player2;


public class SkillsDev implements Skill {
    private boolean firstOpen = false;
    private boolean twoOpen = false;
    private boolean threeOpen = false;
    private ImageView[] imageViewsText = {
            new ImageView(new Image("file:src\\Picture\\Skills\\11.png")),
            new ImageView(new Image("file:src\\Picture\\Skills\\12.png")),
            new ImageView(new Image("file:src\\Picture\\Skills\\13.png"))
    };
    private ImageView[] imageViewList = {
            new ImageView(new Image("file:src\\Picture\\Skills\\SkillDev1.png")),
            new ImageView(new Image("file:src\\Picture\\Skills\\SkillDev2.png")),
            new ImageView(new Image("file:src\\Picture\\Skills\\SkillDev3.png"))};
    private Sound[] sounds = {
            new Sound(new File("src\\Sounds\\SoundDevourer\\DevSkill1-1.wav")),
            new Sound(new File("src\\Sounds\\SoundDevourer\\DevSkill2-1.wav")),
            new Sound(new File("src\\Sounds\\SoundDevourer\\DevSkill3-1.wav"))
} ;
    private int turnOpen2 = 0;
    private int turnOpen3 = 0;
    private int effect1 = -1;
    private int effect2 = -1;

    public SkillsDev(Hero hero) {
        imageViewList[0].addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            if (firstOpen && ((turn == 1 && hero.getLocation()) || (turn == -1 && !hero.getLocation()))) {
                turns++;
                turn *= -1;
                firstUlt();
            }
        });


        imageViewList[1].addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            if (twoOpen && ((turn == 1 && hero.getLocation()) || (turn == -1 && !hero.getLocation()))) {
                turns++;
                turn *= -1;
                twoUlt();
            }
        });
        imageViewList[2].addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            if (threeOpen && ((turn == 1 && hero.getLocation()) || (turn == -1 && !hero.getLocation()))) {
                turns++;
                turn *= -1;
                threeUlt();
            }
        });


        for (int i = 0; i < 3; i++) {
            imageViewList[i].setOpacity(0.3);
            imageViewList[i].setFitHeight(112);
            imageViewList[i].setFitWidth(112);
            imageViewList[i].setLayoutY(547);
        }

        if (hero.getLocation()) {
            imageViewList[0].setLayoutX(29);
            imageViewList[1].setLayoutX(108);
            imageViewList[2].setLayoutX(177);
        } else {
            for (int i = 0; i < 3; i++) {
                imageViewList[i].setScaleX(-1);
            }
            imageViewList[0].setLayoutX(983);
            imageViewList[1].setLayoutX(1058);
            imageViewList[2].setLayoutX(1131);
        }
        for (int i = 0; i < 3; i++) {
            imageViewsText[i].setOpacity(0);
            imageViewsText[i].setFitHeight(75);
            imageViewsText[i].setFitWidth(100);
            imageViewsText[i].setLayoutY(472);
            imageViewsText[i].setLayoutX(imageViewList[i].getLayoutX());
            int finalI = i;
            imageViewsText[i].addEventHandler(MouseEvent.MOUSE_ENTERED, mouseEvent -> {
                        FadeTransition fadeTransition = new FadeTransition(Duration.millis(1000), imageViewsText[finalI]);
                        fadeTransition.setToValue(0.8);
                        fadeTransition.setCycleCount(1);
                        FadeTransition fadeTransition2 = new FadeTransition(Duration.millis(1000), imageViewsText[finalI]);
                        fadeTransition2.setToValue(0);
                        fadeTransition2.setCycleCount(1);
                        fadeTransition2.delayProperty().setValue(Duration.seconds(1));
                        fadeTransition.setOnFinished(event -> fadeTransition2.play());
                        fadeTransition.play();
                    }
            );
        }
    }

    @Override
    public ImageView[] getImageViewsText() {
        return imageViewsText;
    }

    @Override
    public void setImageViewsText(ImageView[] imageViewsText) {
        this.imageViewsText = imageViewsText;
    }

    @Override
    public ImageView[] getImageViewList() {
        return imageViewList;
    }

    @Override
    public void firstUlt() {
        sounds[0].play();
        firstOpen = false;

        if (turn == -1) {
            player2.getHero().setHitPoints(player2.getHero().getHitPoints() - player1.getHero().getAttack() * 5);
            battle.damageOrHilForSkills(player1.getHero().getAttack() * 5, null, 11);
        } else {
            player1.getHero().setHitPoints(player1.getHero().getHitPoints() - player2.getHero().getAttack() * 5);
            battle.damageOrHilForSkills(player2.getHero().getAttack() * 5, null, 11);
        }
    }

    @Override
    public void twoUlt() {
        sounds[1].play();
        twoOpen = false;
        if (turn == -1) {
            player1.getHero().setHitPoints(player1.getHero().getHitPoints() + player1.getHero().getTreatment() * 1.4);
            battle.damageOrHilForSkills(null, player2.getHero().getTreatment() * 1.4, 12);
            effect1 = turns;
        } else {
            player2.getHero().setHitPoints(player2.getHero().getHitPoints() + player2.getHero().getTreatment() * 1.4);
            battle.damageOrHilForSkills(null, player1.getHero().getTreatment() * 1.4, 12);
            effect2 = turns;
        }
    }

    @Override
    public void threeUlt() {
        sounds[2].play();
        threeOpen = false;
        if (turn == -1) {
            player2.getHero().setHitPoints(player2.getHero().getHitPoints() / 2);
            battle.damageOrHilForSkills(player1.getHero().getHitPoints() / 2, null, 12);
        } else {
            player1.getHero().setHitPoints(player1.getHero().getHitPoints() / 2);
            battle.damageOrHilForSkills(player2.getHero().getHitPoints() / 2, null, 12);
        }
    }

    @Override
    public boolean isFirstOpen() {
        return firstOpen;
    }

    @Override
    public void setFirstOpen(boolean firstOpen) {
        this.firstOpen = firstOpen;
    }

    @Override
    public boolean isTwoOpen() {
        return twoOpen;
    }

    @Override
    public void setTwoOpen(boolean twoOpen) {
        this.twoOpen = twoOpen;
    }

    @Override
    public boolean isThreeOpen() {
        return threeOpen;
    }

    @Override
    public void setThreeOpen(boolean threeOpen) {
        this.threeOpen = threeOpen;
    }

    public void updateSkills(Hero hero) {
        if (effect1 + 2 == turns && effect1 != -1) {
            effect1 = -1;
            player1.getHero().setHitPoints(player1.getHero().getHitPoints() + player1.getHero().getTreatment() * 1.4);
        }

        if (effect2 + 2 == turns && effect2 != -1) {
            effect2 = -1;
            player2.getHero().setHitPoints(player2.getHero().getHitPoints() + player2.getHero().getTreatment() * 1.4);
        }

        if (turnOpen2 == 0 && hero.getLevelHero() >= 3) turnOpen2 = turns;
        if (turnOpen3 == 0 && hero.getLevelHero() >= 5) turnOpen3 = turns;

        if (turns % 10 == 0 && turns > 0) {
            firstOpen = true;
            FadeTransition fadeTransition = new FadeTransition(Duration.millis(400), imageViewList[0]);
            fadeTransition.setFromValue(0.3);
            fadeTransition.setToValue(1);
            fadeTransition.setCycleCount(1);
            fadeTransition.play();
        }

        if ((turns - turnOpen2) % 14 == 0 && hero.getLevelHero() >= 3) {
            FadeTransition fadeTransition = new FadeTransition(Duration.millis(400), imageViewList[1]);
            fadeTransition.setFromValue(0.3);
            fadeTransition.setToValue(1);
            fadeTransition.setCycleCount(1);
            fadeTransition.play();
            twoOpen = true;
        }

        if ((turns - turnOpen3) % 12 == 0 && hero.getLevelHero() >= 6) {
            FadeTransition fadeTransition = new FadeTransition(Duration.millis(400), imageViewList[2]);
            fadeTransition.setFromValue(0.3);
            fadeTransition.setToValue(1);
            fadeTransition.setCycleCount(1);
            fadeTransition.play();
            threeOpen = true;
        }

        if (!firstOpen) imageViewList[0].setOpacity(0.3);
        if (!twoOpen) imageViewList[1].setOpacity(0.3);
        if (!threeOpen) imageViewList[2].setOpacity(0.3);
    }
}
