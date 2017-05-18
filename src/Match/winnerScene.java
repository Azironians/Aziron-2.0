package Match;

import Main.Profile;

import java.io.IOException;

class winnerScene {


    static void winInfoUpdate(Profile profile1, Profile profile2, Boolean winer) throws IOException {

//        if (winer){
//            profile1.setWin(profile1.getWin()+1);
//            if (profile1.getPlayer().getHero().getClass().equals(HeroOrcBasher.class)) profile1.setWinForOrcBacher(profile1.getWinForOrcBacher()+1);
//            if (profile1.getPlayer().getHero().getClass().equals(HeroLordVamp.class)) profile1.setWinForLV(profile1.getWinForLV()+1);
//            if (profile1.getPlayer().getHero().getClass().equals(HeroDevourer.class)) profile1.setWinForDevourer(profile1.getWinForDevourer()+1);
//        profile2.setLose(profile2.getLose()+1);
//        }else {
//            profile2.setWin(profile2.getWin()+1);
//            if (profile2.getPlayer().getHero().getClass().equals(HeroOrcBasher.class)) profile2.setWinForOrcBacher(profile2.getWinForOrcBacher()+1);
//            if (profile2.getPlayer().getHero().getClass().equals(HeroLordVamp.class)) profile2.setWinForLV(profile2.getWinForLV()+1);
//            if (profile2.getPlayer().getHero().getClass().equals(HeroDevourer.class)) profile2.setWinForDevourer(profile2.getWinForDevourer()+1);
//            profile1.setLose(profile1.getLose()+1);
//        }
        if (winer) {
            profile2.getPlayer().setWinner(false);
            profile1.getPlayer().setWinner(true);
        }else {
            profile1.getPlayer().setWinner(false);
            profile2.getPlayer().setWinner(true);
        }
        profile1.correctStatistics(profile2);
        profile2.correctStatistics(profile1);
    }

}
