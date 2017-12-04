package Heroes;

import BonusDirectory.Bonus;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;

import java.util.List;

public class AHero {

    //Inner:
    private Double attack; //Атака
    private Double treatment; //Лечение
    private Double hitPoints; //Здоровье
    private Double supplyHealth; //Запас здоровья
    private Double currentExperience = 0.0; //Текущий опыт
    private int levelHero; //Уровень героя
    private List<Double> listOfRequiredExperience;
    private List<Double> listOfSupplyHealth;
    private List<Double> listOfDamage;
    private List<Double> listOfTreatment;
    private List<Skill> collectionOfSkills; //Коллекция суперспособностей


    //Outer:
    private ImageView imageView; //Картинка героя
    private List<Media> listOfAttackVoices;
    private List<Media> listOfTreatmentVoices;
    private Presentation presentation;

    public static class Presentation {
        private final ImageView backGround;
        private final List<Media> listOfPresentationMedia;
        private Pane pane;
        private List<Bonus> currentCollection;


        public Presentation(ImageView backGround, List<Media> listOfPresentationMedia, Pane pane) {
            backGround.setFitWidth(1280);
            backGround.setFitHeight(720);
            pane.getChildren().add(backGround);
            pane.setVisible(false);
            pane.setOpacity(0);
            this.backGround = backGround;
            this.listOfPresentationMedia = listOfPresentationMedia;
            this.pane = pane;
        }

        public void showPresentation() {
            pane.setVisible(true);
        }

        public void hidePresentation() {
            pane.setVisible(false);
        }

        public ImageView getBackGround() {
            return backGround;
        }

        public List<Media> getListOfPresentationMedia() {
            return listOfPresentationMedia;
        }

        public List<Bonus> getCurentCollection() {
            return currentCollection;
        }

        public void setCurentCollection(List<Bonus> curentCollection) {
            this.currentCollection = curentCollection;
        }

        public Pane getPane() {
            return pane;
        }
    }


    AHero() {
    }

    AHero(Double attack, Double treatment, Double hitPoints, Double supplyHealth, Double currentExperience,
          int levelHero, List<Double> listOfRequiredExperience, List<Double> listOfDamage,
          List<Double> listOfTreatment, List<Double> listOfSupplyHealth,
          List<Skill> collectionOfSkills,
          //Outer:
          ImageView imageView, List<Media> listOfAttackVoices, List<Media> listOfTreatmentVoices) {

        this.attack = attack;
        this.treatment = treatment;
        this.hitPoints = hitPoints;
        this.supplyHealth = supplyHealth;
        this.currentExperience = currentExperience;
        this.levelHero = levelHero;
        this.listOfDamage = listOfDamage;
        this.listOfTreatment = listOfTreatment;
        this.listOfRequiredExperience = listOfRequiredExperience;
        this.listOfSupplyHealth = listOfSupplyHealth;
        this.collectionOfSkills = collectionOfSkills;
        this.imageView = imageView;
        this.listOfAttackVoices = listOfAttackVoices;
        this.listOfTreatmentVoices = listOfTreatmentVoices;
    }


    AHero(Presentation presentation) {
        this.presentation = presentation;
    }

    abstract static class Skill {
        private ImageView pictureOfDescription;
        private ImageView sprite;
        private List<Media> listOfVoices;
        private Media soundOfAnimation;

        public Skill(ImageView pictureOfDescription, ImageView sprite, List<Media> listOfVoices, Media soundOfAnimation) {
            sprite.setOnMouseEntered(event -> showDescription());
            sprite.setOnMouseExited(event -> hideDescription());
            sprite.setOnMouseClicked(event -> run());
            this.pictureOfDescription = pictureOfDescription;
            this.sprite = sprite;
            this.listOfVoices = listOfVoices;
            this.soundOfAnimation = soundOfAnimation;
        }


        abstract void run();

        private void showDescription() {
            pictureOfDescription.setVisible(true);
        }

        private void hideDescription() {
            pictureOfDescription.setVisible(false);
        }

        public void initSkill(Pane paneControlSkill) {
            pictureOfDescription.setVisible(false);
            paneControlSkill.getChildren().add(sprite);
            paneControlSkill.getChildren().add(sprite);
        }
    }

    public Presentation getPresentation() {
        return presentation;
    }

    public void setPresentation(Presentation presentation) {
        this.presentation = presentation;
    }

    public ImageView getImageView() {
        return imageView;
    }
}
