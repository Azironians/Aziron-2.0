package Heroes;

import Skills.Skill;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.util.List;

public class HeroLordVamp implements Hero {

    private Double attack;
    private Double treatment;
    private Double hitPoints;
    private Double supplyHealth;
    private Double levelHero;
    private List<Skill> skills;
    private ImageView imageView;

    public HeroLordVamp() {
        this.attack = 50.0;
        this.supplyHealth = 300.0;
        this.treatment = 75.0;
        this.levelHero = 1.0;
        this.hitPoints=300.0;
        this.imageView = new ImageView(new Image(new File("src\\Picture\\Heroes\\LordWamp\\LV.png").toURI().toString()));
    }

@Override
public ImageView getImage(){
        return imageView;
}

    @Override
    public void levelUp() {
        levelHero++;
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
    public Double getLevelHero() {
        return levelHero;
    }

    @Override
    public void setLevelHero(Double levelHero) {
        this.levelHero = levelHero;
    }

    @Override
    public List<Skill> getSkills() {
        return skills;
    }

    @Override
    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }
}
