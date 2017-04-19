package Match;

import Heroes.Hero;

public class Player {
    private String profileName;
    private Hero hero;
    private boolean yourTurn;

    public Player(String profileName, Hero hero, boolean yourTurn) {
        this.profileName = profileName;
        this.hero = hero;
        this.yourTurn = yourTurn;
    }

}




