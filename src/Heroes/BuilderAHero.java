package Heroes;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BuilderAHero {

    //Метод:
    public static AHero buildDevourer() {
        //Суперспособность 1:
        AHero.Skill skillFlameSnakes = new AHero.Skill(new ImageView(), new ImageView(), new ArrayList<>(), new Media("")) {
            @Override
            void run() {

            }
        };
        //Суперспособность 2:
        AHero.Skill skillRegeneration = new AHero.Skill(new ImageView(), new ImageView(), new ArrayList<>(), new Media("")) {
            @Override
            void run() {

            }
        };
        //Суперспособность 3:
        AHero.Skill skillSplit = new AHero.Skill(new ImageView(), new ImageView(), new ArrayList<>(), new Media("")) {
            @Override
            void run() {

            }
        };
        //Лист, в который ты потом положишь суперспособности:
        List<AHero.Skill> listOfSkills = Arrays.asList(skillFlameSnakes, skillRegeneration, skillSplit);
        //Лист перехода по опыту:
        List<Double> listOfRequiredExperience = Arrays.asList(0.0, 200.0, 488.0, 894.0, 1446.0, 2193.0, 3193.0, 4513.0,
                6229.0, 8465.0, Double.MAX_VALUE);
        //Лист переходов со здоровьем:
        List<Double> listOfSupplyHealth = Arrays.asList(0.0, 80.0, 95.0, 115.0, 140.0, 165.0, 200.0, 235.0, 290.0, 345.0);
        //Лист звуков с атакой:
        List<Media> mediaListOfAttack = Arrays.asList(
                new Media("src\\Sounds\\SoundDevourer\\DevAttack-1.wav"),
                new Media("src\\Sounds\\SoundDevourer\\DevAttack-2.wav"),
                new Media("src\\Sounds\\SoundDevourer\\DevAttack-3.wav"),
                new Media("src\\Sounds\\SoundDevourer\\DevAttack-4.wav"));
        //Лист звуков с лечением:
        List<Media> mediaListOfTreatment = Arrays.asList(
                new Media("src\\Sounds\\SoundDevourer\\DevTreatment-1.wav"),
                new Media("src\\Sounds\\SoundDevourer\\DevTreatment-2.wav"),
                new Media("src\\Sounds\\SoundDevourer\\DevTreatment-3.wav"),
                new Media("src\\Sounds\\SoundDevourer\\DevTreatment-4.wav"));
        //Лист урона
        List<Double> listOfDamage = Arrays.asList(0.0, 8.0, 10.0, 11.0, 14.0, 17.0, 20.0, 23.0, 29.0, 35.0);
        //Лист Лечения
        List<Double> listOfTreatment = Arrays.asList(0.0, 20.0, 24.0, 29.0, 34.0, 42.0, 50.0, 59.0, 72.0, 86.0);
        //Картинка героя:
        ImageView sprite = new ImageView(); //Саня!
        List<Media> mediaListOfPresentation = Arrays.asList(
                new Media("src\\Sounds\\SoundDevourer\\DevGreetings-1.wav"),
                new Media("src\\Sounds\\SoundDevourer\\DevGreetings-2.wav")
        );
        AHero.Presentation presentation = new AHero.Presentation(
                new ImageView(new Image("@../Picture/Windows/DEV_Spotlight.jpg")),
                mediaListOfPresentation, new Pane());

        //Возврат собранного героя:
        return new AHero(40.0, 100.0, 400.0, 400.0, 0.0, 1,
                listOfRequiredExperience, listOfDamage, listOfTreatment, listOfSupplyHealth, listOfSkills, sprite,
                mediaListOfAttack, mediaListOfTreatment);

    }

    public static AHero buildLordVamp() {
        //Суперспособность 1:
        AHero.Skill skillCannibalism = new AHero.Skill(new ImageView(), new ImageView(), new ArrayList<>(), new Media("")) {
            @Override
            void run() {

            }
        };
        // Суперспособность 2:
        AHero.Skill skillsDevilsBlades = new AHero.Skill(new ImageView(), new ImageView(), new ArrayList<>(), new Media("")) {
            @Override
            void run() {

            }
        };
        //Суперспособность 3:
        AHero.Skill skillReincarnation = new AHero.Skill(new ImageView(), new ImageView(), new ArrayList<>(), new Media("")) {
            @Override
            void run() {

            }
        };
        //Лист, в который ты потом положишь суперспособности:
        List<AHero.Skill> listOfSkills = Arrays.asList(skillCannibalism, skillsDevilsBlades, skillReincarnation);
        //Лист перехода по опыту:
        List<Double> listOfRequiredExperience = Arrays.asList(0.0, 250.0, 610.0, 1114.0, 1794.0, 2730.0, 3980.0, 5619.0, 7767.0, 10562.0, Double.MAX_VALUE);

        //Лист переходов со здоровьем:
        List<Double> listOfSupplyHealth = Arrays.asList(0.0, 60.0, 70.0, 90.0, 105.0, 120.0, 150.0, 180.0, 225.0, 250.0);
        //Лист звуков с атакой:
        List<Media> mediaListOfAttack = Arrays.asList(
                new Media("src\\Sounds\\SoundLordVampire\\LVAttack-1.wav"),
                new Media("src\\Sounds\\SoundLordVampire\\LVAttack-2.wav"),
                new Media("src\\Sounds\\SoundLordVampire\\LVAttack-3.wav"),
                new Media("src\\Sounds\\SoundLordVampire\\LVAttack-4.wav"));
        //Лист звуков с лечением:
        List<Media> mediaListOfTreatment = Arrays.asList(
                new Media("src\\Sounds\\SoundLordVampire\\LVTreatment-1.wav"),
                new Media("src\\Sounds\\SoundLordVampire\\LVTreatment-2.wav"),
                new Media("src\\Sounds\\SoundLordVampire\\LVTreatment-3.wav"),
                new Media("src\\Sounds\\SoundLordVampire\\LVTreatment-4.wav"));
        //Лист урона
        List<Double> listOfDamage = Arrays.asList(0.0, 10.0, 12.0, 13.0, 19.0, 21.0, 24.0, 30.0, 36.0, 41.0);
        //Лист Лечения
        List<Double> listOfTreatment = Arrays.asList(0.0, 15.0, 18.0, 22.0, 26.0, 31.0, 37.0, 45.0, 53.0, 65.0);
        //Картинка героя:
        ImageView sprite = new ImageView(); //Саня!
        List<Media> mediaListOfPresentation = Arrays.asList(
                new Media("src\\Sounds\\SoundLordVampire\\LVGreetings-1.wav"),
                new Media("src\\Sounds\\SoundLordVampire\\LVGreetings-2.wav")
        );
        AHero.Presentation presentation = new AHero.Presentation(
                new ImageView(new Image("@../Picture/Windows/LV_Spotlight.jpg")),
                mediaListOfPresentation, new Pane());
        //Возврат собранного героя:


        {
            return new AHero();
        }
    }

    ;

    public static AHero buildOrcBasher() {
        //Суперспособность 1:
        //Суперспособность 2:
        //Суперспособность 3:
        //Лист, в который ты потом положишь суперспособности:
        List<AHero.Skill> listOfSkills = Arrays.asList();
        //Лист перехода по опыту:
        List<Double> listOfRequiredExperience = Arrays.asList(0.0, 150.0, 366.0, 667.0, 1083.0, 1641.0, 2381.0, 3371.0, 4667.0, 6357.0, Double.MAX_VALUE);
        //Лист переходов со здоровьем:
        List<Double> listOfSupplyHealth = Arrays.asList(0.0, 100.0, 120.0, 145.0, 170.0, 210.0, 245.0, 300.0, 360.0, 410.0);
        //Лист звуков с атакой:
        List<Media> mediaListOfAttack = Arrays.asList(
                new Media("src\\Sounds\\SoundOrcBasher\\BhrAttack-1.wav"),
                new Media("src\\Sounds\\SoundOrcBasher\\BhrAttack-2.wav"),
                new Media("src\\Sounds\\SoundOrcBasher\\BhrAttack-3.wav"),
                new Media("src\\Sounds\\SoundOrcBasher\\BhrAttack-4.wav"));
        //Лист звуков с лечением:
        List<Media> mediaListOfTreatment = Arrays.asList(
                new Media("src\\Sounds\\SoundOrcBasher\\BhrTreatment-1.wav"),
                new Media("src\\Sounds\\SoundOrcBasher\\BhrTreatment-2.wav"),
                new Media("src\\Sounds\\SoundOrcBasher\\BhrTreatment-3.wav"),
                new Media("src\\Sounds\\SoundOrcBasher\\BhrTreatment-4.wav"));
        //Лист урона
        List<Double> listOfDamage = Arrays.asList(0.0, 6.0, 7.0, 9.0, 10.0, 12.0, 16.0, 18.0, 22.0, 25.0);
        //Лист Лечения
        List<Double> listOfTreatment = Arrays.asList(0.0, 25.0, 30.0, 36.0, 43.0, 52.0, 62.0, 75.0, 89.0, 108.0);
        //Картинка героя:
        ImageView sprite = new ImageView(); //Саня!
        List<Media> mediaListOfPresentation = Arrays.asList(
                new Media("src\\Sounds\\SoundOrcBasher\\BhrGreetings-1.wav"),
                new Media("src\\Sounds\\SoundOrcBasher\\BhrGreetings-2.wav")
        );
        AHero.Presentation presentation = new AHero.Presentation(
                new ImageView(new Image("@../Picture/Windows/BHR_Spotlight.jpg")),
                mediaListOfPresentation, new Pane());
        //Возврат собранного героя:

        return new AHero();
    }
};
