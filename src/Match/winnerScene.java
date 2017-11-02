package Match;

import Main.Profile;

import java.io.IOException;

class winnerScene {


    static void winInfoUpdate(Profile profile1, Profile profile2, Boolean winner) throws IOException {
        if (winner) {
            profile2.getPlayer().setWinner(false);
            profile1.getPlayer().setWinner(true);
        } else {
            profile1.getPlayer().setWinner(false);
            profile2.getPlayer().setWinner(true);
        }
        profile1.correctStatistics(profile2);
        profile2.correctStatistics(profile1);

    }

}
