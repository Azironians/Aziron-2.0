package Heroes;

import Main.Sound;
import Match.Player;
import Skills.Skill;
import Skills.SkillsLV;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;

import static Heroes.LevelLordVamp.LevelUpLordVamp;

public class HeroLordVamp implements Hero {

    private Double attack;
    private Double treatment;
    private Double hitPoints;
    private Double supplyHealth;
    private int levelHero;
    private Skill skills;
    private ImageView imageView;
    private Double experience = 0.0;
    private Boolean location;
    private Player player;
    private Sound a1 = new Sound(new File("src\\Sounds\\SoundLordVampire\\LVAttack-1.wav"));
    private Sound a2 = new Sound(new File("src\\Sounds\\SoundLordVampire\\LVAttack-2.wav"));
    private Sound a3 = new Sound(new File("src\\Sounds\\SoundLordVampire\\LVAttack-3.wav"));
 //   private Sound a4 = new Sound(new File("src\\Sounds\\SoundLordVampire\\LVAttack-4.wav"));
    private Sound h1 = new Sound(new File("src\\Sounds\\SoundLordVampire\\LVTreatment-1.wav"));
    private Sound h2 = new Sound(new File("src\\Sounds\\SoundLordVampire\\LVTreatment-2.wav"));
    private Sound h3 = new Sound(new File("src\\Sounds\\SoundLordVampire\\LVTreatment-3.wav"));
    private Sound h4 = new Sound(new File("src\\Sounds\\SoundLordVampire\\LVTreatment-4.wav"));

    public HeroLordVamp(Boolean location) {
        this.location = location;
        this.attack = 50.0;
        this.supplyHealth = 300.0;
        this.treatment = 75.0;
        this.levelHero = 1;
        this.hitPoints = 300.0;
        this.skills = new SkillsLV(this);
        this.imageView = new ImageView(new Image(new File("src\\Picture\\Heroes\\LordWamp\\LV.png").toURI().toString()));
    }

    @Override
    public void soundAttack() {
        int choise = (int) (Math.random() * 75) / 25;
        switch (choise) {
            case 1:
                a1.play();
                break;
            case 2:
                a2.play();
                break;
            case 3:
                a3.play();
                break;
//            case 4:
//                a4.play();
//                break;
            default:
                a1.play();
                break;
        }
    }

    @Override
    public void soundTreatment() {
        int choise = (int) (Math.random() * 100) / 25;
        switch (choise) {
            case 1:
                h1.play();
                break;
            case 2:
                h2.play();
                break;
            case 3:
                h3.play();
                break;
            case 4:
                h4.play();
                break;
            default:
                h1.play();
                break;
        }
    }

    @Override
    public void setPlayer(Player player) {
        this.player = player;
    }

    @Override
    public Player getPlayer() {
        return player;
    }

    @Override
    public Double getExperience() {
        return experience;
    }

    public void setExperience(Double experience) {
        this.experience = experience;
    }

    @Override
    public ImageView getImage() {
        return imageView;
    }

    @Override
    public void levelUp() {
        LevelUpLordVamp(this);
    }


    @Override
    public Double getAttack() {
        return attack;
    }

    @Override
    public void setAttack(Double attack) {
        this.attack = attack;
    }

    @Override
    public Double getTreatment() {
        return treatment;
    }

    @Override
    public void setTreatment(Double treatment) {
        this.treatment = treatment;
    }

    @Override
    public Double getHitPoints() {
        return hitPoints;
    }

    @Override
    public void setHitPoints(Double hitPoints) {
        this.hitPoints = hitPoints;
    }

    @Override
    public Double getSupplyHealth() {
        return supplyHealth;
    }

    @Override
    public void setSupplyHealth(Double supplyHealth) {
        this.supplyHealth = supplyHealth;
    }

    @Override
    public int getLevelHero() {
        return levelHero;
    }

    @Override
    public void setLevelHero(int levelHero) {
        this.levelHero = levelHero;
    }

    @Override
    public Skill getSkills() {
        return skills;
    }

    @Override
    public void setSkills(Skill skills) {
        this.skills = skills;
    }

    @Override
    public void setLocation(Boolean location) {
        this.location = location;
    }

    @Override
    public Boolean getLocation() {
        return location;
    }


}
