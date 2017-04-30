package Match;

import Heroes.Hero;

public class Player {
    private String profileName;
    private Hero hero;

    public Player(String profileName, Hero hero) {
        this.profileName = profileName;
        this.hero = hero;
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

}




