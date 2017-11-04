package Match;

import BonusDirectory.Bonus;
import Heroes.Hero;

public class Player {
    private String profileName;
    private Hero hero;
    private double dealDamage=0;
    private double restoredHitPoints=0;
    private byte reachedLevel=1;
    private byte usedSkills=0;
    private Bonus favouriteBonus;
    private int remainingTime;
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












    String getProfileName() {
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

    void setDealDamage(int dealDamage) {
        this.dealDamage = dealDamage;
    }

    public double getRestoredHitPoints() {
        return restoredHitPoints;
    }

    void setRestoredHitPoints(int restoredHitPoints) {
        this.restoredHitPoints = restoredHitPoints;
    }

    public byte getReachedLevel() {
        return reachedLevel;
    }

    void setReachedLevel(byte reachedLevel) {
        this.reachedLevel = reachedLevel;
    }

    public byte getUsedSkills() {
        return usedSkills;
    }

    void setUsedSkills(byte usedSkills) {
        this.usedSkills = usedSkills;
    }

    public Bonus getFavouriteBonus() {
        return favouriteBonus;
    }

    public void setFavouriteBonus(Bonus favouriteBonus) {
        this.favouriteBonus = favouriteBonus;
    }

    public int getRemainingTime() {
        return remainingTime;
    }

    void setRemainingTime(int remainingTime) {
        this.remainingTime = remainingTime;
    }

    public boolean isWinner() {
        return winner;
    }

    void setWinner(boolean winner) {
        this.winner = winner;
    }

}




