package Match;

import Heroes.Hero;

public class Player {
    private String profileName;
    private Hero hero;
    private Boolean yourTurn;

    public Player(String profileName, Hero hero, Boolean yourTurn) {
        this.profileName = profileName;
        this.hero = hero;
        this.yourTurn = yourTurn;
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

    public boolean isYourTurn() {
        return yourTurn;
    }

    public void setYourTurn(boolean yourTurn) {
        this.yourTurn = yourTurn;
    }
}




