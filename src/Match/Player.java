package Match;

import Bonus.Bonus;
import Heroes.Hero;

public class Player {
    private String profileName;
    private Hero hero;
    private double dealDamage;
    private double restoredHitPoints;
    private byte reachedLevel;
    private byte usedSkills;
    private Bonus favouriteBonus;
    private byte remainingTime;
    private boolean winner;

    public Player(String profileName, Hero hero) {
        this.profileName = profileName;
        this.hero = hero;
        hero.setPlayer(this);
    }

    //Второй конструктор для статистики:
    public Player(String profileName, Hero hero, int dealDamage, int restoredHitPoints, byte reachedLevel,
                  byte usedSkills, Bonus favouriteBonus, byte remainingTime, boolean winner) {
        this.profileName = profileName;
        this.hero = hero;
        this.dealDamage = dealDamage;
        this.restoredHitPoints = restoredHitPoints;
        this.reachedLevel = reachedLevel;
        this.usedSkills = usedSkills;
        this.favouriteBonus = favouriteBonus;
        this.remainingTime = remainingTime;
        this.winner = winner;
        hero.setPlayer(this);
    }












    public String getProfileName() {
        return profileName;
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }

    public Hero getHero() {
        return hero;
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }

    public double getDealDamage() {
        return dealDamage;
    }

    public void setDealDamage(int dealDamage) {
        this.dealDamage = dealDamage;
    }

    public double getRestoredHitPoints() {
        return restoredHitPoints;
    }

    public void setRestoredHitPoints(int restoredHitPoints) {
        this.restoredHitPoints = restoredHitPoints;
    }

    public byte getReachedLevel() {
        return reachedLevel;
    }

    public void setReachedLevel(byte reachedLevel) {
        this.reachedLevel = reachedLevel;
    }

    public byte getUsedSkills() {
        return usedSkills;
    }

    public void setUsedSkills(byte usedSkills) {
        this.usedSkills = usedSkills;
    }

    public Bonus getFavouriteBonus() {
        return favouriteBonus;
    }

    public void setFavouriteBonus(Bonus favouriteBonus) {
        this.favouriteBonus = favouriteBonus;
    }

    public byte getRemainingTime() {
        return remainingTime;
    }

    public void setRemainingTime(byte remainingTime) {
        this.remainingTime = remainingTime;
    }

    public boolean isWinner() {
        return winner;
    }

    public void setWinner(boolean winner) {
        this.winner = winner;
    }

}




