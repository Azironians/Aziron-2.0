package Heroes;

import javafx.scene.image.ImageView;
import javafx.scene.media.Media;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BuilderAzironHero {

    //Метод:
    public AzironHero buildDevourer() {
        //Суперспособность 1:
        AzironHero.Skill skillFlameSnakes = new AzironHero.Skill(new ImageView(), new ImageView(), new ArrayList<>(), new Media("")) {
            @Override
            void run() {

            }
        };
        //Суперспособность 2:
        AzironHero.Skill skillRegeneration = new AzironHero.Skill(new ImageView(), new ImageView(), new ArrayList<>(), new Media("")) {
            @Override
            void run() {

            }
        };
        //Суперспособность 3:
        AzironHero.Skill skillSplit = new AzironHero.Skill(new ImageView(), new ImageView(), new ArrayList<>(), new Media("")) {
            @Override
            void run() {

            }
        };
        //Лист, в который ты потом положишь суперспособности:
        List<AzironHero.Skill> listOfSkills = Arrays.asList(skillFlameSnakes, skillRegeneration, skillSplit);
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
        new Media ("src\\Sounds\\SoundDevourer\\DevTreatment-1.wav"),
        new Media ("src\\Sounds\\SoundDevourer\\DevTreatment-2.wav"),
        new Media ("src\\Sounds\\SoundDevourer\\DevTreatment-3.wav"),
        new Media ("src\\Sounds\\SoundDevourer\\DevTreatment-4.wav"));
        //Лист урона
        List<Double> listOfDamage = Arrays.asList(0.0, 8.0, 10.0, 11.0, 14.0, 17.0, 20.0, 23.0, 29.0, 35.0);
        //Лист Лечения
        List<Double> listOfTreatment = Arrays.asList(0.0, 20.0, 24.0, 29.0, 34.0, 42.0, 50.0, 59.0, 72.0, 86.0);
        //Картинка героя:
        ImageView sprite = new ImageView(); //Саня!
        //Возврат собранного героя:
        return new AzironHero(40.0, 100.0, 400.0, 400.0, 0.0, 1,
                listOfRequiredExperience, listOfDamage, listOfTreatment, listOfSupplyHealth, listOfSkills, sprite,
                mediaListOfAttack, mediaListOfTreatment);

    }

    public AzironHero buildLordVamp() {
        return new AzironHero();
    }

    public AzironHero buildOrcBasher() {
        return new AzironHero();
    }
}


