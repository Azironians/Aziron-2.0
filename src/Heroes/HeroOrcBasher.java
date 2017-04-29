package Heroes;

import Skills.Skill;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.util.List;

import static Heroes.LevelOrg.LevelUpOgr;

public class HeroOrcBasher implements Hero {

    private Double attack;
    private Double treatment;
    private Double hitPoints;
    private Double supplyHealth;
    private int levelHero;
    private Skill skills;
    private ImageView imageView;
    private Double experience = 0.0;


    public HeroOrcBasher() {
        this.attack = 30.0;
        this.supplyHealth = 500.0;
        this.treatment = 125.0;
        this.levelHero = 1;
        this.hitPoints = 500.0;
        this.imageView = new ImageView(new Image(new File("src\\Picture\\Heroes\\Basher\\Basher.png").toURI().toString()));

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
        LevelUpOgr(this);
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
}
