package Heroes;

import Skills.Skill;

import java.util.List;

public class HeroDevourer implements Hero {

    private Double attack;
    private Double treatment;
    private Double hitPoints;
    private Double supplyHealth;
    private Double levelHero;
    private List<Skill> skills;

    public HeroDevourer() {
        this.attack = 40.0;
        this.supplyHealth = 400.0;
        this.treatment = 100.0;
        this.levelHero = 1.0;
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