package Match;

import Heroes.Hero;

public class Player {
    private String profileName;
    private Hero hero;
    private Boolean location;

    public Player(String profileName, Hero hero) {
        this.profileName = profileName;
        this.hero = hero;
    }

    public Boolean getLocation() {
        return location;
    }

    public void setLocation(Boolean location) {
        this.location = location;
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




